package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductToApproveResponse implements Serializable {
    private Integer id;
    private String ucpc;
    private ResourceResponse img;
    private String name;
    private String brandName;
    private String categoryName;
    private String subCategoryName;
    private List<String> flavors;
    private String quantity;
    private String description;
    private String status;
}
