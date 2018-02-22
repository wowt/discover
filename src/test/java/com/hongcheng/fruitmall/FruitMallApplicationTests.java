package com.hongcheng.fruitmall;

import com.hongcheng.fruitmall.mall.dao.mapper.CartEntityMapper;
import com.hongcheng.fruitmall.mall.entity.CartEntity;
import com.hongcheng.fruitmall.mall.service.CartService;
import org.assertj.core.util.Compatibility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FruitMallApplication.class)
public class FruitMallApplicationTests {

	@Autowired
	private CartService service;

	@Test
	public void test() {
		service.getById();

	}

}
