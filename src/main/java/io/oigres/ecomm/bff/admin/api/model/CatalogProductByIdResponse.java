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
import java.math.BigDecimal;
import java.util.List;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CatalogProductByIdResponse implements Serializable {
  private Long id;
  private String name;
  private String ucpc;
  private Long category;
  private Long subcategory;
  private Long brand;
  private Long strain;
  private BigDecimal thc;
  private BigDecimal cbd;
  private Integer formatValue;
  private Long formatUnit;
  private Integer contentValue;
  private Long contentUnit;
  private String description;
  @Singular private List<ResourceResponse> images;
  @Singular private List<ResourceResponse> videos;
  private Boolean isCatalogProduct;
  private Boolean isActive;

  public List<ResourceResponse> getImages() {
    return List.copyOf(images);
  }

  public List<ResourceResponse> getVideos() {
    return List.copyOf(videos);
  }
}
