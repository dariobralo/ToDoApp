package com.practica.todoapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoappApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoappApplication.class, args);
    }
/*
    @Bean
    public OpenAPI custonOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ToDo API")
                        .version("v1")
                        .description("API de práctica")
                        .termsOfService("")
                        .license(new License().name("").url(""))
                );
    }*/

}
