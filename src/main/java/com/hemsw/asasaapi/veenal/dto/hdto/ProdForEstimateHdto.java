package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class ProdForEstimateHdto
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

	@Column(name = "qty_current")
	private BigDecimal qtyCurrent;

	@Column(name = "pending_qty_sales")
	private BigDecimal pendingQtySales;

	@Column(name = "pending_qty_estimate")
	private BigDecimal pendingQtyEstimate;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public Integer getUnitId()
	{
		return unitId;
	}

	public void setUnitId(Integer unitId)
	{
		this.unitId = unitId;
	}

	public String getUnitName()
	{
		return unitName;
	}

	public void setUnitName(String unitName)
	{
		this.unitName = unitName;
	}

	public Integer getHsn()
	{
		return hsn;
	}

	public void setHsn(Integer hsn)
	{
		this.hsn = hsn;
	}

	public BigDecimal getRawPurchasePrice()
	{
		return rawPurchasePrice;
	}

	public void setRawPurchasePrice(BigDecimal rawPurchasePrice)
	{
		this.rawPurchasePrice = rawPurchasePrice;
	}

	public BigDecimal getPolishPrice()
	{
		return polishPrice;
	}

	public void setPolishPrice(BigDecimal polishPrice)
	{
		this.polishPrice = polishPrice;
	}

	public BigDecimal getCostPrice()
	{
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice)
	{
		this.costPrice = costPrice;
	}

	public BigDecimal getAdditionalCost()
	{
		return additionalCost;
	}

	public void setAdditionalCost(BigDecimal additionalCost)
	{
		this.additionalCost = additionalCost;
	}

	public BigDecimal getMinSalesPrice()
	{
		return minSalesPrice;
	}

	public void setMinSalesPrice(BigDecimal minSalesPrice)
	{
		this.minSalesPrice = minSalesPrice;
	}

	public BigDecimal getWholesaleSalesPrice()
	{
		return wholesaleSalesPrice;
	}

	public void setWholesaleSalesPrice(BigDecimal wholesaleSalesPrice)
	{
		this.wholesaleSalesPrice = wholesaleSalesPrice;
	}

	public BigDecimal getMrp()
	{
		return mrp;
	}

	public void setMrp(BigDecimal mrp)
	{
		this.mrp = mrp;
	}

	public BigDecimal getInternetSalesPrice()
	{
		return internetSalesPrice;
	}

	public void setInternetSalesPrice(BigDecimal internetSalesPrice)
	{
		this.internetSalesPrice = internetSalesPrice;
	}

	public BigDecimal getMaxSalesPrice()
	{
		return maxSalesPrice;
	}

	public void setMaxSalesPrice(BigDecimal maxSalesPrice)
	{
		this.maxSalesPrice = maxSalesPrice;
	}

	public BigDecimal getDiscount()
	{
		return discount;
	}

	public void setDiscount(BigDecimal discount)
	{
		this.discount = discount;
	}

	public Integer getProductCategoryId()
	{
		return productCategoryId;
	}

	public void setProductCategoryId(Integer productCategoryId)
	{
		this.productCategoryId = productCategoryId;
	}

	public String getProductCategoryName()
	{
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName)
	{
		this.productCategoryName = productCategoryName;
	}

	public Integer getTaxCatId()
	{
		return taxCatId;
	}

	public void setTaxCatId(Integer taxCatId)
	{
		this.taxCatId = taxCatId;
	}

	public String getTaxCategoryName()
	{
		return taxCategoryName;
	}

	public void setTaxCategoryName(String taxCategoryName)
	{
		this.taxCategoryName = taxCategoryName;
	}

	public Integer getTaxId()
	{
		return taxId;
	}

	public void setTaxId(Integer taxId)
	{
		this.taxId = taxId;
	}

	public String getTaxName()
	{
		return taxName;
	}

	public void setTaxName(String taxName)
	{
		this.taxName = taxName;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public boolean isIsSold()
	{
		return isSold;
	}

	public void setIsSold(boolean isSold)
	{
		this.isSold = isSold;
	}

	public boolean isIsMade()
	{
		return isMade;
	}

	public void setIsMade(boolean isMade)
	{
		this.isMade = isMade;
	}

	public BigDecimal getMinQty()
	{
		return minQty;
	}

	public void setMinQty(BigDecimal minQty)
	{
		this.minQty = minQty;
	}

	public BigDecimal getReorderQty()
	{
		return reorderQty;
	}

	public void setReorderQty(BigDecimal reorderQty)
	{
		this.reorderQty = reorderQty;
	}

	public Integer getRawSupplierId()
	{
		return rawSupplierId;
	}

	public void setRawSupplierId(Integer rawSupplierId)
	{
		this.rawSupplierId = rawSupplierId;
	}

	public String getRawSupplierName()
	{
		return rawSupplierName;
	}

	public void setRawSupplierName(String rawSupplierName)
	{
		this.rawSupplierName = rawSupplierName;
	}

	public Integer getPolishedBySupplierId()
	{
		return polishedBySupplierId;
	}

	public void setPolishedBySupplierId(Integer polishedBySupplierId)
	{
		this.polishedBySupplierId = polishedBySupplierId;
	}

	public String getPolishedBySupplierName()
	{
		return polishedBySupplierName;
	}

	public void setPolishedBySupplierName(String polishedBySupplierName)
	{
		this.polishedBySupplierName = polishedBySupplierName;
	}

	public BigDecimal getWeight()
	{
		return weight;
	}

	public void setWeight(BigDecimal weight)
	{
		this.weight = weight;
	}

	public int getCreatedByUserId()
	{
		return createdByUserId;
	}

	public void setCreatedByUserId(int createdByUserId)
	{
		this.createdByUserId = createdByUserId;
	}

	public String getCreatedByUserName()
	{
		return createdByUserName;
	}

	public void setCreatedByUserName(String createdByUserName)
	{
		this.createdByUserName = createdByUserName;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}

	public BigDecimal getQtyCurrent()
	{
		return qtyCurrent;
	}

	public void setQtyCurrent(BigDecimal qtyCurrent)
	{
		this.qtyCurrent = qtyCurrent;
	}

	public BigDecimal getPendingQtySales()
	{
		return pendingQtySales;
	}

	public void setPendingQtySales(BigDecimal pendingQtySales)
	{
		this.pendingQtySales = pendingQtySales;
	}

	public BigDecimal getPendingQtyEstimate()
	{
		return pendingQtyEstimate;
	}

	public void setPendingQtyEstimate(BigDecimal pendingQtyEstimate)
	{
		this.pendingQtyEstimate = pendingQtyEstimate;
	}

}
