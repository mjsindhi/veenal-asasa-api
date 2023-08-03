package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@Entity
@Table(name = "product")
public class ProductModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "desc")
	private String desc;

	@Column(name = "unit_id")
	private Integer unitId;

	@Column(name = "hsn")
	private Integer hsn;

	@Column(name = "purchase_price_raw")
	private BigDecimal purchasePriceRaw;

	@Column(name = "puchase_price_finished")
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

	@Column(name = "product_category_id")
	private Integer productCategoryId;

	@Column(name = "tax_category_id")
	private Integer taxCategoryId;

	@Column(name = "tax_id")
	private Integer taxId;

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

	@Column(name = "raw_supplier_id")
	private Integer rawSupplierId;

	@Column(name = "finished_supplier_id")
	private Integer finishedSupplierId;

	@Column(name = "weight")
	private BigDecimal weight;

	@Column(name = "created_by_user_id")
	private int createdByUserId;

	@Column(name = "created_at")
	private Date createdAt;

}
