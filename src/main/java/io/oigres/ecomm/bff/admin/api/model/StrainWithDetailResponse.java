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

import java.io.Serializable;
import java.util.List;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class StrainWithDetailResponse implements Serializable {
  private Integer id;
  private String ucpc;

  @Singular("img")
  private List<ResourceRequest> img;

  private String name;
  private Integer calmingLevel;
  private Integer typeId;
  private Integer seedCompanyId;
  private Float thc;
  private Float cbd;
  private Float cbg;
  private Float thcv;
  @Singular private List<Integer> terpenesIds;
  @Singular private List<Integer> helpsWithIds;
  @Singular private List<Integer> consumeTypesIds;
  @Singular private List<Integer> effectsIds;
  @Singular private List<Integer> flavorsIds;
  private Boolean isPaused;
  private String description;

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
