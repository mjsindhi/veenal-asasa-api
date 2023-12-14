package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class RptEstimatePendingByAcctHdto
{

	@Column(name = "acct_id")
	private int acctId;

	@Column(name = "acct_name")
	private String acctName;

	@Column(name = "cnt_estimate")
	private int cntEstimate;

	@Column(name = "cnt_prod")
	private int cntProd;

	@Column(name = "sum_qty")
	private BigDecimal sumQty;

	public int getAcctId()
	{
		return acctId;
	}

	public void setAcctId(int acctId)
	{
		this.acctId = acctId;
	}

	public String getAcctName()
	{
		return acctName;
	}

	public void setAcctName(String acctName)
	{
		this.acctName = acctName;
	}

	public int getCntEstimate()
	{
		return cntEstimate;
	}

	public void setCntEstimate(int cntEstimate)
	{
		this.cntEstimate = cntEstimate;
	}

	public int getCntProd()
	{
		return cntProd;
	}

	public void setCntProd(int cntProd)
	{
		this.cntProd = cntProd;
	}

	public BigDecimal getSumQty()
	{
		return sumQty;
	}

	public void setSumQty(BigDecimal sumQty)
	{
		this.sumQty = sumQty;
	}

}
