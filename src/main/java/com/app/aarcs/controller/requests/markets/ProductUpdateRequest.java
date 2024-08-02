package com.app.aarcs.controller.requests.markets;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductUpdateRequest {

	private String id;
	private String product;
	private String userId;
	private BigDecimal amount;
	private String address;
	private boolean enabled;
}
