package com.app.aarcs.service;

import com.app.aarcs.controller.requests.markets.ProductDeleteRequest;
import com.app.aarcs.controller.requests.markets.ProductUpdateRequest;
import com.app.aarcs.controller.requests.markets.ProductInsertRequest;
import com.app.aarcs.controller.responses.markets.MarketData;
import com.app.aarcs.exception.ServiceException;
import com.app.aarcs.mappers.db.MarketDbMapper;
import com.app.aarcs.mappers.object.MarketObjectMapper;
import com.app.aarcs.model.Market;
import com.app.aarcs.settings.ServiceManager;
import com.app.aarcs.util.FileUtil;
import com.app.aarcs.util.LoggingUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MarketService {

	private final MarketDbMapper marketDbMapper;
	private final MarketObjectMapper marketObjectMapper;

	@Autowired
	private MarketService(MarketDbMapper marketDbMapper, MarketObjectMapper marketObjectMapper) {
		this.marketDbMapper = marketDbMapper;
		this.marketObjectMapper = marketObjectMapper;
	}

	public void add(ProductInsertRequest request) {
		try {
			Market market = marketObjectMapper.insertRequestToMarketObject(request);
			market.setPic(FileUtil.saveFile(request.getFile(), "products"));
			marketDbMapper.insert(market);
		} catch (PersistenceException ex) {
			LoggingUtil.printInfo(this.getClass(), "Error while inserting market date");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.MARKET_DATA_INSERT_ERROR);
		} catch (ServiceException ex) {
			throw ex;
		} catch (Exception ex) {
			LoggingUtil.printInfo(this.getClass(), "Unknown error while inserting market date");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.UNKNOWN_ERROR);
		}
	}

	public void updateProduct(ProductUpdateRequest request) {
		try {
			if(marketDbMapper.updateProduct(marketObjectMapper.updateRequestToMarketObject(request))==0) {
				LoggingUtil.printInfo(this.getClass(), "No product found to update");
				throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.NO_PRODUCT_ERROR);
			}
		} catch (PersistenceException ex) {
			LoggingUtil.printError(ex.getMessage());
			LoggingUtil.printInfo(this.getClass(), "Error while updating product details");
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.PRODUCT_UPDATE_ERROR);
		} catch (ServiceException ex) {
			throw ex;
		} catch (Exception ex) {
			LoggingUtil.printError(ex.getMessage());
			LoggingUtil.printInfo(this.getClass(), "Unknown error while updating product details");
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.UNKNOWN_ERROR);
		}
	}

	public List<MarketData> getAll() {
		try {
			return marketDbMapper.getAll();
		} catch (PersistenceException ex) {
			LoggingUtil.printError(ex.getMessage());
			LoggingUtil.printInfo(this.getClass(), "Error while fetching market date");
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.MARKET_FETCH_ERROR);
		} catch (Exception ex) {
			LoggingUtil.printError(ex.getMessage());
			LoggingUtil.printInfo(this.getClass(), "Unknown error while fetching market data");
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.UNKNOWN_ERROR);
		}
	}

	public void deleteProduct(ProductDeleteRequest request) {
		try {
			if (marketDbMapper.deleteProduct(marketObjectMapper.deleteRequestToMarketObject(request)) == 0) {
				LoggingUtil.printInfo(this.getClass(), "No product found to delete");
				throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.NO_PRODUCT_ERROR);
			}
		} catch (PersistenceException ex) {
			LoggingUtil.printError(ex.getMessage());
			LoggingUtil.printInfo(this.getClass(), "Error while deleting product");
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.PRODUCT_DELETE_ERROR);
		} catch (ServiceException ex) {
			throw ex;
		} catch (Exception ex) {
			LoggingUtil.printError(ex.getMessage());
			LoggingUtil.printInfo(this.getClass(), "Unknown error while deleting product");
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.UNKNOWN_ERROR);
		}
	}
}
