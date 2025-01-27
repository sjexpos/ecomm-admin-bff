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

package io.oigres.ecomm.bff.admin.api.model.products.strains;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DeleteStrainApiResponse {
  @Schema(name = "id", example = "1")
  private Long id;

  @Schema(name = "ucpc", example = "4CRCZTMHQW00000000000000")
  private String ucpc;

  @Schema(name = "name", example = "Afternoon Delight")
  private String name;

  @Schema(
      name = "description",
      example = "Afternoon Delight is a hybrid marijuana strain created by Colorado Seed Inc.")
  private String description;

  @Schema(name = "strainType", example = "1")
  private Integer strainType;

  @Schema(name = "seedCompany", example = "1")
  private Integer seedCompany;

  @Schema(name = "calmingEnergizingValue", example = "5")
  private Integer calmingEnergizingValue;

  @Schema(name = "thc", example = "20")
  private Integer thc;

  @Schema(name = "cbd", example = "20")
  private Integer cbd;

  @Schema(name = "cbg", example = "20")
  private Integer cbg;

  @Schema(name = "thcv", example = "20")
  private Integer thcv;

  @Schema(name = "enabled", example = "true")
  private Boolean enabled;
}
