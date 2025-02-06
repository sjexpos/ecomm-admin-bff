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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.oigres.ecomm.service.products.model.*;
import io.oigres.ecomm.service.products.model.category.GetAllCategoriesResponse;
import io.oigres.ecomm.service.products.model.category.GetAllSubcategoriesResponse;
import io.oigres.ecomm.service.products.model.category.GetCategoryResponse;
import io.oigres.ecomm.service.products.model.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
public class CategoryServiceProxyEnhanced implements CategoryService {
  private final CategoryService delegate;
  private final RestTemplate restTemplate;

  @Override
  @CircuitBreaker(name = "remote-gets", fallbackMethod = "fallbackMethodForGetCategoryById")
  public GetCategoryResponse getCategoryById(long categoryId) throws NotFoundException {
    return delegate.getCategoryById(categoryId);
  }

  private GetCategoryResponse fallbackMethodForGetCategoryById(long categoryId, Exception e) {
    log.warn("Fallback method for get category by id " + categoryId);
    return GetCategoryResponse.builder().id(categoryId).name("Not Available").build();
  }

  @Override
  @CircuitBreaker(name = "remote-gets")
  public PageResponse<GetAllCategoriesResponse> getAllCategories(PageableRequest pageable) {
    return delegate.getAllCategories(pageable);
  }

  @Override
  @CircuitBreaker(
      name = "remote-gets",
      fallbackMethod = "fallbackMethodForGetSubcategoriesByCategoryId")
  public PageResponse<GetAllSubcategoriesResponse> getSubcategoriesByCategoryId(
      long categoryId, PageableRequest pageable) throws NotFoundException {
    return delegate.getSubcategoriesByCategoryId(categoryId, pageable);
  }

  private PageResponse<GetAllSubcategoriesResponse> fallbackMethodForGetSubcategoriesByCategoryId(
      long categoryId, PageableRequest pageable, Exception e) {
    log.warn("Fallback method for get subcategories by category id: " + categoryId);
    return PageResponse.empty();
  }
}
