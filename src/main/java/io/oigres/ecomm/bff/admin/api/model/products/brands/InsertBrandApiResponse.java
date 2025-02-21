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

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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

  @Schema(name = "categoriesIds")
  @Singular
  private List<Integer> categoriesIds;

  @Schema(name = "featuresProductsIds")
  @Singular
  private List<Integer> featuresProductsIds;

  @Schema(name = "images")
  @Singular
  private List<Integer> images;

  @Schema(name = "videos")
  @Singular
  private List<Integer> videos;

  public List<Integer> getCategoriesIds() {
    return List.copyOf(categoriesIds);
  }

  public List<Integer> getFeaturesProductsIds() {
    return List.copyOf(featuresProductsIds);
  }

  public List<Integer> getImages() {
    return List.copyOf(images);
  }

  public List<Integer> getVideos() {
    return List.copyOf(videos);
  }
}
