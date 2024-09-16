package io.oigres.ecomm.bff.admin.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class CatalogProductByIdResponse implements Serializable {
    private Long id;
    private String name;
    private String ucpc;
    private Long category;
    private Long subcategory;
    private Long brand;
    private Long strain;
    private BigDecimal thc;
    private BigDecimal cbd;
    private Integer formatValue;
    private Long formatUnit;
    private Integer contentValue;
    private Long contentUnit;
    private String description;
    private List<ResourceResponse> images;
    private List<ResourceResponse> videos;
    private Boolean isCatalogProduct;
    private Boolean isActive;
}