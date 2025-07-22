package com.example.jpalearn;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpalearnApplicationTests {


	@BeforeEach
	void setUp() {
		System.out.println("Before each test");
	}
	@AfterEach
	void tearDown() {
		System.out.println("🧹 Cleaning up\n");
	}
	@Test
	void contextLoads() {
	}

	@Test
	void TestMethod() {
		System.out.println("Testing method Running");
	}

}
