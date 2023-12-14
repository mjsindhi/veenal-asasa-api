package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.CommncAssignToModel;
import com.hemsw.asasaapi.veenal.model.gen.CommncLogModel;
import com.hemsw.asasaapi.veenal.model.gen.ReminderModel;
import java.util.List;

public class ReminderAddHoDto
{

	ReminderModel reminderModel;

	List<CommncAssignToModel> commncAssignToModels;

	boolean hasLog;
	CommncLogModel commncLogModel;

	private int parentTypeId;
	private Integer leadId;
	private Integer acctId;

	public ReminderModel getReminderModel()
	{
		return reminderModel;
	}

	public void setReminderModel(ReminderModel reminderModel)
	{
		this.reminderModel = reminderModel;
	}

	public List<CommncAssignToModel> getCommncAssignToModels()
	{
		return commncAssignToModels;
	}

	public void setCommncAssignToModels(List<CommncAssignToModel> commncAssignToModels)
	{
		this.commncAssignToModels = commncAssignToModels;
	}

	public boolean isHasLog()
	{
		return hasLog;
	}

	public void setHasLog(boolean hasLog)
	{
		this.hasLog = hasLog;
	}

	public CommncLogModel getCommncLogModel()
	{
		return commncLogModel;
	}

	public void setCommncLogModel(CommncLogModel commncLogModel)
	{
		this.commncLogModel = commncLogModel;
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
