package com.banco.APIBanco.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class customOpenAPI {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API BANCO")
                        .version("v1.0")
                        .description("Aplication for Exchange Rate")
                        .contact(new Contact().name("Joseph Magallanes Nolazco"))
                        //.termsOfService("http://swagger.io/terms/")
                        //.license(new License().name("Apache 2.0").url("http://springdoc.org"))
                );
    }
}
