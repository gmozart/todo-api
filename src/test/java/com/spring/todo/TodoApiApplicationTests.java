package com.spring.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoApiApplicationTests {

	@Test
	void contextLoads() {
		String valor = "oi";
		Assertions.assertEquals("oi", valor);
		Assertions.assertTrue(true);
	}

}
