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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class DispensaryUserWithDetailRequest implements Serializable {
  private Long id;
  @NotNull @NotEmpty private String name;
  @NotNull @NotEmpty private String description;
  @NotNull @NotEmpty @Email private String email;
  @NotNull @NotEmpty private String password;
  @NotNull @NotEmpty private String address;
  @NotNull @NotEmpty private String logo;
  @NotNull @NotEmpty private String license;
  @NotNull private Integer licenseStatus;
  @NotNull private SocialMediaRequest socialMedia;
  @NotNull @NotEmpty private String phone;
  private List<ResourceRequest> images;
  private List<ResourceRequest> videos;
  private Boolean isActive;
}
