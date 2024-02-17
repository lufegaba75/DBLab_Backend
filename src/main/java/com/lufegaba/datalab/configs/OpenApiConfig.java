package com.lufegaba.datalab.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "DataLab",
                version = "1.0",
                description = "Documentation for endpoints in DataLab"
        )
)
public class OpenApiConfig {
}


