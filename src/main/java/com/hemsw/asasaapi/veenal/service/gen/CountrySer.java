package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dto.req.CountryReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.mapper.CountryMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.CountryModel;
import com.hemsw.asasaapi.veenal.dao.gen.CountryDao;
import com.hemsw.asasaapi.veenal.dto.ldto.CountryLdto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class CountrySer
{

	@Autowired
	private CountryDao countryDao;

	public CommonUpsertResDto create(CountryReqDto countryReqDto, UserModel userModel)
	{
		if (countryReqDto == null
				|| countryReqDto.getName() == null
				|| countryReqDto.getName().isEmpty())
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_required",
					"Enter name",
					"Enter name"
			));
		}

		if (countryReqDto.getCode() == null
				|| countryReqDto.getCode().isEmpty())
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"code_required",
					"Enter code",
					"Enter code"
			));
		}

		if (countryDao.isNameExists(countryReqDto.getName()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_exists",
					"Name already exists",
					"Name already exists"
			));
		}

		if (countryDao.isCodeExists(countryReqDto.getCode()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"code_exists",
					"Code already exists",
					"Code already exists"
			));
		}

		CountryModel countryModel = CountryMapper.toCountryModel(countryReqDto);
		countryModel.setCreatedByUserId(userModel.getId());
		countryDao.create(countryModel);

		return new CommonUpsertResDto(countryModel.getId());

	}

	@Transactional
	public CommonGetResDto<List<CountryLdto>> getLdtos(String name)
	{
		try
		{
			List<CountryLdto> data = null;
			data = countryDao.getLdtos(name);
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
