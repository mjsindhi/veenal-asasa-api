package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "comm_list_cat")
public class CommListCatModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "comm_list_id")
	private int commListId;

	@Column(name = "cat_id")
	private int catId;

	@Column(name = "rate")
	private BigDecimal rate;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getCommListId()
	{
		return commListId;
	}

	public void setCommListId(int commListId)
	{
		this.commListId = commListId;
	}

	public int getCatId()
	{
		return catId;
	}

	public void setCatId(int catId)
	{
		this.catId = catId;
	}

	public BigDecimal getRate()
	{
		return rate;
	}

	public void setRate(BigDecimal rate)
	{
		this.rate = rate;
	}

}
