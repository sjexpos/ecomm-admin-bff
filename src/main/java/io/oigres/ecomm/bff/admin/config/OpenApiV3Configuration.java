package io.oigres.ecomm.bff.admin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiV3Configuration {

    @Bean
    public OpenAPI customOpenAPI(
            @Value("${ecomm.bff.admin.version}") String appVersion,
            @Value("${ecomm.bff.admin.name}") String appName,
            @Value("${ecomm.termsOfService}") String appTermsOfService,
            @Value("${ecomm.license}") String appLicense
    ) {
        return new OpenAPI()
                .info(
                        new Info()
                                .title(appName)
                                .version(appVersion)
                                .description("EComm - Admin backend for frontend.")
                                .termsOfService(appTermsOfService)
                                .license(
                                        new License()
                                                .name("Private License")
                                                .url(appLicense)
                                )
                );
    }

}
