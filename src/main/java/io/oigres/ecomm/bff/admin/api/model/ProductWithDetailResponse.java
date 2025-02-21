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
public class ProductWithDetailResponse implements Serializable {
  private Integer id;
  @Singular private List<ResourceRequest> images;
  @Singular private List<ResourceRequest> videos;
  private String name;
  private String ucpc;
  private Integer categoryId;
  private Integer subCategoryId;
  private Integer brandId;
  private Integer strainId;
  private Float thc;
  private Float cbd;
  private Integer format;
  private Integer formatUnitId;
  private Integer content;
  private Integer contentUnitId;
  private String description;

  public List<ResourceRequest> getVideos() {
    return List.copyOf(videos);
  }

  public List<ResourceRequest> getImages() {
    return List.copyOf(images);
  }
}
