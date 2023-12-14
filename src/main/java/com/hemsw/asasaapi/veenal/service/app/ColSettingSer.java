package com.hemsw.asasaapi.veenal.service.app;

import com.hemsw.asasaapi.veenal.dao.gen.ColSettingDao;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetOneResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.model.app.ColSettingModel;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class ColSettingSer //extends BaseSer<ColSettingModel>
{

	@Autowired
	ColSettingDao colSettingDao;

	@Transactional
	public CommonGetOneResDto<ColSettingModel> getById(int id)
	{
		try
		{
			ColSettingModel data = null;
			data = colSettingDao.getById(id);
			return new CommonGetOneResDto(data);
		}
		catch (Exception ex)
		{
			try
			{
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return new CommonGetOneResDto(ex);
			}
			catch (Exception ex2)
			{
				return new CommonGetOneResDto(ex, ex2);
			}
		}
	}

	private ColSettingModel getById(int id, List<ColSettingModel> colSettingModels)
	{
		for (ColSettingModel colSettingModel : colSettingModels)
		{
			if (id == colSettingModel.getId())
			{
				return colSettingModel;
			}
		}
		return null;
	}

	@Transactional
	public CommonGetResDto<List<ColSettingModel>> getByMenuIdForSelect(int menuId, Boolean isVisible)
	{
		try
		{
			List<ColSettingModel> data = null;
			data = colSettingDao.getByMenuIdForSelect(menuId, isVisible);
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

	public CommonGetResDto<List<ColSettingModel>> getByMenuIdForOrder(int menuId, Boolean isOrderBy)
	{
		try
		{
			List<ColSettingModel> data = null;
			data = colSettingDao.getByMenuIdForOrder(menuId, isOrderBy);
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
