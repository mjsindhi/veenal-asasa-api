package com.hemsw.asasaapi.veenal.dto.ldto;

import com.hemsw.asasaapi.veenal.enums.RateType;
import com.hemsw.asasaapi.veenal.model.gen.VouOthChModel.CalcOnType;
import com.hemsw.asasaapi.veenal.model.gen.VouOthChModel.CalcType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class OthChargeLdto
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "seq_no")
	private int seqNo;

	@Column(name = "name")
	private String name;

	@Column(name = "sales_acct_name")
	private String salesAcctName;

	@Column(name = "sales_ret_acct_name")
	private String salesRetAcctName;

	@Column(name = "purchase_acct_name")
	private String purchaseAcctName;

	@Column(name = "purchase_ret_acct_iname")
	private String purchaseRetAcctName;

	@Column(name = "rate")
	private BigDecimal rate;

	@Column(name = "rate_type_id")
	private Integer rateTypeId;

	@Column(name = "calc_on_type_id")
	private int calcOnTypeId;

	@Column(name = "is_taxable")
	private boolean isTaxable;

	@Column(name = "tax_name")
	private String taxName;

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

	@Column(name = "created_by_user_name")
	private String createdByUserName;

	@Column(name = "created_at")
	private Date createdAt;

	public int getId()
	{
		return id;
	}

	public int getSeqNo()
	{
		return seqNo;
	}

	public String getName()
	{
		return name;
	}

	public String getSalesAcctName()
	{
		return salesAcctName;
	}

	public String getSalesRetAcctName()
	{
		return salesRetAcctName;
	}

	public String getPurchaseAcctName()
	{
		return purchaseAcctName;
	}

	public String getPurchaseRetAcctName()
	{
		return purchaseRetAcctName;
	}

	public BigDecimal getRate()
	{
		return rate;
	}

	public Integer getRateTypeId()
	{
		return rateTypeId;
	}

	public int getCalcOnTypeId()
	{
		return calcOnTypeId;
	}

	public boolean isIsTaxable()
	{
		return isTaxable;
	}

	public String getTaxName()
	{
		return taxName;
	}

	public boolean isIsAddAutoS()
	{
		return isAddAutoS;
	}

	public boolean isIsAddAutoSR()
	{
		return isAddAutoSR;
	}

	public boolean isIsAddAutoP()
	{
		return isAddAutoP;
	}

	public boolean isIsAddAutoPR()
	{
		return isAddAutoPR;
	}

	public int getCalcTypeVal()
	{
		return calcTypeVal;
	}

	public String getCreatedByUserName()
	{
		return createdByUserName;
	}

	public Date getCreatedAt()
	{
		return createdAt;
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
