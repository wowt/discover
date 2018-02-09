package com.hongcheng.fruitmall;

import com.hongcheng.fruitmall.mall.dao.mapper.CartEntityMapper;
import com.hongcheng.fruitmall.mall.entity.CartEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FruitMallApplicationTests {

	@Resource
	private CartEntityMapper mapper;

	@Test
	public void test() {
		CartEntity entity = mapper.getById(1);
		System.out.println(entity);
	}

}
