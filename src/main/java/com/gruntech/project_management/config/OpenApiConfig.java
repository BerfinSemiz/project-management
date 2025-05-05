package com.gruntech.project_management.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Project Management API",
        description = "API Documentation for Project Management with Spring Boot and JWT Authentication",
        version = "1.0",
        contact = @Contact(
            name = "Berfin",
            email = "berfin@example.com",
            url = "https://github.com/berfin"
        )
    )
)
@SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT",
    in = SecuritySchemeIn.HEADER,
    description = "JWT Authorization header using Bearer token"
)


public class OpenApiConfig {
    // Bu sınıf yalnızca Swagger konfigürasyonlarını içermektedir.
}
