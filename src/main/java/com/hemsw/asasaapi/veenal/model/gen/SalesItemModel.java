package com.hemsw.asasaapi.veenal.model.gen;

import com.hemsw.asasaapi.veenal.enums.PriceListType;
import com.hemsw.asasaapi.veenal.enums.RateType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "sales_item")
public class SalesItemModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "sales_id")
	private int salesId;

	@Column(name = "product_id")
	private int productId;

	@Column(name = "desc")
	private String desc;

	@Column(name = "qty")
	private BigDecimal qty;

	@Column(name = "price_list_type_id")
	private Integer priceListTypeId;

	@Column(name = "price_list_rate")
	private BigDecimal priceListRate;

	@Column(name = "rate")
	private BigDecimal rate;

	@Column(name = "rate_incl_all")
	private boolean rateInclAll;

	@Column(name = "qxr")
	private BigDecimal qxr;

	@Column(name = "disc_rate")
	private BigDecimal discRate;

	@Column(name = "disc_rate_type_id")
	private Integer discRateTypeId;

	@Column(name = "disc_a")
	private BigDecimal discA;

	@Column(name = "amt_after_disc")
	private BigDecimal amtAfterDisc;

	@Column(name = "taxable_amt")
	private BigDecimal taxableAmt;

	@Column(name = "tax_id")
	private Integer taxId;

	@Column(name = "tax_rate")
	private BigDecimal taxRate;

	@Column(name = "cgst_a")
	private BigDecimal cgstA;

	@Column(name = "sgst_a")
	private BigDecimal sgstA;

	@Column(name = "igst_a")
	private BigDecimal igstA;

	@Column(name = "amt")
	private BigDecimal amt;

	public SalesItemModel()
	{
	}

	public SalesItemModel(EstimateItemModel estimateItemModel)
	{
		this.productId = estimateItemModel.getProductId();
		this.desc = estimateItemModel.getDesc();
		this.qty = estimateItemModel.getQty();
		this.priceListTypeId = estimateItemModel.getPriceListTypeId();
		this.priceListRate = estimateItemModel.getPriceListRate();
		this.rate = estimateItemModel.getRate();
		this.rateInclAll = false;
		this.qxr = estimateItemModel.getQxr();
		this.discRate = estimateItemModel.getDiscRate();
		this.discRateTypeId = estimateItemModel.getDiscRateTypeId();
		this.discA = estimateItemModel.getDiscA();
		this.amtAfterDisc = estimateItemModel.getAmtAfterDisc();
		this.taxableAmt = estimateItemModel.getTaxableAmt();
		this.taxId = estimateItemModel.getTaxId();
		this.taxRate = estimateItemModel.getTaxRate();
		this.cgstA = estimateItemModel.getCgstA();
		this.sgstA = estimateItemModel.getSgstA();
		this.igstA = estimateItemModel.getIgstA();
		this.amt = estimateItemModel.getAmt();
	}

	public SalesItemModel(SalesOrderItemModel salesOrderItemModel)
	{
		this.productId = salesOrderItemModel.getProductId();
		this.desc = salesOrderItemModel.getDesc();
		this.qty = salesOrderItemModel.getQty();
		this.priceListTypeId = salesOrderItemModel.getPriceListTypeId();
		this.priceListRate = salesOrderItemModel.getPriceListRate();
		this.rate = salesOrderItemModel.getRate();
		this.rateInclAll = false;
		this.qxr = salesOrderItemModel.getQxr();
		this.discRate = salesOrderItemModel.getDiscRate();
		this.discRateTypeId = salesOrderItemModel.getDiscRateTypeId();
		this.discA = salesOrderItemModel.getDiscA();
		this.amtAfterDisc = salesOrderItemModel.getAmtAfterDisc();
		this.taxableAmt = salesOrderItemModel.getTaxableAmt();
		this.taxId = salesOrderItemModel.getTaxId();
		this.taxRate = salesOrderItemModel.getTaxRate();
		this.cgstA = salesOrderItemModel.getCgstA();
		this.sgstA = salesOrderItemModel.getSgstA();
		this.igstA = salesOrderItemModel.getIgstA();
		this.amt = salesOrderItemModel.getAmt();
	}

	public SalesItemModel(PiItemModel piItemModel)
	{
		this.productId = piItemModel.getProductId();
		this.desc = piItemModel.getDesc();
		this.qty = piItemModel.getQty();
		this.priceListTypeId = piItemModel.getPriceListTypeId();
		this.priceListRate = piItemModel.getPriceListRate();
		this.rate = piItemModel.getRate();
		this.rateInclAll = false;
		this.qxr = piItemModel.getQxr();
		this.discRate = piItemModel.getDiscRate();
		this.discRateTypeId = piItemModel.getDiscRateTypeId();
		this.discA = piItemModel.getDiscA();
		this.amtAfterDisc = piItemModel.getAmtAfterDisc();
		this.taxableAmt = piItemModel.getTaxableAmt();
		this.taxId = piItemModel.getTaxId();
		this.taxRate = piItemModel.getTaxRate();
		this.cgstA = piItemModel.getCgstA();
		this.sgstA = piItemModel.getSgstA();
		this.igstA = piItemModel.getIgstA();
		this.amt = piItemModel.getAmt();
	}

	public SalesItemModel(SalesItemModel salesItemModel, boolean copyId)
	{
		if (copyId)
		{
			this.id = salesItemModel.id;
		}

		this.salesId = salesItemModel.salesId;
		this.productId = salesItemModel.productId;
		this.desc = salesItemModel.desc;
		this.qty = salesItemModel.qty;
		this.priceListTypeId = salesItemModel.priceListTypeId;
		this.priceListRate = salesItemModel.priceListRate;
		this.rate = salesItemModel.rate;
		this.rateInclAll = salesItemModel.rateInclAll;
		this.qxr = salesItemModel.qxr;
		this.discRate = salesItemModel.discRate;
		this.discRateTypeId = salesItemModel.discRateTypeId;
		this.discA = salesItemModel.discA;
		this.amtAfterDisc = salesItemModel.amtAfterDisc;
		this.taxableAmt = salesItemModel.taxableAmt;
		this.taxId = salesItemModel.taxId;
		this.taxRate = salesItemModel.taxRate;
		this.cgstA = salesItemModel.cgstA;
		this.sgstA = salesItemModel.sgstA;
		this.igstA = salesItemModel.igstA;
		this.amt = salesItemModel.amt;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getSalesId()
	{
		return salesId;
	}

	public void setSalesId(int salesId)
	{
		this.salesId = salesId;
	}

	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public BigDecimal getQty()
	{
		return qty;
	}

	public void setQty(BigDecimal qty)
	{
		this.qty = qty;
	}

	public Integer getPriceListTypeId()
	{
		return priceListTypeId;
	}

	public void setPriceListTypeId(Integer priceListTypeId)
	{
		this.priceListTypeId = priceListTypeId;
	}

	public BigDecimal getPriceListRate()
	{
		return priceListRate;
	}

	public void setPriceListRate(BigDecimal priceListRate)
	{
		this.priceListRate = priceListRate;
	}

	public BigDecimal getRate()
	{
		return rate;
	}

	public void setRate(BigDecimal rate)
	{
		this.rate = rate;
	}

	public boolean isRateInclAll()
	{
		return rateInclAll;
	}

	public void setRateInclAll(boolean rateInclAll)
	{
		this.rateInclAll = rateInclAll;
	}

	public BigDecimal getQxr()
	{
		return qxr;
	}

	public void setQxr(BigDecimal qxr)
	{
		this.qxr = qxr;
	}

	public BigDecimal getDiscRate()
	{
		return discRate;
	}

	public void setDiscRate(BigDecimal discRate)
	{
		this.discRate = discRate;
	}

	public Integer getDiscRateTypeId()
	{
		return discRateTypeId;
	}

	public void setDiscRateTypeId(Integer discRateTypeId)
	{
		this.discRateTypeId = discRateTypeId;
	}

	public BigDecimal getDiscA()
	{
		return discA;
	}

	public void setDiscA(BigDecimal discA)
	{
		this.discA = discA;
	}

	public BigDecimal getAmtAfterDisc()
	{
		return amtAfterDisc;
	}

	public void setAmtAfterDisc(BigDecimal amtAfterDisc)
	{
		this.amtAfterDisc = amtAfterDisc;
	}

	public BigDecimal getTaxableAmt()
	{
		return taxableAmt;
	}

	public void setTaxableAmt(BigDecimal taxableAmt)
	{
		this.taxableAmt = taxableAmt;
	}

	public Integer getTaxId()
	{
		return taxId;
	}

	public void setTaxId(Integer taxId)
	{
		this.taxId = taxId;
	}

	public BigDecimal getTaxRate()
	{
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate)
	{
		this.taxRate = taxRate;
	}

	public BigDecimal getCgstA()
	{
		return cgstA;
	}

	public void setCgstA(BigDecimal cgstA)
	{
		this.cgstA = cgstA;
	}

	public BigDecimal getSgstA()
	{
		return sgstA;
	}

	public void setSgstA(BigDecimal sgstA)
	{
		this.sgstA = sgstA;
	}

	public BigDecimal getIgstA()
	{
		return igstA;
	}

	public void setIgstA(BigDecimal igstA)
	{
		this.igstA = igstA;
	}

	public BigDecimal getAmt()
	{
		return amt;
	}

	public void setAmt(BigDecimal amt)
	{
		this.amt = amt;
	}

	//
	public RateType getDiscRateType()
	{
		if (discRateTypeId == null)
		{
			return null;
		}

		for (RateType value : RateType.values())
		{
			if (value.getId() == discRateTypeId)
			{
				return value;
			}
		}
		return null;
	}

	public void setDiscRateType(RateType vouItemRateType)
	{
		if (vouItemRateType == null)
		{
			this.discRateTypeId = null;
		}
		else
		{
			this.discRateTypeId = vouItemRateType.getId();
		}
	}

	public PriceListType getPriceListType()
	{
		if (priceListTypeId == null)
		{
			return null;
		}

		return PriceListType.getById(priceListTypeId);
	}

	public void setPriceListType(PriceListType priceListType)
	{
		if (priceListType == null)
		{
			this.priceListTypeId = null;
		}
		else
		{
			this.priceListTypeId = priceListType.getId();
		}
	}

}
