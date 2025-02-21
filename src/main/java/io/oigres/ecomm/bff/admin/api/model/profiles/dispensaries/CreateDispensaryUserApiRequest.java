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

package io.oigres.ecomm.bff.admin.api.model.profiles.dispensaries;

import io.oigres.ecomm.bff.admin.api.model.ResourceRequest;
import io.oigres.ecomm.bff.admin.api.model.SocialMediaRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CreateDispensaryUserApiRequest implements Serializable {
  @Schema(name = "name", example = "", required = true)
  @NotEmpty
  private String name;

  @Schema(name = "description", example = "", required = true)
  @NotEmpty
  private String description;

  @Schema(name = "email", example = "dispensary@email.com", required = true)
  @NotEmpty
  @Email
  private String email;

  @Schema(name = "password", example = "", required = true)
  @NotEmpty
  private String password;

  @Schema(name = "address", example = "", required = true)
  @NotEmpty
  private String address;

  @Schema(name = "logo", example = "", required = true)
  @NotEmpty
  private String logo;

  @Schema(name = "license", example = "", required = true)
  @NotEmpty
  private String license;

  @Schema(
      name = "licenseStatus",
      allowableValues = "PENDING, APPROVED, REJECTED",
      example = "PENDING",
      required = true)
  @NotEmpty(message = "licenseStatus must not be empty")
  private String licenseStatus;

  @Schema(name = "socialMedia", example = "", required = true)
  @NotNull private SocialMediaRequest socialMedia;

  @Schema(name = "phone", example = "", required = true)
  @NotEmpty
  private String phone;

  @Schema(name = "images", example = "", required = false)
  @Singular
  private List<ResourceRequest> images;

  @Schema(name = "videos", example = "", required = false)
  @Singular
  private List<ResourceRequest> videos;

  @Schema(name = "isActive", example = "", required = false, type = "boolean")
  private Boolean isActive;

  public List<ResourceRequest> getVideos() {
    return List.copyOf(videos);
  }

  public List<ResourceRequest> getImages() {
    return List.copyOf(images);
  }
}
