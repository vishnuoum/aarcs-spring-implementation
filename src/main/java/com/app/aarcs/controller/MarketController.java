package com.app.aarcs.controller;

import com.app.aarcs.controller.requests.markets.ProductDeleteRequest;
import com.app.aarcs.controller.requests.markets.ProductInsertRequest;
import com.app.aarcs.controller.requests.markets.ProductUpdateRequest;
import com.app.aarcs.controller.responses.markets.MarketData;
import com.app.aarcs.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market")
public class MarketController {

	private final MarketService marketService;

	@Autowired
	private MarketController(MarketService marketService) {
		this.marketService = marketService;
	}

	@PostMapping(path = "/add", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public void add(@ModelAttribute ProductInsertRequest request) {
		marketService.add(request);
	}

	@PostMapping(path = "/updateProduct")
	public void updateProduct(@RequestBody ProductUpdateRequest request) {
		marketService.updateProduct(request);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<MarketData>> getProducts() {
		return new ResponseEntity<>(marketService.getAll(), HttpStatus.OK);
	}

	@DeleteMapping("/deleteProduct")
	public void deleteProduct(@RequestBody ProductDeleteRequest request) {
		marketService.deleteProduct(request);
	}
}
