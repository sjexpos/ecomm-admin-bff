package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductResponse implements Serializable {
    private Integer id;
    private String img;
    private String title;
    private String brandName;
    private String categoryName;
    private String subCategoryName;
    private String quantity;
    private Boolean isPaused;
    private String status;
}
