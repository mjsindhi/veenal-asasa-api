package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "set_against")
public class SetAgainstModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "dr_voucher_id")
	private Integer drVoucherId;

	@Column(name = "cr_voucher_id")
	private Integer crVoucherId;

	@Column(name = "amt")
	private BigDecimal amt;

	public int getId()
	{
		return id;
	}

	public BigDecimal getAmt()
	{
		return amt;
	}

	public int getDrVoucherId()
	{
		return drVoucherId;
	}

	public void setDrVoucherId(int drVoucherId)
	{
		this.drVoucherId = drVoucherId;
	}

	public int getCrVoucherId()
	{
		return crVoucherId;
	}

	public void setCrVoucherId(int crVoucherId)
	{
		this.crVoucherId = crVoucherId;
	}

	public void setAmt(BigDecimal amt)
	{
		this.amt = amt;
	}

}
