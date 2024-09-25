package io.oigres.ecomm.bff.admin.config;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "ecomm.bff.tracing")
public class TracingProperties {
    @NotNull
    @NotBlank
    private String url;
}
