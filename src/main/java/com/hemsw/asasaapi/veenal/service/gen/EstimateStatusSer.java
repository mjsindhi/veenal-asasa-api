package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dao.gen.EstimateStatusDao;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.model.gen.EstimateStatusModel;
import jakarta.transaction.Transactional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class EstimateStatusSer
{

	@Autowired
	EstimateStatusDao estimateStatusDao;

	@Transactional
	public boolean create(EstimateStatusModel estimateStatusModel, StringBuilder errorMsg)
	{
		estimateStatusDao.create(estimateStatusModel);
		return true;
	}

	public void createNonTx(EstimateStatusModel estimateStatusModel)
	{
		estimateStatusDao.create(estimateStatusModel);
	}

	public boolean createNonTx(List<EstimateStatusModel> estimateStatusModels, StringBuilder errorMsg)
	{
		errorMsg = errorMsg == null ? new StringBuilder() : errorMsg;

		estimateStatusDao.deleteAll();
		for (EstimateStatusModel estimateStatusModel : estimateStatusModels)
		{
			if (!checkIsValidCreate(estimateStatusModel, errorMsg))
			{
				return false;
			}

			createNonTx(estimateStatusModel);
		}
		return true;
	}

	@Transactional
	public List<String> getNames()
	{
		List<String> data = null;
		data = estimateStatusDao.getNames();

		return data;
	}

	@Transactional
	public CommonGetResDto<List<EstimateStatusModel>> get(String name)
	{
		try
		{
			List<EstimateStatusModel> data = null;
			data = estimateStatusDao.get(name);
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
	public boolean delete(EstimateStatusModel estimateStatusModel, StringBuilder errorMsg)
	{
		if (!hasDelPerm(errorMsg))
		{
			return false;
		}

		estimateStatusDao.delete(estimateStatusModel);
		return true;

	}

	@Transactional
	public boolean delete(int id, StringBuilder errorMsg)
	{
		if (!hasDelPerm(errorMsg))
		{
			return false;
		}

		estimateStatusDao.delete(id);
		return true;
	}

	public boolean checkIsValidCreate(EstimateStatusModel estimateStatus, StringBuilder errorMsg)
	{
		if (!checkIsValid(estimateStatus, errorMsg))
		{
			return false;
		}

		EstimateStatusModel estimateStatusFound = estimateStatusDao.getByName(estimateStatus.getName());
		if (estimateStatusFound != null)
		{
			errorMsg.append("Name already exists");
			return false;
		}

		return true;
	}

	public boolean checkIsValidUpdate(EstimateStatusModel estimateStatus, StringBuilder errorMsg)
	{
		if (!checkIsValid(estimateStatus, errorMsg))
		{
			return false;
		}

		EstimateStatusModel estimateStatusFound = estimateStatusDao.getByName(estimateStatus.getName());
		if (estimateStatusFound != null && estimateStatus.getId() != estimateStatusFound.getId())
		{
			errorMsg.append("Name already exists");
			return false;
		}
		return true;
	}

	public boolean checkIsValid(EstimateStatusModel estimateStatus, StringBuilder errorMsg)
	{

		if (estimateStatus == null)
		{
			errorMsg.append("EstimateStatus dto is null");
			return false;
		}

		if (estimateStatus.getName() == null || estimateStatus.getName().equals(""))
		{
			errorMsg.append("Name is required");
			return false;
		}

		return true;
	}

	private boolean hasDelPerm(StringBuilder errorMsg)
	{

		return true;
	}

	public boolean hasEditPerm(StringBuilder errorMsg)
	{

		return true;
	}

}
