package com.hongcheng.discover.tools;

import com.google.common.base.Joiner;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * <h2>Bean字段修改比较器</h2>
 * <p>
 * 主要用于标准的JavaBean进行修改前后的字段比较<br/>
 * 比较字段需在build后自行注册,注册字段必须有公开的getter方法
 * </p>
 *
 * @param <T> 比较bean类型
 * @author xiazijian
 * @version 2017-09-15
 */
public class BeanComparator<T> {

    private static final String GETTER_PREFIX = "get";
    private static final char SPLIT_CHAR = ',';
    /**
     * 比较数据类型Class
     */
    private Class<T> typeClass;
    /**
     * 字段列表
     */
    private List<FieldElement> fieldElementList;
    private Joiner joiner;

    public static <T> BeanComparator<T> build(Class<T> typeClass) {
        return new BeanComparator<>(typeClass);
    }

    private BeanComparator(Class<T> typeClass) {
        this.typeClass = typeClass;
        this.fieldElementList = new ArrayList<>();
        this.joiner = Joiner.on(SPLIT_CHAR).skipNulls();
    }

    /**
     * 注册需要比较的字段信息
     *
     * @param fieldName
     * @param describe
     * @return
     */
    public BeanComparator register(String fieldName, String describe) {

        for (Class<?> superClass = typeClass; superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                Field field = superClass.getDeclaredField(fieldName);
                return register(field, describe);
            } catch (NoSuchFieldException e) {
                // Field不在当前类定义,继续向上转型
                continue;
            }
        }

        return this;
    }

    /**
     * 注册需要比较的字段
     *
     * @param field
     * @param describe
     * @return
     */
    public BeanComparator register(Field field, String describe) {

        String getterMethodName = GETTER_PREFIX + StringUtils.capitalize(field.getName());
        try {
            Method fieldGetter = typeClass.getMethod(getterMethodName);
            fieldElementList.add(new FieldElement(describe, field, fieldGetter));
        } catch (NoSuchMethodException e) {
            System.out.println("字段不符合JavaBean标准，未找到对应的get方法");
        }
        return this;
    }

    /**
     * 注册bean的所有字段
     *
     * @return
     */
    public BeanComparator registerAll() {
        for (Class<?> superClass = typeClass; superClass != Object.class; superClass = superClass.getSuperclass()) {
            for (Field field : superClass.getDeclaredFields()) {
                register(field, field.getName());
            }
        }
        return this;
    }

    /**
     * 比较两个bean注册字段，返回综合性的简要信息
     *
     * @param oldElement 修改之前的bean
     * @param newElement 修改之后的bean
     * @return 综合性的简要信息，ex.:添加标志 删除Title 修改亮点,标题
     */
    public String compare(T oldElement, T newElement) {

        StringBuilder content = new StringBuilder();
        // 记录添加内容的字段
        List<String> addList = new LinkedList<>();
        // 记录修改内容的字段
        List<String> updateList = new LinkedList<>();
        // 记录删除内容的字段
        List<String> deleteList = new LinkedList<>();

        try {
            for (FieldElement fieldElement : fieldElementList) {
                Object oldField = fieldElement.getFieldGetter().invoke(oldElement);
                Object newField = fieldElement.getFieldGetter().invoke(newElement);

                boolean oldIsNull = isNull(oldField);
                boolean newIsNull = isNull(newField);
                if (oldIsNull && !newIsNull) {
                    //旧字段为空，新字段不为空，则为添加
                    addList.add(fieldElement.getDescribe());
                } else if (!oldIsNull && newIsNull) {
                    //旧字段不为空，新字段为空，则为删除
                    deleteList.add(fieldElement.getDescribe());
                } else if (!Objects.equals(oldField, newField)) {
                    //新旧字段都不为空，字段比较不同，则为修改
                    updateList.add(fieldElement.getDescribe());
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        if (!addList.isEmpty()) {
            appendList(content, OperateEnum.ADD, addList);
        }
        if (!deleteList.isEmpty()) {
            appendList(content, OperateEnum.DELETE, deleteList);
        }
        if (!updateList.isEmpty()) {
            appendList(content, OperateEnum.UPDATE, updateList);
        }

        return content.toString();
    }

    /**
     * 比较两个bean的注册字段，返回详细信息
     *
     * @param oldElement 修改之前的bean
     * @param newElement 修改之后的bean
     * @return
     */
    public String compareDetail(T oldElement, T newElement) {

        StringBuilder content = new StringBuilder();

        try {
            for (FieldElement fieldElement : fieldElementList) {
                Object oldField = fieldElement.getFieldGetter().invoke(oldElement);
                Object newField = fieldElement.getFieldGetter().invoke(newElement);

                boolean oldIsNull = isNull(oldField);
                boolean newIsNull = isNull(newField);
                if (oldIsNull && !newIsNull) {
                    //旧字段为空，新字段不为空，则为添加
                    appendDetail(content, OperateEnum.ADD, fieldElement.getDescribe(), newField);
                } else if (!oldIsNull && newIsNull) {
                    //旧字段不为空，新字段为空，则为删除
                    appendDetail(content, OperateEnum.DELETE, fieldElement.getDescribe(), newField);
                } else if (!Objects.equals(oldField, newField)) {
                    //新旧字段都不为空，字段比较不同，则为修改
                    appendDetail(content, OperateEnum.UPDATE, fieldElement.getDescribe(), newField);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // 删除末尾的分隔符
        if (content.length() > 0) {
            content.deleteCharAt(content.length() - 1);
        }

        return content.toString();
    }

    private boolean isNull(Object object) {
        return object == null || object instanceof String && object.equals("");
    }

    private void appendList(StringBuilder sb, OperateEnum operate, List<String> elements) {
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(operate.getText());
        joiner.appendTo(sb, elements);
    }

    private void appendDetail(StringBuilder sb, OperateEnum operate, String describe, Object field) {
        sb.append(operate.getText());
        sb.append(describe);
        if (operate != OperateEnum.DELETE) {
            sb.append("为“");
            sb.append(field.toString());
            sb.append('”');
        }
        sb.append(SPLIT_CHAR);
    }

    private enum OperateEnum {
        ADD("添加"),
        UPDATE("修改"),
        DELETE("删除");

        private String text;

        OperateEnum(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    /**
     * 字段列表元素
     *
     * @version 2017-09-15
     */
    private class FieldElement {

        private String describe;

        private Field field;

        private Method fieldGetter;

        public FieldElement(String fieldName, Field field, Method fieldGetter) {
            this.describe = fieldName;
            this.field = field;
            this.fieldGetter = fieldGetter;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public Field getField() {
            return field;
        }

        public void setField(Field field) {
            this.field = field;
        }

        public Method getFieldGetter() {
            return fieldGetter;
        }

        public void setFieldGetter(Method fieldGetter) {
            this.fieldGetter = fieldGetter;
        }
    }

}
