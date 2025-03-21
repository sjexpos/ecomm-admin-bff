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
public class OrderWithDetailResponse implements Serializable {
  private Long id;
  private Long orderNumber;
  private long orderDate;
  @Singular private List<OrderItemResponse> items;
  @Singular private List<OrderStatusResponse> statuses;
  private String paymentMethod;
  private String deliveryMethod;
  private BigDecimal totalPriceProducts;
  private BigDecimal exciseTax;
  private BigDecimal salesTax;
  private BigDecimal totalPriceOrder;
  private OrderUserResponse user;
  private OrderDispensaryResponse dispensary;

  public List<OrderItemResponse> getItems() {
    return List.copyOf(items);
  }

  public List<OrderStatusResponse> getStatuses() {
    return List.copyOf(statuses);
  }
}
