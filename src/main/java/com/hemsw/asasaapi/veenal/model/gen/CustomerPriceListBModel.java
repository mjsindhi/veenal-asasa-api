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
@Table(name = "customer_price_list_b")
public class CustomerPriceListBModel implements ICusupPriceListModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "price_list_id")
	private int priceListId;

	@Column(name = "disc")
	private BigDecimal disc;

	@Column(name = "effect_from")
	private Date effectFrom;

	@Override
	public int getId()
	{
		return id;
	}

	@Override
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

	@Override
	public int getPriceListId()
	{
		return priceListId;
	}

	@Override
	public void setPriceListId(int priceListId)
	{
		this.priceListId = priceListId;
	}

	@Override
	public BigDecimal getDisc()
	{
		return disc;
	}

	@Override
	public void setDisc(BigDecimal disc)
	{
		this.disc = disc;
	}

	@Override
	public Date getEffectFrom()
	{
		return effectFrom;
	}

	@Override
	public void setEffectFrom(Date effectFrom)
	{
		this.effectFrom = effectFrom;
	}

}
