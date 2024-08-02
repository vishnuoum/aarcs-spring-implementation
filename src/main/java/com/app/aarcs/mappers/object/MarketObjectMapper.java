package com.app.aarcs.mappers.object;

import com.app.aarcs.controller.requests.markets.ProductDeleteRequest;
import com.app.aarcs.controller.requests.markets.ProductInsertRequest;
import com.app.aarcs.controller.requests.markets.ProductUpdateRequest;
import com.app.aarcs.model.Market;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MarketObjectMapper {

	@Mapping(target = "pic", ignore = true)
	Market insertRequestToMarketObject(ProductInsertRequest request);

	Market updateRequestToMarketObject(ProductUpdateRequest request);

	Market deleteRequestToMarketObject(ProductDeleteRequest request);
}
