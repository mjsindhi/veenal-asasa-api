package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class RptIoDetHdto
{

	@Column(name = "voucher_id")
	private int voucherId;

	@Column(name = "date")
	private Date date;

	@Column(name = "voucher_type_id")
	private Integer voucherTypeId;

	@Column(name = "voucher_no")
	private String voucherNo;

	@Column(name = "acct_id")
	private Integer acctId;

	@Column(name = "acct_name")
	private String acctName;

	@Column(name = "prod_id")
	private int prodId;

	@Column(name = "prod_name")
	private String prodName;

	@Column(name = "qty_in")
	private BigDecimal qtyIn;

	@Column(name = "qty_out")
	private BigDecimal qtyOut;

	public int getVoucherId()
	{
		return voucherId;
	}

	public void setVoucherId(int voucherId)
	{
		this.voucherId = voucherId;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public Integer getVoucherTypeId()
	{
		return voucherTypeId;
	}

	public void setVoucherTypeId(Integer voucherTypeId)
	{
		this.voucherTypeId = voucherTypeId;
	}

	public String getVoucherNo()
	{
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo)
	{
		this.voucherNo = voucherNo;
	}

	public Integer getAcctId()
	{
		return acctId;
	}

	public void setAcctId(Integer acctId)
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

	public int getProdId()
	{
		return prodId;
	}

	public void setProdId(int prodId)
	{
		this.prodId = prodId;
	}

	public String getProdName()
	{
		return prodName;
	}

	public void setProdName(String prodName)
	{
		this.prodName = prodName;
	}

	public BigDecimal getQtyIn()
	{
		return qtyIn;
	}

	public void setQtyIn(BigDecimal qtyIn)
	{
		this.qtyIn = qtyIn;
	}

	public BigDecimal getQtyOut()
	{
		return qtyOut;
	}

	public void setQtyOut(BigDecimal qtyOut)
	{
		this.qtyOut = qtyOut;
	}

}
