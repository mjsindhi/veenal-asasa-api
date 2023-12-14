package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import java.util.List;

public class HomeMenuHoDto
{

	private String homeMenuCustName;
	private List<String> homeMenuStrings;

	public String getHomeMenuCustName()
	{
		return homeMenuCustName;
	}

	public void setHomeMenuCustName(String homeMenuCustName)
	{
		this.homeMenuCustName = homeMenuCustName;
	}

	public List<String> getHomeMenuStrings()
	{
		return homeMenuStrings;
	}

	public void setHomeMenuStrings(List<String> homeMenuStrings)
	{
		this.homeMenuStrings = homeMenuStrings;
	}

}
