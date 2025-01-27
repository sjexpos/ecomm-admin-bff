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

package io.oigres.ecomm.bff.admin.config.rpc;

import io.oigres.ecomm.service.orders.OrderStatusEnumApi;
import io.oigres.ecomm.service.orders.OrdersService;
import io.oigres.ecomm.service.orders.model.NotFoundException;
import io.oigres.ecomm.service.orders.model.PageResponse;
import io.oigres.ecomm.service.orders.model.PageableRequest;
import io.oigres.ecomm.service.orders.model.order.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrdersServiceProxyEnhanced implements OrdersService {

  private final OrdersService ordersService;

  // **************************************** OrdersService
  // ****************************************//

  @Override
  public GetOrderByIdResponse getOrderById(long orderId) throws NotFoundException {
    return ordersService.getOrderById(orderId);
  }

  @Override
  public PageResponse<GetAllOrdersResponse> getAllOrders(
      Long dispensaryId, Long userId, OrderStatusEnumApi status, PageableRequest pageable) {
    return ordersService.getAllOrders(dispensaryId, userId, status, pageable);
  }

  @Override
  public OrdersCountResponse getOrdersCount(
      Long dispensaryId, Long userId, OrderStatusEnumApi status) {
    return ordersService.getOrdersCount(dispensaryId, userId, status);
  }

  @Override
  public ChangeCurrentOrderStatusResponse changeOrderStatus(
      long orderId, ChangeCurrentOrderStatusRequest request) throws NotFoundException {
    return ordersService.changeOrderStatus(orderId, request);
  }

  @Override
  public OrderStatusAmountsResponse getOrdersStatusAmount(Long dispensaryId)
      throws NotFoundException {
    return ordersService.getOrdersStatusAmount(dispensaryId);
  }
}
