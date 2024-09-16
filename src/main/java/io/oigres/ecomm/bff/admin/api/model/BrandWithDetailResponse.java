package io.oigres.ecomm.bff.admin.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class BrandWithDetailResponse extends BrandResponse {
    private String license;
    private String licenseStatus;
    private String address;
    private List<Integer> productCategoriesIds;
    private List<Integer> featuredProductsIds;
    private String description;
    private ResourceResponse logo;
    private String ucpc;
    private String type;
    private String phone;
    private String email;
    private SocialMediaResponse socialMedia;
    private List<ResourceResponse> images;
    private List<ResourceResponse> videos;
}
