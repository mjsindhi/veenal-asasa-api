package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class CurrentStockDetHdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "qty")
	private BigDecimal qty;

	@Column(name = "rate")
	private BigDecimal rate;

	@Column(name = "amt")
	private BigDecimal amt;

	@Column(name = "pending_qty_purchase")
	private BigDecimal pendingQtyPurchase;

	@Column(name = "pending_qty_sales")
	private BigDecimal pendingQtySales;

	@Column(name = "final_qty")
	private BigDecimal finalQty;

	@Column(name = "min_qty_days")
	private Integer minQtyDays;

	@Column(name = "avg_daily_sales")
	private BigDecimal avgDailySales;

	@Column(name = "reorder_level")
	private BigDecimal reorderLevel;

	@Column(name = "shortfall")
	private BigDecimal shortfall;

	@Column(name = "reorder_qty_days")
	private Integer reorderQtyDays;

	@Column(name = "min_reorder_qty")
	private BigDecimal minReorderQty;

	@Column(name = "reorder_qty")
	private BigDecimal reorderQty;

	@Column(name = "suppliers")
	private String suppliers;

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public BigDecimal getQty()
	{
		return qty;
	}

	public BigDecimal getRate()
	{
		return rate;
	}

	public BigDecimal getAmt()
	{
		return amt;
	}

	public BigDecimal getPendingQtyPurchase()
	{
		return pendingQtyPurchase;
	}

	public BigDecimal getPendingQtySales()
	{
		return pendingQtySales;
	}

	public BigDecimal getFinalQty()
	{
		return finalQty;
	}

	public Integer getMinQtyDays()
	{
		return minQtyDays;
	}

	public BigDecimal getAvgDailySales()
	{
		return avgDailySales;
	}

	public BigDecimal getReorderLevel()
	{
		return reorderLevel;
	}

	public BigDecimal getShortfall()
	{
		return shortfall;
	}

	public Integer getReorderQtyDays()
	{
		return reorderQtyDays;
	}

	public BigDecimal getMinReorderQty()
	{
		return minReorderQty;
	}

	public BigDecimal getReorderQty()
	{
		return reorderQty;
	}

	public String getSuppliers()
	{
		return suppliers;
	}

}
