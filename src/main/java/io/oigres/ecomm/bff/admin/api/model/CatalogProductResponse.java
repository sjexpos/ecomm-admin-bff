package io.oigres.ecomm.bff.admin.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CatalogProductResponse implements Serializable {
    private Long id;
    private String image;
    private String name;
    private String brand;
    private String category;
    private String subCategory;
    private Integer formatValue;
    private String formatUnit;
    private Integer contentValue;
    private String contentUnit;
    private Boolean isActive;
}