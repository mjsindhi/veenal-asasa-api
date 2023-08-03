package com.hemsw.asasaapi.veenal.dto.ldto;

import com.hemsw.asasaapi.veenal.enums.TxType;
import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class JournalLdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "no")
	private String no;

	@Column(name = "date")
	private Date date;

	@Column(name = "tx_type_id")
	private int txTypeId;

	@Column(name = "acct_name")
	private String acctName;

	@Column(name = "amt")
	private BigDecimal amt;

	@Column(name = "note")
	private String note;

	@Column(name = "created_by_user_name")
	private String createdByUserName;

	@Column(name = "created_at")
	private Date createdAt;

	public int getId()
	{
		return id;
	}

	public String getNo()
	{
		return no;
	}

	public Date getDate()
	{
		return date;
	}

	public int getTxTypeId()
	{
		return txTypeId;
	}

	public String getAcctName()
	{
		return acctName;
	}

	public BigDecimal getAmt()
	{
		return amt;
	}

	public String getNote()
	{
		return note;
	}

	public String getCreatedByUserName()
	{
		return createdByUserName;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	//Custom Getters setters
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
