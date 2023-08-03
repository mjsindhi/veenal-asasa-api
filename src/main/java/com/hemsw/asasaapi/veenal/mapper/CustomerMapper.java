package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.CustomerReqDto;
import com.hemsw.asasaapi.veenal.enums.AccountType;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.model.gen.AcctModel;
import com.hemsw.asasaapi.veenal.model.gen.CustomerModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import com.hemsw.asasaapi.veenal.util.Util;
import java.sql.Date;

public class CustomerMapper
{

	public static AcctModel toAcctModel(
			CustomerReqDto customerReqDto,
			int createdByUserId
	)
	{
		AcctModel acctModel = new AcctModel();
		acctModel.setName(customerReqDto.getName());
		acctModel.setAcctType(AccountType.CUSTOMER);
		acctModel.setCanDelete(true);
		if (customerReqDto.getOb() != null)
		{
			acctModel.setOb(customerReqDto.getOb());
			acctModel.setObTypeId(customerReqDto.getObTypeId());
		}
		acctModel.setCreatedByUserId(createdByUserId);
		return acctModel;
	}

	public static VoucherModel toVoucherModel(
			CustomerReqDto customerReqDto,
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

	public static CustomerModel toCustomerModel(CustomerReqDto customerReqDto)
	{
		return new CustomerModel()
				.setAddress(customerReqDto.getAddress() == null ? "" : customerReqDto.getAddress())
				.setCity(customerReqDto.getCity() == null ? "" : customerReqDto.getCity())
				.setStateId(customerReqDto.getStateId())
				.setPin(customerReqDto.getPin())
				.setEmail(customerReqDto.getEmail() == null ? "" : customerReqDto.getEmail())
				.setGstNo(customerReqDto.getGstNo() == null ? "" : customerReqDto.getGstNo())
				.setBankName(customerReqDto.getBankName() == null ? "" : customerReqDto.getBankName())
				.setBankBranchName(customerReqDto.getBankBranchName() == null ? "" : customerReqDto.getBankBranchName())
				.setBankAcctName(customerReqDto.getBankAcctName() == null ? "" : customerReqDto.getBankAcctName())
				.setBankAcctNo(customerReqDto.getBankAcctNo() == null ? "" : customerReqDto.getBankAcctNo())
				.setBankIfsc(customerReqDto.getBankIfsc() == null ? "" : customerReqDto.getBankIfsc())
				.setCreditDays(customerReqDto.getCreditDays())
				.setCreditAmtLimit(customerReqDto.getCreditAmtLimit())
				.setDisc(customerReqDto.getDisc())
				.setPrefTransId(customerReqDto.getPrefTransId())
				.setNote(customerReqDto.getNote() == null ? "" : customerReqDto.getNote());
	}
}
