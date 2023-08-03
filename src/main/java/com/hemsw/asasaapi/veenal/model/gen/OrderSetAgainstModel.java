package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "order_set_against")
public class OrderSetAgainstModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "order_journal_id_order")
	private int orderJournalIdOrder;

	@Column(name = "order_journal_id_pusa")
	private int orderJournalIdPusa;

	@Column(name = "qty")
	private BigDecimal qty;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getOrderJournalIdOrder()
	{
		return orderJournalIdOrder;
	}

	public void setOrderJournalIdOrder(int orderJournalIdOrder)
	{
		this.orderJournalIdOrder = orderJournalIdOrder;
	}

	public int getOrderJournalIdPusa()
	{
		return orderJournalIdPusa;
	}

	public void setOrderJournalIdPusa(int orderJournalIdPusa)
	{
		this.orderJournalIdPusa = orderJournalIdPusa;
	}

	public BigDecimal getQty()
	{
		return qty;
	}

	public void setQty(BigDecimal qty)
	{
		this.qty = qty;
	}

}
