package com.hemsw.asasaapi.veenal.model.gen;

import com.hemsw.asasaapi.veenal.enums.RateType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "purchase")
public class PurchaseModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "no")
	private String no;

	@Column(name = "date")
	private Date date;

	//Customer Details
	@Column(name = "supplier_id")
	private int supplierId;

	@Column(name = "is_intra")
	private boolean isIntra;

	//Order Details
	@Column(name = "order_no")
	private String orderNo;

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "agent_id")
	private Integer agentId;

	//Transport Details
	@Column(name = "lr_no")
	private String lrNo;

	@Column(name = "lr_date")
	private Date lrDate;

	@Column(name = "transporter_id")
	private Integer transporterId;

	@Column(name = "sum_qty")
	private BigDecimal sumQty;

	@Column(name = "no_of_cartoon")
	private Integer noOfCartoon;

	//variables for internal use
	@Column(name = "sum_qxr")
	private BigDecimal sumQxr;

	@Column(name = "is_disc_on_item")
	private boolean isDiscOnItem;

	@Column(name = "disc_rate")
	private BigDecimal discRate;

	@Column(name = "disc_rate_type_id")
	private Integer discRateTypeId;

	@Column(name = "disc_a")
	private BigDecimal discA;

	//Item val
	@Column(name = "sum_amt_after_disc")
	private BigDecimal sumAmtAfterDisc;

	// Tax
	@Column(name = "is_tax")
	private boolean isTax;

	@Column(name = "cgst_a")
	private BigDecimal cgstA;

	@Column(name = "sgst_a")
	private BigDecimal sgstA;

	@Column(name = "igst_a")
	private BigDecimal igstA;

	@Column(name = "sum_amt_after_tax")
	private BigDecimal sumAmtAfterTax;

	@Column(name = "total_amt")
	private BigDecimal totalAmt;

	@Column(name = "round_off")
	private BigDecimal roundOff;

	@Column(name = "amt_payable")
	private BigDecimal amtPayable;

	@Column(name = "note")
	private String note;

	@Column(name = "is_hosiery")
	private boolean isHosiery;

	@Column(name = "tax_amt")
	private BigDecimal taxAmt;

	public PurchaseModel()
	{
	}

	public PurchaseModel(PurchaseModel purchaseModel, boolean copyId)
	{
		if (copyId)
		{
			this.id = purchaseModel.id;
		}
		this.no = purchaseModel.no;
		this.date = purchaseModel.date;
		this.supplierId = purchaseModel.supplierId;
		this.isIntra = purchaseModel.isIntra;
		this.orderNo = purchaseModel.orderNo;
		this.orderDate = purchaseModel.orderDate;
		this.agentId = purchaseModel.agentId;
		this.lrNo = purchaseModel.lrNo;
		this.lrDate = purchaseModel.lrDate;
		this.transporterId = purchaseModel.transporterId;
		this.sumQty = purchaseModel.sumQty;
		this.noOfCartoon = purchaseModel.noOfCartoon;
		this.sumQxr = purchaseModel.sumQxr;
		this.isDiscOnItem = purchaseModel.isDiscOnItem;
		this.discRate = purchaseModel.discRate;
		this.discRateTypeId = purchaseModel.discRateTypeId;
		this.discA = purchaseModel.discA;
		this.sumAmtAfterDisc = purchaseModel.sumAmtAfterDisc;
		this.isTax = purchaseModel.isTax;
		this.cgstA = purchaseModel.cgstA;
		this.sgstA = purchaseModel.sgstA;
		this.igstA = purchaseModel.igstA;
		this.sumAmtAfterTax = purchaseModel.sumAmtAfterTax;
		this.totalAmt = purchaseModel.totalAmt;
		this.roundOff = purchaseModel.roundOff;
		this.amtPayable = purchaseModel.amtPayable;
		this.note = purchaseModel.note;
		this.isHosiery = purchaseModel.isHosiery;
		this.taxAmt = purchaseModel.taxAmt;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getNo()
	{
		return no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public int getSupplierId()
	{
		return supplierId;
	}

	public void setSupplierId(int supplierId)
	{
		this.supplierId = supplierId;
	}

	public boolean isIsIntra()
	{
		return isIntra;
	}

	public void setIsIntra(boolean isIntra)
	{
		this.isIntra = isIntra;
	}

	public String getOrderNo()
	{
		return orderNo;
	}

	public void setOrderNo(String orderNo)
	{
		this.orderNo = orderNo;
	}

	public Date getOrderDate()
	{
		return orderDate;
	}

	public void setOrderDate(Date orderDate)
	{
		this.orderDate = orderDate;
	}

	public Integer getAgentId()
	{
		return agentId;
	}

	public void setAgentId(Integer agentId)
	{
		this.agentId = agentId;
	}

	public String getLrNo()
	{
		return lrNo;
	}

	public void setLrNo(String lrNo)
	{
		this.lrNo = lrNo;
	}

	public Date getLrDate()
	{
		return lrDate;
	}

	public void setLrDate(Date lrDate)
	{
		this.lrDate = lrDate;
	}

	public Integer getTransporterId()
	{
		return transporterId;
	}

	public void setTransporterId(Integer transporterId)
	{
		this.transporterId = transporterId;
	}

	public BigDecimal getSumQty()
	{
		return sumQty;
	}

	public void setSumQty(BigDecimal sumQty)
	{
		this.sumQty = sumQty;
	}

	public Integer getNoOfCartoon()
	{
		return noOfCartoon;
	}

	public void setNoOfCartoon(Integer noOfCartoon)
	{
		this.noOfCartoon = noOfCartoon;
	}

	public BigDecimal getSumQxr()
	{
		return sumQxr;
	}

	public void setSumQxr(BigDecimal sumQxr)
	{
		this.sumQxr = sumQxr;
	}

	public boolean isIsDiscOnItem()
	{
		return isDiscOnItem;
	}

	public void setIsDiscOnItem(boolean isDiscOnItem)
	{
		this.isDiscOnItem = isDiscOnItem;
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

	public BigDecimal getDiscA()
	{
		return discA;
	}

	public void setDiscA(BigDecimal discA)
	{
		this.discA = discA;
	}

	public BigDecimal getSumAmtAfterDisc()
	{
		return sumAmtAfterDisc;
	}

	public void setSumAmtAfterDisc(BigDecimal sumAmtAfterDisc)
	{
		this.sumAmtAfterDisc = sumAmtAfterDisc;
	}

	public boolean isIsTax()
	{
		return isTax;
	}

	public void setIsTax(boolean isTax)
	{
		this.isTax = isTax;
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

	public BigDecimal getSumAmtAfterTax()
	{
		return sumAmtAfterTax;
	}

	public void setSumAmtAfterTax(BigDecimal sumAmtAfterTax)
	{
		this.sumAmtAfterTax = sumAmtAfterTax;
	}

	public BigDecimal getTotalAmt()
	{
		return totalAmt;
	}

	public void setTotalAmt(BigDecimal totalAmt)
	{
		this.totalAmt = totalAmt;
	}

	public BigDecimal getRoundOff()
	{
		return roundOff;
	}

	public void setRoundOff(BigDecimal roundOff)
	{
		this.roundOff = roundOff;
	}

	public BigDecimal getAmtPayable()
	{
		return amtPayable;
	}

	public void setAmtPayable(BigDecimal amtPayable)
	{
		this.amtPayable = amtPayable;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public boolean isIsHosiery()
	{
		return isHosiery;
	}

	public void setIsHosiery(boolean isHosiery)
	{
		this.isHosiery = isHosiery;
	}

	public BigDecimal getTaxAmt()
	{
		return taxAmt;
	}

	public void setTaxAmt(BigDecimal taxAmt)
	{
		this.taxAmt = taxAmt;
	}

}
