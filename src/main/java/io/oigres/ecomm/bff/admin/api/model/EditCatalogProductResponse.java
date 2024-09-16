package io.oigres.ecomm.bff.admin.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
public class EditCatalogProductResponse implements Serializable {
    private Long id;
    private String title;
    private String ucpc;
    private Long category;
    private Long subcategory;
    private Long brand;
    private Long strain;
    private BigDecimal thc;
    private BigDecimal cbd;
    private String description;
    private Integer formatValue;
    private Long formatUnit;
    private Integer contentValue;
    private Long contentUnit;
}
