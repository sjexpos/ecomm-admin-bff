package io.oigres.ecomm.bff.admin.api.model.products.strains;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class UpdateStrainByIdApiResponse {
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
    private BigDecimal calmingEnergizingValue;
    @Schema(name = "thc", example = "20")
    private BigDecimal thc;
    @Schema(name = "cbd", example = "20")
    private BigDecimal cbd;
    @Schema(name = "cbg", example = "20")
    private BigDecimal cbg;
    @Schema(name = "thcv", example = "20")
    private BigDecimal thcv;
    @Schema(name = "enabled", example = "true")
    private Boolean enabled;

    @Schema(name = "terpenesIds", example = "[1, 2]")
    private List<Integer> terpenesIds = new ArrayList<>();
    @Schema(name = "helpsWithIds", example = "[1, 2]")
    private List<Integer> helpsWithIds = new ArrayList<>();
    @Schema(name = "effectsIds", example = "[1, 2]")
    private List<Integer> effectsIds = new ArrayList<>();
    @Schema(name = "flavorsIds", example = "[1, 2]")
    private List<Integer> flavorsIds = new ArrayList<>();
    private List<String> images = new ArrayList<>(); //Maybe should be Long for ids
}
