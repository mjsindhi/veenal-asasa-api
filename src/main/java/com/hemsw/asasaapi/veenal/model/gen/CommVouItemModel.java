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
@Table(name = "comm_vou_item")
public class CommVouItemModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "comm_vou_id")
	private int commVouId;

	@Column(name = "product_id")
	private int productId;

	@Column(name = "qty")
	private BigDecimal qty;

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

	@Column(name = "comm_rate")
	private BigDecimal commRate;

	@Column(name = "comm_amt")
	private BigDecimal commAmt;

	public CommVouItemModel()
	{
	}

	public CommVouItemModel(SalesItemModel salesItemModel)
	{
		this.productId = salesItemModel.getProductId();
		this.qty = salesItemModel.getQty();
		this.rate = salesItemModel.getRate();
		this.qxr = salesItemModel.getQxr();
		this.discRate = salesItemModel.getDiscRate();
		this.discRateTypeId = salesItemModel.getDiscRateTypeId();
		this.discA = salesItemModel.getDiscA();
		this.amtAfterDisc = salesItemModel.getAmtAfterDisc();
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getCommVouId()
	{
		return commVouId;
	}

	public void setCommVouId(int commVouId)
	{
		this.commVouId = commVouId;
	}

	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
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

	public BigDecimal getCommRate()
	{
		return commRate;
	}

	public void setCommRate(BigDecimal commRate)
	{
		this.commRate = commRate;
	}

	public BigDecimal getCommAmt()
	{
		return commAmt;
	}

	public void setCommAmt(BigDecimal commAmt)
	{
		this.commAmt = commAmt;
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

}
