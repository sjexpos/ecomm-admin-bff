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

package io.oigres.ecomm.bff.admin.api.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class StrainWithDetailRequest implements Serializable {
  private Integer id;
  @NotNull @NotEmpty private String ucpc;

  @Singular("img")
  @NotNull private List<ResourceRequest> img;

  @NotNull @NotEmpty private String name;
  @NotNull private Integer calmingLevel;
  @NotNull private Integer typeId;
  @NotNull private Integer seedCompanyId;
  private Float thc;
  private Float cbd;
  private Float cbg;
  private Float thcv;
  @Singular @NotNull private List<Integer> terpenesIds;
  @Singular @NotNull private List<Integer> helpsWithIds;
  @Singular @NotNull private List<Integer> consumeTypesIds;
  @Singular @NotNull private List<Integer> effectsIds;
  @Singular @NotNull private List<Integer> flavorsIds;
  private Boolean isPaused;
  @NotNull @NotEmpty private String description;

  public List<ResourceRequest> getImg() {
    return List.copyOf(img);
  }

  public List<Integer> getTerpenesIds() {
    return List.copyOf(terpenesIds);
  }

  public List<Integer> getHelpsWithIds() {
    return List.copyOf(helpsWithIds);
  }

  public List<Integer> getConsumeTypesIds() {
    return List.copyOf(consumeTypesIds);
  }

  public List<Integer> getEffectsIds() {
    return List.copyOf(effectsIds);
  }

  public List<Integer> getFlavorsIds() {
    return List.copyOf(flavorsIds);
  }
}
