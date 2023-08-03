package com.hemsw.asasaapi.veenal.dto.req;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class ProductReqDto
{

	private String name;
	private String code;
	private String desc;
	private Integer unitId;
	private Integer hsn;
	private BigDecimal purchasePriceRaw;
	private BigDecimal purchasePriceFinished;
	private BigDecimal costPrice;
	private BigDecimal additionalCost;
	private BigDecimal minSalesPrice;
	private BigDecimal maxSalesPrice;
	private BigDecimal internetSalesPrice;
	private BigDecimal mrp;
	private BigDecimal discount;
	private Integer productCategoryId;
	private Integer taxCategoryId;
	private Integer taxId;
	private String note;
	private boolean isSold;
	private boolean isMade;
	private BigDecimal minQty;
	private BigDecimal reorderQty;
	private Integer rawSupplierId;
	private Integer finishedSupplierId;
	private BigDecimal weight;
}
