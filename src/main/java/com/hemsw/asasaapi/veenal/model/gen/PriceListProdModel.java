package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "price_list_prod")
public class PriceListProdModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "seq_no")
	private int seqNo;

	@Column(name = "price_list_id")
	private int priceListId;

	@Column(name = "prod_id")
	private int prodId;

	@Column(name = "rate")
	private BigDecimal rate;

	@Column(name = "disc")
	private BigDecimal disc;

	public PriceListProdModel()
	{
	}

	public PriceListProdModel(PriceListProdModel priceListProdModel, boolean copyId)
	{
		if (copyId)
		{
			this.id = priceListProdModel.id;
		}
		this.seqNo = priceListProdModel.seqNo;
		this.priceListId = priceListProdModel.priceListId;
		this.prodId = priceListProdModel.prodId;
		this.rate = priceListProdModel.rate;
		this.disc = priceListProdModel.disc;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getSeqNo()
	{
		return seqNo;
	}

	public void setSeqNo(int seqNo)
	{
		this.seqNo = seqNo;
	}

	public int getPriceListId()
	{
		return priceListId;
	}

	public void setPriceListId(int priceListId)
	{
		this.priceListId = priceListId;
	}

	public int getProdId()
	{
		return prodId;
	}

	public void setProdId(int prodId)
	{
		this.prodId = prodId;
	}

	public BigDecimal getRate()
	{
		return rate;
	}

	public void setRate(BigDecimal rate)
	{
		this.rate = rate;
	}

	public BigDecimal getDisc()
	{
		return disc;
	}

	public void setDisc(BigDecimal disc)
	{
		this.disc = disc;
	}

}
