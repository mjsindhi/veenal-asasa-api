package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.EstimateReqDto;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;

public class VoucherMapper
{

	public static VoucherModel toVoucherModel(EstimateReqDto estimateReqDto)
	{
		VoucherModel voucherModel = new VoucherModel();
		voucherModel.setDate(estimateReqDto.getDate());
		voucherModel.setNo(estimateReqDto.getNo());
		voucherModel.setVoucherTypeId(VoucherType.ESTIMATE.getId());
		return voucherModel;
	}
}
