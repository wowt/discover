package com.hongcheng.fruitmall.tools;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipTools {

    private static Logger logger = LoggerFactory.getLogger(GzipTools.class);

    private static Jedis getRedis() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);
        config.setMaxIdle(10);
        config.setMaxWaitMillis(1000);
        config.setTestOnBorrow(true);
        JedisPool pool = new JedisPool(config,"127.0.0.1",6379);
        Jedis jedis = pool.getResource();
        return jedis;
    }

    private static void saveRedis(String key,String value) {
        getRedis().set(key,value);
    }
    private static String getRedis(String key) {
        return getRedis().get(key);
    }

    /**
     * 根据前2个字节是否是 0x8b1f判断是否是gzip压缩的数据
     *
     * @param value
     * @return
     */
    public static boolean isGzip (String value) {

        if (StringUtils.isEmpty(value)) {
            return false;
        }
        try {
            byte[] bytes = value.getBytes("ISO-8859-1");
            if(bytes.length < 2) {
                return false;
            }
            int magic = ((bytes[1] & 0xff) << 8) | (bytes[0] & 0xff);
            return magic == GZIPInputStream.GZIP_MAGIC;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error("isGzip check error",e);
        }
        return false;
    }

    /**
     * 字符串的压缩
     *
     * @param str 待压缩的字符串
     * @return 返回压缩后的字符串
     * @throws IOException
     */
    public static String compress(String str) {
        if(StringUtils.isEmpty(str)) {
            return str;
        }
        String comStr = str;
        //创建一个byte数组输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            GZIPOutputStream gzip = new GZIPOutputStream(out);
            gzip.write(str.getBytes());
            try {
                gzip.close();
                comStr = out.toString("ISO-8859-1");
            } catch (IOException e) {
                logger.error("gzip close error", e);
            }
        } catch (IOException e) {
            logger.error("compress failed", e);
        }
        return comStr;
    }

    /**
     * 字符串的解压
     *
     * @param str 对字符串解压
     * @return 返回解压缩后的字符串
     */
    public static String unCompress(String str)  {
        if (StringUtils.isEmpty(str) || !isGzip(str)) {
            return str;
        }
        String unComStr = "";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = null;
        GZIPInputStream gzip = null;

        try {
            in = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
            // 使用默认缓冲区大小创建新的输入流
            gzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n = 0;
            while ((n = gzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }

            unComStr = out.toString();
        } catch (IOException e) {
            logger.error("unCompress failed", e);
        } finally {
            if (null != gzip) {
                try {
                    gzip.close();

                } catch (IOException e) {
                    logger.error("gzip close error", e);
                }
            }

        }
        return unComStr;
    }
}
