package com.example.mysqlexample;

import com.example.mysqlexample.repositories.user.UserRepositoryCustomImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//// this annotation allows us reference our `UserRepositoryCustomImpl` bean as just `UserRepository`
//// allowing us to follow the conventions of Spring MVC applications using a conventional JPA data layer
//@EnableJpaRepositories(repositoryBaseClass = UserRepositoryCustomImpl.class)
public class MysqlExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlExampleApplication.class, args);
	}

}
