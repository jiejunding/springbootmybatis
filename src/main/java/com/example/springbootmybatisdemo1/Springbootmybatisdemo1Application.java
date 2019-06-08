package com.example.springbootmybatisdemo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springbootmybatisdemo1.mapper")
public class Springbootmybatisdemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootmybatisdemo1Application.class, args);
	}

}
