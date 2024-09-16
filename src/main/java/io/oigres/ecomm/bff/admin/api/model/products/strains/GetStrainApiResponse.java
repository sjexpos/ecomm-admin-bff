package io.oigres.ecomm.bff.admin.api.model.products.strains;

import io.oigres.ecomm.bff.admin.api.model.GetEffectByIdApiResponse;
import io.oigres.ecomm.bff.admin.api.model.GetFlavorByIdApiResponse;
import io.oigres.ecomm.bff.admin.api.model.GetTerpeneByIdApiResponse;
import io.oigres.ecomm.bff.admin.api.model.conditions.GetConditionByIdApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
public class GetStrainApiResponse {
    @Schema(name = "id", example = "1")
    private Long id;
    @Schema(name = "ucpc", example = "4CRCZTMHQW00000000000000")
    private String ucpc;
    @Schema(name = "name", example = "Afternoon Delight")
    private String name;
    @Schema(name = "description", example = "Afternoon Delight is a hybrid marijuana strain created by Colorado Seed Inc.")
    private String description;
    @Schema(name = "strainType", example = "1")
    private Long strainType;
    @Schema(name = "seedCompany", example = "1")
    private Long seedCompany;
    @Schema(name = "calmingEnergizingValue", example = "5")
    private BigDecimal calmingEnergizingValue;
    @Schema(name = "thc", example = "20")
    private BigDecimal thc;
    @Schema(name = "cbd", example = "20")
    private BigDecimal cbd;
    @Schema(name = "cbg", example = "20")
    private BigDecimal cbg;
    @Schema(name = "thcv", example = "20")
    private BigDecimal thcv;
    @Schema(name = "isActive", example = "true")
    private Boolean isActive;
    private Set<GetTerpeneByIdApiResponse> terpenes;
    private Set<GetConditionByIdApiResponse> helpsWith;
    private Set<GetEffectByIdApiResponse> effects;
    private Set<GetFlavorByIdApiResponse> flavors;
    private Set<String> images;
}
