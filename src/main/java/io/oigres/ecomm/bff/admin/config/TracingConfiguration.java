package io.oigres.ecomm.bff.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;

@Configuration
public class TracingConfiguration {

    @Bean
    public OtlpHttpSpanExporter otlpHttpSpanExporter(TracingProperties properties) {
        return OtlpHttpSpanExporter.builder()
                .setEndpoint(properties.getUrl())
                .build();
    }

}
