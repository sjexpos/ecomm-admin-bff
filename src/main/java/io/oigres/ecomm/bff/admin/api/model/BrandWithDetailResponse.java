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

import java.util.List;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class BrandWithDetailResponse extends BrandResponse {
  private String license;
  private String licenseStatus;
  private String address;
  @Singular private List<Integer> productCategoriesIds;
  @Singular private List<Integer> featuredProductsIds;
  private String description;
  private ResourceResponse logo;
  private String ucpc;
  private String type;
  private String phone;
  private String email;
  private SocialMediaResponse socialMedia;
  @Singular private List<ResourceResponse> images;
  @Singular private List<ResourceResponse> videos;

  public List<Integer> getProductCategoriesIds() {
    return List.copyOf(productCategoriesIds);
  }

  public List<Integer> getFeaturedProductsIds() {
    return List.copyOf(featuredProductsIds);
  }

  public List<ResourceResponse> getImages() {
    return List.copyOf(images);
  }

  public List<ResourceResponse> getVideos() {
    return List.copyOf(videos);
  }
}
