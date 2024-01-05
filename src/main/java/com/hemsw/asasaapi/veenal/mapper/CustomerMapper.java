package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.rrdto.CustomerRrDto;
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
			CustomerRrDto customerReqDto,
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
			CustomerRrDto customerReqDto,
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

	public static CustomerModel toCustomerModel(CustomerRrDto customerReqDto)
	{
		CustomerModel customerModel = new CustomerModel();
		customerModel.setAddress(customerReqDto.getAddress() == null ? "" : customerReqDto.getAddress());
		customerModel.setCity(customerReqDto.getCity() == null ? "" : customerReqDto.getCity());
		customerModel.setStateId(customerReqDto.getStateId());
		customerModel.setStateId(customerReqDto.getCountryId());
		customerModel.setPin(customerReqDto.getPin());
		customerModel.setEmail(customerReqDto.getEmail() == null ? "" : customerReqDto.getEmail());
		customerModel.setGstNo(customerReqDto.getGstNo() == null ? "" : customerReqDto.getGstNo());
		customerModel.setShippingSameAsBilling(customerReqDto.isShippingSameAsBilling());
		customerModel.setShippingName(customerReqDto.getShippingName() == null ? "" : customerReqDto.getShippingName());
		customerModel.setShippingAddress(customerReqDto.getShippingAddress() == null ? "" : customerReqDto.getShippingAddress());
		customerModel.setShippingCity(customerReqDto.getShippingCity() == null ? "" : customerReqDto.getShippingCity());
		customerModel.setShippingStateId(customerReqDto.getShippingStateId());
		customerModel.setShippingCountryId(customerReqDto.getShippingCountryId());
		customerModel.setShippingPin(customerReqDto.getShippingPin());
		customerModel.setShippingEmail(customerReqDto.getShippingEmail() == null ? "" : customerReqDto.getShippingEmail());
		customerModel.setShippingGstNo(customerReqDto.getShippingGstNo() == null ? "" : customerReqDto.getShippingGstNo());
		customerModel.setShippingContactNo(customerReqDto.getShippingContactNo() == null ? "" : customerReqDto.getShippingContactNo());
		customerModel.setBankName(customerReqDto.getBankName() == null ? "" : customerReqDto.getBankName());
		customerModel.setBankBranchName(customerReqDto.getBankBranchName() == null ? "" : customerReqDto.getBankBranchName());
		customerModel.setBankAcctName(customerReqDto.getBankAcctName() == null ? "" : customerReqDto.getBankAcctName());
		customerModel.setBankAcctNo(customerReqDto.getBankAcctNo() == null ? "" : customerReqDto.getBankAcctNo());
		customerModel.setBankIfsc(customerReqDto.getBankIfsc() == null ? "" : customerReqDto.getBankIfsc());
		customerModel.setCreditDays(customerReqDto.getCreditDays());
		customerModel.setCreditAmtLimit(customerReqDto.getCreditAmtLimit());
		customerModel.setDisc(customerReqDto.getDisc());
		customerModel.setPrefTransId(customerReqDto.getPrefTransId());
		customerModel.setPrefAgentId(customerReqDto.getPrefAgentId());
		customerModel.setNote(customerReqDto.getNote() == null ? "" : customerReqDto.getNote());
		return customerModel;
	}
}
