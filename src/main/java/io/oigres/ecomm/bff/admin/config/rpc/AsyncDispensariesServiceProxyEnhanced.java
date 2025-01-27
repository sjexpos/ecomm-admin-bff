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
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import io.oigres.ecomm.service.products.api.AsyncDispensariesService;
import io.oigres.ecomm.service.products.model.PageResponse;
import io.oigres.ecomm.service.products.model.PageableRequest;
import io.oigres.ecomm.service.products.model.dispensary.*;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class AsyncDispensariesServiceProxyEnhanced implements AsyncDispensariesService {

  private final AsyncDispensariesService asyncDispensariesService;

  @Override
  @CircuitBreaker(name = "remote-gets", fallbackMethod = "fallbackMethodForGetDispensaryByIdAsync")
  // @Retry(name = "remote-get-by-id-200-expected") does not work when @CircuitBreaker is added
  @TimeLimiter(name = "remote-get-by-id")
  public CompletableFuture<GetDispensaryResponse> getDispensaryByIdAsync(Long dispensaryId) {
    return asyncDispensariesService.getDispensaryByIdAsync(dispensaryId);
  }

  private CompletableFuture<GetDispensaryResponse> fallbackMethodForGetDispensaryByIdAsync(
      Long dispensaryId, Exception exception) {
    log.warn(
        String.format("Executing fallback method for getDispensaryByIdAsync(%d)", dispensaryId));
    return Mono.just(GetDispensaryResponse.builder().id(dispensaryId).name("Not available").build())
        .toFuture();
  }

  @Override
  @Retry(name = "remote-get-page-200-expected")
  @TimeLimiter(name = "remote-get-page")
  public CompletableFuture<? extends PageResponse<GetAllDispensaryResponse>>
      getAllDispensariesAsync(PageableRequest pageable) {
    return asyncDispensariesService.getAllDispensariesAsync(pageable);
  }
}
