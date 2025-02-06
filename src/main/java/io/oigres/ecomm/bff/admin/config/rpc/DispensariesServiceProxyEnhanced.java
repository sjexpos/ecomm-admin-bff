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

import io.oigres.ecomm.service.products.IDispensaryService;
import io.oigres.ecomm.service.products.model.PageResponse;
import io.oigres.ecomm.service.products.model.PageableRequest;
import io.oigres.ecomm.service.products.model.dispensary.*;
import io.oigres.ecomm.service.products.model.exception.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DispensariesServiceProxyEnhanced implements IDispensaryService {

  private final IDispensaryService dispensaryService;

  @Override
  public DispensaryPublicationResponse insertDispensaryPublication(
      Long dispensaryId, InsertDispensaryPublicationRequest request)
      throws DispensaryPublicationNotFoundException,
          DispensaryPublicationBadRequestExceptionResponseApi,
          CatalogProductNotFoundApiException {
    return dispensaryService.insertDispensaryPublication(dispensaryId, request);
  }

  @Override
  public DispensaryPublicationResponse updateDispensaryPublication(
      Long dispensaryId, Long publicationId, UpdateDispensaryPublicationRequest request)
      throws DispensaryPublicationNotFoundException {
    return dispensaryService.updateDispensaryPublication(dispensaryId, publicationId, request);
  }

  @Override
  public DispensaryPublicationResponse addStockToDispensaryPublication(
      Long dispensaryId, Long publicationId, AddStockDPRequest request)
      throws DispensaryPublicationNotFoundException {
    return dispensaryService.addStockToDispensaryPublication(dispensaryId, publicationId, request);
  }

  @Override
  public InsertDispensaryResponse insertDispensary(InsertDispensaryRequest insertDispensaryRequest)
      throws ExistingDispensaryException, RequestStatusNotFoundApiException {
    return dispensaryService.insertDispensary(insertDispensaryRequest);
  }

  @Override
  public UpdateDispensaryByIdResponse updateDispensary(
      Long dispensaryId, UpdateDispensaryByIdRequest request)
      throws DispensaryNotFoundApiException, RequestStatusNotFoundApiException {
    return dispensaryService.updateDispensary(dispensaryId, request);
  }

  @Override
  public GetDispensaryResponse getDispensary(Long dispensaryId)
      throws DispensaryNotFoundApiException {
    return dispensaryService.getDispensary(dispensaryId);
  }

  @Override
  public PageResponse<GetAllDispensaryResponse> getAllDispensaries(PageableRequest pageable) {
    return dispensaryService.getAllDispensaries(pageable);
  }

  @Override
  public DeleteDispensaryResponse deleteDispensary(Long dispensaryId)
      throws DispensaryBadRequestApiException, DispensaryNotFoundApiException {
    return dispensaryService.deleteDispensary(dispensaryId);
  }

  @Override
  public DispensaryStatusResponse activateByDispensaryId(long dispensaryId)
      throws DispensaryStatusExceptionApi, DispensaryNotFoundApiException {
    return dispensaryService.activateByDispensaryId(dispensaryId);
  }

  @Override
  public DispensaryStatusResponse deactivateByDispensaryId(long dispensaryId)
      throws DispensaryStatusExceptionApi, DispensaryNotFoundApiException {
    return dispensaryService.deactivateByDispensaryId(dispensaryId);
  }
}
