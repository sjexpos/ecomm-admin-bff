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
import java.io.Serializable;
import java.util.List;
import lombok.Builder;
import lombok.Data;

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
