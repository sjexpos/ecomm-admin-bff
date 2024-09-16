package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductWithDetailResponse implements Serializable {
    private Integer id;
    private List<ResourceRequest> images;
    private List<ResourceRequest> videos;
    private String name;
    private String ucpc;
    private Integer categoryId;
    private Integer subCategoryId;
    private Integer brandId;
    private Integer strainId;
    private Float thc;
    private Float cbd;
    private Integer format;
    private Integer formatUnitId;
    private Integer content;
    private Integer contentUnitId;
    private String description;
}
