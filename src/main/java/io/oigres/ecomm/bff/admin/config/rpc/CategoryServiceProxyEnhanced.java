package io.oigres.ecomm.bff.admin.config.rpc;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.oigres.ecomm.service.products.Routes;
import io.oigres.ecomm.service.products.model.*;
import io.oigres.ecomm.service.products.model.category.GetAllCategoriesResponse;
import io.oigres.ecomm.service.products.model.category.GetAllSubcategoriesResponse;
import io.oigres.ecomm.service.products.model.category.GetCategoryResponse;
import io.oigres.ecomm.service.products.model.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class CategoryServiceProxyEnhanced implements CategoryService {
    private final CategoryService delegate;
    private final RestTemplate restTemplate;

    @Override
    @CircuitBreaker(name = "remote-gets")
    //@CircuitBreaker(name = "remote-gets", fallbackMethod = "fallbackMethodForGetCategoryById")
    public GetCategoryResponse getCategoryById(long categoryId) throws NotFoundException {
        return delegate.getCategoryById(categoryId);
    }

    private GetCategoryResponse fallbackMethodForGetCategoryById(Exception e) {
        log.info("Fallback method for get category by id");
        return GetCategoryResponse.builder()
                .name("Not Available")
                .build();
    }

    @Override
    @CircuitBreaker(name = "remote-gets")
    //@CircuitBreaker(name = "remote-gets", fallbackMethod = "fallbackMethodForGetAllCategories")
    public PageResponse<GetAllCategoriesResponse> getAllCategories(PageableRequest pageable) {
        JacksonPageImpl<GetAllCategoriesResponse> response = new JacksonPageImpl<GetAllCategoriesResponse>(List.of(), new JacksonPageableRequestImpl(0, 20), 0);
        response = this.restTemplate.getForObject(Routes.CATEGORY_CONTROLLER_PATH+"?page={page}&size={size}", response.getClass(), pageable.getPageNumber(), pageable.getPageSize());
        return response;
        //return delegate.getAllCategories(pageable);
    }

    private PageResponse<GetAllCategoriesResponse> fallbackMethodForGetAllCategories(Exception e) {
        log.info("Fallback method for get all categories");
        return PageResponse.empty();
    }

    @Override
    @CircuitBreaker(name = "remote-gets")
    //@CircuitBreaker(name = "remote-gets", fallbackMethod = "fallbackMethodForGetSubcategoriesByCategoryId")
    public PageResponse<GetAllSubcategoriesResponse> getSubcategoriesByCategoryId(long categoryId, PageableRequest pageable) throws NotFoundException {
        return delegate.getSubcategoriesByCategoryId(categoryId, pageable);
    }

    private PageResponse<GetAllSubcategoriesResponse> fallbackMethodForGetSubcategoriesByCategoryId(Exception e) {
        log.info("Fallback method for get subcategories by category id");
        return PageResponse.empty();
    }

}
