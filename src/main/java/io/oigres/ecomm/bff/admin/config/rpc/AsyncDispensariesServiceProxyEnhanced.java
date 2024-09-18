package io.oigres.ecomm.bff.admin.config.rpc;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import io.oigres.ecomm.service.products.api.AsyncDispensariesService;
import io.oigres.ecomm.service.products.model.PageResponse;
import io.oigres.ecomm.service.products.model.PageResponseImpl;
import io.oigres.ecomm.service.products.model.PageableRequest;
import io.oigres.ecomm.service.products.model.dispensary.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
public class AsyncDispensariesServiceProxyEnhanced implements AsyncDispensariesService {

    private final AsyncDispensariesService asyncDispensariesService;

    @Override
    @CircuitBreaker(name = "remote-gets", fallbackMethod = "fallbackMethodForGetDispensaryByIdAsync")
    //@Retry(name = "remote-get-by-id-200-expected") does not work when @CircuitBreaker is added
    @TimeLimiter(name = "remote-get-by-id")
    public CompletableFuture<GetDispensaryResponse> getDispensaryByIdAsync(Long dispensaryId) {
        return asyncDispensariesService.getDispensaryByIdAsync(dispensaryId);
    }

    private CompletableFuture<GetDispensaryResponse> fallbackMethodForGetDispensaryByIdAsync(Long dispensaryId, Exception exception) {
        log.warn(String.format("Executing fallback method for getDispensaryByIdAsync(%d)", dispensaryId));
        return Mono.just(
                GetDispensaryResponse.builder()
                        .id(dispensaryId)
                        .name("Not available")
                        .build()
        ).toFuture();
    }

    @Override
    @Retry(name = "remote-get-page-200-expected")
    @TimeLimiter(name = "remote-get-page")
    public CompletableFuture<? extends PageResponse<GetAllDispensaryResponse>> getAllDispensariesAsync(PageableRequest pageable) {
        return asyncDispensariesService.getAllDispensariesAsync(pageable);
    }

}
