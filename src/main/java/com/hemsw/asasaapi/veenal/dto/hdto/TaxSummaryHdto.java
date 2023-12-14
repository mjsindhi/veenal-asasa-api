package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class TaxSummaryHdto
{

	@Column(name = "hsn")
	private int hsn;

	@Column(name = "sum_qty")
	private BigDecimal sumQty;

	@Column(name = "tax_id")
	private int taxId;

	@Column(name = "taxable_amt")
	private BigDecimal taxableAmt;

	@Column(name = "cgst_a")
	private BigDecimal cgstA;

	@Column(name = "sgst_a")
	private BigDecimal sgstA;

	@Column(name = "igst_a")
	private BigDecimal igstA;

	public int getHsn()
	{
		return hsn;
	}

	public void setHsn(int hsn)
	{
		this.hsn = hsn;
	}

	public BigDecimal getSumQty()
	{
		return sumQty;
	}

	public void setSumQty(BigDecimal sumQty)
	{
		this.sumQty = sumQty;
	}

	public int getTaxId()
	{
		return taxId;
	}

	public void setTaxId(int taxId)
	{
		this.taxId = taxId;
	}

	public BigDecimal getTaxableAmt()
	{
		return taxableAmt;
	}

	public void setTaxableAmt(BigDecimal taxableAmt)
	{
		this.taxableAmt = taxableAmt;
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

}
