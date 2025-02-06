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

package io.oigres.ecomm.bff.admin.api.model.profiles.users;

import io.oigres.ecomm.bff.admin.api.model.enums.UserTypeApi;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UpdateCannaUserApiRequest implements Serializable {
  @Schema(name = "password", required = false)
  private String password;

  @Schema(name = "firstName", required = true)
  @NotEmpty
  private String firstName;

  @Schema(name = "lastName", required = true)
  @NotEmpty
  private String lastName;

  @Schema(name = "genderId", required = true)
  @NotNull private Long genderId;

  @Schema(name = "stateId", required = true)
  @NotNull private Long stateId;

  @Schema(name = "zipCodeId", required = true)
  @NotNull private Long zipCodeId;

  @Schema(name = "phone", required = true)
  @NotEmpty
  private String phone;

  @Schema(
      name = "card",
      example = "/id_card_image.png",
      required = false,
      allowableValues = "card image URL (no matter what type of card it is)")
  @NotEmpty
  private String card;

  @Schema(name = "userType", required = true)
  @NotEmpty
  private UserTypeApi userType;
}
