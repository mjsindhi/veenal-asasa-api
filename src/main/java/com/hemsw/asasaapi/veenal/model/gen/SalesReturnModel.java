package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "sales_return")
public class SalesReturnModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "acct_id")
	private int acctId;

	//Customer Details
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "is_intra")
	private boolean isIntra;

	//Order Details
	@Column(name = "agent_id")
	private Integer agentId;

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

	@Column(name = "final_invoice_no")
	private String finalInvoiceNo;

	@Column(name = "company_profile_id")
	private Integer companyProfileId;

	public SalesReturnModel()
	{
	}

	public SalesReturnModel(SalesReturnModel salesReturnModel, boolean copyId)
	{
		if (copyId)
		{
			this.id = salesReturnModel.id;
		}

		this.acctId = salesReturnModel.acctId;
		this.customerId = salesReturnModel.customerId;
		this.isIntra = salesReturnModel.isIntra;
		this.agentId = salesReturnModel.agentId;
		this.sumQty = salesReturnModel.sumQty;
		this.noOfCartoon = salesReturnModel.noOfCartoon;
		this.sumQxr = salesReturnModel.sumQxr;
		this.isDiscOnItem = salesReturnModel.isDiscOnItem;
		this.discRate = salesReturnModel.discRate;
		this.discRateTypeId = salesReturnModel.discRateTypeId;
		this.discA = salesReturnModel.discA;
		this.sumAmtAfterItemDisc = salesReturnModel.sumAmtAfterItemDisc;
		this.sumItemTaxableAmt = salesReturnModel.sumItemTaxableAmt;
		this.isTax = salesReturnModel.isTax;
		this.cgstA = salesReturnModel.cgstA;
		this.sgstA = salesReturnModel.sgstA;
		this.igstA = salesReturnModel.igstA;
		this.sumAmtAfterTax = salesReturnModel.sumAmtAfterTax;
		this.totalAmt = salesReturnModel.totalAmt;
		this.roundOff = salesReturnModel.roundOff;
		this.amtPayable = salesReturnModel.amtPayable;
		this.note = salesReturnModel.note;

		this.finalInvoiceNo = salesReturnModel.finalInvoiceNo;
		this.companyProfileId = salesReturnModel.companyProfileId;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getAcctId()
	{
		return acctId;
	}

	public void setAcctId(int acctId)
	{
		this.acctId = acctId;
	}

	public int getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(int customerId)
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

	public BigDecimal getDiscA()
	{
		return discA;
	}

	public void setDiscA(BigDecimal discA)
	{
		this.discA = discA;
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

	public String getFinalInvoiceNo()
	{
		return finalInvoiceNo;
	}

	public void setFinalInvoiceNo(String finalInvoiceNo)
	{
		this.finalInvoiceNo = finalInvoiceNo;
	}

	public Integer getCompanyProfileId()
	{
		return companyProfileId;
	}

	public void setCompanyProfileId(Integer companyProfileId)
	{
		this.companyProfileId = companyProfileId;
	}

	public int getSucuId()
	{
		return customerId;
	}

	public void setSucuId(int sucuId)
	{
		this.customerId = sucuId;
	}

}
