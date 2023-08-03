package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "customer_agent_comm")
public class CustomerAgentCommModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "agent_id")
	private int agentId;

	@Column(name = "comm")
	private BigDecimal comm;

	@Column(name = "effect_from")
	private Date effectFrom;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}

	public int getAgentId()
	{
		return agentId;
	}

	public void setAgentId(int agentId)
	{
		this.agentId = agentId;
	}

	public BigDecimal getComm()
	{
		return comm;
	}

	public void setComm(BigDecimal comm)
	{
		this.comm = comm;
	}

	public Date getEffectFrom()
	{
		return effectFrom;
	}

	public void setEffectFrom(Date effectFrom)
	{
		this.effectFrom = effectFrom;
	}

}
