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
@Table(name = "sales_oth_charge_taxable")
public class SalesOthChTaxableModel
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

	@Column(name = "taxable_amt")
	private BigDecimal taxableAmt;

	@Column(name = "tax_id")
	private Integer taxId;

	@Column(name = "cgst_a")
	private BigDecimal cgstA;

	@Column(name = "sgst_a")
	private BigDecimal sgstA;

	@Column(name = "igst_a")
	private BigDecimal igstA;

	@Column(name = "amt")
	private BigDecimal amt;

	public SalesOthChTaxableModel()
	{
	}

	public SalesOthChTaxableModel(EstimateOthChTaxableModel estimateOthChTaxableModel)
	{
		this.no = estimateOthChTaxableModel.getNo();
		this.othChargeId = estimateOthChTaxableModel.getOthChargeId();
		this.rate = estimateOthChTaxableModel.getRate();
		this.rateTypeId = estimateOthChTaxableModel.getRateTypeId();
		this.taxableAmt = estimateOthChTaxableModel.getTaxableAmt();
		this.taxId = estimateOthChTaxableModel.getTaxId();
		this.cgstA = estimateOthChTaxableModel.getCgstA();
		this.sgstA = estimateOthChTaxableModel.getSgstA();
		this.igstA = estimateOthChTaxableModel.getIgstA();
		this.amt = estimateOthChTaxableModel.getAmt();
	}

	public SalesOthChTaxableModel(SalesOrderOthChTaxableModel salesOrderOthChTaxableModel)
	{
		this.no = salesOrderOthChTaxableModel.getNo();
		this.othChargeId = salesOrderOthChTaxableModel.getOthChargeId();
		this.rate = salesOrderOthChTaxableModel.getRate();
		this.rateTypeId = salesOrderOthChTaxableModel.getRateTypeId();
		this.taxableAmt = salesOrderOthChTaxableModel.getTaxableAmt();
		this.taxId = salesOrderOthChTaxableModel.getTaxId();
		this.cgstA = salesOrderOthChTaxableModel.getCgstA();
		this.sgstA = salesOrderOthChTaxableModel.getSgstA();
		this.igstA = salesOrderOthChTaxableModel.getIgstA();
		this.amt = salesOrderOthChTaxableModel.getAmt();
	}

	public SalesOthChTaxableModel(PiOthChTaxableModel piOthChTaxableModel)
	{
		this.no = piOthChTaxableModel.getNo();
		this.othChargeId = piOthChTaxableModel.getOthChargeId();
		this.rate = piOthChTaxableModel.getRate();
		this.rateTypeId = piOthChTaxableModel.getRateTypeId();
		this.taxableAmt = piOthChTaxableModel.getTaxableAmt();
		this.taxId = piOthChTaxableModel.getTaxId();
		this.cgstA = piOthChTaxableModel.getCgstA();
		this.sgstA = piOthChTaxableModel.getSgstA();
		this.igstA = piOthChTaxableModel.getIgstA();
		this.amt = piOthChTaxableModel.getAmt();
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

	public BigDecimal getTaxableAmt()
	{
		return taxableAmt;
	}

	public void setTaxableAmt(BigDecimal taxableAmt)
	{
		this.taxableAmt = taxableAmt;
	}

	public Integer getTaxId()
	{
		return taxId;
	}

	public void setTaxId(Integer taxId)
	{
		this.taxId = taxId;
	}

	public BigDecimal getCgstA()
	{
		return cgstA;
	}

	public void setCgstA(BigDecimal cgstA)
	{
		this.cgstA = cgstA;
	}

	public BigDecimal getSgstA()
	{
		return sgstA;
	}

	public void setSgstA(BigDecimal sgstA)
	{
		this.sgstA = sgstA;
	}

	public BigDecimal getIgstA()
	{
		return igstA;
	}

	public void setIgstA(BigDecimal igstA)
	{
		this.igstA = igstA;
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
