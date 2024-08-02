package com.app.aarcs.controller.requests.markets;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductInsertRequest {

	private String product;
	private String userId;
	private BigDecimal amount;
	private String address;
	private MultipartFile file;
}
