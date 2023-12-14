package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.CommncAssignToModel;
import com.hemsw.asasaapi.veenal.model.gen.CommncLogModel;
import com.hemsw.asasaapi.veenal.model.gen.ReminderModel;
import java.util.List;

public class CommncAddHoDto
{

	CommncLogModel commncLogModel;

	boolean isReminder;
	ReminderModel reminderModel;

	List<CommncAssignToModel> commncAssignToModels;

	private int parentTypeId;
	private Integer leadId;
	private Integer acctId;

	public CommncLogModel getCommncLogModel()
	{
		return commncLogModel;
	}

	public void setCommncLogModel(CommncLogModel commncLogModel)
	{
		this.commncLogModel = commncLogModel;
	}

	public boolean isIsReminder()
	{
		return isReminder;
	}

	public void setIsReminder(boolean isReminder)
	{
		this.isReminder = isReminder;
	}

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
