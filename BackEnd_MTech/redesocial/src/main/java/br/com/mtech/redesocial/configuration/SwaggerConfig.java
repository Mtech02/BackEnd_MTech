package br.com.mtech.redesocial.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI springMtechOpenAPI() {

		return new OpenAPI()
				.info(new Info().title("MTech").description("https://github.com/Mtech02").version("V1.0.1")
						.license(new License().name("generation.org.br").url("http://springdoc.org"))
						.contact(new Contact().name("MTech").url("https://github.com/Mtech02/BackEnd_MTech")
								.email("techm4267@gmail.com")))
				.externalDocs(new ExternalDocumentation().description("GitHub").url("https://github.com/Mtech02"));

	}

	@Bean
	public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {
		
		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

				ApiResponses apiResponses = operation.getResponses();

				apiResponses.addApiResponse("200", createApiResponse("Sucess!"));
				apiResponses.addApiResponse("201", createApiResponse("Persistent Object!"));
				apiResponses.addApiResponse("204", createApiResponse("Deleted Object!"));
				apiResponses.addApiResponse("400", createApiResponse("Error in the Request!"));
				apiResponses.addApiResponse("401", createApiResponse("Unauthorized access!"));
				apiResponses.addApiResponse("404", createApiResponse("Object not found!"));
				apiResponses.addApiResponse("500", createApiResponse("Application Error!"));

			}));
		};
		
	}
	
	private ApiResponse createApiResponse(String mensage) {
		
		
		return new ApiResponse().description(mensage);
		
	}
	
}
