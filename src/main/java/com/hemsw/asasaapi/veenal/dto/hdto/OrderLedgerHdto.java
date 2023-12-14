package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class OrderLedgerHdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "voucher_type_id")
	private int voucherTypeId;

	@Column(name = "no")
	private String no;

	@Column(name = "date")
	private Date date;

	@Column(name = "acct_id")
	private Integer acctId;

	@Column(name = "acct_name")
	private String acctName;

	@Column(name = "product_id")
	private Integer productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "order_qty")
	private BigDecimal orderQty;

	@Column(name = "pusa_qty")
	private BigDecimal pusaQty;

	public int getId()
	{
		return id;
	}

	public int getVoucherTypeId()
	{
		return voucherTypeId;
	}

	public String getNo()
	{
		return no;
	}

	public Date getDate()
	{
		return date;
	}

	public Integer getAcctId()
	{
		return acctId;
	}

	public String getAcctName()
	{
		return acctName;
	}

	public Integer getProductId()
	{
		return productId;
	}

	public String getProductName()
	{
		return productName;
	}

	public BigDecimal getOrderQty()
	{
		return orderQty;
	}

	public BigDecimal getPusaQty()
	{
		return pusaQty;
	}

}
