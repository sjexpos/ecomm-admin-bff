package io.oigres.ecomm.bff.admin.api.model.products.brands;

import io.oigres.ecomm.bff.admin.api.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Data
public class InsertBrandApiRequest {
    @Schema(name = "name", example = "Left Coast Extracts", required = true)
    @NotNull(message = "name must not be null")
    @NotEmpty(message = "name must not be empty")
    private String name;
    @Schema(name = "description")
    @NotNull(message = "description must not be null")
    private String description;
    @Schema(name = "email", example = "info@leftcoast.club", required = true)
    @Email(regexp = Constants.EMAIL_REGEX_VALIDATION)
    private String email;
    @Schema(name = "license", example = "0001070-LIC", required = true)
    @NotNull(message = "license must not be null")
    @NotEmpty(message = "license must not be empty")
    private String license;
    @Schema(name = "brandType", allowableValues = "GROWER, PROCESSOR, GROWER & PROCESSOR", example = "GROWER", required = true)
    private String brandType;
    @Schema(name = "logoImageURL", required = true)
    private String logoImageURL;
    @Schema(name = "instagramURL")
    private String instagramURL;
    @Schema(name = "twitterURL")
    private String twitterURL;
    @Schema(name = "facebookURL")
    private String facebookURL;
    @Schema(name = "websiteURL")
    private String websiteURL;
    @Schema(name = "adminId", example = "0", required = true)
    private Integer adminId;
    @Schema(name = "enabled")
    @NotNull(message = "enabled must not be null")
    private Boolean enabled;
    @Schema(name = "licenseStatus", allowableValues = "PENDING, APPROVED, REJECTED", example = "PENDING", required = true)
    @NotNull(message = "licenseStatus must not be null")
    @NotEmpty(message = "licenseStatus must not be empty")
    private String licenseStatus;
    @Schema(name = "phone")
    @NotNull(message = "phone must not be null")
    @NotEmpty(message = "phone must not be empty")
    private String phone;
    @Schema(name = "address")
    @NotNull(message = "address must not be null")
    @NotEmpty(message = "address must not be empty")
    private String address;
    @Schema(name = "ucpc")
    @NotNull(message = "ucpc must not be null")
    @NotEmpty(message = "ucpc must not be empty")
    private String ucpc;
    @Schema(name = "categoriesIds", example = "[1,2]")
    private List<Integer> categoriesIds;
    @Schema(name = "featuresProductsIds", example = "[1,2]")
    private List<Integer> featuresProductsIds;
    @Schema(name = "images", example = "[1,2]")
    private List<String> images;
    @Schema(name = "videos", example = "[1,2]")
    private List<String> videos;
}