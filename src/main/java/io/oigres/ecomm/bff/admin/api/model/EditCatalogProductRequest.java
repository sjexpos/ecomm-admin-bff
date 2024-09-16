package io.oigres.ecomm.bff.admin.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class EditCatalogProductRequest implements Serializable {
    @Schema(name = "title", required = true)
    @NotNull(message = "title must not be null")
    @NotEmpty(message = "title must not be empty")
    private String title;
    @Schema(name = "ucpc", required = true)
    @NotNull(message = "ucpc must not be null")
    @NotEmpty(message = "ucpc must not be empty")
    private String ucpc;
    @Schema(name = "category", required = true)
    @Min(value = 1, message = "category must be greater than zero")
    private Long category;
    @Schema(name = "subcategory", required = true)
    @Min(value = 1, message = "subcategory must be greater than zero")
    private Long subcategory;
    @Schema(name = "brand", required = true)
    @Min(value = 1, message = "brand must be greater than zero")
    private Long brand;
    @Schema(name = "strain", required = true)
    @Min(value = 1, message = "strain must be greater than zero")
    private Long strain;
    @Schema(name = "thc", required = true)
    @NotNull(message = "thc must not be null")
    private BigDecimal thc;
    @Schema(name = "cbd", required = true)
    @NotNull(message = "cbd must not be null")
    private BigDecimal cbd;
    @Schema(name = "description", required = true)
    @NotNull(message = "description must not be null")
    @NotEmpty(message = "description must not be empty")
    private String description;
    @Schema(name = "formatValue", required = true)
    @NotNull(message = "formatValue must not be null")
    private Integer formatValue;
    @Schema(name = "formatUnit", required = true)
    @Min(value = 1, message = "formatUnit must be greater than zero")
    private Long formatUnit;
    @Schema(name = "contentValue", required = true)
    @NotNull(message = "contentValue must not be null")
    private Integer contentValue;
    @Schema(name = "contentUnit", required = true)
    @Min(value = 1, message = "contentUnit must be greater than zero")
    private Long contentUnit;
}
