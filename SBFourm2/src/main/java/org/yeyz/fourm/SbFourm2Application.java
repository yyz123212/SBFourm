package org.yeyz.fourm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.yeyz.fourm.mapper")
public class SbFourm2Application {

	public static void main(String[] args) {
		SpringApplication.run(SbFourm2Application.class, args);
	}

}
