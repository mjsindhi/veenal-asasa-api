package com.hemsw.asasaapi.veenal.service;

import com.hemsw.asasaapi.veenal.dto.req.SupplierReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.enums.OpeningBalanceType;
import com.hemsw.asasaapi.veenal.mapper.SupplierMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.AcctModel;
import com.hemsw.asasaapi.veenal.model.gen.SupplierModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import com.hemsw.asasaapi.veenal.dao.gen.AcctDao;
import com.hemsw.asasaapi.veenal.dao.gen.StateDao;
import com.hemsw.asasaapi.veenal.dao.gen.SupplierDao;
import com.hemsw.asasaapi.veenal.dao.gen.TransporterDao;
import com.hemsw.asasaapi.veenal.dao.gen.VoucherDao;
import jakarta.transaction.Transactional;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierSer
{

	@Autowired
	private VoucherDao voucherDao;

	@Autowired
	private AcctDao acctDao;

	@Autowired
	private StateDao stateDao;

	@Autowired
	private TransporterDao transporterDao;

	@Autowired
	private SupplierDao supplierDao;

	@Transactional
	public CommonUpsertResDto create(SupplierReqDto supplierReqDto, UserModel userModel)
	{
		if (supplierReqDto == null
				|| supplierReqDto.getName() == null
				|| supplierReqDto.getName().isEmpty())
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_required",
					"Enter name",
					"Enter name"
			));
		}

		if (supplierReqDto.getOb() != null
				&& supplierReqDto.getObTypeId() == null)
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"opening_balance_type_required",
					"Enter opening balance type",
					"Enter opening balance type"
			));
		}

		if (supplierReqDto.getOb() != null
				&& supplierReqDto.getObTypeId() != null
				&& OpeningBalanceType.getById(supplierReqDto.getObTypeId()) == null)
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"invalid_opening_balance_type",
					"Invalid opening balance type",
					"Invalid opening balance type"
			));
		}

		if (acctDao.isNameExists(supplierReqDto.getName()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_already_exists",
					"Name already exists",
					"Name already exists"
			));
		}

		if (supplierReqDto.getStateId() != null
				&& !stateDao.isIdExists(supplierReqDto.getStateId()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"invalid_state",
					"Invalid state",
					"Invalid state"
			));
		}

		AcctModel acctModel = SupplierMapper.toAcctModel(supplierReqDto, userModel.getId());
		acctDao.create(acctModel);

		VoucherModel voucherModel = SupplierMapper.toVoucherModel(
				supplierReqDto,
				acctModel.getId(),
				userModel.getId());
		voucherModel.setNo("0");
		voucherDao.create(voucherModel);

		SupplierModel supplierModel = SupplierMapper.toSupplierModel(supplierReqDto);
		supplierModel.setId(acctModel.getId());
		supplierDao.create(supplierModel);

		return new CommonUpsertResDto(supplierModel.getId());

	}

}
