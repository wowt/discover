package com.hongcheng.discover;

import com.hongcheng.discover.mall.service.CartService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
