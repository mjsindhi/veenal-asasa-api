package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sales_return_agent")
public class SalesReturnAgentModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "sales_return_id")
	private int salesReturnId;

	@Column(name = "agent_id")
	private int agentId;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getSalesReturnId()
	{
		return salesReturnId;
	}

	public void setSalesReturnId(int salesReturnId)
	{
		this.salesReturnId = salesReturnId;
	}

	public int getAgentId()
	{
		return agentId;
	}

	public void setAgentId(int agentId)
	{
		this.agentId = agentId;
	}

}
