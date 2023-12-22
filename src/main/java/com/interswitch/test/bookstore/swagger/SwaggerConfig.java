package com.interswitch.test.bookstore.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;


@OpenAPIDefinition(
        info = @Info(
                title = "Online Book Store",
                description = "REST API service for a Book Store",
                contact = @Contact(
                        name = "Ikechukwu Ezugworie",
                        url = "https://www.linkedin.com/in/ezugworie/",
                        email = "i.ezugworie@gmail.com"
                )
        ),
        servers = @Server(url = "http://localhost:8080")
)
public class SwaggerConfig {
}