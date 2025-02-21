/**********
 This project is free software; you can redistribute it and/or modify it under
 the terms of the GNU General Public License as published by the
 Free Software Foundation; either version 3.0 of the License, or (at your
 option) any later version. (See <https://www.gnu.org/licenses/gpl-3.0.html>.)

 This project is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 more details.

 You should have received a copy of the GNU General Public License
 along with this project; if not, write to the Free Software Foundation, Inc.,
 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 **********/
// Copyright (c) 2024-2025 Sergio Exposito.  All rights reserved.              

package io.oigres.ecomm.bff.admin.api.model.products.brands;

import io.oigres.ecomm.bff.admin.api.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class UpdateBrandByIdApiRequest {
  @Schema(name = "name", example = "Left Coast Extracts", required = true)
  @NotNull(message = "name must not be null") @NotEmpty(message = "name must not be empty")
  private String name;

  @Schema(name = "description")
  @NotNull(message = "description must not be null") private String description;

  @Schema(name = "email", example = "info@leftcoast.club", required = true)
  @Email(regexp = Constants.EMAIL_REGEX_VALIDATION)
  private String email;

  @Schema(name = "license", example = "0001070-LIC", required = true)
  @NotNull(message = "license must not be null") @NotEmpty(message = "license must not be empty")
  private String license;

  @Schema(
      name = "brandType",
      allowableValues = "GROWER, PROCESSOR, GROWER & PROCESSOR",
      example = "GROWER",
      required = true)
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
  @NotNull(message = "enabled must not be null") private Boolean enabled;

  @Schema(
      name = "licenseStatus",
      allowableValues = "PENDING, APPROVED, REJECTED",
      example = "PENDING",
      required = true)
  @NotNull(message = "licenseStatus must not be null") @NotEmpty(message = "licenseStatus must not be empty")
  private String licenseStatus;

  @Schema(name = "phone")
  @NotNull(message = "phone must not be null") @NotEmpty(message = "phone must not be empty")
  private String phone;

  @Schema(name = "address")
  @NotNull(message = "address must not be null") @NotEmpty(message = "address must not be empty")
  private String address;

  @Schema(name = "ucpc")
  @NotNull(message = "ucpc must not be null") @NotEmpty(message = "ucpc must not be empty")
  private String ucpc;

  @Schema(name = "categoriesIds", example = "[1,2]")
  @Singular
  private List<Integer> categoriesIds;

  @Schema(name = "featuresProductsIds", example = "[1,2]")
  @Singular
  private List<Integer> featuresProductsIds;

  @Schema(name = "images", example = "[1,2]")
  @Singular
  private List<String> images;

  @Schema(name = "videos", example = "[1,2]")
  @Singular
  private List<String> videos;

  public List<Integer> getCategoriesIds() {
    return List.copyOf(categoriesIds);
  }

  public List<Integer> getFeaturesProductsIds() {
    return List.copyOf(featuresProductsIds);
  }

  public List<String> getImages() {
    return List.copyOf(images);
  }

  public List<String> getVideos() {
    return List.copyOf(videos);
  }
}
