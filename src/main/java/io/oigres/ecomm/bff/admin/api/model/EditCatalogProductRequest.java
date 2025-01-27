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

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EditCatalogProductRequest implements Serializable {
  @Schema(name = "title", required = true)
  @NotNull(message = "title must not be null") @NotEmpty(message = "title must not be empty")
  private String title;

  @Schema(name = "ucpc", required = true)
  @NotNull(message = "ucpc must not be null") @NotEmpty(message = "ucpc must not be empty")
  private String ucpc;

  @Schema(name = "category", required = true)
  @Min(value = 1, message = "category must be greater than zero")
  private Long category;

  @Schema(name = "subcategory", required = true)
  @Min(value = 1, message = "subcategory must be greater than zero")
  private Long subcategory;

  @Schema(name = "brand", required = true)
  @Min(value = 1, message = "brand must be greater than zero")
  private Long brand;

  @Schema(name = "strain", required = true)
  @Min(value = 1, message = "strain must be greater than zero")
  private Long strain;

  @Schema(name = "thc", required = true)
  @NotNull(message = "thc must not be null") private BigDecimal thc;

  @Schema(name = "cbd", required = true)
  @NotNull(message = "cbd must not be null") private BigDecimal cbd;

  @Schema(name = "description", required = true)
  @NotNull(message = "description must not be null") @NotEmpty(message = "description must not be empty")
  private String description;

  @Schema(name = "formatValue", required = true)
  @NotNull(message = "formatValue must not be null") private Integer formatValue;

  @Schema(name = "formatUnit", required = true)
  @Min(value = 1, message = "formatUnit must be greater than zero")
  private Long formatUnit;

  @Schema(name = "contentValue", required = true)
  @NotNull(message = "contentValue must not be null") private Integer contentValue;

  @Schema(name = "contentUnit", required = true)
  @Min(value = 1, message = "contentUnit must be greater than zero")
  private Long contentUnit;
}
