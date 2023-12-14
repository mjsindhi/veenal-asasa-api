package com.hemsw.asasaapi.veenal.dto.hdto;

import com.hemsw.asasaapi.veenal.enums.TxType;
import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class AcctJournalClrAmtsHdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "date")
	private Date date;

	@Column(name = "acct_id")
	private int acctId;

	@Column(name = "voucher_id")
	private Integer voucherId;

	@Column(name = "tx_type_id")
	private int txTypeId;

	@Column(name = "dr")
	private BigDecimal dr;

	@Column(name = "cr")
	private BigDecimal cr;

	@Column(name = "amt_clrd")
	private BigDecimal amtClrd;

	@Column(name = "amt_unclrd")
	private BigDecimal amtUnclrd;

	public int getId()
	{
		return id;
	}

	public Date getDate()
	{
		return date;
	}

	public int getAcctId()
	{
		return acctId;
	}

	public Integer getVoucherId()
	{
		return voucherId;
	}

	public int getTxTypeId()
	{
		return txTypeId;
	}

	public BigDecimal getDr()
	{
		return dr;
	}

	public BigDecimal getCr()
	{
		return cr;
	}

	public BigDecimal getAmtClrd()
	{
		return amtClrd;
	}

	public BigDecimal getAmtUnclrd()
	{
		return amtUnclrd;
	}

	//
	public TxType getTxType()
	{
		for (TxType txType : TxType.values())
		{
			if (txType.getId() == txTypeId)
			{
				return txType;
			}
		}
		return null;
	}

}
