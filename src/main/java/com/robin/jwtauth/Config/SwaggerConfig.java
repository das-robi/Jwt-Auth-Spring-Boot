package com.robin.jwtauth.Config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customAPI(){

        return new OpenAPI()
                .info(new Info()
                        .title("Product Management System")
                        .version("1.0")
                        .description("Spring Boot Restful API Documentation for Product Management")
                        .contact(new Contact()
                                .name("Robin")
                                .email("contact.robindas@gmail.com")))

                //Add Security Requirement JWT Token
                .addSecurityItem(new SecurityRequirement().addList("Bearer Auth"))

                //Defines The Schema
                .components(new Components()
                        .addSecuritySchemes("Bearer Auth",
                                new SecurityScheme()
                                        .name("Authorization")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));

    }


}
