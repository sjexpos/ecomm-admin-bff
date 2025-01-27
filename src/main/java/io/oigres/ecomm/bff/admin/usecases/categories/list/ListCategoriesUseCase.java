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

package io.oigres.ecomm.bff.admin.usecases.categories.list;

import io.oigres.ecomm.bff.admin.api.model.CategoryResponse;
import io.oigres.ecomm.bff.admin.api.model.PaginatedResponse;
import io.oigres.ecomm.bff.admin.usecases.UseCase;
import io.oigres.ecomm.service.products.model.CategoryService;
import io.oigres.ecomm.service.products.model.PageResponse;
import io.oigres.ecomm.service.products.model.PageableRequestImpl;
import io.oigres.ecomm.service.products.model.category.GetAllCategoriesResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ListCategoriesUseCase implements UseCase {
  private final CategoryService categoryService;

  public PaginatedResponse<CategoryResponse> listCategories(int pageNumber, int pageSize) {
    PageResponse<GetAllCategoriesResponse> pages =
        categoryService.getAllCategories(PageableRequestImpl.of(pageNumber, pageSize));
    List<CategoryResponse> categories =
        pages.getContent().stream()
            .map(el -> new CategoryResponse(el.getId(), el.getName()))
            .toList();
    return new PaginatedResponse<>(
        categories, pages.getTotalPages(), pageNumber, pageSize, pages.getTotalElements());
  }
}
