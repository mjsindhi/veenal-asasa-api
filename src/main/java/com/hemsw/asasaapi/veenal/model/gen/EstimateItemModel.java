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
import java.util.Objects;

@Entity
@Table(name = "estimate_item")
public class EstimateItemModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "seq_no")
	private int seqNo;

	@Column(name = "estimate_id")
	private int estimateId;

	@Column(name = "product_id")
	private int productId;

	@Column(name = "desc")
	private String desc;

	@Column(name = "order_qty")
	private BigDecimal orderQty;

	@Column(name = "order_unit_id")
	private int orderUnitId;

	@Column(name = "is_pending")
	private boolean isPending;

	@Column(name = "qty")
	private BigDecimal qty;

	@Column(name = "price_list_type_id")
	private Integer priceListTypeId;

	@Column(name = "price_list_rate")
	private BigDecimal priceListRate;

	@Column(name = "rate")
	private BigDecimal rate;

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

	public EstimateItemModel()
	{
	}

	public EstimateItemModel(EstimateItemModel estimateItemModel)
	{
		this.id = estimateItemModel.id;
		this.seqNo = estimateItemModel.seqNo;
		this.estimateId = estimateItemModel.estimateId;
		this.productId = estimateItemModel.productId;
		this.desc = estimateItemModel.desc;
		this.orderQty = estimateItemModel.orderQty;
		this.orderUnitId = estimateItemModel.orderUnitId;
		this.isPending = estimateItemModel.isPending;
		this.qty = estimateItemModel.qty;
		this.priceListTypeId = estimateItemModel.priceListTypeId;
		this.priceListRate = estimateItemModel.priceListRate;
		this.rate = estimateItemModel.rate;
		this.qxr = estimateItemModel.qxr;
		this.discRate = estimateItemModel.discRate;
		this.discRateTypeId = estimateItemModel.discRateTypeId;
		this.discA = estimateItemModel.discA;
		this.amtAfterDisc = estimateItemModel.amtAfterDisc;
		this.taxableAmt = estimateItemModel.taxableAmt;
		this.taxId = estimateItemModel.taxId;
		this.taxRate = estimateItemModel.taxRate;
		this.cgstA = estimateItemModel.cgstA;
		this.sgstA = estimateItemModel.sgstA;
		this.igstA = estimateItemModel.igstA;
		this.amt = estimateItemModel.amt;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getSeqNo()
	{
		return seqNo;
	}

	public void setSeqNo(int seqNo)
	{
		this.seqNo = seqNo;
	}

	public int getEstimateId()
	{
		return estimateId;
	}

	public void setEstimateId(int estimateId)
	{
		this.estimateId = estimateId;
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

	public BigDecimal getOrderQty()
	{
		return orderQty;
	}

	public void setOrderQty(BigDecimal orderQty)
	{
		this.orderQty = orderQty;
	}

	public int getOrderUnitId()
	{
		return orderUnitId;
	}

	public void setOrderUnitId(int orderUnitId)
	{
		this.orderUnitId = orderUnitId;
	}

	public boolean isIsPending()
	{
		return isPending;
	}

	public void setIsPending(boolean isPending)
	{
		this.isPending = isPending;
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

	public int hashCode()
	{
		int hash = 7;
		hash = 43 * hash + this.id;
		hash = 43 * hash + this.seqNo;
		hash = 43 * hash + this.estimateId;
		hash = 43 * hash + this.productId;
		hash = 43 * hash + Objects.hashCode(this.desc);
		hash = 43 * hash + Objects.hashCode(this.orderQty);
		hash = 43 * hash + this.orderUnitId;
		hash = 43 * hash + (this.isPending ? 1 : 0);
		hash = 43 * hash + Objects.hashCode(this.qty);
		hash = 43 * hash + Objects.hashCode(this.priceListTypeId);
		hash = 43 * hash + Objects.hashCode(this.priceListRate);
		hash = 43 * hash + Objects.hashCode(this.rate);
		hash = 43 * hash + Objects.hashCode(this.qxr);
		hash = 43 * hash + Objects.hashCode(this.discRate);
		hash = 43 * hash + Objects.hashCode(this.discRateTypeId);
		hash = 43 * hash + Objects.hashCode(this.discA);
		hash = 43 * hash + Objects.hashCode(this.amtAfterDisc);
		hash = 43 * hash + Objects.hashCode(this.taxableAmt);
		hash = 43 * hash + Objects.hashCode(this.taxId);
		hash = 43 * hash + Objects.hashCode(this.taxRate);
		hash = 43 * hash + Objects.hashCode(this.cgstA);
		hash = 43 * hash + Objects.hashCode(this.sgstA);
		hash = 43 * hash + Objects.hashCode(this.igstA);
		hash = 43 * hash + Objects.hashCode(this.amt);
		return hash;
	}

	public boolean isRateInclAll()
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public void setRateInclAll(boolean rateInclAll)
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
