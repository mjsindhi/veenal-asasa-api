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
@Table(name = "pi_item")
public class PiItemModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "pi_id")
	private int piId;

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

	public PiItemModel()
	{
	}

	public PiItemModel(PiItemModel piItemModel, boolean copyId)
	{
		if (copyId)
		{
			this.id = piItemModel.id;
		}

		this.piId = piItemModel.piId;
		this.productId = piItemModel.productId;
		this.desc = piItemModel.desc;
		this.qty = piItemModel.qty;
		this.priceListTypeId = piItemModel.priceListTypeId;
		this.priceListRate = piItemModel.priceListRate;
		this.rate = piItemModel.rate;
		this.rateInclAll = piItemModel.rateInclAll;
		this.qxr = piItemModel.qxr;
		this.discRate = piItemModel.discRate;
		this.discRateTypeId = piItemModel.discRateTypeId;
		this.discA = piItemModel.discA;
		this.amtAfterDisc = piItemModel.amtAfterDisc;
		this.taxableAmt = piItemModel.taxableAmt;
		this.taxId = piItemModel.taxId;
		this.taxRate = piItemModel.taxRate;
		this.cgstA = piItemModel.cgstA;
		this.sgstA = piItemModel.sgstA;
		this.igstA = piItemModel.igstA;
		this.amt = piItemModel.amt;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getPiId()
	{
		return piId;
	}

	public void setPiId(int piId)
	{
		this.piId = piId;
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
