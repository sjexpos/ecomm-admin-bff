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

import io.oigres.ecomm.bff.admin.api.model.GetEffectByIdApiResponse;
import io.oigres.ecomm.bff.admin.api.model.GetFlavorByIdApiResponse;
import io.oigres.ecomm.bff.admin.api.model.GetTerpeneByIdApiResponse;
import io.oigres.ecomm.bff.admin.api.model.conditions.GetConditionByIdApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.Set;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GetStrainApiResponse {
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
  private Long strainType;

  @Schema(name = "seedCompany", example = "1")
  private Long seedCompany;

  @Schema(name = "calmingEnergizingValue", example = "5")
  private BigDecimal calmingEnergizingValue;

  @Schema(name = "thc", example = "20")
  private BigDecimal thc;

  @Schema(name = "cbd", example = "20")
  private BigDecimal cbd;

  @Schema(name = "cbg", example = "20")
  private BigDecimal cbg;

  @Schema(name = "thcv", example = "20")
  private BigDecimal thcv;

  @Schema(name = "isActive", example = "true")
  private Boolean isActive;

  @Singular private Set<GetTerpeneByIdApiResponse> terpenes;

  @Singular("helpsWith")
  private Set<GetConditionByIdApiResponse> helpsWith;

  @Singular private Set<GetEffectByIdApiResponse> effects;
  @Singular private Set<GetFlavorByIdApiResponse> flavors;
  @Singular private Set<String> images;

  public Set<GetTerpeneByIdApiResponse> getTerpenes() {
    return Set.copyOf(terpenes);
  }

  public Set<GetConditionByIdApiResponse> getHelpsWith() {
    return Set.copyOf(helpsWith);
  }

  public Set<GetEffectByIdApiResponse> getEffects() {
    return Set.copyOf(effects);
  }

  public Set<GetFlavorByIdApiResponse> getFlavors() {
    return Set.copyOf(flavors);
  }

  public Set<String> getImages() {
    return Set.copyOf(images);
  }
}
