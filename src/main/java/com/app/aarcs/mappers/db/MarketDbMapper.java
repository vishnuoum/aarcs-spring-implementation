package com.app.aarcs.mappers.db;

import com.app.aarcs.controller.responses.markets.MarketData;
import com.app.aarcs.model.Market;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MarketDbMapper {

	void insert(Market market);
	List<MarketData> getAll();
	int updateProduct(Market market);
	int deleteProduct(Market market);
}
