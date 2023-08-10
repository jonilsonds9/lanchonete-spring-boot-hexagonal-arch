package br.com.fiap.lanchonete.infrastracture.apis.rest.controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ResponseEntity<String> home() {
        String content = """
                <!DOCTYPE html>
                <head>
                    <meta charset="UTF-8">
                    <title>API Lanchonete</title>
                </head>
                <body>
                    <h1>Bem-vindo a API Lanchonete!</h1><br>
                    <p>
                        Veja a documentação em <a href="http://localhost:8081/api/docs">http://localhost:8081/api/docs</a>
                    </p>
                </body>
                </html>
                """;
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>(content, responseHeaders, HttpStatus.OK);
    }
}
