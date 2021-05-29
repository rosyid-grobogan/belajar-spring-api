package com.rosyidgrobogan.belajarspringapi.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.rosyidgrobogan.belajarspringapi.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "Demo Belajar Spring Boot API",
                "Belajar Spring boot",
                "API TOS",
                "Tersm of service",
                new Contact("Rosyid Grobogan", "https://rosyid-grobogan.github.io", "rosyidgrobogan@test.com"),
                "Apache License",
                "www.apache.com",
                Collections.emptyList()
        );
        return apiInfo;
    }
}
