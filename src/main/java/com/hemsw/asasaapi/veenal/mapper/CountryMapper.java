package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.CountryReqDto;
import com.hemsw.asasaapi.veenal.model.gen.CountryModel;

public class CountryMapper
{

	public static CountryModel toCountryModel(CountryReqDto countryReqDto)
	{
		CountryModel countryModel = new CountryModel();
		countryModel.setName(countryReqDto.getName());
		countryModel.setCode(countryReqDto.getCode());
		countryModel.setCurrencyName(countryReqDto.getCurrencyName());
		countryModel.setCurrencyCode(countryReqDto.getCurrencyCode());
		return countryModel;
	}
}
