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

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetAllDispensariesApiResponse implements Serializable {
  @Schema(name = "id", example = "1")
  private Long id;

  @Schema(name = "logoImageURL", example = "")
  private String logoImageURL;

  @Schema(name = "email", example = "info@leftcoast.club")
  private String email;

  @Schema(name = "enabled", example = " ")
  private Boolean enabled;

  @Schema(name = "name", example = "")
  private String name;

  @Schema(name = "state", example = "Left Coast Extracts")
  private String state;

  @Schema(name = "licenseStatus", example = "Left Coast Extracts")
  private String licenseStatus;

  @Schema(name = "userId", example = "1")
  private Long userId;
}
