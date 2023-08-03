package com.hemsw.asasaapi.veenal.model.gen;

import com.hemsw.asasaapi.veenal.enums.RateType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "purchase_item")
public class PurchaseItemModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "purchase_id")
	int purchaseId;

	@Column(name = "product_id")
	private int productId;

	@Column(name = "desc")
	private String desc;

	@Column(name = "qty_28")
	private BigDecimal qty28;

	@Column(name = "qty_30")
	private BigDecimal qty30;

	@Column(name = "qty_32")
	private BigDecimal qty32;

	@Column(name = "qty_34")
	private BigDecimal qty34;

	@Column(name = "qty_36")
	private BigDecimal qty36;

	@Column(name = "qty_38")
	private BigDecimal qty38;

	@Column(name = "qty_40")
	private BigDecimal qty40;

	@Column(name = "qty_42")
	private BigDecimal qty42;

	@Column(name = "qty_44")
	private BigDecimal qty44;

	@Column(name = "qty_46")
	private BigDecimal qty46;

	@Column(name = "qty")
	private BigDecimal qty;

	@Column(name = "rate")
	private BigDecimal rate;

	@Column(name = "rate_incl_all")
	private boolean rateInclAll;

	@Column(name = "min_rp")
	private BigDecimal minRp;

	@Column(name = "max_rp")
	private BigDecimal maxRp;

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

	@Column(name = "cgst_a")
	private BigDecimal cgstA;

	@Column(name = "sgst_a")
	private BigDecimal sgstA;

	@Column(name = "igst_a")
	private BigDecimal igstA;

	@Column(name = "amt")
	private BigDecimal amt;

	public PurchaseItemModel()
	{
	}

	/*
	public void set(PurchaseItemModel purchaseItemModel)
	{
		this.id = purchaseItemModel.id;
		this.purchaseId = purchaseItemModel.purchaseId;
		this.productId = purchaseItemModel.productId;
		this.desc = purchaseItemModel.desc;
		this.qty = purchaseItemModel.qty;
		this.rate = purchaseItemModel.rate;
		this.rateInclAll = purchaseItemModel.rateInclAll;
		this.qxr = purchaseItemModel.qxr;
		this.discP = purchaseItemModel.discP;
		this.discA = purchaseItemModel.discA;
		this.taxableAmt = purchaseItemModel.taxableAmt;
		this.taxId = purchaseItemModel.taxId;
		this.cgstA = purchaseItemModel.cgstA;
		this.sgstA = purchaseItemModel.sgstA;
		this.igstA = purchaseItemModel.igstA;
		this.amt = purchaseItemModel.amt;
	}
	 */
	public int getId()
	{
		return id;
	}

	public int getPurchaseId()
	{
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId)
	{
		this.purchaseId = purchaseId;
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

	public BigDecimal getQty28()
	{
		return qty28;
	}

	public void setQty28(BigDecimal qty28)
	{
		this.qty28 = qty28;
	}

	public BigDecimal getQty30()
	{
		return qty30;
	}

	public void setQty30(BigDecimal qty30)
	{
		this.qty30 = qty30;
	}

	public BigDecimal getQty32()
	{
		return qty32;
	}

	public void setQty32(BigDecimal qty32)
	{
		this.qty32 = qty32;
	}

	public BigDecimal getQty34()
	{
		return qty34;
	}

	public void setQty34(BigDecimal qty34)
	{
		this.qty34 = qty34;
	}

	public BigDecimal getQty36()
	{
		return qty36;
	}

	public void setQty36(BigDecimal qty36)
	{
		this.qty36 = qty36;
	}

	public BigDecimal getQty38()
	{
		return qty38;
	}

	public void setQty38(BigDecimal qty38)
	{
		this.qty38 = qty38;
	}

	public BigDecimal getQty40()
	{
		return qty40;
	}

	public void setQty40(BigDecimal qty40)
	{
		this.qty40 = qty40;
	}

	public BigDecimal getQty42()
	{
		return qty42;
	}

	public void setQty42(BigDecimal qty42)
	{
		this.qty42 = qty42;
	}

	public BigDecimal getQty44()
	{
		return qty44;
	}

	public void setQty44(BigDecimal qty44)
	{
		this.qty44 = qty44;
	}

	public BigDecimal getQty46()
	{
		return qty46;
	}

	public void setQty46(BigDecimal qty46)
	{
		this.qty46 = qty46;
	}

	public BigDecimal getQty()
	{
		return qty;
	}

	public void setQty(BigDecimal qty)
	{
		this.qty = qty;
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

	public BigDecimal getMinRp()
	{
		return minRp;
	}

	public void setMinRp(BigDecimal minRp)
	{
		this.minRp = minRp;
	}

	public BigDecimal getMaxRp()
	{
		return maxRp;
	}

	public void setMaxRp(BigDecimal maxRp)
	{
		this.maxRp = maxRp;
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

	public RateType getDiscRateType()
	{
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

}
