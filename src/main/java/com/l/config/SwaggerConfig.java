package com.l.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * 开启swagger
 *
 * @author l
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("后台API")
                .select()
//                扫描什么路径
                .apis(RequestHandlerSelectors.basePackage("com.l.controller"))
//                过滤什么路径
//                .paths(PathSelectors.ant("/l/**"))
                .build();
    }

    private ApiInfo apiInfo() {
//        作者信息
        Contact contact = new Contact(
                "陆梁雨",
                "https://byaoh.coding.net/public/",
                "ll789y@gmail.com");
        ApiInfo apiInfo = new ApiInfo(
                "老陆新闻头条后台管理系统API",
                "API文档",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
        return apiInfo;
    }
}
