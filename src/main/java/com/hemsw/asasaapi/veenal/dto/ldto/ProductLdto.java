package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Immutable;

@Getter
@Accessors(chain = true)
@ToString
@Entity
@Immutable
public class ProductLdto
{

	@Id
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "desc")
	private String desc;

	@Column(name = "unit_name")
	private String unitName;

	@Column(name = "hsn")
	private Integer hsn;

	@Column(name = "purchase_price_raw")
	private BigDecimal purchasePriceRaw;

	@Column(name = "purchase_price_finished")
	private BigDecimal purchasePriceFinished;

	@Column(name = "cost_price")
	private BigDecimal costPrice;

	@Column(name = "additional_cost")
	private BigDecimal additionalCost;

	@Column(name = "min_sales_price")
	private BigDecimal minSalesPrice;

	@Column(name = "max_sales_price")
	private BigDecimal maxSalesPrice;

	@Column(name = "internet_sales_price")
	private BigDecimal internetSalesPrice;

	@Column(name = "mrp")
	private BigDecimal mrp;

	@Column(name = "discount")
	private BigDecimal discount;

	@Column(name = "product_category_name")
	private String productCategoryName;

	@Column(name = "tax_category_name")
	private String taxCategoryName;

	@Column(name = "tax_name")
	private String taxName;

	@Column(name = "note")
	private String note;

	@Column(name = "is_sold")
	private boolean isSold;

	@Column(name = "is_made")
	private boolean isMade;

	@Column(name = "min_qty")
	private BigDecimal minQty;

	@Column(name = "reorder_qty")
	private BigDecimal reorderQty;

	@Column(name = "raw_supplier_name")
	private String rawSupplierName;

	@Column(name = "finished_supplier_name")
	private String finishedSupplierName;

	@Column(name = "weight")
	private BigDecimal weight;

	@Column(name = "created_by_user_name")
	private String createdByUserName;

	@Column(name = "created_at")
	private Date createdAt;

}
