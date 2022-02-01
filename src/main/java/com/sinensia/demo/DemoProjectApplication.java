package com.sinensia.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Generated;

@SpringBootApplication
@RestController
public class DemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProjectApplication.class, args);
	}

	@Generated(value="org.springframework.boot")
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "world") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/")
	public String Hola(@RequestParam(value = "BusinessName", defaultValue = "GFT") String name) {
		return String.format("Welcome to %s!", name);
	}

	@GetMapping("/add")
	public Object add(
			@RequestParam(value = "a", defaultValue = "0") Float a,
			@RequestParam(value = "b", defaultValue = "0") Float b)
	{
		Float sum = a+b;
		Float decimals = sum - sum.intValue();

		if(decimals!=0){
			return sum;
		}
		return sum.intValue();
	}

	@GetMapping("/substract")
	public Object sust(
			@RequestParam(value = "a", defaultValue = "0") Float a,
			@RequestParam(value = "b", defaultValue = "0") Float b)
	{
		Float sums = a-b;
		Float decimals = sums - sums.intValue();

		if(decimals!=0){
			return sums;
		}
		return sums.intValue();
	}

	@GetMapping("/multiply")
	public Object multiply(
			@RequestParam(value = "a", defaultValue = "0") Float a,
			@RequestParam(value = "b", defaultValue = "0") Float b)
	{
		Float product = a*b;
		Float decimals = product - product.intValue();

		if(decimals!=0){
			return product;
		}
		return product.intValue();
	}

	@GetMapping("/divide")
	public Object divide(
			@RequestParam(value = "a", defaultValue = "0") Float a,
			@RequestParam(value = "b", defaultValue = "0") Float b)
	{
		Float div = a/b;
		Float decimals = div - div.intValue();

		if(decimals!=0){
			return div;
		}
		return div.intValue();
	}
}

