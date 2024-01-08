package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dto.rrdto.CustomerRrDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.enums.OpeningBalanceType;
import com.hemsw.asasaapi.veenal.mapper.CustomerMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.AcctModel;
import com.hemsw.asasaapi.veenal.model.gen.CustomerModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import com.hemsw.asasaapi.veenal.dao.gen.AcctDao;
import com.hemsw.asasaapi.veenal.dao.gen.CustomerDao;
import com.hemsw.asasaapi.veenal.dao.gen.StateDao;
import com.hemsw.asasaapi.veenal.dao.gen.TransporterDao;
import com.hemsw.asasaapi.veenal.dao.gen.VoucherDao;
import com.hemsw.asasaapi.veenal.dto.ldto.CustomerLdto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.mapper.VoucherMapper;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class CustomerSer
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
	private CustomerDao customerDao;

	@Transactional
	public CommonUpsertResDto create(CustomerRrDto customerReqDto, UserModel userModel)
	{
		if (customerReqDto == null
				|| customerReqDto.getName() == null
				|| customerReqDto.getName().isEmpty())
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_required",
					"Enter name",
					"Enter name"
			));
		}

		if (customerReqDto.getOb() != null
				&& customerReqDto.getObTypeId() == null)
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"opening_balance_type_required",
					"Enter opening balance type",
					"Enter opening balance type"
			));
		}

		if (customerReqDto.getOb() != null
				&& customerReqDto.getObTypeId() != null
				&& OpeningBalanceType.getById(customerReqDto.getObTypeId()) == null)
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"invalid_opening_balance_type",
					"Invalid opening balance type",
					"Invalid opening balance type"
			));
		}

		if (acctDao.isNameExists(customerReqDto.getName()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_already_exists",
					"Name already exists",
					"Name already exists"
			));
		}

		if (customerReqDto.getStateId() != null
				&& !stateDao.isIdExists(customerReqDto.getStateId()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"invalid_state",
					"Invalid state",
					"Invalid state"
			));
		}

		if (customerReqDto.getPrefTransId() != null
				&& !transporterDao.isIdExists(customerReqDto.getPrefTransId()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"invalid_preffered_transporter",
					"Invalid preffered transporter",
					"Invalid preffered transporter"
			));
		}

		AcctModel acctModel = CustomerMapper.toAcctModel(customerReqDto, userModel.getId());
		acctDao.create(acctModel);

		VoucherModel voucherModel = VoucherMapper.toVoucherModel(
				customerReqDto,
				acctModel.getId(),
				userModel.getId());
		voucherModel.setNo("0");
		voucherDao.create(voucherModel);

		CustomerModel customerModel = CustomerMapper.toCustomerModel(customerReqDto);
		customerModel.setId(acctModel.getId());
		customerDao.create(customerModel);

		return new CommonUpsertResDto(customerModel.getId());

	}

	@Transactional
	public CommonGetResDto<List<CustomerLdto>> getLdtos(
			String name,
			String city,
			Integer stateId,
			String state,
			String no
	)
	{
		try
		{
			List<CustomerLdto> data = null;
			data = customerDao.getLdtos(name, city, stateId, state, no);
			return new CommonGetResDto(data);
		}
		catch (Exception ex)
		{
			try
			{
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return new CommonGetResDto(ex);
			}
			catch (Exception ex2)
			{
				return new CommonGetResDto(ex, ex2);
			}
		}
	}

}
