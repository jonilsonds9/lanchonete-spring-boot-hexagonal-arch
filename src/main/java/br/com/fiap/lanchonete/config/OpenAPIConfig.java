package br.com.fiap.lanchonete.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Info info = new Info()
                .title("Projeto Lanchonete")
                .version("1.0")
                .description("Esta API expõe endpoints para gerenciar uma lanchonete.");

        return new OpenAPI().info(info);
    }
}
