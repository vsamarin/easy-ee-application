package ru.vsamarin.easy_ee_application.rest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(title = "Application API", version = "1.0.0", description = "Описание API"),
        servers = {@Server(url = "/application/rest/")}
)
public class OpenApiDefinition {
}