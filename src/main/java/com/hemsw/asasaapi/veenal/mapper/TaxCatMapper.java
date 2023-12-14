package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.TaxCatReqDto;
import com.hemsw.asasaapi.veenal.model.gen.TaxCatModel;

public class TaxCatMapper
{

	public static TaxCatModel toTaxCatModel(TaxCatReqDto taxCatReqDto)
	{
		TaxCatModel taxCatModel = new TaxCatModel();
		taxCatModel.setName(taxCatReqDto.getName());
		taxCatModel.setHsn(taxCatReqDto.getHsn());
		taxCatModel.setTaxId(taxCatReqDto.getTaxId());
		return taxCatModel;
	}
}
