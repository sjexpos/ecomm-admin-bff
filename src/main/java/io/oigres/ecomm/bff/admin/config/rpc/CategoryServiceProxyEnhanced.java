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
        return GetCategoryResponse.builder()
                .id(categoryId)
                .name("Not Available")
                .build();
    }

    @Override
    @CircuitBreaker(name = "remote-gets")
    public PageResponse<GetAllCategoriesResponse> getAllCategories(PageableRequest pageable) {
        return delegate.getAllCategories(pageable);
    }

    @Override
    @CircuitBreaker(name = "remote-gets", fallbackMethod = "fallbackMethodForGetSubcategoriesByCategoryId")
    public PageResponse<GetAllSubcategoriesResponse> getSubcategoriesByCategoryId(long categoryId, PageableRequest pageable) throws NotFoundException {
        return delegate.getSubcategoriesByCategoryId(categoryId, pageable);
    }

    private PageResponse<GetAllSubcategoriesResponse> fallbackMethodForGetSubcategoriesByCategoryId(long categoryId, PageableRequest pageable, Exception e) {
        log.warn("Fallback method for get subcategories by category id: " + categoryId);
        return PageResponse.empty();
    }

}
