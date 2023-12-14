package com.hemsw.asasaapi.veenal.dto.req;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;

@Getter
public class ProductReqDto
{

	private String name;
	private String code;
	private String desc;
	private Integer unitId;
	private Integer hsn;
	private BigDecimal rawPurchasePrice;
	private BigDecimal polishPrice;
	private BigDecimal costPrice;
	private BigDecimal additionalCost;
	private BigDecimal minSalesPrice;
	private BigDecimal wholesaleSalesPrice;
	private BigDecimal mrp;
	private BigDecimal internetSalesPrice;
	private BigDecimal maxSalesPrice;
	private BigDecimal discount;
	private Integer productCatId;
	private Integer taxCatId;
	private Integer taxId;
	private String note;
	private boolean isSold;
	private boolean isMade;
	private BigDecimal minQty;
	private BigDecimal reorderQty;
	private Integer rawSupplierId;
	private Integer polishedBySupplierId;
	private BigDecimal weight;
	private int createdByUserId;
	private Date createdAt;

}
