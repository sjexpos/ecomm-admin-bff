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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class InsertStrainApiRequest {
  @Schema(name = "name", example = "strain test name", required = true)
  @NotNull(message = "name must not be null") @NotEmpty(message = "name must not be empty")
  private String name;

  @Schema(
      name = "description",
      example =
          "The original White Widow was created when a sativa landrace from Brazil was pollinated"
              + " by an indica hybrid from southern India.",
      required = true)
  private String description;

  @Schema(name = "ucpc", example = "PKL123-MN3456-00SD-XZ11", required = true)
  @NotNull(message = "ucpc must not be null") @NotEmpty(message = "ucpc must not be empty")
  private String ucpc;

  @Schema(name = "strainType", example = "1", required = true)
  @Min(value = 1, message = "strainType must be greater than zero")
  @NotNull(message = "strainType must not be null") private Integer strainType;

  @Schema(name = "seedCompany", example = "1", required = true)
  @Min(value = 1, message = "seedCompany must be greater than zero")
  @NotNull(message = "seedCompany must not be null") private Integer seedCompany;

  @Schema(name = "calmingEnergizingValue", example = "5", required = true)
  private BigDecimal calmingEnergizingValue;

  @Schema(name = "thc", example = "15.2")
  private BigDecimal thc;

  @Schema(name = "cbd", example = "14.0")
  private BigDecimal cbd;

  @Schema(name = "cbg", example = "10.5")
  private BigDecimal cbg;

  @Schema(name = "thcv", example = "60.3")
  private BigDecimal thcv;

  @Schema(name = "enabled", example = "true")
  private Boolean enabled;

  @Schema(name = "terpenesIds", example = "[1, 2]")
  @Singular
  private List<Integer> terpenesIds;

  @Schema(name = "helpsWithIds", example = "[1, 2]")
  @Singular
  private List<Integer> helpsWithIds;

  @Schema(name = "effectsIds", example = "[1, 2]")
  @Singular
  private List<Integer> effectsIds;

  @Schema(name = "flavorsIds", example = "[1, 2]")
  @Singular
  private List<Integer> flavorsIds;

  @Singular private List<String> images;

  public List<Integer> getTerpenesIds() {
    return List.copyOf(terpenesIds);
  }

  public List<Integer> getHelpsWithIds() {
    return List.copyOf(helpsWithIds);
  }

  public List<Integer> getEffectsIds() {
    return List.copyOf(effectsIds);
  }

  public List<Integer> getFlavorsIds() {
    return List.copyOf(flavorsIds);
  }

  public List<String> getImages() {
    return List.copyOf(images);
  }
}
