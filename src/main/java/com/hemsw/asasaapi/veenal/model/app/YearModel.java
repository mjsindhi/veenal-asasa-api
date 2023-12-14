package com.hemsw.asasaapi.veenal.model.app;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.util.Date;

@Table(name = "year")
public class YearModel
{

	@Column(name = "id")
	private int id;

	@Column(name = "company_id")
	private int companyId;

	@Column(name = "date_from")
	private Date dateFrom;

	@Column(name = "date_to")
	private Date dateTo;

	@Column(name = "is_default")
	private boolean isDefault;

	public int getId()
	{
		return id;
	}

	public int getCompanyId()
	{
		return companyId;
	}

	public void setCompanyId(int companyId)
	{
		this.companyId = companyId;
	}

	public Date getDateFrom()
	{
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom)
	{
		this.dateFrom = dateFrom;
	}

	public Date getDateTo()
	{
		return dateTo;
	}

	public void setDateTo(Date dateTo)
	{
		this.dateTo = dateTo;
	}

	public boolean isIsDefault()
	{
		return isDefault;
	}

	public void setIsDefault(boolean isDefault)
	{
		this.isDefault = isDefault;
	}

}
