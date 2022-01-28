package com.sinensia.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class DemoProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void rootTest1(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate
				.getForObject("/", String.class))
				.isEqualTo("Welcome to GFT!");
	}

	@Test
	void rootTest2(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate
				.getForObject("/hello", String.class))
				.isEqualTo("Hello world!");
	}

	@Test
	void rootTest3(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate
				.getForObject("/hello?name=Adria", String.class))
				.isEqualTo("Hello Adria!");
	}

	@Test
	void canAdd(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate
				.getForObject("/add?a=1&b=2", String.class))
				.isEqualTo("3");
	}

	@Test
	void canAddZero(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate
				.getForObject("/add?a=0&b=2", String.class))
				.isEqualTo("2");
	}

	@Test
	void canAddNegative(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate
				.getForObject("/add?a=1&b=-2", String.class))
				.isEqualTo("-1");
	}

	@Test
	void canAddNulla(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate
				.getForObject("/add?a=&b=2", String.class))
				.isEqualTo("2");
	}

	@Test
	void canAddNullb(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate
				.getForObject("/add?a=1&b=", String.class))
				.isEqualTo("1");
	}
}
