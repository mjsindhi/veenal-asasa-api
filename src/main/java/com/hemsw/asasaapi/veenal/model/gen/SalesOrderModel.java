package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "sales_order")
public class SalesOrderModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "is_intra")
	private boolean isIntra;

	@Column(name = "transporter_id")
	private Integer transporterId;

	@Column(name = "sum_qty")
	private BigDecimal sumQty;

	//variables for internal use
	@Column(name = "sum_qxr")
	private BigDecimal sumQxr;

	//Item val
	@Column(name = "sum_amt_after_item_disc")
	private BigDecimal sumAmtAfterItemDisc;

	@Column(name = "sum_item_taxable_amt")
	private BigDecimal sumItemTaxableAmt;

	// Tax
	@Column(name = "is_tax")
	private boolean isTax;

	@Column(name = "cgst_a")
	private BigDecimal cgstA;

	@Column(name = "sgst_a")
	private BigDecimal sgstA;

	@Column(name = "igst_a")
	private BigDecimal igstA;

	@Column(name = "sum_amt_after_tax")
	private BigDecimal sumAmtAfterTax;

	@Column(name = "total_amt")
	private BigDecimal totalAmt;

	@Column(name = "round_off")
	private BigDecimal roundOff;

	@Column(name = "amt_payable")
	private BigDecimal amtPayable;

	@Column(name = "note")
	private String note;

	@Column(name = "company_profile_id")
	private Integer companyProfileId;

	@Column(name = "estimate_id")
	private Integer estimateId;

	public SalesOrderModel(EstimateModel estimateModel)
	{
		this.customerId = estimateModel.getCustomerId();
		this.isIntra = estimateModel.isIsIntra();
		this.transporterId = estimateModel.getTransporterId();
		this.sumQty = estimateModel.getSumQty();
		this.sumQxr = estimateModel.getSumQxr();
		this.sumAmtAfterItemDisc = estimateModel.getSumAmtAfterItemDisc();
		this.sumItemTaxableAmt = estimateModel.getSumItemTaxableAmt();
		this.isTax = estimateModel.isIsTax();
		this.cgstA = estimateModel.getCgstA();
		this.sgstA = estimateModel.getSgstA();
		this.igstA = estimateModel.getIgstA();
		this.sumAmtAfterTax = estimateModel.getSumAmtAfterTax();
		this.totalAmt = estimateModel.getTotalAmt();
		this.roundOff = estimateModel.getRoundOff();
		this.amtPayable = estimateModel.getAmtPayable();
		this.note = estimateModel.getNote();
		this.companyProfileId = estimateModel.getCompanyProfileId();
		this.estimateId = estimateModel.getId();
	}

	public SalesOrderModel(PiModel piModel)
	{
		this.customerId = piModel.getCustomerId();
		this.isIntra = piModel.isIsIntra();
		this.sumQty = piModel.getSumQty();
		this.sumQxr = piModel.getSumQxr();
		this.sumAmtAfterItemDisc = piModel.getSumAmtAfterItemDisc();
		this.sumItemTaxableAmt = piModel.getSumItemTaxableAmt();
		this.isTax = piModel.isIsTax();
		this.cgstA = piModel.getCgstA();
		this.sgstA = piModel.getSgstA();
		this.igstA = piModel.getIgstA();
		this.sumAmtAfterTax = piModel.getSumAmtAfterTax();
		this.totalAmt = piModel.getTotalAmt();
		this.roundOff = piModel.getRoundOff();
		this.amtPayable = piModel.getAmtPayable();
		this.note = piModel.getNote();
		this.companyProfileId = piModel.getCompanyProfileId();
	}

	public SalesOrderModel(SalesOrderModel salesOrderModel, boolean copyId)
	{
		if (copyId)
		{
			this.id = salesOrderModel.id;
		}

		this.customerId = salesOrderModel.customerId;
		this.isIntra = salesOrderModel.isIntra;
		this.transporterId = salesOrderModel.getTransporterId();
		this.sumQty = salesOrderModel.sumQty;
		this.sumQxr = salesOrderModel.sumQxr;
		this.sumAmtAfterItemDisc = salesOrderModel.sumAmtAfterItemDisc;
		this.sumItemTaxableAmt = salesOrderModel.sumItemTaxableAmt;
		this.isTax = salesOrderModel.isTax;
		this.cgstA = salesOrderModel.cgstA;
		this.sgstA = salesOrderModel.sgstA;
		this.igstA = salesOrderModel.igstA;
		this.sumAmtAfterTax = salesOrderModel.sumAmtAfterTax;
		this.totalAmt = salesOrderModel.totalAmt;
		this.roundOff = salesOrderModel.roundOff;
		this.amtPayable = salesOrderModel.amtPayable;
		this.note = salesOrderModel.note;
		this.companyProfileId = salesOrderModel.companyProfileId;
	}

	public SalesOrderModel()
	{
		note = "";
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Integer getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(Integer customerId)
	{
		this.customerId = customerId;
	}

	public boolean isIsIntra()
	{
		return isIntra;
	}

	public void setIsIntra(boolean isIntra)
	{
		this.isIntra = isIntra;
	}

	public Integer getTransporterId()
	{
		return transporterId;
	}

	public void setTransporterId(Integer transporterId)
	{
		this.transporterId = transporterId;
	}

	public BigDecimal getSumQty()
	{
		return sumQty;
	}

	public void setSumQty(BigDecimal sumQty)
	{
		this.sumQty = sumQty;
	}

	public BigDecimal getSumQxr()
	{
		return sumQxr;
	}

	public void setSumQxr(BigDecimal sumQxr)
	{
		this.sumQxr = sumQxr;
	}

	public BigDecimal getSumAmtAfterItemDisc()
	{
		return sumAmtAfterItemDisc;
	}

	public void setSumAmtAfterItemDisc(BigDecimal sumAmtAfterItemDisc)
	{
		this.sumAmtAfterItemDisc = sumAmtAfterItemDisc;
	}

	public BigDecimal getSumItemTaxableAmt()
	{
		return sumItemTaxableAmt;
	}

	public void setSumItemTaxableAmt(BigDecimal sumItemTaxableAmt)
	{
		this.sumItemTaxableAmt = sumItemTaxableAmt;
	}

	public boolean isIsTax()
	{
		return isTax;
	}

	public void setIsTax(boolean isTax)
	{
		this.isTax = isTax;
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

	public BigDecimal getSumAmtAfterTax()
	{
		return sumAmtAfterTax;
	}

	public void setSumAmtAfterTax(BigDecimal sumAmtAfterTax)
	{
		this.sumAmtAfterTax = sumAmtAfterTax;
	}

	public BigDecimal getTotalAmt()
	{
		return totalAmt;
	}

	public void setTotalAmt(BigDecimal totalAmt)
	{
		this.totalAmt = totalAmt;
	}

	public BigDecimal getRoundOff()
	{
		return roundOff;
	}

	public void setRoundOff(BigDecimal roundOff)
	{
		this.roundOff = roundOff;
	}

	public BigDecimal getAmtPayable()
	{
		return amtPayable;
	}

	public void setAmtPayable(BigDecimal amtPayable)
	{
		this.amtPayable = amtPayable;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public Integer getCompanyProfileId()
	{
		return companyProfileId;
	}

	public void setCompanyProfileId(Integer companyProfileId)
	{
		this.companyProfileId = companyProfileId;
	}

	public Integer getEstimateId()
	{
		return estimateId;
	}

	public void setEstimateId(Integer estimateId)
	{
		this.estimateId = estimateId;
	}

	//
	public int getSucuId()
	{
		return customerId;
	}

	public void setSucuId(int sucuId)
	{
		this.customerId = sucuId;
	}

	//
	public int hashCode()
	{
		int hash = 7;
		hash = 97 * hash + this.id;
		hash = 97 * hash + Objects.hashCode(this.customerId);
		hash = 97 * hash + (this.isIntra ? 1 : 0);
		hash = 97 * hash + Objects.hashCode(this.transporterId);
		hash = 97 * hash + Objects.hashCode(this.sumQty);
		hash = 97 * hash + Objects.hashCode(this.sumQxr);
		hash = 97 * hash + Objects.hashCode(this.sumAmtAfterItemDisc);
		hash = 97 * hash + Objects.hashCode(this.sumItemTaxableAmt);
		hash = 97 * hash + (this.isTax ? 1 : 0);
		hash = 97 * hash + Objects.hashCode(this.cgstA);
		hash = 97 * hash + Objects.hashCode(this.sgstA);
		hash = 97 * hash + Objects.hashCode(this.igstA);
		hash = 97 * hash + Objects.hashCode(this.sumAmtAfterTax);
		hash = 97 * hash + Objects.hashCode(this.totalAmt);
		hash = 97 * hash + Objects.hashCode(this.roundOff);
		hash = 97 * hash + Objects.hashCode(this.amtPayable);
		hash = 97 * hash + Objects.hashCode(this.note);
		hash = 97 * hash + Objects.hashCode(this.companyProfileId);
		hash = 97 * hash + Objects.hashCode(this.estimateId);
		return hash;
	}

	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final SalesOrderModel other = (SalesOrderModel) obj;
		if (this.id != other.id)
		{
			return false;
		}
		if (!Objects.equals(this.customerId, other.customerId))
		{
			return false;
		}
		if (!Objects.equals(this.transporterId, other.transporterId))
		{
			return false;
		}
		if (this.isIntra != other.isIntra)
		{
			return false;
		}
		if (this.isTax != other.isTax)
		{
			return false;
		}
		if (!Objects.equals(this.note, other.note))
		{
			return false;
		}
		if (!Objects.equals(this.sumQty, other.sumQty))
		{
			return false;
		}
		if (!Objects.equals(this.sumQxr, other.sumQxr))
		{
			return false;
		}
		if (!Objects.equals(this.sumAmtAfterItemDisc, other.sumAmtAfterItemDisc))
		{
			return false;
		}
		if (!Objects.equals(this.sumItemTaxableAmt, other.sumItemTaxableAmt))
		{
			return false;
		}
		if (!Objects.equals(this.cgstA, other.cgstA))
		{
			return false;
		}
		if (!Objects.equals(this.sgstA, other.sgstA))
		{
			return false;
		}
		if (!Objects.equals(this.igstA, other.igstA))
		{
			return false;
		}
		if (!Objects.equals(this.sumAmtAfterTax, other.sumAmtAfterTax))
		{
			return false;
		}
		if (!Objects.equals(this.totalAmt, other.totalAmt))
		{
			return false;
		}
		if (!Objects.equals(this.roundOff, other.roundOff))
		{
			return false;
		}
		if (!Objects.equals(this.amtPayable, other.amtPayable))
		{
			return false;
		}
		if (!Objects.equals(this.companyProfileId, other.companyProfileId))
		{
			return false;
		}
		if (!Objects.equals(this.estimateId, other.estimateId))
		{
			return false;
		}
		return true;
	}

}
