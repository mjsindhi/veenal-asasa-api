package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.SupplierReqDto;
import com.hemsw.asasaapi.veenal.enums.AccountType;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.model.gen.AcctModel;
import com.hemsw.asasaapi.veenal.model.gen.SupplierModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import com.hemsw.asasaapi.veenal.util.Util;
import java.util.Date;

public class SupplierMapper
{

	public static AcctModel toAcctModel(
			SupplierReqDto supplierReqDto,
			int createdByUserId
	)
	{
		AcctModel acctModel = new AcctModel();
		acctModel.setName(supplierReqDto.getName());
		acctModel.setAcctType(AccountType.SUPPLIER);
		acctModel.setCanDelete(true);
		if (supplierReqDto.getOb() != null)
		{
			acctModel.setOb(supplierReqDto.getOb());
			acctModel.setObTypeId(supplierReqDto.getObTypeId());
		}
		acctModel.setCreatedByUserId(createdByUserId);
		return acctModel;
	}

	public static VoucherModel toVoucherModel(
			SupplierReqDto supplierReqDto,
			int acctId,
			int createdByUserId
	)
	{
		VoucherModel voucherModel = new VoucherModel();
		voucherModel.setDate(new Date(Util.stringToDate("1000-01-01", Util.Formats.DB_DATE).getTime()));
		voucherModel.setVoucherType(VoucherType.OPENING_BALANCE);
		voucherModel.setAcctId(acctId);
		voucherModel.setCreatedByUserId(createdByUserId);
		return voucherModel;
	}

	public static SupplierModel toSupplierModel(SupplierReqDto supplierReqDto)
	{
		return new SupplierModel()
				.setAddress(supplierReqDto.getAddress() == null ? "" : supplierReqDto.getAddress())
				.setCity(supplierReqDto.getCity() == null ? "" : supplierReqDto.getCity())
				.setStateId(supplierReqDto.getStateId())
				.setPin(supplierReqDto.getPin())
				.setEmail(supplierReqDto.getEmail() == null ? "" : supplierReqDto.getEmail())
				.setGstNo(supplierReqDto.getGstNo() == null ? "" : supplierReqDto.getGstNo())
				.setBankName(supplierReqDto.getBankName() == null ? "" : supplierReqDto.getBankName())
				.setBankBranchName(supplierReqDto.getBankBranchName() == null ? "" : supplierReqDto.getBankBranchName())
				.setBankAcctName(supplierReqDto.getBankAcctName() == null ? "" : supplierReqDto.getBankAcctName())
				.setBankAcctNo(supplierReqDto.getBankAcctNo() == null ? "" : supplierReqDto.getBankAcctNo())
				.setBankIfsc(supplierReqDto.getBankIfsc() == null ? "" : supplierReqDto.getBankIfsc())
				.setCreditDays(supplierReqDto.getCreditDays())
				.setDeliveryDays(supplierReqDto.getDeliveryDays())
				.setNote(supplierReqDto.getNote() == null ? "" : supplierReqDto.getNote());
	}
}
