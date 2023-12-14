package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.CommncAssignToModel;
import com.hemsw.asasaapi.veenal.model.gen.CommncLogModel;
import com.hemsw.asasaapi.veenal.model.gen.LeadModel;
import com.hemsw.asasaapi.veenal.model.gen.ReminderModel;
import java.util.List;

public class LeadAddHoDto
{

	LeadModel leadModel;

	List<CommncAssignToModel> commncAssignToModels;

	boolean hasLog;
	CommncLogModel commncLogModel;

	boolean hasReminder;
	ReminderModel reminderModel;

	public LeadModel getLeadModel()
	{
		return leadModel;
	}

	public void setLeadModel(LeadModel leadModel)
	{
		this.leadModel = leadModel;
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

	public boolean isHasReminder()
	{
		return hasReminder;
	}

	public void setHasReminder(boolean hasReminder)
	{
		this.hasReminder = hasReminder;
	}

	public ReminderModel getReminderModel()
	{
		return reminderModel;
	}

	public void setReminderModel(ReminderModel reminderModel)
	{
		this.reminderModel = reminderModel;
	}

}
