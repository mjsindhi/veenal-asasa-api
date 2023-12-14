package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "pi")
public class PiModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "is_intra")
	private boolean isIntra;

	//Order Details
	@Column(name = "agent_id")
	private Integer agentId;

	@Column(name = "sum_qty")
	private BigDecimal sumQty;

	//variables for internal use
	@Column(name = "sum_qxr")
	private BigDecimal sumQxr;

	//Item val
	@Column(name = "sum_amt_after_item_disc")
	private BigDecimal sumAmtAfterItemDisc;

	@Column(name = "sum_item_taxable_amt")
	private BigDecimal sumItemTaxableAmt;

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

	@Column(name = "company_profile_id")
	private Integer companyProfileId;

	public PiModel()
	{
		note = "";
	}

	public PiModel(PiModel piModel, boolean copyId)
	{
		if (copyId)
		{
			this.id = piModel.id;
		}
		this.customerId = piModel.customerId;
		this.isIntra = piModel.isIntra;
		this.agentId = piModel.agentId;
		this.sumQty = piModel.sumQty;
		this.sumQxr = piModel.sumQxr;
		this.sumAmtAfterItemDisc = piModel.sumAmtAfterItemDisc;
		this.sumItemTaxableAmt = piModel.sumItemTaxableAmt;
		this.isTax = piModel.isTax;
		this.cgstA = piModel.cgstA;
		this.sgstA = piModel.sgstA;
		this.igstA = piModel.igstA;
		this.sumAmtAfterTax = piModel.sumAmtAfterTax;
		this.totalAmt = piModel.totalAmt;
		this.roundOff = piModel.roundOff;
		this.amtPayable = piModel.amtPayable;
		this.note = piModel.note;
		this.companyProfileId = piModel.companyProfileId;
	}

	public PiModel(EstimateModel estimateModel)
	{
		this.customerId = estimateModel.getCustomerId();
		this.isIntra = estimateModel.isIsIntra();
		this.sumQty = estimateModel.getSumQty();
		this.sumQxr = estimateModel.getSumQxr();
		this.sumAmtAfterItemDisc = estimateModel.getSumAmtAfterItemDisc();
		this.sumItemTaxableAmt = estimateModel.getSumItemTaxableAmt();
		this.isTax = estimateModel.isIsTax();
		this.cgstA = estimateModel.getCgstA();
		this.sgstA = estimateModel.getSgstA();
		this.igstA = estimateModel.getIgstA();
		this.sumAmtAfterTax = estimateModel.getSumAmtAfterTax();
		this.totalAmt = estimateModel.getTotalAmt();
		this.roundOff = estimateModel.getRoundOff();
		this.amtPayable = estimateModel.getAmtPayable();
		this.note = estimateModel.getNote();
	}

	public PiModel(PiModel salesOrderModel)
	{
		this.id = salesOrderModel.id;
		this.customerId = salesOrderModel.customerId;
		this.isIntra = salesOrderModel.isIntra;
		this.agentId = salesOrderModel.agentId;
		this.sumQty = salesOrderModel.sumQty;
		this.sumQxr = salesOrderModel.sumQxr;
		this.sumAmtAfterItemDisc = salesOrderModel.sumAmtAfterItemDisc;
		this.sumItemTaxableAmt = salesOrderModel.sumItemTaxableAmt;
		this.isTax = salesOrderModel.isTax;
		this.cgstA = salesOrderModel.cgstA;
		this.sgstA = salesOrderModel.sgstA;
		this.igstA = salesOrderModel.igstA;
		this.sumAmtAfterTax = salesOrderModel.sumAmtAfterTax;
		this.totalAmt = salesOrderModel.totalAmt;
		this.roundOff = salesOrderModel.roundOff;
		this.amtPayable = salesOrderModel.amtPayable;
		this.note = salesOrderModel.note;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Integer getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(Integer customerId)
	{
		this.customerId = customerId;
	}

	public boolean isIsIntra()
	{
		return isIntra;
	}

	public void setIsIntra(boolean isIntra)
	{
		this.isIntra = isIntra;
	}

	public Integer getAgentId()
	{
		return agentId;
	}

	public void setAgentId(Integer agentId)
	{
		this.agentId = agentId;
	}

	public BigDecimal getSumQty()
	{
		return sumQty;
	}

	public void setSumQty(BigDecimal sumQty)
	{
		this.sumQty = sumQty;
	}

	public BigDecimal getSumQxr()
	{
		return sumQxr;
	}

	public void setSumQxr(BigDecimal sumQxr)
	{
		this.sumQxr = sumQxr;
	}

	public BigDecimal getSumAmtAfterItemDisc()
	{
		return sumAmtAfterItemDisc;
	}

	public void setSumAmtAfterItemDisc(BigDecimal sumAmtAfterItemDisc)
	{
		this.sumAmtAfterItemDisc = sumAmtAfterItemDisc;
	}

	public BigDecimal getSumItemTaxableAmt()
	{
		return sumItemTaxableAmt;
	}

	public void setSumItemTaxableAmt(BigDecimal sumItemTaxableAmt)
	{
		this.sumItemTaxableAmt = sumItemTaxableAmt;
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

	public Integer getCompanyProfileId()
	{
		return companyProfileId;
	}

	public void setCompanyProfileId(Integer companyProfileId)
	{
		this.companyProfileId = companyProfileId;
	}

	//
	public int getSucuId()
	{
		return customerId;
	}

	public void setSucuId(int sucuId)
	{
		this.customerId = sucuId;
	}

}
