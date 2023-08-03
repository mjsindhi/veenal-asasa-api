package com.hemsw.asasaapi.veenal.model.gen;

import com.hemsw.asasaapi.veenal.enums.RateType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "sales_oth_charge")
public class SalesOthChModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "no")
	private int no;

	@Column(name = "sales_id")
	int salesId;

	@Column(name = "oth_charge_id")
	private int othChargeId;

	@Column(name = "rate")
	private BigDecimal rate;

	@Column(name = "rate_type_id")
	private int rateTypeId;

	@Column(name = "amt")
	private BigDecimal amt;

	public SalesOthChModel()
	{
	}

	public SalesOthChModel(EstimateOthChModel estimateOthChNonTaxModel)
	{
		this.no = estimateOthChNonTaxModel.getNo();
		this.othChargeId = estimateOthChNonTaxModel.getOthChargeId();
		this.rate = estimateOthChNonTaxModel.getRate();
		this.rateTypeId = estimateOthChNonTaxModel.getRateTypeId();
		this.amt = estimateOthChNonTaxModel.getAmt();
	}

	public SalesOthChModel(SalesOrderOthChModel salesOrderOthChNonTaxModel)
	{
		this.no = salesOrderOthChNonTaxModel.getNo();
		this.othChargeId = salesOrderOthChNonTaxModel.getOthChargeId();
		this.rate = salesOrderOthChNonTaxModel.getRate();
		this.rateTypeId = salesOrderOthChNonTaxModel.getRateTypeId();
		this.amt = salesOrderOthChNonTaxModel.getAmt();
	}

	public SalesOthChModel(PiOthChModel piOthChNonTaxModel)
	{
		this.no = piOthChNonTaxModel.getNo();
		this.othChargeId = piOthChNonTaxModel.getOthChargeId();
		this.rate = piOthChNonTaxModel.getRate();
		this.rateTypeId = piOthChNonTaxModel.getRateTypeId();
		this.amt = piOthChNonTaxModel.getAmt();
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getNo()
	{
		return no;
	}

	public void setNo(int no)
	{
		this.no = no;
	}

	public int getSalesId()
	{
		return salesId;
	}

	public void setSalesId(int salesId)
	{
		this.salesId = salesId;
	}

	public int getOthChargeId()
	{
		return othChargeId;
	}

	public void setOthChargeId(int othChargeId)
	{
		this.othChargeId = othChargeId;
	}

	public int getRateTypeId()
	{
		return rateTypeId;
	}

	public void setRateTypeId(int rateTypeId)
	{
		this.rateTypeId = rateTypeId;
	}

	public RateType getRateType()
	{
		for (RateType value1 : RateType.values())
		{
			if (value1.getId() == rateTypeId)
			{
				return value1;
			}
		}
		return null;
	}

	public void setRateType(RateType vouItemCalcType)
	{
		this.rateTypeId = vouItemCalcType.getId();
	}

	public BigDecimal getRate()
	{
		return rate;
	}

	public void setRate(BigDecimal rate)
	{
		this.rate = rate;
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
