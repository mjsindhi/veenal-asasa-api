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
@Table(name = "estimate")
public class EstimateModel
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

	@Column(name = "status_id")
	private Integer statusId;

	@Column(name = "lock_stock_for_days")
	private Integer lockStatusForDays;

	public EstimateModel(PiModel piModel)
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

	public EstimateModel(EstimateModel estimateModel, boolean copyId)
	{
		if (copyId)
		{
			this.id = estimateModel.id;
		}

		this.customerId = estimateModel.customerId;
		this.isIntra = estimateModel.isIntra;
		this.transporterId = estimateModel.transporterId;
		this.sumQty = estimateModel.sumQty;
		this.sumQxr = estimateModel.sumQxr;
		this.sumAmtAfterItemDisc = estimateModel.sumAmtAfterItemDisc;
		this.sumItemTaxableAmt = estimateModel.sumItemTaxableAmt;
		this.isTax = estimateModel.isTax;
		this.cgstA = estimateModel.cgstA;
		this.sgstA = estimateModel.sgstA;
		this.igstA = estimateModel.igstA;
		this.sumAmtAfterTax = estimateModel.sumAmtAfterTax;
		this.totalAmt = estimateModel.totalAmt;
		this.roundOff = estimateModel.roundOff;
		this.amtPayable = estimateModel.amtPayable;
		this.note = estimateModel.note;
		this.companyProfileId = estimateModel.companyProfileId;
		this.statusId = estimateModel.statusId;
		this.lockStatusForDays = estimateModel.lockStatusForDays;
	}

	public EstimateModel()
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

	public Integer getStatusId()
	{
		return statusId;
	}

	public void setStatusId(Integer statusId)
	{
		this.statusId = statusId;
	}

	public Integer getLockStatusForDays()
	{
		return lockStatusForDays;
	}

	public void setLockStatusForDays(Integer lockStatusForDays)
	{
		this.lockStatusForDays = lockStatusForDays;
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
		int hash = 3;
		hash = 89 * hash + this.id;
		hash = 89 * hash + Objects.hashCode(this.customerId);
		hash = 89 * hash + (this.isIntra ? 1 : 0);
		hash = 89 * hash + Objects.hashCode(this.transporterId);
		hash = 89 * hash + Objects.hashCode(this.sumQty);
		hash = 89 * hash + Objects.hashCode(this.sumQxr);
		hash = 89 * hash + Objects.hashCode(this.sumAmtAfterItemDisc);
		hash = 89 * hash + Objects.hashCode(this.sumItemTaxableAmt);
		hash = 89 * hash + (this.isTax ? 1 : 0);
		hash = 89 * hash + Objects.hashCode(this.cgstA);
		hash = 89 * hash + Objects.hashCode(this.sgstA);
		hash = 89 * hash + Objects.hashCode(this.igstA);
		hash = 89 * hash + Objects.hashCode(this.sumAmtAfterTax);
		hash = 89 * hash + Objects.hashCode(this.totalAmt);
		hash = 89 * hash + Objects.hashCode(this.roundOff);
		hash = 89 * hash + Objects.hashCode(this.amtPayable);
		hash = 89 * hash + Objects.hashCode(this.note);
		hash = 89 * hash + Objects.hashCode(this.companyProfileId);
		hash = 89 * hash + Objects.hashCode(this.statusId);
		hash = 89 * hash + Objects.hashCode(this.lockStatusForDays);
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
		final EstimateModel other = (EstimateModel) obj;
		if (this.id != other.id)
		{
			return false;
		}
		if (this.isIntra != other.isIntra)
		{
			return false;
		}
		if (!Objects.equals(this.transporterId, other.transporterId))
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
		if (!Objects.equals(this.customerId, other.customerId))
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
		if (!Objects.equals(this.statusId, other.statusId))
		{
			return false;
		}
		if (!Objects.equals(this.lockStatusForDays, other.lockStatusForDays))
		{
			return false;
		}
		return true;
	}

}
