package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "cash_disc_vou_set_against")
public class CashDiscVouSetAgainstModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "cash_disc_vou_id")
	private int cashDiscVouId;

	@Column(name = "voucher_id")
	private int voucherId;

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

	public int getCashDiscVouId()
	{
		return cashDiscVouId;
	}

	public void setCashDiscVouId(int cashDiscVouId)
	{
		this.cashDiscVouId = cashDiscVouId;
	}

	public int getVoucherId()
	{
		return voucherId;
	}

	public void setVoucherId(int voucherId)
	{
		this.voucherId = voucherId;
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
