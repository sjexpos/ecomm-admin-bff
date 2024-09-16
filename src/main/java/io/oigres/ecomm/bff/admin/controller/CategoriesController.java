package io.oigres.ecomm.bff.admin.controller;

import io.oigres.ecomm.bff.admin.api.Routes;
import io.oigres.ecomm.bff.admin.api.model.CategoryResponse;
import io.oigres.ecomm.bff.admin.api.model.PaginatedResponse;
import io.oigres.ecomm.bff.admin.usecases.categories.list.ListCategoriesUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Routes.CATEGORIES_PATH)
@Tag(name = "Categories", description = " ")
@RequiredArgsConstructor
@Slf4j
public class CategoriesController extends AbstractController {
    private final ListCategoriesUseCase listCategoriesUseCase;

    @Operation(summary = "Retrieve categories")
    @PageableAsQueryParam
    @GetMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public PaginatedResponse<CategoryResponse> getCategories(Pageable pageable) {
        log.info("======= getCategories | page={} size={} =====", pageable.getPageNumber(), pageable.getPageSize());
        return listCategoriesUseCase.listCategories(pageable.getPageNumber(), pageable.getPageSize());
    }

}
