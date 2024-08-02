package com.app.aarcs.controller.responses.markets;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MarketData {

	private String id;
	private String product;
	private String username;
	private String phone;
	private String postDate;
	private BigDecimal amount;
	private String address;
	private String pic;
}
