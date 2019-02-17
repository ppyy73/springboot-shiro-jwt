package com.pp.sj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.pp.sj.mapper")
@EnableSwagger2
public class SpringbootShiroJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootShiroJwtApplication.class, args);
	}

}
