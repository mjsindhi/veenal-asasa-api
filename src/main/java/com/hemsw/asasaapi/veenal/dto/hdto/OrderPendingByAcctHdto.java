package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class OrderPendingByAcctHdto
{

	@Column(name = "acct_id")
	private int acctId;

	@Column(name = "acct_name")
	private String acctName;

	@Column(name = "product_cnt")
	private BigDecimal productCnt;

	@Column(name = "qty_total")
	private BigDecimal qtyTotal;

	public int getAcctId()
	{
		return acctId;
	}

	public String getAcctName()
	{
		return acctName;
	}

	public BigDecimal getProductCnt()
	{
		return productCnt;
	}

	public BigDecimal getQtyTotal()
	{
		return qtyTotal;
	}

}
