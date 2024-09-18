package io.oigres.ecomm.bff.admin.config.rpc;

import io.oigres.ecomm.service.products.IDispensaryService;
import io.oigres.ecomm.service.products.model.PageResponse;
import io.oigres.ecomm.service.products.model.PageableRequest;
import io.oigres.ecomm.service.products.model.dispensary.*;
import io.oigres.ecomm.service.products.model.exception.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DispensariesServiceProxyEnhanced implements IDispensaryService  {

    private final IDispensaryService dispensaryService;

    @Override
    public DispensaryPublicationResponse insertDispensaryPublication(Long dispensaryId, InsertDispensaryPublicationRequest request) throws DispensaryPublicationNotFoundException, DispensaryPublicationBadRequestExceptionResponseApi, CatalogProductNotFoundApiException {
        return dispensaryService.insertDispensaryPublication(dispensaryId, request);
    }

    @Override
    public DispensaryPublicationResponse updateDispensaryPublication(Long dispensaryId, Long publicationId, UpdateDispensaryPublicationRequest request) throws DispensaryPublicationNotFoundException {
        return dispensaryService.updateDispensaryPublication(dispensaryId, publicationId, request);
    }

    @Override
    public DispensaryPublicationResponse addStockToDispensaryPublication(Long dispensaryId, Long publicationId, AddStockDPRequest request) throws DispensaryPublicationNotFoundException {
        return dispensaryService.addStockToDispensaryPublication(dispensaryId, publicationId, request);
    }

    @Override
    public InsertDispensaryResponse insertDispensary(InsertDispensaryRequest insertDispensaryRequest) throws ExistingDispensaryException, RequestStatusNotFoundApiException {
        return dispensaryService.insertDispensary(insertDispensaryRequest);
    }

    @Override
    public UpdateDispensaryByIdResponse updateDispensary(Long dispensaryId, UpdateDispensaryByIdRequest request) throws DispensaryNotFoundApiException, RequestStatusNotFoundApiException {
        return dispensaryService.updateDispensary(dispensaryId, request);
    }

    @Override
    public GetDispensaryResponse getDispensary(Long dispensaryId) throws DispensaryNotFoundApiException {
        return dispensaryService.getDispensary(dispensaryId);
    }

    @Override
    public PageResponse<GetAllDispensaryResponse> getAllDispensaries(PageableRequest pageable) {
        return dispensaryService.getAllDispensaries(pageable);
    }

    @Override
    public DeleteDispensaryResponse deleteDispensary(Long dispensaryId) throws DispensaryBadRequestApiException, DispensaryNotFoundApiException {
        return dispensaryService.deleteDispensary(dispensaryId);
    }

    @Override
    public DispensaryStatusResponse activateByDispensaryId(long dispensaryId) throws DispensaryStatusExceptionApi, DispensaryNotFoundApiException {
        return dispensaryService.activateByDispensaryId(dispensaryId);
    }

    @Override
    public DispensaryStatusResponse deactivateByDispensaryId(long dispensaryId) throws DispensaryStatusExceptionApi, DispensaryNotFoundApiException {
        return dispensaryService.deactivateByDispensaryId(dispensaryId);
    }

}
