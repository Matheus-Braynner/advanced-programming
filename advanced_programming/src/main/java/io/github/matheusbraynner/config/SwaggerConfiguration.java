package io.github.matheusbraynner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("io.github.matheusbraynner"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.apiInfo(appInfo());
	}

	private ApiInfo appInfo() {
		return new ApiInfoBuilder()
				.title("Api Rest Shop-style")
				.description("Api advanced_programming"
						+ "\n Time de Desenvolvimento"
						+ "\n Matheus Braynner , https://github.com/Matheus-Braynner"
						+ "\n Allan Maia , https://github.com/MrMaia"
						+ "\n Leonardo Gabriele , https://github.com/Leleco1604"
						+ "\n Diego Francisco , https://github.com/diegoframos81"
						+ "\n ThyagoSousa , https://github.com/thyagosousa"
						+ "\n Matheus Moura")
				.version("0.0.1")
				.license("Apache Licence Version 3.0")
				.contact(new Contact("Repository","https://github.com/Matheus-Braynner/project_shop_style",""))
				.build();
	}
}
