package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class CommVouLedgerHdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "date")
	private Date date;

	@Column(name = "agent_id")
	private int agentId;

	@Column(name = "amt")
	private BigDecimal amt;

	@Column(name = "tx_type_id")
	private int txTypeId;

	public int getId()
	{
		return id;
	}

	public Date getDate()
	{
		return date;
	}

	public int getAgentId()
	{
		return agentId;
	}

	public BigDecimal getAmt()
	{
		return amt;
	}

	public int getTxTypeId()
	{
		return txTypeId;
	}

}
