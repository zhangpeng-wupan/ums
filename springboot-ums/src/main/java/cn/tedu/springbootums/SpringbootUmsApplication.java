package cn.tedu.springbootums;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.tedu.springbootums.mapper")
public class SpringbootUmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootUmsApplication.class, args);
	}

}
