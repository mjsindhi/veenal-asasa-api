package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.InvAdjustInModel;
import com.hemsw.asasaapi.veenal.model.gen.InvAdjustModel;
import com.hemsw.asasaapi.veenal.model.gen.InvAdjustOutModel;
import com.hemsw.asasaapi.veenal.model.gen.InvAdjustOutOthChargeModel;
import com.hemsw.asasaapi.veenal.model.gen.InvAdjustOutServiceModel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

public class InvAdjustHoDto
{

	String no;
	Date date;
	private InvAdjustModel invAdjustModel;
	private List<InvAdjustInModel> invAdjustInModels;
	private List<InvAdjustOutModel> invAdjustOutModels;
	private List<InvAdjustOutServiceModel> invAdjustOutServiceModels;
	private List<InvAdjustOutOthChargeModel> invAdjustOutOthChargeModels;

	public String getNo()
	{
		return no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public InvAdjustModel getInvAdjustModel()
	{
		return invAdjustModel;
	}

	public void setInvAdjustModel(InvAdjustModel invAdjustModel)
	{
		this.invAdjustModel = invAdjustModel;
	}

	public List<InvAdjustInModel> getInvAdjustInModels()
	{
		return invAdjustInModels;
	}

	public void setInvAdjustInModels(List<InvAdjustInModel> invAdjustInModels)
	{
		this.invAdjustInModels = invAdjustInModels;
	}

	public List<InvAdjustOutModel> getInvAdjustOutModels()
	{
		return invAdjustOutModels;
	}

	public void setInvAdjustOutModels(List<InvAdjustOutModel> invAdjustOutModels)
	{
		this.invAdjustOutModels = invAdjustOutModels;
	}

	public List<InvAdjustOutServiceModel> getInvAdjustOutServiceModels()
	{
		return invAdjustOutServiceModels;
	}

	public void setInvAdjustOutServiceModels(List<InvAdjustOutServiceModel> invAdjustOutServiceModels)
	{
		this.invAdjustOutServiceModels = invAdjustOutServiceModels;
	}

	public List<InvAdjustOutOthChargeModel> getInvAdjustOutOthChargeModels()
	{
		return invAdjustOutOthChargeModels;
	}

	public void setInvAdjustOutOthChargeModels(List<InvAdjustOutOthChargeModel> invAdjustOutOthChargeModels)
	{
		this.invAdjustOutOthChargeModels = invAdjustOutOthChargeModels;
	}

	//
	public BigDecimal getSumQtyIn()
	{
		BigDecimal sumQty = BigDecimal.ZERO;
		for (InvAdjustInModel invAdjustInModel : invAdjustInModels)
		{
			sumQty = sumQty.add(invAdjustInModel.getQty());
		}
		return sumQty;
	}

	public BigDecimal getSumAmtIn()
	{
		BigDecimal sumAmt = BigDecimal.ZERO;
		for (InvAdjustInModel invAdjustInModel : invAdjustInModels)
		{
			sumAmt = sumAmt.add(invAdjustInModel.getAmt());
		}
		return sumAmt;
	}

	public BigDecimal getSumQtyOut()
	{
		BigDecimal sumQty = BigDecimal.ZERO;
		for (InvAdjustOutModel invAdjustOutModel : invAdjustOutModels)
		{
			sumQty = sumQty.add(invAdjustOutModel.getQty());
		}
		return sumQty;
	}

	public BigDecimal getSumAmtOut()
	{
		BigDecimal sumAmt = BigDecimal.ZERO;
		for (InvAdjustOutModel invAdjustOutModel : invAdjustOutModels)
		{
			sumAmt = sumAmt.add(invAdjustOutModel.getAmt());
		}
		for (InvAdjustOutServiceModel invAdjustOutServiceModel : invAdjustOutServiceModels)
		{
			sumAmt = sumAmt.add(invAdjustOutServiceModel.getAmt());
		}
		for (InvAdjustOutOthChargeModel invAdjustOutOthChargeModel : invAdjustOutOthChargeModels)
		{
			sumAmt = sumAmt.add(invAdjustOutOthChargeModel.getAmt());
		}
		return sumAmt;
	}

	public BigDecimal getEffectiveRate()
	{
		return getSumAmtOut().divide(getSumQtyIn(), 2, RoundingMode.HALF_UP);
	}
}
