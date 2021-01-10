package com.packtpub.springboot.footballplayermicroservices;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

// http://localhost:8080/swagger-ui/index.html

@Configuration
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurationSupport {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(
                        "com.packtpub.springboot.footballplayermicroservices.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Spring Boot REST API")
                .description("\"Spring Boot REST API for Football Player Microservices\"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("\"http://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Mauro Vocale", "https://github.com/Hands-on-MSA-JakartaEE",
                        "mauro.vocale@gmail.com"))
                .build();
    }
}

