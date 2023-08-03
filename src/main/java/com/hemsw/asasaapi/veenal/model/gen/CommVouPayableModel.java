package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "comm_vou_payable")
public class CommVouPayableModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "comm_vou_id")
	private int commVouId;

	@Column(name = "set_against_id")
	private int setAgainstId;

	@Column(name = "amt_payable_estimated")
	private BigDecimal amtPayableEstimated;

	@Column(name = "amt")
	private BigDecimal amt;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getCommVouId()
	{
		return commVouId;
	}

	public void setCommVouId(int commVouId)
	{
		this.commVouId = commVouId;
	}

	public int getSetAgainstId()
	{
		return setAgainstId;
	}

	public void setSetAgainstId(int setAgainstId)
	{
		this.setAgainstId = setAgainstId;
	}

	public BigDecimal getAmtPayableEstimated()
	{
		return amtPayableEstimated;
	}

	public void setAmtPayableEstimated(BigDecimal amtPayableEstimated)
	{
		this.amtPayableEstimated = amtPayableEstimated;
	}

	public BigDecimal getAmt()
	{
		return amt;
	}

	public void setAmt(BigDecimal amt)
	{
		this.amt = amt;
	}

}
