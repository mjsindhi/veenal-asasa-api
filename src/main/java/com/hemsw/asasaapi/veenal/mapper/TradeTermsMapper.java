package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.TradeTermsReqDto;
import com.hemsw.asasaapi.veenal.model.gen.TradeTermsModel;

public class TradeTermsMapper
{

	public static TradeTermsModel toTradeTermsModel(TradeTermsReqDto leadStatusReqDto)
	{
		TradeTermsModel tradeTermsModel = new TradeTermsModel();
		tradeTermsModel.setName(leadStatusReqDto.getName());
		tradeTermsModel.setValue(leadStatusReqDto.getValue());
		return tradeTermsModel;
	}
}
