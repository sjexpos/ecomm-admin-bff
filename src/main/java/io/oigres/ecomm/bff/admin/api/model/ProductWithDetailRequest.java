package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class ProductWithDetailRequest implements Serializable {
    private Integer id;
    @NotNull
    private List<ResourceRequest> images;
    @NotNull
    private List<ResourceRequest> videos;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String ucpc;
    @NotNull
    private Integer categoryId;
    @NotNull
    private Integer subCategoryId;
    @NotNull
    private Integer brandId;
    @NotNull
    private Integer strainId;
    private Float thc;
    private Float cbd;
    @NotNull
    private Integer format;
    @NotNull
    private Integer formatUnitId;
    @NotNull
    private Integer content;
    @NotNull
    private Integer contentUnitId;
    @NotNull
    @NotEmpty
    private String description;
}
