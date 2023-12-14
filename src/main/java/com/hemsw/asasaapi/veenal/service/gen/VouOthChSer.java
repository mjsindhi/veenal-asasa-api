package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dao.gen.ColSettingDao;
import com.hemsw.asasaapi.veenal.dao.gen.VouOthChDao;
import com.hemsw.asasaapi.veenal.dto.hdto.VouOthChLdto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.helper.UserHelper;
import com.hemsw.asasaapi.veenal.model.gen.VouOthChModel;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class VouOthChSer
{

	@Autowired
	ColSettingDao colSettingDao;

	@Autowired
	VouOthChDao othChargeDao;

	@Transactional
	public boolean create(VouOthChModel othChargeModel, StringBuilder errorMsg)
	{
		errorMsg = errorMsg == null ? new StringBuilder() : errorMsg;

		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isVouOthChAdd())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		if (!checkIsValidCreate(othChargeModel, errorMsg))
		{
			return false;
		}

		createNonTx(othChargeModel);

		return true;

	}

	public void createNonTx(VouOthChModel othChargeModel)
	{
		othChargeModel.setCreatedByUserId(UserHelper.getUserDetailsImpl().getUserModel().getId());
		othChargeDao.create(othChargeModel);
	}

	public boolean createNonTx(List<VouOthChModel> vouOthChModels, StringBuilder errorMsg)
	{
		errorMsg = errorMsg == null ? new StringBuilder() : errorMsg;

		othChargeDao.deleteAll();
		for (VouOthChModel vouOthChModel : vouOthChModels)
		{
			if (!checkIsValidCreate(vouOthChModel, errorMsg))
			{
				return false;
			}

			createNonTx(vouOthChModel);
		}
		return true;
	}

	@Transactional
	public List<VouOthChModel> get()
	{
		List<VouOthChModel> othchargeModels = null;
		othchargeModels = othChargeDao.get();

		return othchargeModels;
	}

	@Transactional
	public CommonGetResDto<List<VouOthChModel>> get(VouOthChModel.CalcOnType calOnType, Boolean isTaxable, VoucherType voucherType, Boolean isSystem)
	{
		try
		{
			List<VouOthChModel> othchargeModels = othChargeDao.get(calOnType, isTaxable, voucherType, isSystem);
			return new CommonGetResDto(othchargeModels);
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
	public CommonGetResDto<List<VouOthChLdto>> getLdtos(String name)
	{
		try
		{
			List<VouOthChLdto> data = othChargeDao.getLdtos(name);
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
	public boolean delete(VouOthChModel othChargeModel, StringBuilder errorMsg)
	{
		if (!hasDelPerm(errorMsg))
		{
			return false;
		}

		othChargeDao.delete(othChargeModel);

		return true;

	}

	@Transactional
	public boolean delete(int id, StringBuilder errorMsg)
	{
		if (!hasDelPerm(errorMsg))
		{
			return false;
		}

		othChargeDao.delete(id);

		return true;

	}

	public boolean checkIsValidCreate(VouOthChModel vouItem, StringBuilder errorMsg)
	{
		if (!checkIsValid(vouItem, errorMsg))
		{
			return false;
		}

		VouOthChModel vouItemFound = othChargeDao.getByName(vouItem.getName());
		if (vouItemFound != null)
		{
			errorMsg.append("Name already exists");
			return false;
		}

		return true;
	}

	public boolean checkIsValidUpdate(VouOthChModel vouItem, StringBuilder errorMsg)
	{
		if (!checkIsValid(vouItem, errorMsg))
		{
			return false;
		}

		VouOthChModel vouItemFound = othChargeDao.getByName(vouItem.getName());
		if (vouItemFound != null && vouItem.getId() != vouItemFound.getId())
		{
			errorMsg.append("Name already exists");
			return false;
		}
		return true;
	}

	public boolean checkIsValid(VouOthChModel vouItem, StringBuilder errorMsg)
	{

		if (vouItem == null)
		{
			errorMsg.append("VouItemsBeTa dto is null");
			return false;
		}

		if (vouItem.getName() == null || vouItem.getName().equals(""))
		{
			errorMsg.append("Name is required");
			return false;
		}

		return true;
	}

	private boolean hasDelPerm(StringBuilder errorMsg)
	{
		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isVouOthChDelete())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		return true;
	}

	public boolean hasEditPerm(StringBuilder errorMsg)
	{
		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isVouOthChEdit())
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
