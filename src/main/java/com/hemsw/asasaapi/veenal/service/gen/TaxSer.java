package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dao.gen.TaxDao;
import com.hemsw.asasaapi.veenal.dto.ldto.TaxLdto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.helper.UserHelper;
import com.hemsw.asasaapi.veenal.model.gen.TaxModel;
import jakarta.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class TaxSer
{

	@Autowired
	TaxDao taxDao;

	public boolean create(TaxModel agent, StringBuilder errorMsg)
	{
		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isTaxAdd())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		agent.setCreatedByUserId(UserHelper.getUserDetailsImpl().getUserModel().getId());
		taxDao.create(agent);
		return true;
	}

	public void createNonTx(TaxModel taxModel)
	{
		taxModel.setCreatedByUserId(UserHelper.getUserDetailsImpl().getUserModel().getId());
		taxDao.create(taxModel);
	}

	public boolean createNonTx(List<TaxModel> taxModels, StringBuilder errorMsg)
	{
		errorMsg = errorMsg == null ? new StringBuilder() : errorMsg;

		taxDao.deleteAll();
		for (TaxModel taxModel : taxModels)
		{
			if (!checkIsValidCreate(taxModel, errorMsg))
			{
				return false;
			}

			createNonTx(taxModel);
		}
		return true;
	}

	@Transactional
	public Map<Integer, TaxModel> getMap()
	{
		Map<Integer, TaxModel> data = new HashMap<>();

		List<TaxModel> taxModels = taxDao.get();
		for (TaxModel taxModel : taxModels)
		{
			data.put(taxModel.getId(), taxModel);
		}

		return data;
	}

	@Transactional
	public CommonGetResDto<List<TaxLdto>> getLdtos(String name)
	{
		try
		{
			List<TaxLdto> data = null;
			data = taxDao.getLdtos(name);
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

	@Transactional
	public List<String> getNames()
	{
		List<String> data = null;
		data = taxDao.getNames();

		return data;
	}

	public boolean delete(TaxModel taxModel, StringBuilder errorMsg)
	{
		if (!hasDelPerm(errorMsg))
		{
			return false;
		}

		taxDao.delete(taxModel);

		return true;

	}

	public boolean delete(int id, StringBuilder errorMsg)
	{
		if (!hasDelPerm(errorMsg))
		{
			return false;
		}

		taxDao.delete(id);

		return true;

	}

	public boolean checkIsValidCreate(TaxModel tax, StringBuilder errorMsg)
	{
		if (!checkIsValid(tax, errorMsg))
		{
			return false;
		}

		TaxModel taxFound = taxDao.getByName(tax.getName());
		if (taxFound != null)
		{
			errorMsg.append("Name already exists");
			return false;
		}

		return true;
	}

	public boolean checkIsValidUpdate(TaxModel tax, StringBuilder errorMsg)
	{
		if (!checkIsValid(tax, errorMsg))
		{
			return false;
		}

		TaxModel taxFound = taxDao.getByName(tax.getName());
		if (taxFound != null && tax.getId() != taxFound.getId())
		{
			errorMsg.append("Name already exists");
			return false;
		}
		return true;
	}

	public boolean checkIsValid(TaxModel tax, StringBuilder errorMsg)
	{

		if (tax == null)
		{
			errorMsg.append("Tax dto is null");
			return false;
		}

		if (tax.getName() == null || tax.getName().equals(""))
		{
			errorMsg.append("Name is required");
			return false;
		}

		return true;
	}

	private boolean hasDelPerm(StringBuilder errorMsg)
	{
		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isTaxDelete())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		return true;
	}

	public boolean hasEditPerm(StringBuilder errorMsg)
	{
		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isTaxEdit())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		return true;
	}

	public boolean _hasEditPerm(int id, StringBuilder errorMsg)
	{

		//1.1 hasEditPermNonTx(id, errorMsg);
		return true;

	}
}
