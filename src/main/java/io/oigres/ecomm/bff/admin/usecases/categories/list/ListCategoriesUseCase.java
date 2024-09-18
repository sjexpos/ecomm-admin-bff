package io.oigres.ecomm.bff.admin.usecases.categories.list;

import io.oigres.ecomm.bff.admin.api.model.CategoryResponse;
import io.oigres.ecomm.bff.admin.api.model.PaginatedResponse;
import io.oigres.ecomm.bff.admin.usecases.UseCase;
import io.oigres.ecomm.service.products.model.CategoryService;
import io.oigres.ecomm.service.products.model.PageResponse;
import io.oigres.ecomm.service.products.model.PageableRequestImpl;
import io.oigres.ecomm.service.products.model.category.GetAllCategoriesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ListCategoriesUseCase  implements UseCase {
    private final CategoryService categoryService;

    public PaginatedResponse<CategoryResponse> listCategories(int pageNumber, int pageSize) {
        PageResponse<GetAllCategoriesResponse> pages = categoryService.getAllCategories(PageableRequestImpl.of(pageNumber, pageSize));
        List<CategoryResponse> categories = pages.getContent().stream()
                .map(el -> new CategoryResponse(el.getId(), el.getName())
                )
                .toList();
        return new PaginatedResponse<>(categories, pages.getTotalPages(), pageNumber, pageSize, pages.getTotalElements());
    }

}
