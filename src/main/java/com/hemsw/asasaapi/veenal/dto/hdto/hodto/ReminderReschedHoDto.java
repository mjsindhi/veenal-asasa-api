package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.CommncLogModel;
import com.hemsw.asasaapi.veenal.model.gen.ReminderModel;

public class ReminderReschedHoDto
{

	private int reminderId;

	ReminderModel reminderModel;

	boolean hasLog;
	CommncLogModel commncLogModel;

	public int getReminderId()
	{
		return reminderId;
	}

	public void setReminderId(int reminderId)
	{
		this.reminderId = reminderId;
	}

	public ReminderModel getReminderModel()
	{
		return reminderModel;
	}

	public void setReminderModel(ReminderModel reminderModel)
	{
		this.reminderModel = reminderModel;
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

}
