package io.oigres.ecomm.bff.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiV3Configuration {

    @Bean
    public OpenAPI customOpenAPI(
            OpenApiV3Properties openApiV3Properties
    ) {
        return new OpenAPI()
                .info(
                        new Info()
                                .title(openApiV3Properties.getBff().getAdmin().getName())
                                .version(openApiV3Properties.getBff().getAdmin().getVersion())
                                .description(openApiV3Properties.getBff().getAdmin().getDescription())
                                .termsOfService(openApiV3Properties.getTermsOfService())
                                .license(
                                        new License()
                                                .name("Private License")
                                                .url(openApiV3Properties.getLicense())
                                )
                );
    }

}
