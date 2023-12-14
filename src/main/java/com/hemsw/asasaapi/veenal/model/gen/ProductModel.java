package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import lombok.ToString;
import lombok.experimental.Accessors;

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

	@Column(name = "category_id")
	private Integer catId;

	@Column(name = "tax_cat_id")
	private Integer taxCatId;

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

	@Column(name = "polished_by_supplier_id")
	private Integer polishedBySupplierId;

	@Column(name = "weight")
	private BigDecimal weight;

	@Column(name = "created_by_user_id")
	private int createdByUserId;

	@Transient
	@Column(name = "created_at")
	private Date createdAt;

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

	public Integer getCatId()
	{
		return catId;
	}

	public void setCatId(Integer productCategoryId)
	{
		this.catId = productCategoryId;
	}

	public Integer getTaxCatId()
	{
		return taxCatId;
	}

	public void setTaxCatId(Integer taxCategoryegoryId)
	{
		this.taxCatId = taxCategoryegoryId;
	}

	public Integer getTaxId()
	{
		return taxId;
	}

	public void setTaxId(Integer taxId)
	{
		this.taxId = taxId;
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

	public Integer getPolishedBySupplierId()
	{
		return polishedBySupplierId;
	}

	public void setPolishedBySupplierId(Integer polishedBySupplierId)
	{
		this.polishedBySupplierId = polishedBySupplierId;
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

	public Date getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}

}
