package io.oigres.ecomm.bff.admin.api.model.products.strains;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DeleteStrainApiResponse {
    @Schema(name = "id", example = "1")
    private Long id;
    @Schema(name = "ucpc", example = "4CRCZTMHQW00000000000000")
    private String ucpc;
    @Schema(name = "name", example = "Afternoon Delight")
    private String name;
    @Schema(name = "description", example = "Afternoon Delight is a hybrid marijuana strain created by Colorado Seed Inc.")
    private String description;
    @Schema(name = "strainType", example = "1")
    private Integer strainType;
    @Schema(name = "seedCompany", example = "1")
    private Integer seedCompany;
    @Schema(name = "calmingEnergizingValue", example = "5")
    private Integer calmingEnergizingValue;
    @Schema(name = "thc", example = "20")
    private Integer thc;
    @Schema(name = "cbd", example = "20")
    private Integer cbd;
    @Schema(name = "cbg", example = "20")
    private Integer cbg;
    @Schema(name = "thcv", example = "20")
    private Integer thcv;
    @Schema(name = "enabled", example = "true")
    private Boolean enabled;
}