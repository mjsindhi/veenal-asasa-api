package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "opening_stock")
public class OpeningStockModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "product_id")
	private int productId;

	@Column(name = "qty_28")
	private BigDecimal qty28;

	@Column(name = "qty_30")
	private BigDecimal qty30;

	@Column(name = "qty_32")
	private BigDecimal qty32;

	@Column(name = "qty_34")
	private BigDecimal qty34;

	@Column(name = "qty_36")
	private BigDecimal qty36;

	@Column(name = "qty_38")
	private BigDecimal qty38;

	@Column(name = "qty_40")
	private BigDecimal qty40;

	@Column(name = "qty_42")
	private BigDecimal qty42;

	@Column(name = "qty_44")
	private BigDecimal qty44;

	@Column(name = "qty_46")
	private BigDecimal qty46;

	@Column(name = "quantity")
	private BigDecimal quantity;

	@Column(name = "rate")
	private BigDecimal rate;

	@Column(name = "min_rp")
	private BigDecimal minRp;

	@Column(name = "max_rp")
	private BigDecimal maxRp;

	@Column(name = "amount")
	private BigDecimal amount;

	public OpeningStockModel()
	{
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
	}

	public BigDecimal getQty28()
	{
		return qty28;
	}

	public void setQty28(BigDecimal qty28)
	{
		this.qty28 = qty28;
	}

	public BigDecimal getQty30()
	{
		return qty30;
	}

	public void setQty30(BigDecimal qty30)
	{
		this.qty30 = qty30;
	}

	public BigDecimal getQty32()
	{
		return qty32;
	}

	public void setQty32(BigDecimal qty32)
	{
		this.qty32 = qty32;
	}

	public BigDecimal getQty34()
	{
		return qty34;
	}

	public void setQty34(BigDecimal qty34)
	{
		this.qty34 = qty34;
	}

	public BigDecimal getQty36()
	{
		return qty36;
	}

	public void setQty36(BigDecimal qty36)
	{
		this.qty36 = qty36;
	}

	public BigDecimal getQty38()
	{
		return qty38;
	}

	public void setQty38(BigDecimal qty38)
	{
		this.qty38 = qty38;
	}

	public BigDecimal getQty40()
	{
		return qty40;
	}

	public void setQty40(BigDecimal qty40)
	{
		this.qty40 = qty40;
	}

	public BigDecimal getQty42()
	{
		return qty42;
	}

	public void setQty42(BigDecimal qty42)
	{
		this.qty42 = qty42;
	}

	public BigDecimal getQty44()
	{
		return qty44;
	}

	public void setQty44(BigDecimal qty44)
	{
		this.qty44 = qty44;
	}

	public BigDecimal getQty46()
	{
		return qty46;
	}

	public void setQty46(BigDecimal qty46)
	{
		this.qty46 = qty46;
	}

	public BigDecimal getQuantity()
	{
		return quantity;
	}

	public void setQuantity(BigDecimal quantity)
	{
		this.quantity = quantity;
	}

	public BigDecimal getRate()
	{
		return rate;
	}

	public void setRate(BigDecimal rate)
	{
		this.rate = rate;
	}

	public BigDecimal getMinRp()
	{
		return minRp;
	}

	public void setMinRp(BigDecimal minRp)
	{
		this.minRp = minRp;
	}

	public BigDecimal getMaxRp()
	{
		return maxRp;
	}

	public void setMaxRp(BigDecimal maxRp)
	{
		this.maxRp = maxRp;
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
