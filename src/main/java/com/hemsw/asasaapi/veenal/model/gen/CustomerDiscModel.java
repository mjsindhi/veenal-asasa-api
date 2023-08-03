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
@Table(name = "customer_disc")
public class CustomerDiscModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "disc")
	private BigDecimal disc;

	@Column(name = "days")
	private int days;

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

	public BigDecimal getDisc()
	{
		return disc;
	}

	public void setDisc(BigDecimal disc)
	{
		this.disc = disc;
	}

	public int getDays()
	{
		return days;
	}

	public void setDays(int days)
	{
		this.days = days;
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
