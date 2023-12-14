package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dao.gen.AcctDao;
import com.hemsw.asasaapi.veenal.dao.gen.AcctJournalDao;
import com.hemsw.asasaapi.veenal.dao.gen.AgentDao;
import com.hemsw.asasaapi.veenal.dao.gen.BankDao;
import com.hemsw.asasaapi.veenal.dao.gen.ColSettingDao;
import com.hemsw.asasaapi.veenal.dao.gen.CustomerDao;
import com.hemsw.asasaapi.veenal.dao.gen.SupplierDao;
import com.hemsw.asasaapi.veenal.dto.hdto.AcctJournalSumHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.AcctListForCustomerHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.AcctListForSupplierHdto;
import com.hemsw.asasaapi.veenal.dto.ldto.AcctLdto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.enums.AccountType;
import com.hemsw.asasaapi.veenal.enums.BalanceType;
import com.hemsw.asasaapi.veenal.helper.UserHelper;
import com.hemsw.asasaapi.veenal.model.gen.AcctModel;
import jakarta.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class AcctSer //extends BaseSer<AcctModel>
{

	@Autowired
	ColSettingDao colSettingDao;

	@Autowired
	AcctDao acctDao;

	@Autowired
	BankDao bankDao;

	@Autowired
	SupplierDao supplierDao;

	@Autowired
	CustomerDao customerDao;

	@Autowired
	AgentDao agentDao;

	@Autowired
	AcctJournalDao acctJournalDao;

	public void createAcctNonTx(AcctModel acctModel, StringBuilder errorMsg) throws SQLException, Exception
	{

		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isAcctAdd())
		{
			errorMsg.append("You don't have permission");
			return;
		}
		acctModel.setCreatedByUserId(UserHelper.getUserDetailsImpl().getUserModel().getId());
		acctDao.create(acctModel);
	}

	//
	@Transactional
	public boolean create(AcctModel acctModel, StringBuilder errorMsg)
	{
		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isAcctAdd())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		acctModel.setCreatedByUserId(UserHelper.getUserDetailsImpl().getUserModel().getId());
		acctModel.setCanDelete(true);
		acctDao.create(acctModel, UserHelper.getUserDetailsImpl().getUserModel().getId());

		return true;
	}

	public boolean createNonTx(AcctModel acctModel, StringBuilder errorMsg)
	{
		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isAcctAdd())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		acctModel.setCreatedByUserId(UserHelper.getUserDetailsImpl().getUserModel().getId());
		acctModel.setCanDelete(true);
		acctDao.create(acctModel, UserHelper.getUserDetailsImpl().getUserModel().getId());

		return true;
	}

	public boolean createNonTx(List<AcctModel> acctModels, StringBuilder errorMsg)
	{
		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isAcctAdd())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		for (AcctModel acctModel : acctModels)
		{
			acctModel.setCreatedByUserId(UserHelper.getUserDetailsImpl().getUserModel().getId());
			acctDao.create(acctModel, UserHelper.getUserDetailsImpl().getUserModel().getId());
		}

		return true;
	}

	@Transactional
	public boolean update(AcctModel acctModel, StringBuilder errorMsg)
	{
		AcctModel oldAcctModel = acctDao.getById(acctModel.getId());

		acctModel.setCanDelete(oldAcctModel.isCanDelete());
		acctModel.setClearUpto(oldAcctModel.getClearUpto());
		acctModel.setCreatedAt(oldAcctModel.getCreatedAt());
		acctModel.setCreatedByUserId(oldAcctModel.getCreatedByUserId());

		bankDao.delete(acctModel.getId());
		supplierDao.delete(acctModel.getId());
		customerDao.delete(acctModel.getId());
		agentDao.delete(acctModel.getId());
		return true;
	}

	public boolean isUnder(int acctId, AccountType accountType)
	{
		boolean res = false;
		res = acctDao.isUnder(acctId, accountType);
		return res;
	}

	@Transactional
	public List<AcctModel> getUnder(int acctTypeId)
	{
		List<AcctModel> acctModels = null;
		acctModels = acctDao.getUnder(acctTypeId);

		return acctModels;
	}

	//
	@Transactional
	public List<AcctModel> get()
	{
		List<AcctModel> acctModels = null;
		acctModels = acctDao.get();

		return acctModels;
	}

	@Transactional
	public List<AcctModel> getExcept(AcctModel acctTypeModel)
	{
		List<AcctModel> acctModels = null;
		acctModels = acctDao.getExcept(acctTypeModel);

		return acctModels;
	}

	@Transactional
	public List<AcctModel> getAllExceptUnder(List<AccountType> accountTypes)
	{
		List<AcctModel> acctModels = null;
		acctModels = acctDao.getAllExceptUnder(accountTypes);

		return acctModels;
	}

	public List<AcctModel> get(boolean copyClosingBalance, List<AccountType> accountTypesToExc)
	{
		List<AcctModel> acctModels = null;
		acctModels = acctDao.getAllExceptUnder(accountTypesToExc);

		if (copyClosingBalance)
		{
			for (AcctModel acctModel : acctModels)
			{
				acctModel.setOb(null);
				acctModel.setObType(null);

				AcctJournalSumHdto acctJournalSumHdto = acctJournalDao.getAcctJournalSumHdto(acctModel.getId(), null);
				if (acctJournalSumHdto != null)
				{
					if (acctJournalSumHdto.isCrBig())
					{
						acctModel.setOb(acctJournalSumHdto.getCrBal());
						acctModel.setObType(BalanceType.PAYABLE_CR_RCVD);
					}
					else if (acctJournalSumHdto.isDrBig())
					{
						acctModel.setOb(acctJournalSumHdto.getDrBal());
						acctModel.setObType(BalanceType.RECIEVABLE_DR_PAID);
					}
				}
			}
		}
		return acctModels;
	}

	@Transactional
	public List<String> getNames(Integer acctTypeId)
	{
		List<String> data = null;
		data = acctDao.getNames(acctTypeId);

		return data;
	}

	@Transactional
	public CommonGetResDto<List<AcctLdto>> getLdtos(String name, Integer acctTypeId, String acctType)
	{
		try
		{
			List<AcctLdto> data = null;
			data = acctDao.getLdtos(name, acctTypeId, acctType);

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
	public CommonGetResDto<List<AcctListForCustomerHdto>> getAcctListForCustomerHdtos(Integer id)
	{
		try
		{
			List<AcctListForCustomerHdto> data = null;
			data = acctDao.getAcctListForCustomerHdtos(id);

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
	public List<AcctListForSupplierHdto> getAcctListForSupplierHdtos(Integer id)
	{
		List<AcctListForSupplierHdto> data = null;
		data = acctDao.getAcctListForSupplierHdtos(id);

		return data;
	}

	@Transactional
	public AcctModel getById(int id)
	{
		AcctModel data = null;
		data = acctDao.getById(id);

		return data;
	}

	@Transactional
	public AcctModel getByName(String name)
	{
		AcctModel data = null;
		data = acctDao.getByName(name);

		return data;
	}

	public boolean removeCleared(AcctModel acctModel, StringBuilder errorMsg)
	{
		acctModel.setClearUpto(null);
		acctDao.update(acctModel);
		return true;
	}

	public boolean delete(AcctModel acctModel, StringBuilder errorMsg)
	{
		if (!hasDelPerm(errorMsg))
		{
			return false;
		}

		acctDao.delete(acctModel);
		return true;
	}

	public boolean delete(int id, StringBuilder errorMsg)
	{
		if (!hasDelPerm(errorMsg))
		{
			return false;
		}

		acctDao.delete(id);
		return true;
	}

	//
	public boolean checkIsValidCreate(AcctModel acct, StringBuilder errorMsg)
	{
		if (!checkIsValid(acct, errorMsg))
		{
			return false;
		}

		AcctModel acctFound = acctDao.getByName(acct.getName());
		if (acctFound != null)
		{
			errorMsg.append("Name already exists");
			return false;
		}

		return true;
	}

	//
	public boolean checkIsValidUpdate(AcctModel acct, StringBuilder errorMsg)
	{
		if (!checkIsValid(acct, errorMsg))
		{
			return false;
		}

		AcctModel acctFound = acctDao.getByName(acct.getName());
		if (acctFound != null && acct.getId() != acctFound.getId())
		{
			errorMsg.append("Name already exists");
			return false;
		}
		return true;
	}

	//
	public boolean checkIsValid(AcctModel acct, StringBuilder errorMsg)
	{

		if (acct == null)
		{
			errorMsg.append("Acct dto is null");
			return false;
		}

		if (acct.getName() == null || acct.getName().equals(""))
		{
			errorMsg.append("Name is required");
			return false;
		}

		return true;
	}

	private boolean hasDelPerm(StringBuilder errorMsg)
	{
		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isAcctDelete())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		return true;
	}

	public boolean hasEditPerm(StringBuilder errorMsg)
	{
		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isAcctEdit())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		return true;
	}

}
