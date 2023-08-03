package com.hemsw.asasaapi.veenal.model.gen;

import com.hemsw.asasaapi.veenal.enums.RateType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "oth_charge")
public class VouOthChModel
{

	public enum CalcOnType
	{
		ITEM(1, "Item"),
		VOUCHER(2, "Voucher");

		private final int id;
		private final String name;

		CalcOnType(final int id, final String nameString)
		{
			this.id = id;
			name = nameString;
		}

		public int getId()
		{
			return id;
		}

		public String getName()
		{
			return name;
		}

	}

	public enum CalcType
	{
		ADD(1, "Add", 1),
		SUBTRACT(2, "Subtract", -1);

		private final int id;
		private final String name;
		private final int value;

		private CalcType(int id, String name, int value)
		{
			this.id = id;
			this.name = name;
			this.value = value;
		}

		public int getId()
		{
			return id;
		}

		public String getName()
		{
			return name;
		}

		public int getValue()
		{
			return value;
		}

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "seq_no")
	private int seqNo;

	@Column(name = "name")
	private String name;

	@Column(name = "sales_acct_id")
	private int salesAcctId;

	@Column(name = "sales_ret_acct_id")
	private int salesRetAcctId;

	@Column(name = "purchase_acct_id")
	private int purchaseAcctId;

	@Column(name = "purchase_ret_acct_id")
	private int purchaseRetAcctId;

	@Column(name = "rate")
	private BigDecimal rate;

	@Column(name = "rate_type_id")
	private Integer rateTypeId;

	@Column(name = "calc_on_type_id")
	private int calcOnTypeId;

	@Column(name = "is_taxable")
	private boolean isTaxable;

	@Column(name = "tax_id")
	private Integer taxId;

	@Column(name = "is_add_auto_s")
	private boolean isAddAutoS;

	@Column(name = "is_add_auto_sr")
	private boolean isAddAutoSR;

	@Column(name = "is_add_auto_p")
	private boolean isAddAutoP;

	@Column(name = "is_add_auto_pr")
	private boolean isAddAutoPR;

	@Column(name = "calc_type_val")
	private int calcTypeVal;

	@Column(name = "created_by_user_id")
	private int createdByUserId;

	@Column(name = "created_at")
	private Date createdAt;

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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getSalesAcctId()
	{
		return salesAcctId;
	}

	public void setSalesAcctId(int salesAcctId)
	{
		this.salesAcctId = salesAcctId;
	}

	public int getSalesRetAcctId()
	{
		return salesRetAcctId;
	}

	public void setSalesRetAcctId(int salesRetAcctId)
	{
		this.salesRetAcctId = salesRetAcctId;
	}

	public int getPurchaseAcctId()
	{
		return purchaseAcctId;
	}

	public void setPurchaseAcctId(int purchaseAcctId)
	{
		this.purchaseAcctId = purchaseAcctId;
	}

	public int getPurchaseRetAcctId()
	{
		return purchaseRetAcctId;
	}

	public void setPurchaseRetAcctId(int purchaseRetAcctId)
	{
		this.purchaseRetAcctId = purchaseRetAcctId;
	}

	public BigDecimal getRate()
	{
		return rate;
	}

	public void setRate(BigDecimal rate)
	{
		this.rate = rate;
	}

	public Integer getRateTypeId()
	{
		return rateTypeId;
	}

	public void setRateTypeId(Integer rateTypeId)
	{
		this.rateTypeId = rateTypeId;
	}

	public int getCalcOnTypeId()
	{
		return calcOnTypeId;
	}

	public void setCalcOnTypeId(int calcOnTypeId)
	{
		this.calcOnTypeId = calcOnTypeId;
	}

	public boolean isIsTaxable()
	{
		return isTaxable;
	}

	public void setIsTaxable(boolean isTaxable)
	{
		this.isTaxable = isTaxable;
	}

	public Integer getTaxId()
	{
		return taxId;
	}

	public void setTaxId(Integer taxId)
	{
		this.taxId = taxId;
	}

	public boolean isIsAddAutoS()
	{
		return isAddAutoS;
	}

	public void setIsAddAutoS(boolean isAddAutoS)
	{
		this.isAddAutoS = isAddAutoS;
	}

	public boolean isIsAddAutoSR()
	{
		return isAddAutoSR;
	}

	public void setIsAddAutoSR(boolean isAddAutoSR)
	{
		this.isAddAutoSR = isAddAutoSR;
	}

	public boolean isIsAddAutoP()
	{
		return isAddAutoP;
	}

	public void setIsAddAutoP(boolean isAddAutoP)
	{
		this.isAddAutoP = isAddAutoP;
	}

	public boolean isIsAddAutoPR()
	{
		return isAddAutoPR;
	}

	public void setIsAddAutoPR(boolean isAddAutoPR)
	{
		this.isAddAutoPR = isAddAutoPR;
	}

	public int getCalcTypeVal()
	{
		return calcTypeVal;
	}

	public void setCalcTypeVal(int calcTypeVal)
	{
		this.calcTypeVal = calcTypeVal;
	}

	public int getCreatedByUserId()
	{
		return createdByUserId;
	}

	public void setCreatedByUserId(int createdByUserId)
	{
		this.createdByUserId = createdByUserId;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}

	//
	public RateType getRateType()
	{
		if (rateTypeId == null)
		{
			return null;
		}

		for (RateType rateType : RateType.values())
		{
			if (rateType.getId() == rateTypeId)
			{
				return rateType;
			}
		}
		return null;
	}

	public void setRateType(RateType rateType)
	{
		if (rateType == null)
		{
			this.rateTypeId = null;
		}
		else
		{
			this.rateTypeId = rateType.getId();
		}
	}

	public CalcOnType getCalcOnType()
	{
		for (CalcOnType onType : CalcOnType.values())
		{
			if (onType.getId() == calcOnTypeId)
			{
				return onType;
			}
		}
		return null;
	}

	public void setCalcOnType(CalcOnType onType)
	{
		this.calcOnTypeId = onType.getId();
	}

	public CalcType getCalcType()
	{
		for (CalcType calcType : CalcType.values())
		{
			if (calcType.getValue() == calcTypeVal)
			{
				return calcType;
			}
		}
		return null;
	}

	public void setCalcTypeEnum(CalcType calcType)
	{
		this.calcTypeVal = calcType.getValue();
	}

}
