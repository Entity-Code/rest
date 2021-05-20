package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;



@SpringBootApplication()
public class SwaggerOpenApi3 {
	
	@Value("${app.microservice.get.path}")
	private  String url ;
	
	@Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI().info(new Info().title("A2A PMDM APIs")
            .version(appVersion)
            .description("A2A - PMDM APIs")
            .contact(new Contact().name("Accenture (Google Cloud)").email("roberto.verdino@accenture.com"))
            .license(new License().name("MIT")
            .url("https://opensource.org/licenses/MIT")))
        	.addTagsItem(new Tag().name("N025 - Invio Letture di Processo ELE"))
        	.addTagsItem(new Tag().name("N026 - Invio Letture di Processo GAS"))
        	.addTagsItem(new Tag().name("N027 - Notifica Messa a disposizione"))
        	.addTagsItem(new Tag().name("N039 - Ricerca Letture di Processo"))
        	.addTagsItem(new Tag().name("N040 - Inserimento lettura fittizia"))
        	.addTagsItem(new Tag().name("N041 - TEST"))
        	.addServersItem(new Server().url(url).description("A2A - PMDM APIs"))
//        	.addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
//        	.components(new Components().addSecuritySchemes("bearerAuth", new SecurityScheme().type(Type.HTTP).scheme("bearer").bearerFormat("JWT")))
        	;
    }

}
