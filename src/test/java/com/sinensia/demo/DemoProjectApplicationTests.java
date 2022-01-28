package com.sinensia.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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
	void rootTestMultiName(@Autowired TestRestTemplate restTemplate) {
		String[] arr = {"Adria","Patata","Whisky"};
		for(String name: arr) {
			assertThat(restTemplate
					.getForObject("/hello?name="+name, String.class))
					.isEqualTo("Hello "+name+"!");
		}
	}

	@Autowired TestRestTemplate restTemplate;
	@ParameterizedTest
	@ValueSource(strings={"Adria","Whisky","Daddy","Kiwi"})
	void helloParamNames( String name){
		assertThat(restTemplate
				.getForObject("/hello?name="+name, String.class))
				.isEqualTo("Hello "+name+"!");
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
	void canAddNullA(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate
				.getForObject("/add?a=&b=2", String.class))
				.isEqualTo("2");
	}

	@Test
	void canAddNullB(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate
				.getForObject("/add?a=1&b=", String.class))
				.isEqualTo("1");
	}

	@Test
	void canAddFraction(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate
				.getForObject("/add?a=1.5&b=2", String.class))
				.isEqualTo("3.5");
	}
}
