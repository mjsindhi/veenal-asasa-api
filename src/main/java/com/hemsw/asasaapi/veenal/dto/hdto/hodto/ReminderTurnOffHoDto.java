package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.CommncLogModel;

public class ReminderTurnOffHoDto
{

	int reminderId;

	boolean isLog;
	CommncLogModel commncLogModel;

	boolean isEndCommnc;

	private int parentTypeId;
	private Integer leadId;
	private Integer acctId;

	public int getReminderId()
	{
		return reminderId;
	}

	public void setReminderId(int reminderId)
	{
		this.reminderId = reminderId;
	}

	public boolean isIsLog()
	{
		return isLog;
	}

	public void setIsLog(boolean isLog)
	{
		this.isLog = isLog;
	}

	public CommncLogModel getCommncLogModel()
	{
		return commncLogModel;
	}

	public void setCommncLogModel(CommncLogModel commncLogModel)
	{
		this.commncLogModel = commncLogModel;
	}

	public boolean isIsEndCommnc()
	{
		return isEndCommnc;
	}

	public void setIsEndCommnc(boolean isEndCommnc)
	{
		this.isEndCommnc = isEndCommnc;
	}

	public int getParentTypeId()
	{
		return parentTypeId;
	}

	public void setParentTypeId(int parentTypeId)
	{
		this.parentTypeId = parentTypeId;
	}

	public Integer getLeadId()
	{
		return leadId;
	}

	public void setLeadId(Integer leadId)
	{
		this.leadId = leadId;
	}

	public Integer getAcctId()
	{
		return acctId;
	}

	public void setAcctId(Integer acctId)
	{
		this.acctId = acctId;
	}

}
