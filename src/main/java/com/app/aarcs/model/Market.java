package com.app.aarcs.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Market {

	private String id;
	private String product;
	private String userId;
	private String postDate;
	private BigDecimal amount;
	private String address;
	private String pic;
	private boolean enabled;
}
