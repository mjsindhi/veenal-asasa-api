package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Immutable;

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

	@Column(name = "unit_id")
	private Integer unitId;

	@Column(name = "unit_name")
	private String unitName;

	@Column(name = "hsn")
	private Integer hsn;

	@Column(name = "raw_purchase_price")
	private BigDecimal rawPurchasePrice;

	@Column(name = "polish_price")
	private BigDecimal polishPrice;

	@Column(name = "cost_price")
	private BigDecimal costPrice;

	@Column(name = "additional_cost")
	private BigDecimal additionalCost;

	@Column(name = "min_sales_price")
	private BigDecimal minSalesPrice;

	@Column(name = "wholesale_sales_price")
	private BigDecimal wholesaleSalesPrice;

	@Column(name = "mrp")
	private BigDecimal mrp;

	@Column(name = "internet_sales_price")
	private BigDecimal internetSalesPrice;

	@Column(name = "max_sales_price")
	private BigDecimal maxSalesPrice;

	@Column(name = "discount")
	private BigDecimal discount;

	@Column(name = "product_category_id")
	private Integer productCategoryId;

	@Column(name = "product_category_name")
	private String productCategoryName;

	@Column(name = "tax_cat_id")
	private Integer taxCatId;

	@Column(name = "tax_category_name")
	private String taxCategoryName;

	@Column(name = "tax_id")
	private Integer taxId;

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

	@Column(name = "raw_supplier_id")
	private Integer rawSupplierId;

	@Column(name = "raw_supplier_name")
	private String rawSupplierName;

	@Column(name = "polished_by_supplier_id")
	private Integer polishedBySupplierId;

	@Column(name = "polished_by_supplier_name")
	private String polishedBySupplierName;

	@Column(name = "weight")
	private BigDecimal weight;

	@Column(name = "created_by_user_id")
	private int createdByUserId;

	@Column(name = "created_by_user_name")
	private String createdByUserName;

	@Column(name = "created_at")
	private Date createdAt;

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getCode()
	{
		return code;
	}

	public String getDesc()
	{
		return desc;
	}

	public Integer getUnitId()
	{
		return unitId;
	}

	public String getUnitName()
	{
		return unitName;
	}

	public Integer getHsn()
	{
		return hsn;
	}

	public BigDecimal getRawPurchasePrice()
	{
		return rawPurchasePrice;
	}

	public BigDecimal getPolishPrice()
	{
		return polishPrice;
	}

	public BigDecimal getCostPrice()
	{
		return costPrice;
	}

	public BigDecimal getAdditionalCost()
	{
		return additionalCost;
	}

	public BigDecimal getMinSalesPrice()
	{
		return minSalesPrice;
	}

	public BigDecimal getWholesaleSalesPrice()
	{
		return wholesaleSalesPrice;
	}

	public BigDecimal getMrp()
	{
		return mrp;
	}

	public BigDecimal getInternetSalesPrice()
	{
		return internetSalesPrice;
	}

	public BigDecimal getMaxSalesPrice()
	{
		return maxSalesPrice;
	}

	public BigDecimal getDiscount()
	{
		return discount;
	}

	public Integer getProductCategoryId()
	{
		return productCategoryId;
	}

	public String getProductCategoryName()
	{
		return productCategoryName;
	}

	public Integer getTaxCatId()
	{
		return taxCatId;
	}

	public String getTaxCategoryName()
	{
		return taxCategoryName;
	}

	public Integer getTaxId()
	{
		return taxId;
	}

	public String getTaxName()
	{
		return taxName;
	}

	public String getNote()
	{
		return note;
	}

	public boolean isIsSold()
	{
		return isSold;
	}

	public boolean isIsMade()
	{
		return isMade;
	}

	public BigDecimal getMinQty()
	{
		return minQty;
	}

	public BigDecimal getReorderQty()
	{
		return reorderQty;
	}

	public Integer getRawSupplierId()
	{
		return rawSupplierId;
	}

	public String getRawSupplierName()
	{
		return rawSupplierName;
	}

	public Integer getPolishedBySupplierId()
	{
		return polishedBySupplierId;
	}

	public String getPolishedBySupplierName()
	{
		return polishedBySupplierName;
	}

	public BigDecimal getWeight()
	{
		return weight;
	}

	public int getCreatedByUserId()
	{
		return createdByUserId;
	}

	public String getCreatedByUserName()
	{
		return createdByUserName;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

}
