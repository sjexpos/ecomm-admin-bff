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
public class BrandWithDetailRequest implements Serializable {
  private Integer id;
  private String name;
  private String license;
  private String licenseStatus;
  private String address;
  @Singular private List<Integer> productCategoriesIds;
  @Singular private List<Integer> featuresProductsIds;
  private String description;
  private ResourceRequest logo;
  private String ucpc;
  private String type;
  private String phone;
  private String email;
  private SocialMediaRequest socialMedia;
  @Singular private List<ResourceRequest> images;
  @Singular private List<ResourceRequest> videos;

  public List<Integer> getProductCategoriesIds() {
    return List.copyOf(productCategoriesIds);
  }

  public List<Integer> getFeaturesProductsIds() {
    return List.copyOf(featuresProductsIds);
  }

  public List<ResourceRequest> getImages() {
    return List.copyOf(images);
  }

  public List<ResourceRequest> getVideos() {
    return List.copyOf(videos);
  }
}
