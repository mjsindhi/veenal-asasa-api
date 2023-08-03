package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "comm_vou")
public class CommVouModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "sales_id")
	private int salesId;

	@Column(name = "agent_id")
	private int agentId;

	//Item val
	@Column(name = "sum_comm_amt")
	private BigDecimal sumCommAmt;

	@Column(name = "tot_comm_amt_after_oth_ch")
	private BigDecimal totalCommAmtAfterOthCh;

	@Column(name = "round_off")
	private BigDecimal roundOff;

	@Column(name = "estimated_comm")
	private BigDecimal estimatedComm;

	public CommVouModel()
	{
		this.sumCommAmt = BigDecimal.ZERO;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getSalesId()
	{
		return salesId;
	}

	public void setSalesId(int salesId)
	{
		this.salesId = salesId;
	}

	public int getAgentId()
	{
		return agentId;
	}

	public void setAgentId(int agentId)
	{
		this.agentId = agentId;
	}

	public BigDecimal getSumCommAmt()
	{
		return sumCommAmt;
	}

	public void setSumCommAmt(BigDecimal sumCommAmt)
	{
		this.sumCommAmt = sumCommAmt;
	}

	public BigDecimal getTotalCommAmtAfterOthCh()
	{
		return totalCommAmtAfterOthCh;
	}

	public void setTotalCommAmtAfterOthCh(BigDecimal totalCommAmtAfterOthCh)
	{
		this.totalCommAmtAfterOthCh = totalCommAmtAfterOthCh;
	}

	public BigDecimal getRoundOff()
	{
		return roundOff;
	}

	public void setRoundOff(BigDecimal roundOff)
	{
		this.roundOff = roundOff;
	}

	public BigDecimal getEstimatedComm()
	{
		return estimatedComm;
	}

	public void setEstimatedComm(BigDecimal estimatedComm)
	{
		this.estimatedComm = estimatedComm;
	}

}
