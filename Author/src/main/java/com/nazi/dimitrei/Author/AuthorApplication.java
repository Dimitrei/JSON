package com.nazi.dimitrei.Author;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class AuthorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorApplication.class, args);
	}
}
