package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.JournalItemModel;
import com.hemsw.asasaapi.veenal.model.gen.JournalModel;
import java.util.Date;
import java.util.List;

public class JournalHoDto
{

	Date date;
	JournalModel journalModel;
	List<JournalItemModel> journalItemModels;

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public JournalModel getJournalModel()
	{
		return journalModel;
	}

	public void setJournalModel(JournalModel journalModel)
	{
		this.journalModel = journalModel;
	}

	public List<JournalItemModel> getJournalItemModels()
	{
		return journalItemModels;
	}

	public void setJournalItemModels(List<JournalItemModel> journalItemModels)
	{
		this.journalItemModels = journalItemModels;
	}

}
