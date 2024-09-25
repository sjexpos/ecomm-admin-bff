package io.oigres.ecomm.bff.admin.config;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "ecomm")
public class OpenApiV3Properties {

    @Data
    public static class AdminBFFProperties {
        @NotNull
        @NotBlank
        private String name;
        @NotNull
        @NotBlank
        private String version;
        private String description;
    }

    @Data
    public static class BFFProperties {
        @NotNull
        private AdminBFFProperties admin;
    }

    @NotNull
    @NotBlank
    private String termsOfService;
    @NotNull
    @NotBlank
    private String license;
    @NotNull
    private BFFProperties bff;

}
