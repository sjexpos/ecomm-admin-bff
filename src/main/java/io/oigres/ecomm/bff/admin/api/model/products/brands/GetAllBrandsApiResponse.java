package io.oigres.ecomm.bff.admin.api.model.products.brands;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class GetAllBrandsApiResponse implements Serializable {
    @Schema(name = "id", example = "1")
    private Long id;
    @Schema(name = "name", example = "Left Coast Extracts")
    private String name;
    @Schema(name = "description", example = " ")
    private String description;
    @Schema(name = "email", example = "info@leftcoast.club")
    private String email;
    @Schema(name = "license", example = "0001070-LIC")
    private String license;
    @Schema(name = "brandType", example = "GROWER")
    private String brandType;
    @Schema(name = "logoImageURL", example = " ")
    private String logoImageURL;
    @Schema(name = "instagramURL", example = " ")
    private String instagramURL;
    @Schema(name = "twitterURL", example = " ")
    private String twitterURL;
    @Schema(name = "facebookURL", example = " ")
    private String facebookURL;
    @Schema(name = "websiteURL", example = " ")
    private String websiteURL;
    @Schema(name = "adminId", example = "0")
    private Integer adminId;
    @Schema(name = "enabled", example = " ")
    private Boolean enabled;
    @Schema(name = "licenseStatus", example = " ")
    private String licenseStatus;
    @Schema(name = "phone", example = " ")
    private String phone;
    @Schema(name = "address", example = " ")
    private String address;
    @Schema(name = "ucpc", example = " ")
    private String ucpc;
    @Schema(name = "categoriesIds", example = " ")
    private List<Integer> categoriesIds;
    @Schema(name = "featuresProductsIds", example = " ")
    private List<Integer> featuresProductsIds;
    @Schema(name = "images", example = " ")
    private List<String> images;
    @Schema(name = "videos", example = " ")
    private List<String> videos;
}
