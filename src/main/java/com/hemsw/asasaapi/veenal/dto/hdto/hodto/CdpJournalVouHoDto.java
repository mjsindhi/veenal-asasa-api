package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.CdpJournalVouModel;
import java.util.Date;

public class CdpJournalVouHoDto
{

	String no;
	Date date;
	private CdpJournalVouModel cdpJournalVouModel;

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

	public CdpJournalVouModel getCdpJournalVouModel()
	{
		return cdpJournalVouModel;
	}

	public void setCdpJournalVouModel(CdpJournalVouModel cdpJournalVouModel)
	{
		this.cdpJournalVouModel = cdpJournalVouModel;
	}

}
