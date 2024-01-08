package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.rr.EstimateRrDto;
import com.hemsw.asasaapi.veenal.dto.rrdto.CustomerRrDto;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import java.util.Date;

public class VoucherMapper
{

	public static VoucherModel toVoucherModel(
			CustomerRrDto customerReqDto,
			int acctId,
			int createdByUserId
	)
	{
		VoucherModel voucherModel = new VoucherModel();
		voucherModel.setDate(new Date(0));
		voucherModel.setVoucherType(VoucherType.OPENING_BALANCE);
		voucherModel.setAcctId(acctId);
		voucherModel.setCreatedByUserId(createdByUserId);
		return voucherModel;
	}

	public static VoucherModel toVoucherModel(EstimateRrDto estimateReqDto)
	{
		VoucherModel voucherModel = new VoucherModel();
		voucherModel.setDate(estimateReqDto.getDate());
		voucherModel.setNo(estimateReqDto.getNo());
		voucherModel.setVoucherTypeId(VoucherType.ESTIMATE.getId());
		return voucherModel;
	}

	public static void toVoucherModel(VoucherModel voucherModel, EstimateRrDto estimateReqDto)
	{
		voucherModel.setDate(estimateReqDto.getDate());
		voucherModel.setNo(estimateReqDto.getNo());
		voucherModel.setVoucherTypeId(VoucherType.ESTIMATE.getId());
	}
}
