package io.oigres.ecomm.bff.admin.api.model.products.brands;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class InsertBrandApiResponse {
    @Schema(name = "id", example = "1")
    private Long id;
    @Schema(name = "name", example = "Left Coast Extracts")
    private String name;
    @Schema(name = "description")
    private String description;
    @Schema(name = "email", example = "info@leftcoast.club")
    private String email;
    @Schema(name = "license", example = "0001070-LIC")
    private String license;

    @Schema(name = "brandType", example = "GROWER")
    private String brandType;

    @Schema(name = "logoImageURL")
    private String logoImageURL;
    @Schema(name = "instagramURL")
    private String instagramURL;
    @Schema(name = "twitterURL")
    private String twitterURL;
    @Schema(name = "facebookURL")
    private String facebookURL;
    @Schema(name = "websiteURL")
    private String websiteURL;
    @Schema(name = "adminId", example = "0")
    private Integer adminId;
    @Schema(name = "enabled")
    private Boolean enabled;
    @Schema(name = "licenseStatus", example = "PENDING")
    private String licenseStatus;
    @Schema(name = "phone")
    private String phone;
    @Schema(name = "address")
    private String address;
    @Schema(name = "ucpc")
    private String ucpc;
    @Builder.Default
    @Schema(name = "categoriesIds")
    private List<Integer> categoriesIds = new ArrayList<>();
    @Builder.Default
    @Schema(name = "featuresProductsIds")
    private List<Integer> featuresProductsIds = new ArrayList<>();
    @Builder.Default
    @Schema(name = "images")
    private List<Integer> images = new ArrayList<>();
    @Builder.Default
    @Schema(name = "videos")
    private List<Integer> videos = new ArrayList<>();
}
