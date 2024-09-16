package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class StrainWithDetailRequest implements Serializable {
    private Integer id;
    @NotNull
    @NotEmpty
    private String ucpc;
    @NotNull
    private List<ResourceRequest> img;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    private Integer calmingLevel;
    @NotNull
    private Integer typeId;
    @NotNull
    private Integer seedCompanyId;
    private Float thc;
    private Float cbd;
    private Float cbg;
    private Float thcv;
    @NotNull
    private List<Integer> terpenesIds;
    @NotNull
    private List<Integer> helpsWithIds;
    @NotNull
    private List<Integer> consumeTypesIds;
    @NotNull
    private List<Integer> effectsIds;
    @NotNull
    private List<Integer> flavorsIds;
    private Boolean isPaused;
    @NotNull
    @NotEmpty
    private String description;
}
