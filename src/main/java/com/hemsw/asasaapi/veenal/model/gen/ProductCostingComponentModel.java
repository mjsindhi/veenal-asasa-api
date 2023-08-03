package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "product_costing_component")
public class ProductCostingComponentModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "product_costing_id")
	private int productCostingId;

	@Column(name = "product_component_id")
	private int productComponentId;

	@Column(name = "rate")
	private BigDecimal rate;

	@Column(name = "amount")
	private BigDecimal amount;

	public int getId()
	{
		return id;
	}

	public int getProductCostingId()
	{
		return productCostingId;
	}

	public void setProductCostingId(int productCostingId)
	{
		this.productCostingId = productCostingId;
	}

	public int getProductComponentId()
	{
		return productComponentId;
	}

	public void setProductComponentId(int productComponentId)
	{
		this.productComponentId = productComponentId;
	}

	public BigDecimal getRate()
	{
		return rate;
	}

	public void setRate(BigDecimal rate)
	{
		this.rate = rate;
	}

	public BigDecimal getAmount()
	{
		return amount;
	}

	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}

}
