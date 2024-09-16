package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BrandWithDetailRequest implements Serializable {
    private Integer id;
    private String name;
    private String license;
    private String licenseStatus;
    private String address;
    private List<Integer> productCategoriesIds;
    private List<Integer> featuresProductsIds;
    private String description;
    private ResourceRequest logo;
    private String ucpc;
    private String type;
    private String phone;
    private String email;
    private SocialMediaRequest socialMedia;
    private List<ResourceRequest> images;
    private List<ResourceRequest> videos;
}