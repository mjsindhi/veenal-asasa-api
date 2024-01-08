package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dao.app.YearDao;
import com.hemsw.asasaapi.veenal.dao.gen.AcctDao;
import com.hemsw.asasaapi.veenal.dao.gen.ColSettingDao;
import com.hemsw.asasaapi.veenal.dao.gen.EstimateDao;
import com.hemsw.asasaapi.veenal.dao.gen.EstimateItemDao;
import com.hemsw.asasaapi.veenal.dao.gen.EstimateOthChDao;
import com.hemsw.asasaapi.veenal.dao.gen.EstimateOthChOnItemDao;
import com.hemsw.asasaapi.veenal.dao.gen.EstimateOthChTaxableDao;
import com.hemsw.asasaapi.veenal.dao.gen.EstimateStatusDao;
import com.hemsw.asasaapi.veenal.dao.gen.ProductDao;
import com.hemsw.asasaapi.veenal.dao.gen.TaxCatDao;
import com.hemsw.asasaapi.veenal.dao.gen.TaxDao;
import com.hemsw.asasaapi.veenal.dao.gen.TransporterDao;
import com.hemsw.asasaapi.veenal.dao.gen.VoucherDao;
import com.hemsw.asasaapi.veenal.dto.hdto.ConfigHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.EstimatePendingProductHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.OrderPendingByAcctHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.OrderPendingByProductHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.PicklistItemHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptEstimatePendingByAcctHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptEstimatePendingByProdHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptEstimatePendingDetHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.TaxAmtContainerHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.TaxSumHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.TaxSummaryHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.TotalAmtContainerHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.hodto.EstimateHoDto;
import com.hemsw.asasaapi.veenal.dto.ldto.EstimateLdto;
import com.hemsw.asasaapi.veenal.dto.res.CommonDeleteResDto;
import com.hemsw.asasaapi.veenal.dto.rr.EstimateRrHoDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetOneResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.enums.RateType;
import static com.hemsw.asasaapi.veenal.enums.RateType.FLAT;
import static com.hemsw.asasaapi.veenal.enums.RateType.PERCENT;
import com.hemsw.asasaapi.veenal.enums.SortOrderEnum;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.helper.UserHelper;
import com.hemsw.asasaapi.veenal.mapper.EstimateItemMapper;
import com.hemsw.asasaapi.veenal.mapper.EstimateMapper;
import com.hemsw.asasaapi.veenal.mapper.EstimateOthChNonTaxableMapper;
import com.hemsw.asasaapi.veenal.mapper.EstimateOthChOnItemMapper;
import com.hemsw.asasaapi.veenal.mapper.EstimateOthChTaxableMapper;
import com.hemsw.asasaapi.veenal.mapper.VoucherMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.app.YearModel;
import com.hemsw.asasaapi.veenal.model.gen.EstimateItemModel;
import com.hemsw.asasaapi.veenal.model.gen.EstimateModel;
import com.hemsw.asasaapi.veenal.model.gen.EstimateOthChModel;
import com.hemsw.asasaapi.veenal.model.gen.EstimateOthChOnItemModel;
import com.hemsw.asasaapi.veenal.model.gen.EstimateOthChTaxableModel;
import com.hemsw.asasaapi.veenal.model.gen.ProductModel;
import com.hemsw.asasaapi.veenal.model.gen.TaxCatModel;
import com.hemsw.asasaapi.veenal.model.gen.TaxModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import com.hemsw.asasaapi.veenal.service.enums.RptEstimatePendingByAcctSortByEnum;
import com.hemsw.asasaapi.veenal.service.enums.RptEstimatePendingByProdSortByEnum;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class EstimateSer //
{

	@Autowired
	ColSettingDao colSettingDao;

	@Autowired
	EstimateStatusDao estimateStatusDao;

	@Autowired
	EstimateDao estimateDao;

	@Autowired
	EstimateOthChOnItemDao estimateOthChargeOnItemDao;

	@Autowired
	EstimateOthChTaxableDao estimateOthChargeTaxableDao;

	@Autowired
	EstimateOthChDao estimateOthChargeDao;

	@Autowired
	EstimateItemDao estimateItemDao;

	@Autowired
	VoucherDao voucherDao;

	@Autowired
	EstimateItemDao EstimateItemDao;

	@Autowired
	EstimateOthChOnItemDao estimateOthChOnItemDao;

	@Autowired
	EstimateOthChTaxableDao estimateOthChTaxableDao;

	@Autowired
	EstimateOthChDao estimateOthChDao;

	@Autowired
	YearDao yearDao;

	@Autowired
	TaxCatDao taxCatDao;

	@Autowired
	ProductDao productDao;

	@Autowired
	TaxDao taxDao;

	@Autowired
	AcctDao acctDao;

	@Autowired
	TransporterDao transporterDao;

	@Autowired
	ConfigSer configSer;

	@Transactional
	public CommonUpsertResDto create(EstimateRrHoDto estimateReqHoDto, UserModel userModel)
	{
		try
		{

			if (estimateReqHoDto == null)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"data_required",
						"Enter data",
						"Enter data"
				));
			}

			if (estimateReqHoDto.getEstimateRrDto().getDate() == null)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"date_required",
						"Enter date",
						"Enter date"
				));
			}

			if (estimateReqHoDto.getEstimateRrDto().getCustomerId() == null
					|| !acctDao.isIdExists(estimateReqHoDto.getEstimateRrDto().getCustomerId()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"customer_required",
						"Select customer",
						"Select customer"
				));
			}

			if (estimateReqHoDto.getEstimateRrDto().getCustomerId() == null
					|| !acctDao.isIdExists(estimateReqHoDto.getEstimateRrDto().getCustomerId()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"items_required",
						"Enter items",
						"Enter items"
				));
			}

			if (estimateReqHoDto.getEstimateItemRrDtos() == null
					|| estimateReqHoDto.getEstimateItemRrDtos().isEmpty())
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"items_required",
						"Enter items",
						"Enter items"
				));
			}

			if (estimateReqHoDto.getEstimateRrDto().getStatusId() == null)
			{
				estimateReqHoDto.getEstimateRrDto().setStatusId(2);
			}
			if (estimateReqHoDto.getEstimateRrDto().getCurrencyId() == null)
			{
				estimateReqHoDto.getEstimateRrDto().setCurrencyId(101);
			}
			if (estimateReqHoDto.getEstimateRrDto().getCurrencyConversionRate() == null)
			{
				estimateReqHoDto.getEstimateRrDto().setCurrencyConversionRate(BigDecimal.ONE);
			}

			VoucherModel voucherModel = VoucherMapper.toVoucherModel(estimateReqHoDto.getEstimateRrDto());
			EstimateModel estimateModel = EstimateMapper.toEstimateModel(estimateReqHoDto.getEstimateRrDto());
			List<EstimateItemModel> estimateItemModels = EstimateItemMapper.toEstimateItemModels(estimateReqHoDto.getEstimateItemRrDtos());

			for (EstimateItemModel estimateItemModel : estimateItemModels)
			{
				estimateItemModel.setId(0);
			}

			List<EstimateOthChOnItemModel> estimateOthChOnItemModels = EstimateOthChOnItemMapper.toEstimateOthChOnItemModels(estimateReqHoDto.getEstimateOthChOnItemRrDtos());
			List<EstimateOthChTaxableModel> estimateOthChTaxableModels = EstimateOthChTaxableMapper.toEstimateOthChTaxableModels(estimateReqHoDto.getEstimateOthChTaxableRrDtos());
			List<EstimateOthChModel> estimateOthChModels = EstimateOthChNonTaxableMapper.toEstimateOthChNonTaxableModels(estimateReqHoDto.getEstimateOthChNonTaxableRrDtos());

			calcAll(estimateModel, estimateItemModels, estimateOthChOnItemModels, estimateOthChTaxableModels, estimateOthChModels);

			if (estimateModel.getStatusId() == null)
			{
				estimateModel.setStatusId(2);
			}

			estimateDao.create(
					estimateModel,
					voucherModel.getNo(),
					voucherModel.getDate(),
					UserHelper.getUserDetailsImpl().getUserModel().getId()
			);
			createOrUpdateEstimateItem(estimateModel, estimateItemModels);
			estimateOthChargeOnItemDao.save(estimateModel, estimateOthChOnItemModels);
			estimateOthChargeTaxableDao.save(estimateModel, estimateOthChTaxableModels);
			estimateOthChargeDao.save(estimateModel, estimateOthChModels);

			return new CommonUpsertResDto(estimateModel.getVoucherModel().getId());
		}
		catch (Exception ex)
		{
			try
			{
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return new CommonUpsertResDto(ex);
			}
			catch (Exception ex2)
			{
				return new CommonUpsertResDto(ex, ex2);
			}
		}

	}

	@Transactional
	public CommonUpsertResDto update(int id, EstimateRrHoDto estimateReqHoDto)
	{
		try
		{

			if (id <= 0)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"invalid_id",
						"Enter valid id",
						"Enter valid id"
				));
			}

			EstimateModel estimateModel = estimateDao.getById(id);
			if (estimateModel == null)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"invalid_id",
						"Enter valid id",
						"Enter valid id"
				));
			}

			if (estimateReqHoDto == null)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"data_required",
						"Enter data",
						"Enter data"
				));
			}

			if (estimateReqHoDto.getEstimateRrDto().getDate() == null)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"date_required",
						"Enter date",
						"Enter date"
				));
			}

			if (estimateReqHoDto.getEstimateRrDto().getCustomerId() == null
					|| !acctDao.isIdExists(estimateReqHoDto.getEstimateRrDto().getCustomerId()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"customer_required",
						"Select customer",
						"Select customer"
				));
			}

			if (estimateReqHoDto.getEstimateRrDto().getTransporterId() != null
					&& !transporterDao.isIdExists(estimateReqHoDto.getEstimateRrDto().getTransporterId()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"company_profile_invalid",
						"Select valid company profile",
						"Select valid company profile"
				));
			}

			if (estimateReqHoDto.getEstimateRrDto().getStatusId() != null
					&& !estimateStatusDao.isIdExists(estimateReqHoDto.getEstimateRrDto().getStatusId()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"company_profile_invalid",
						"Select valid company profile",
						"Select valid company profile"
				));
			}

			if (estimateReqHoDto.getEstimateItemRrDtos() == null
					|| estimateReqHoDto.getEstimateItemRrDtos().isEmpty())
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"items_required",
						"Enter items",
						"Enter items"
				));
			}

			if (estimateReqHoDto.getEstimateRrDto().getStatusId() == null)
			{
				estimateReqHoDto.getEstimateRrDto().setStatusId(2);
			}

			VoucherModel voucherModel = voucherDao.getById(id);
			VoucherMapper.toVoucherModel(voucherModel, estimateReqHoDto.getEstimateRrDto());

			EstimateMapper.toEstimateModel(estimateModel, estimateReqHoDto.getEstimateRrDto());

			List<EstimateItemModel> estimateItemModels = EstimateItemMapper.toEstimateItemModels(estimateReqHoDto.getEstimateItemRrDtos());

			for (int i = 0; i < estimateItemModels.size(); i++)
			{
				EstimateItemModel estimateItemModel = estimateItemModels.get(i);
				if (estimateItemModel.getId() > 0)
				{
					EstimateItemModel estimateItemModelNew = estimateItemDao.getById(estimateItemModel.getId());
					estimateItemModelNew.set(estimateItemModel);
					estimateItemModel = estimateItemModelNew;
				}
			}

			List<EstimateOthChOnItemModel> estimateOthChOnItemModels = EstimateOthChOnItemMapper.toEstimateOthChOnItemModels(estimateReqHoDto.getEstimateOthChOnItemRrDtos());
			List<EstimateOthChTaxableModel> estimateOthChTaxableModels = EstimateOthChTaxableMapper.toEstimateOthChTaxableModels(estimateReqHoDto.getEstimateOthChTaxableRrDtos());
			List<EstimateOthChModel> estimateOthChModels = EstimateOthChNonTaxableMapper.toEstimateOthChNonTaxableModels(estimateReqHoDto.getEstimateOthChNonTaxableRrDtos());

			calcAll(estimateModel, estimateItemModels, estimateOthChOnItemModels, estimateOthChTaxableModels, estimateOthChModels);

			if (estimateModel.getStatusId() == null)
			{
				estimateModel.setStatusId(2);
			}

			estimateDao.update(
					estimateModel,
					voucherModel.getNo(),
					voucherModel.getDate()
			);
			createOrUpdateEstimateItem(estimateModel, estimateItemModels);
			estimateOthChargeOnItemDao.save(estimateModel, estimateOthChOnItemModels);
			estimateOthChargeTaxableDao.save(estimateModel, estimateOthChTaxableModels);
			estimateOthChargeDao.save(estimateModel, estimateOthChModels);

			return new CommonUpsertResDto(estimateModel.getVoucherModel().getId());
		}
		catch (Exception ex)
		{
			try
			{
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return new CommonUpsertResDto(ex);
			}
			catch (Exception ex2)
			{
				return new CommonUpsertResDto(ex, ex2);
			}
		}

	}

	@Transactional
	public boolean update(EstimateRrHoDto estimateReqHoDto,
			StringBuilder errorMsg)
	{
		errorMsg = errorMsg == null ? new StringBuilder() : errorMsg;

		updateNonTx(estimateReqHoDto, errorMsg);

		return true;

	}

	public boolean updateNonTx(EstimateRrHoDto estimateReqHoDto, StringBuilder errorMsg)
	{
		VoucherModel voucherModel = VoucherMapper.toVoucherModel(estimateReqHoDto.getEstimateRrDto());
		EstimateModel estimateModel = EstimateMapper.toEstimateModel(estimateReqHoDto.getEstimateRrDto());
		List<EstimateItemModel> estimateItemModels = EstimateItemMapper.toEstimateItemModels(estimateReqHoDto.getEstimateItemRrDtos());
		List<EstimateOthChOnItemModel> estimateOthChOnItemModels = EstimateOthChOnItemMapper.toEstimateOthChOnItemModels(estimateReqHoDto.getEstimateOthChOnItemRrDtos());
		List<EstimateOthChTaxableModel> estimateOthChTaxableModels = EstimateOthChTaxableMapper.toEstimateOthChTaxableModels(estimateReqHoDto.getEstimateOthChTaxableRrDtos());
		List<EstimateOthChModel> estimateOthChModels = EstimateOthChNonTaxableMapper.toEstimateOthChNonTaxableModels(estimateReqHoDto.getEstimateOthChNonTaxableRrDtos());

		calcAll(estimateModel, estimateItemModels, estimateOthChOnItemModels, estimateOthChTaxableModels, estimateOthChModels);

		estimateDao.update(
				estimateModel,
				voucherModel.getNo(),
				voucherModel.getDate()
		);
		createOrUpdateEstimateItem(estimateModel, estimateItemModels);
		estimateOthChargeOnItemDao.save(estimateModel, estimateOthChOnItemModels);
		estimateOthChargeTaxableDao.save(estimateModel, estimateOthChTaxableModels);
		estimateOthChargeDao.save(estimateModel, estimateOthChModels);

		return true;
	}

	private void createOrUpdateEstimateItem(
			EstimateModel estimateModel,
			List<EstimateItemModel> estimateItemModels
	)
	{

		estimateItemDao.deleteAllByEstimateId(
				estimateModel.getVoucherModel().getId()
		);

		for (int i = 0; i < estimateItemModels.size(); i++)
		{
			EstimateItemModel estimateItemModel = estimateItemModels.get(i);

			estimateItemModel.setSeqNo(i + 1);

			estimateItemModel.setEstimateModel(estimateModel);
			estimateItemDao.create(estimateItemModel);
		}
	}

	@Transactional
	public CommonGetOneResDto<EstimateRrHoDto> getRrHoDtoById(int estimateId)
	{
		try
		{
			EstimateRrHoDto data = new EstimateRrHoDto();
			data.setEstimateRrDto(EstimateMapper.toEstimateRrDto(estimateDao.getById(estimateId)));
			EstimateMapper.toEstimateRrDto(data.getEstimateRrDto(), voucherDao.getById(estimateId));
			data.setEstimateItemRrDtos(EstimateItemMapper.toEstimateItemRrDtos(estimateItemDao.getByEstimateId(estimateId)));
			data.setEstimateOthChOnItemRrDtos(EstimateOthChOnItemMapper.toEstimateOthChOnItemRrDtos(estimateOthChOnItemDao.get(estimateId, null, false)));
			data.setEstimateOthChTaxableRrDtos(EstimateOthChTaxableMapper.toEstimateOthChTaxableRrDtos(estimateOthChTaxableDao.get(estimateId)));
			data.setEstimateOthChNonTaxableRrDtos(EstimateOthChNonTaxableMapper.toEstimateOthChNonTaxableRrDtos(estimateOthChargeDao.get(estimateId)));
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

	@Transactional
	public EstimateHoDto getHoDto(int EstimateId)
	{
		EstimateHoDto data = null;
		data = getHoDtoNonTx(EstimateId);

		return data;
	}

	@Transactional
	public List<PicklistItemHdto> getPicklistItemHdtos(int estimateId)
	{
		List<PicklistItemHdto> data = null;
		data = estimateDao.getPicklistItemHdtos(estimateId);

		return data;
	}

	public EstimateHoDto getHoDtoNonTx(int estimateId)
	{
		EstimateHoDto data = null;
		data = new EstimateHoDto();

		data.setVoucherModel(voucherDao.getById(estimateId));
		data.setEstimateModel(estimateDao.getById(estimateId));
		data.setEstimateItemModels(EstimateItemDao.getByEstimateId(estimateId));
		data.setEstimateOthChOnItemModels(estimateOthChOnItemDao.get(estimateId, null, false));
		data.setEstimateOthChTaxableModels(estimateOthChTaxableDao.get(estimateId));
		data.setEstimateOthChNonTaxModels(estimateOthChDao.get(estimateId));

		return data;
	}

	public boolean checkIsValidCreate(EstimateHoDto EstimateHoDto, StringBuilder errorMsg)
	{
		if (!checkIsValid(EstimateHoDto, errorMsg))
		{
			return false;
		}

		VoucherModel voucherModel = voucherDao.getByNo(EstimateHoDto.getVoucherModel().getNo(), VoucherType.ESTIMATE);

		if (voucherModel != null)
		{
			errorMsg.append("Number already exists");
			return false;
		}
		return true;
	}

	public boolean checkIsValidUpdate(EstimateHoDto EstimateHoDto, StringBuilder errorMsg)
	{
		if (!checkIsValid(EstimateHoDto, errorMsg))
		{
			return false;
		}

		VoucherModel voucherModel = voucherDao.getByNo(EstimateHoDto.getVoucherModel().getNo(), VoucherType.ESTIMATE);

		if (voucherModel != null && voucherModel.getId() != EstimateHoDto.getEstimateModel().getVoucherModel().getId())
		{
			errorMsg.append("Number already exists");
			return false;
		}

		return true;
	}

	public boolean checkIsValid(EstimateHoDto EstimateHoDto, StringBuilder errorMsg)
	{

		if (EstimateHoDto == null)
		{
			errorMsg.append("Estimate dto is null");
			return false;
		}

		YearModel yearModel = yearDao.getById(1);

		if (EstimateHoDto.getVoucherModel().getDate().getTime() < yearModel.getDateFrom().getTime()
				|| EstimateHoDto.getVoucherModel().getDate().getTime() > yearModel.getDateTo().getTime())
		{
			errorMsg.append("Date out of financial year range");
			return false;
		}

		return true;
	}

	@Transactional
	public String getNextNo()
	{
		String data = "";
		data = voucherDao.getNextNo(VoucherType.ESTIMATE, null);

		return data;
	}

	@Transactional
	public CommonGetResDto<List<EstimateLdto>> getLdtos(
			Integer no,
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			String customerName,
			String city,
			Integer stateId,
			String state,
			String note,
			Boolean convertedToSo,
			Integer statusId
	)
	{
		try
		{
			List<EstimateLdto> data = null;
			data = estimateDao.getLdtos(no, dateFrom, dateTo, customerId, customerName, city, stateId, state, note, convertedToSo, statusId);

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
	private List<OrderPendingByAcctHdto> getEstimatePendingByCustomerHdto(
			Integer customerId,
			String customerName,
			Integer productId,
			String productName,
			boolean pending
	)
	{
		List<OrderPendingByAcctHdto> data = null;
		data = estimateDao.getEstimatePendingByCustomerHdto(customerId, customerName, productId, productName, pending);
		return data;
	}

	@Transactional
	private List<OrderPendingByProductHdto> getEstimatePendingByProductHdto(
			Integer customerId,
			String customerName,
			Integer productId,
			String productName,
			boolean pending
	)
	{
		List<OrderPendingByProductHdto> data = null;
		data = estimateDao.getEstimatePendingByProductHdto(customerId, customerName, productId, productName, pending);
		return data;
	}

	@Transactional
	public EstimateModel getById(int id)
	{
		EstimateModel EstimateModel = null;
		EstimateModel = estimateDao.getById(id);

		return EstimateModel;
	}

	@Transactional
	public CommonDeleteResDto delete(int id)
	{
		try
		{
			voucherDao.delete(id);

			return new CommonDeleteResDto();
		}
		catch (Exception ex)
		{
			try
			{
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return new CommonDeleteResDto(ex);
			}
			catch (Exception ex2)
			{
				return new CommonDeleteResDto(ex, ex2);
			}
		}
	}

	@Transactional
	public boolean delete(int EstimateId, StringBuilder errorMsg)
	{
		if (!hasDelPerm(errorMsg))
		{
			return false;
		}

		voucherDao.delete(EstimateId);

		return true;

	}

	@Transactional
	public List<EstimatePendingProductHdto> getPendingProductHdtos(int estimateId)
	{
		List<EstimatePendingProductHdto> data = null;
		data = estimateDao.getPendingProduct(estimateId);

		return data;
	}

	@Transactional
	public List<TaxSummaryHdto> getTaxSummaryHelperModels(int estimateId)
	{
		List<TaxSummaryHdto> taxsummaryhelperModels = null;
		taxsummaryhelperModels = estimateDao.getTaxSummaryHelperModels(estimateId);

		return taxsummaryhelperModels;
	}

	@Transactional
	public List<TaxSummaryHdto> getTaxSummaryHelperModels(EstimateHoDto estimateHoDto)
	{
		List<TaxSummaryHdto> taxsummaryhelperModels = null;
		Map<Integer, Map<Integer, TaxSummaryHdto>> abc = new HashMap<>();

		for (EstimateItemModel estimateItemModel : estimateHoDto.getEstimateItemModels())
		{
			ProductModel productModel = productDao.getById(estimateItemModel.getProductId());
			Integer hsn;
			if (productModel.getTaxCatId() == null)
			{
				hsn = productModel.getHsn() == null ? 0 : productModel.getHsn();
			}
			else
			{
				TaxCatModel taxCatModel = taxCatDao.getById(productModel.getTaxCatId());
				hsn = taxCatModel.getHsn() == null ? 0 : taxCatModel.getHsn();
			}

			Map<Integer, TaxSummaryHdto> taxMap = abc.get(hsn);

			if (taxMap == null)
			{
				taxMap = new HashMap();
				TaxSummaryHdto taxSummaryHdto = new TaxSummaryHdto();
				taxSummaryHdto.setHsn(hsn);
				taxSummaryHdto.setTaxId(estimateItemModel.getTaxId());
				taxSummaryHdto.setSumQty(estimateItemModel.getQty());
				taxSummaryHdto.setTaxableAmt(estimateItemModel.getTaxableAmt());
				taxSummaryHdto.setCgstA(estimateItemModel.getCgstA());
				taxSummaryHdto.setSgstA(estimateItemModel.getSgstA());
				taxSummaryHdto.setIgstA(estimateItemModel.getIgstA());

				taxMap.put(estimateItemModel.getTaxId(), taxSummaryHdto);
				abc.put(hsn, taxMap);
			}
			else
			{
				TaxSummaryHdto taxSummaryHdto = taxMap.get(estimateItemModel.getTaxId());
				if (taxSummaryHdto == null)
				{
					taxSummaryHdto = new TaxSummaryHdto();
					taxSummaryHdto.setHsn(hsn);
					taxSummaryHdto.setTaxId(estimateItemModel.getTaxId());
					taxSummaryHdto.setSumQty(estimateItemModel.getQty());
					taxSummaryHdto.setTaxableAmt(estimateItemModel.getTaxableAmt());
					taxSummaryHdto.setCgstA(estimateItemModel.getCgstA());
					taxSummaryHdto.setSgstA(estimateItemModel.getSgstA());
					taxSummaryHdto.setIgstA(estimateItemModel.getIgstA());

					taxMap.put(estimateItemModel.getTaxId(), taxSummaryHdto);
				}
				else
				{
					taxSummaryHdto.setSumQty(taxSummaryHdto.getSumQty().add(estimateItemModel.getQty()));
					taxSummaryHdto.setTaxableAmt(taxSummaryHdto.getTaxableAmt().add(estimateItemModel.getTaxableAmt()));
					taxSummaryHdto.setCgstA(taxSummaryHdto.getCgstA().add(estimateItemModel.getCgstA()));
					taxSummaryHdto.setSgstA(taxSummaryHdto.getSgstA().add(estimateItemModel.getSgstA()));
					taxSummaryHdto.setIgstA(taxSummaryHdto.getIgstA().add(estimateItemModel.getIgstA()));
				}
			}
		}

		taxsummaryhelperModels = new ArrayList<>();
		for (Map.Entry<Integer, Map<Integer, TaxSummaryHdto>> entry : abc.entrySet())
		{
			Integer key = entry.getKey();
			Map<Integer, TaxSummaryHdto> value = entry.getValue();

			for (Map.Entry<Integer, TaxSummaryHdto> entry1 : value.entrySet())
			{
				Integer key1 = entry1.getKey();
				TaxSummaryHdto value1 = entry1.getValue();

				taxsummaryhelperModels.add(value1);
			}
		}

		return taxsummaryhelperModels;
	}

	@Transactional
	public TaxSumHdto getTaxSumHdto(int estimateId)
	{
		TaxSumHdto taxsumHdto = null;
		taxsumHdto = estimateDao.getTaxSumHdto(estimateId);

		return taxsumHdto;
	}

	@Transactional
	public BigDecimal getPendingQty(int productId)
	{
		BigDecimal data = null;
		data = estimateDao.getPendingQty(productId);

		return data;
	}

	public TaxSumHdto getTaxSumHdto(List<TaxSummaryHdto> taxSummaryHdtos)
	{
		TaxSumHdto data = null;
		data = new TaxSumHdto();

		for (TaxSummaryHdto taxSummaryHdto : taxSummaryHdtos)
		{
			data.setQty(data.getQty().add(taxSummaryHdto.getSumQty()));
			data.setTaxableAmt(data.getTaxableAmt().add(taxSummaryHdto.getTaxableAmt()));
			data.setCgstA(data.getCgstA().add(taxSummaryHdto.getCgstA()));
			data.setSgstA(data.getSgstA().add(taxSummaryHdto.getSgstA()));
			data.setIgstA(data.getIgstA().add(taxSummaryHdto.getIgstA()));
		}

		data.setTotal(data.getCgstA()
				.add(data.getSgstA())
				.add(data.getIgstA())
		);

		return data;
	}

	@Transactional
	public List<RptEstimatePendingDetHdto> getRptEstimatePendingProductHdtos(
			Date dateFrom,
			Date dateTo,
			Integer acctId,
			Integer productId
	)
	{
		List<RptEstimatePendingDetHdto> data = null;
		data = estimateDao.getRptEstimatePendingDetHdtos(dateFrom, dateTo, acctId, productId);

		return data;
	}

	@Transactional
	public List<RptEstimatePendingByProdHdto> getRptEstimatePendingSummByProdHdtos(
			Date dateFrom,
			Date dateTo,
			Integer acctId,
			Integer productId,
			RptEstimatePendingByProdSortByEnum rptEstimatePendingSummByProdSortByEnum,
			SortOrderEnum sortOrderEnum
	)
	{
		List<RptEstimatePendingByProdHdto> data = null;
		data = estimateDao.getRptEstimatePendingByProdHdtos(
				dateFrom,
				dateTo,
				acctId,
				productId,
				rptEstimatePendingSummByProdSortByEnum,
				sortOrderEnum
		);

		return data;
	}

	@Transactional
	public List<RptEstimatePendingByAcctHdto> getRptEstimatePendingSummByAcctHdtos(
			Date dateFrom,
			Date dateTo,
			Integer acctId,
			Integer productId,
			RptEstimatePendingByAcctSortByEnum rptEstimatePendingSummByAcctSortByEnum,
			SortOrderEnum sortOrderEnum
	)
	{
		List<RptEstimatePendingByAcctHdto> data = null;
		data = estimateDao.getRptEstimatePendingByAcctHdtos(
				dateFrom,
				dateTo,
				acctId,
				productId,
				rptEstimatePendingSummByAcctSortByEnum,
				sortOrderEnum
		);

		return data;
	}

	private boolean hasDelPerm(StringBuilder errorMsg)
	{
		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isEstimateDelete())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		return true;
	}

	public boolean hasEditPerm(StringBuilder errorMsg)
	{
		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isEstimateEdit())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		return true;
	}

	/*
	**************************************************
	ITEM CALCULATIONS
	**************************************************
	 */
	public void calcAll(
			EstimateModel estimateModel,
			List<EstimateItemModel> estimateItemModels,
			List<EstimateOthChOnItemModel> estimateOthChOnItemModels,
			List<EstimateOthChTaxableModel> estimateOthChTaxableModels,
			List<EstimateOthChModel> estimateOthChModels
	)
	{
		calItems(estimateModel, estimateItemModels, estimateOthChOnItemModels);
		calOthChTaxable(estimateModel, estimateItemModels, estimateOthChTaxableModels);
		calOthChNonTax(estimateItemModels, estimateOthChTaxableModels, estimateOthChModels);
		setScalarData(estimateModel, estimateItemModels, estimateOthChOnItemModels, estimateOthChTaxableModels, estimateOthChModels);
	}

	public void calItems(
			EstimateModel estimateModel,
			List<EstimateItemModel> estimateItemModels,
			List<EstimateOthChOnItemModel> estimateOthChOnItemModels
	)
	{
		ConfigHdto configHdto = configSer.get();

		if (estimateItemModels != null && !estimateItemModels.isEmpty())
		{

			BigDecimal sumAmtAftDisc = BigDecimal.ZERO;

			for (EstimateItemModel estimateItemModel : estimateItemModels)
			{

				ProductModel productModel = productDao.getById(estimateItemModel.getProductId());

				Integer taxId;
				if (productModel.getTaxCatId() == null)
				{
					taxId = productModel.getTaxId();
				}
				else
				{
					TaxCatModel taxCatModel = taxCatDao.getById(productModel.getTaxCatId());
					taxId = taxCatModel.getTaxId();
				}

				//
				estimateItemModel.setQxr(estimateItemModel.getQty().multiply(estimateItemModel.getRate()));

				//Calculation upto amt after disc
				if (estimateItemModel.getDiscRate() == null)
				{
					estimateItemModel.setDiscA(BigDecimal.ZERO);
				}
				else
				{
					switch (estimateItemModel.getDiscRateType())
					{
						case FLAT:
							estimateItemModel.setDiscA(estimateItemModel.getDiscRate()
									.multiply(estimateItemModel.getQty()));
							break;
						case PERCENT:
							estimateItemModel.setDiscA(estimateItemModel.getDiscRate()
									.multiply(estimateItemModel.getQxr())
									.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
							break;
					}
				}
				estimateItemModel.setAmtAfterDisc(estimateItemModel.getQxr().subtract(estimateItemModel.getDiscA()));
				estimateItemModel.setTaxableAmt(estimateItemModel.getAmtAfterDisc());
				sumAmtAftDisc = sumAmtAftDisc.add(estimateItemModel.getAmtAfterDisc());

				if (configHdto.isIsAddTax())
				{
					TaxModel taxModel = taxDao.getById(taxId);

					estimateItemModel.setTaxId(taxModel.getId());
					estimateItemModel.setTaxRate(taxModel.getIgst());
				}

			}

			if (estimateOthChOnItemModels != null)
			{
				for (EstimateOthChOnItemModel estimateOthChOnItemModel : estimateOthChOnItemModels)
				{
					estimateOthChOnItemModel.setAmt(BigDecimal.ZERO);
					for (EstimateItemModel estimateItemModel : estimateItemModels)
					{
						applyOthChOnItem(sumAmtAftDisc, estimateItemModel, estimateOthChOnItemModel);
					}
					if (estimateOthChOnItemModel.getRateType() == RateType.FLAT)
					{
						estimateOthChOnItemModel.setAmt(estimateOthChOnItemModel.getRate());
					}
				}
			}

			if (estimateModel.isIsTax())
			{
				for (EstimateItemModel estimateItemModel : estimateItemModels)
				{
					TaxAmtContainerHdto taxAmtContainer = calTaxAmt(estimateItemModel.getTaxId(),
							estimateItemModel.getTaxRate(),
							estimateModel.isIsIntra(),
							estimateItemModel.getTaxableAmt());
					estimateItemModel.setCgstA(taxAmtContainer.cgstA);
					estimateItemModel.setSgstA(taxAmtContainer.sgstA);
					estimateItemModel.setIgstA(taxAmtContainer.igstA);
					estimateItemModel.setAmt(taxAmtContainer.amtWithTax);
				}
			}
			else
			{
				for (EstimateItemModel estimateItemModel : estimateItemModels)
				{
					estimateItemModel.setCgstA(BigDecimal.ZERO);
					estimateItemModel.setSgstA(BigDecimal.ZERO);
					estimateItemModel.setIgstA(BigDecimal.ZERO);
					estimateItemModel.setAmt(estimateItemModel.getTaxableAmt());
				}
			}
		}
	}

	public static void applyOthChOnItem(BigDecimal sumAmtAftDisc, EstimateItemModel estimateItemModel, EstimateOthChOnItemModel estimateOthChOnItemModel)
	{
		BigDecimal itemOthChAmt = BigDecimal.ZERO;

		switch (estimateOthChOnItemModel.getRateType())
		{
			case FLAT:
				itemOthChAmt = estimateOthChOnItemModel.getRate()
						.multiply(estimateItemModel.getAmtAfterDisc())
						.divide(sumAmtAftDisc, 2, RoundingMode.HALF_UP);
				break;
			case PERCENT:
				itemOthChAmt = estimateItemModel.getTaxableAmt()
						.multiply(estimateOthChOnItemModel.getRate())
						.divide(BigDecimal.valueOf(100d), 2, RoundingMode.HALF_UP);

				estimateOthChOnItemModel.setAmt(estimateOthChOnItemModel.getAmt().add(itemOthChAmt));
				break;
		}

		estimateItemModel.setTaxableAmt(estimateItemModel.getTaxableAmt().add(itemOthChAmt));
	}

	public void calOthChTaxable(
			EstimateModel estimateModel,
			List<EstimateItemModel> estimateItemModels,
			List<EstimateOthChTaxableModel> estimateOthChTaxableModels
	)
	{
		BigDecimal sumItemTaxableAmt = getSumItemTaxableAmt(estimateItemModels);

		for (EstimateOthChTaxableModel pusaOthChTax : estimateOthChTaxableModels)
		{
			if (pusaOthChTax.getRate() == null)
			{
				pusaOthChTax.setTaxableAmt(BigDecimal.ZERO);
			}
			else
			{
				if (pusaOthChTax.getRateType() == RateType.FLAT)
				{
					pusaOthChTax.setTaxableAmt(pusaOthChTax.getRate());
				}
				else
				{
					if (pusaOthChTax.getRateType() == RateType.PERCENT)
					{
						pusaOthChTax.setTaxableAmt(sumItemTaxableAmt.multiply(pusaOthChTax.getRate()).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
					}
				}
			}

			if (estimateModel.isIsTax())
			{
				TaxAmtContainerHdto taxAmtContainer = calTaxAmt(
						pusaOthChTax.getTaxId(),
						null,
						estimateModel.isIsIntra(),
						pusaOthChTax.getTaxableAmt());
				pusaOthChTax.setCgstA(taxAmtContainer.cgstA);
				pusaOthChTax.setSgstA(taxAmtContainer.sgstA);
				pusaOthChTax.setIgstA(taxAmtContainer.igstA);
				pusaOthChTax.setAmt(taxAmtContainer.amtWithTax);
			}
			else
			{
				pusaOthChTax.setCgstA(BigDecimal.ZERO);
				pusaOthChTax.setSgstA(BigDecimal.ZERO);
				pusaOthChTax.setIgstA(BigDecimal.ZERO);
				pusaOthChTax.setAmt(pusaOthChTax.getTaxableAmt());
			}
		}
	}

	public static void calOthChNonTax(
			List<EstimateItemModel> estimateItemModels,
			List<EstimateOthChTaxableModel> estimateOthChTaxableModels,
			List<EstimateOthChModel> estimateOthChModels
	)
	{
		BigDecimal sumAmtAfterTax = getSumAmtAfterTax(estimateItemModels, estimateOthChTaxableModels);
		for (EstimateOthChModel pusaOthChargeHdto : estimateOthChModels)
		{
			if (pusaOthChargeHdto.getRate() == null)
			{
				pusaOthChargeHdto.setAmt(BigDecimal.ZERO);
			}
			else
			{
				if (pusaOthChargeHdto.getRateType() == RateType.FLAT)
				{
					pusaOthChargeHdto.setAmt(pusaOthChargeHdto.getRate());
				}
				else
				{
					if (pusaOthChargeHdto.getRateType() == RateType.PERCENT)
					{
						pusaOthChargeHdto.setAmt(sumAmtAfterTax.multiply(pusaOthChargeHdto.getRate()).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
					}
				}
			}
		}
	}

	public static BigDecimal getSumItemTaxableAmt(List<EstimateItemModel> estimateItemModels)
	{
		BigDecimal sumItemTaxableAmt = BigDecimal.ZERO;
		for (EstimateItemModel estimateItemModel : estimateItemModels)
		{
			sumItemTaxableAmt = sumItemTaxableAmt.add(estimateItemModel.getTaxableAmt());
		}
		return sumItemTaxableAmt;
	}

	private TaxAmtContainerHdto calTaxAmt(Integer taxId, BigDecimal taxRate, boolean isIntra, BigDecimal taxableAmt)
	{

		TaxAmtContainerHdto taxAmtContainer = new TaxAmtContainerHdto();

		taxAmtContainer.cgstA = BigDecimal.ZERO;
		taxAmtContainer.sgstA = BigDecimal.ZERO;
		taxAmtContainer.igstA = BigDecimal.ZERO;

		if (taxId == null || taxableAmt == null)
		{
			return taxAmtContainer;
		}

		if (taxRate == null)
		{
			TaxModel taxSelected = taxDao.getById(taxId);
			taxRate = taxSelected.getIgst();
		}

		BigDecimal taxAmt = (taxableAmt
				.multiply(taxRate)
				.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));

		if (isIntra)
		{
			taxAmtContainer.cgstA = (taxAmt
					.divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_UP));
			taxAmtContainer.sgstA = taxAmtContainer.cgstA;
		}
		else
		{
			taxAmtContainer.igstA = taxAmt;
		}

		taxAmtContainer.amtWithTax = (taxableAmt.add(taxAmtContainer.cgstA).add(taxAmtContainer.sgstA.add(taxAmtContainer.igstA)));

		return taxAmtContainer;
	}

	public static BigDecimal getSumAmtAfterItemDisc(List<EstimateItemModel> estimateItemModels)
	{
		BigDecimal sumAmtAfterItemDisc = BigDecimal.ZERO;
		for (EstimateItemModel estimateItemModel : estimateItemModels)
		{
			sumAmtAfterItemDisc = sumAmtAfterItemDisc.add(estimateItemModel.getAmtAfterDisc());
		}
		return sumAmtAfterItemDisc;
	}

	public static BigDecimal getSumAmtAfterTax(List<EstimateItemModel> estimateItemModels, List<EstimateOthChTaxableModel> estimateOthChTaxableModels)
	{
		BigDecimal sumAmtAfterTax = BigDecimal.ZERO;
		for (EstimateItemModel estimateItemModel : estimateItemModels)
		{
			sumAmtAfterTax = sumAmtAfterTax.add(estimateItemModel.getAmt());
		}

		for (EstimateOthChTaxableModel estimateOthChTaxableModel : estimateOthChTaxableModels)
		{
			sumAmtAfterTax = sumAmtAfterTax.add(estimateOthChTaxableModel.getAmt());
		}
		return sumAmtAfterTax;
	}

	public static TaxAmtContainerHdto getTaxSum(
			List<EstimateItemModel> estimateItemModels,
			List<EstimateOthChTaxableModel> estimateOthChTaxableModels)
	{

		TaxAmtContainerHdto taxAmtContainer = new TaxAmtContainerHdto();
		taxAmtContainer.cgstA = BigDecimal.ZERO;
		taxAmtContainer.sgstA = BigDecimal.ZERO;
		taxAmtContainer.igstA = BigDecimal.ZERO;

		for (EstimateItemModel estimateOrderItemModel : estimateItemModels)
		{
			taxAmtContainer.cgstA = taxAmtContainer.cgstA.add(estimateOrderItemModel.getCgstA());
			taxAmtContainer.sgstA = taxAmtContainer.sgstA.add(estimateOrderItemModel.getSgstA());
			taxAmtContainer.igstA = taxAmtContainer.igstA.add(estimateOrderItemModel.getIgstA());
		}

		for (EstimateOthChTaxableModel estimateOrderOthChTaxableModel : estimateOthChTaxableModels)
		{
			taxAmtContainer.cgstA = taxAmtContainer.cgstA.add(estimateOrderOthChTaxableModel.getCgstA());
			taxAmtContainer.sgstA = taxAmtContainer.sgstA.add(estimateOrderOthChTaxableModel.getSgstA());
			taxAmtContainer.igstA = taxAmtContainer.igstA.add(estimateOrderOthChTaxableModel.getIgstA());
		}

		return taxAmtContainer;
	}

	public static List<BigDecimal> getSumEachOthChargeOnItem(List<EstimateOthChOnItemModel> estimateOthChOnItemModels)
	{
		List<BigDecimal> sumEachOthCharge = new ArrayList<>();
		for (EstimateOthChOnItemModel pusaOthChargeOnItemHdto : estimateOthChOnItemModels)
		{
			sumEachOthCharge.add(pusaOthChargeOnItemHdto.getAmt());
		}
		return sumEachOthCharge;
	}

	public static List<BigDecimal> getSumEachOthChargeTaxable(List<EstimateOthChTaxableModel> estimateOthChTaxableModels)
	{
		List<BigDecimal> sumEachOthCharge = new ArrayList<>();
		for (EstimateOthChTaxableModel pusaOthChargeTaxableHdto : estimateOthChTaxableModels)
		{
			sumEachOthCharge.add(pusaOthChargeTaxableHdto.getAmt());
		}
		return sumEachOthCharge;
	}

	public static List<BigDecimal> getSumOthChargeNonTax(List<EstimateOthChModel> estimateOthChModels)
	{
		List<BigDecimal> sums = new ArrayList<>();
		for (EstimateOthChModel pusaOthChargeHdto : estimateOthChModels)
		{
			sums.add(pusaOthChargeHdto.getAmt());
		}
		return sums;
	}

	public static TotalAmtContainerHdto getTotalAmt(
			List<EstimateItemModel> estimateItemModels,
			List<EstimateOthChTaxableModel> estimateOthChTaxableModels,
			List<EstimateOthChModel> estimateOthChModels)
	{

		TotalAmtContainerHdto totalAmtContainerHdto = new TotalAmtContainerHdto();
		totalAmtContainerHdto.totalAmt = BigDecimal.ZERO;
		//
		for (EstimateItemModel estimateOrderItemModel : estimateItemModels)
		{
			totalAmtContainerHdto.totalAmt = totalAmtContainerHdto.totalAmt.add(estimateOrderItemModel.getAmt());
		}

		for (EstimateOthChTaxableModel estimateOrderOthChTaxableModel : estimateOthChTaxableModels)
		{
			totalAmtContainerHdto.totalAmt = totalAmtContainerHdto.totalAmt.add(estimateOrderOthChTaxableModel.getAmt());
		}

		for (EstimateOthChModel estimateOrderOthChNonTaxModel : estimateOthChModels)
		{
			totalAmtContainerHdto.totalAmt = totalAmtContainerHdto.totalAmt.add(estimateOrderOthChNonTaxModel.getAmt());
		}

		totalAmtContainerHdto.amtPayable = totalAmtContainerHdto.totalAmt.setScale(0, RoundingMode.HALF_UP);
		totalAmtContainerHdto.roundOff = totalAmtContainerHdto.amtPayable.subtract(totalAmtContainerHdto.totalAmt);

		return totalAmtContainerHdto;
	}

	private static void setScalarData(
			EstimateModel estimateModel,
			List<EstimateItemModel> estimateItemModels,
			List<EstimateOthChOnItemModel> estimateOthChOnItems,
			List<EstimateOthChTaxableModel> estimateOthChTaxableModels,
			List<EstimateOthChModel> estimateOthChModels)
	{

		estimateModel.setSumQty(BigDecimal.ZERO);
		estimateModel.setSumQxr(BigDecimal.ZERO);
		estimateModel.setSumAmtAfterItemDisc(BigDecimal.ZERO);
		estimateModel.setSumItemTaxableAmt(BigDecimal.ZERO);
		//
		estimateModel.setCgstA(BigDecimal.ZERO);
		estimateModel.setSgstA(BigDecimal.ZERO);
		estimateModel.setIgstA(BigDecimal.ZERO);
		estimateModel.setSumAmtAfterTax(BigDecimal.ZERO);
		//
		for (EstimateItemModel estimateOrderItemModel : estimateItemModels)
		{
			estimateModel.setSumQty(estimateModel.getSumQty().add(estimateOrderItemModel.getQty()));
			estimateModel.setSumQxr(estimateModel.getSumQxr().add(estimateOrderItemModel.getQxr()));
			estimateModel.setSumAmtAfterItemDisc(estimateModel.getSumAmtAfterItemDisc().add(estimateOrderItemModel.getAmtAfterDisc()));
			estimateModel.setSumItemTaxableAmt(estimateModel.getSumItemTaxableAmt().add(estimateOrderItemModel.getTaxableAmt()));
			//
			estimateModel.setCgstA(estimateModel.getCgstA().add(estimateOrderItemModel.getCgstA()));
			estimateModel.setSgstA(estimateModel.getSgstA().add(estimateOrderItemModel.getSgstA()));
			estimateModel.setIgstA(estimateModel.getIgstA().add(estimateOrderItemModel.getIgstA()));
			estimateModel.setSumAmtAfterTax(estimateModel.getSumAmtAfterTax().add(estimateOrderItemModel.getAmt()));
		}

		for (EstimateOthChTaxableModel estimateOrderOthChTaxableModel : estimateOthChTaxableModels)
		{
			estimateModel.setCgstA(estimateModel.getCgstA().add(estimateOrderOthChTaxableModel.getCgstA()));
			estimateModel.setSgstA(estimateModel.getSgstA().add(estimateOrderOthChTaxableModel.getSgstA()));
			estimateModel.setIgstA(estimateModel.getIgstA().add(estimateOrderOthChTaxableModel.getIgstA()));
			//
			estimateModel.setSumAmtAfterTax(estimateModel.getSumAmtAfterTax().add(estimateOrderOthChTaxableModel.getAmt()));
		}

		estimateModel.setTotalAmt(estimateModel.getSumAmtAfterTax());

		for (EstimateOthChModel estimateOrderOthChNonTaxModel : estimateOthChModels)
		{
			estimateModel.setTotalAmt(estimateModel.getTotalAmt().add(estimateOrderOthChNonTaxModel.getAmt()));
		}

		estimateModel.setAmtPayable(estimateModel.getTotalAmt().setScale(0, RoundingMode.HALF_UP));
		estimateModel.setRoundOff(estimateModel.getAmtPayable().subtract(estimateModel.getTotalAmt()));
	}
}
