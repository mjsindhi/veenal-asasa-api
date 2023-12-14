package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dao.app.YearDao;
import com.hemsw.asasaapi.veenal.dto.hdto.AcctJournalClrAmtsHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.AcctJournalSumHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.AcctMonthlySummaryHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.AcctSummaryHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.hodto.CdpJournalVouHoDto;
import com.hemsw.asasaapi.veenal.dto.hdto.hodto.JournalHoDto;
import com.hemsw.asasaapi.veenal.dto.hdto.hodto.PurchaseReturnHoDto;
import com.hemsw.asasaapi.veenal.dto.hdto.hodto.SalesHoDto;
import com.hemsw.asasaapi.veenal.dto.hdto.hodto.SalesReturnHoDto;
import com.hemsw.asasaapi.veenal.enums.Account;
import com.hemsw.asasaapi.veenal.enums.BalanceType;
import com.hemsw.asasaapi.veenal.enums.BalanceTypeByOpCl;
import com.hemsw.asasaapi.veenal.enums.TxType;
import com.hemsw.asasaapi.veenal.model.app.YearModel;
import com.hemsw.asasaapi.veenal.model.gen.AcctJournalModel;
import com.hemsw.asasaapi.veenal.model.gen.AcctModel;
import com.hemsw.asasaapi.veenal.model.gen.CommVouPayableModel;
import com.hemsw.asasaapi.veenal.model.gen.ContraModel;
import com.hemsw.asasaapi.veenal.model.gen.JournalItemModel;
import com.hemsw.asasaapi.veenal.model.gen.PaymentModel;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseModel;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseOthChModel;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseOthChTaxableModel;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseReturnOthChModel;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseReturnOthChTaxableModel;
import com.hemsw.asasaapi.veenal.model.gen.ReceiptModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesOthChModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesOthChTaxableModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesReturnOthChModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesReturnOthChTaxableModel;
import com.hemsw.asasaapi.veenal.model.gen.VouOthChModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AcctJournalDao
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	@Autowired
	private VouOthChDao othChargeDao;

	@Autowired
	private YearDao yearDao;

	public static String tableName = "acct_journal";
	String sqlGetByVoucherId = "SELECT * FROM %s WHERE voucher_id = %s;";
	String sqlDeleteByVoucherId = "DELETE FROM %s WHERE voucher_id = %s;";
	String sqlDeleteByAcctId = "DELETE FROM %s WHERE acct_id = %s;";
	String sqlDelete = "DELETE FROM %s";
	String sqlPrevTotal = "SELECT\n"
			+ "	SUM(dr) as debit,\n"
			+ "	SUM(cr) as credit\n"
			+ "FROM\n"
			+ "	%s";

	public void create(AcctModel acctModel, int voucherId)
	{
		if (acctModel.getOb() == null || acctModel.getOb().compareTo(BigDecimal.ZERO) == 0)
		{
			return;
		}
		saveJournalModels(getJournalModels(acctModel, voucherId));
	}

	public void create(SalesHoDto salesHoDto)
	{
		saveJournalModels(getJournalModels(salesHoDto));
	}

	public void create(SalesReturnHoDto salesReturnHoDto)
	{
		saveJournalModels(getJournalModels(salesReturnHoDto));
	}

	public void create(
			PurchaseModel purchaseModel,
			List<PurchaseOthChTaxableModel> purchaseOthChargeTaxableModels,
			List<PurchaseOthChModel> purchaseOthChargeModels)
	{
		saveJournalModels(getJournalModels(purchaseModel, purchaseOthChargeTaxableModels, purchaseOthChargeModels));
	}

	public void create(PurchaseReturnHoDto purchaseReturnHoDto)
	{
		saveJournalModels(getJournalModels(purchaseReturnHoDto));
	}

	public void create(PaymentModel paymentModel)
	{
		saveJournalModels(getJournalModels(paymentModel));
	}

	public void create(ContraModel contraModel)
	{
		saveJournalModels(getJournalModels(contraModel));
	}

	public void create(ReceiptModel receiptModel)
	{
		saveJournalModels(getJournalModels(receiptModel));
	}

	public void create(JournalHoDto journalHoDto)
	{
		saveJournalModels(getJournalModels(journalHoDto));
	}

	public void create(CdpJournalVouHoDto cdpJournalVouHoDto)
	{
		saveJournalModels(getJournalModels(cdpJournalVouHoDto));
	}

	public void create(CommVouPayableModel commVouPayableModel, int agentAcctId, Date date)
	{
		deleteByVoucherId(commVouPayableModel.getId());
		saveJournalModels(getJournalModels(commVouPayableModel, agentAcctId, date));
	}

	public void update(AcctModel acctModel, int voucherId)
	{
		deleteByVoucherId(voucherId);

		if (acctModel.getOb() == null || acctModel.getOb().compareTo(BigDecimal.ZERO) == 0)
		{
			return;
		}

		saveJournalModels(getJournalModels(acctModel, voucherId));
	}

	public void update(SalesHoDto salesHoDto)
	{
		deleteByVoucherId(salesHoDto.getSalesModel().getId());
		saveJournalModels(getJournalModels(salesHoDto));
	}

	public void update(SalesReturnHoDto salesReturnHoDto)
	{
		deleteByVoucherId(salesReturnHoDto.getSalesReturnModel().getId());
		saveJournalModels(getJournalModels(salesReturnHoDto));
	}

	public void update(
			PurchaseModel purchaseModel,
			List<PurchaseOthChTaxableModel> purchaseOthChargeTaxableModels,
			List<PurchaseOthChModel> purchaseOthChargeModels)
	{
		deleteByVoucherId(purchaseModel.getId());
		saveJournalModels(getJournalModels(purchaseModel, purchaseOthChargeTaxableModels, purchaseOthChargeModels));
	}

	public void update(PurchaseReturnHoDto purchaseReturnHoDto)
	{
		deleteByVoucherId(purchaseReturnHoDto.getPurchaseReturnModel().getId());
		saveJournalModels(getJournalModels(purchaseReturnHoDto));
	}

	public void update(PaymentModel paymentModel)
	{
		deleteByVoucherId(paymentModel.getId());
		saveJournalModels(getJournalModels(paymentModel));
	}

	public void update(ContraModel contraModel)
	{
		deleteByVoucherId(contraModel.getId());
		saveJournalModels(getJournalModels(contraModel));
	}

	public void update(ReceiptModel receiptModel)
	{
		deleteByVoucherId(receiptModel.getId());
		saveJournalModels(getJournalModels(receiptModel));
	}

	public void update(JournalHoDto journalHoDto)
	{
		deleteByVoucherId(journalHoDto.getJournalModel().getId());
		for (JournalItemModel journalItemModel : journalHoDto.getJournalItemModels())
		{
			deleteByVoucherId(journalItemModel.getId());
		}
		saveJournalModels(getJournalModels(journalHoDto));
	}

	public void update(CdpJournalVouHoDto cdpJournalVouHoDto)
	{
		deleteByVoucherId(cdpJournalVouHoDto.getCdpJournalVouModel().getId());
		saveJournalModels(getJournalModels(cdpJournalVouHoDto));
	}

	public void delete(AcctModel acctModel)
	{
		deleteByAcctId(acctModel.getId());
	}

	public void deleteAll()
	{
		String sql = String.format("DELETE FROM %s", tableName);
		session.createNativeQuery(sql).executeUpdate();
	}

	private List<AcctJournalModel> getJournalModels(AcctModel acctModel, int voucherId)
	{
		AcctJournalModel journalModel = new AcctJournalModel();

		journalModel.setDate(Util.stringToDate("1000-01-01", Util.Formats.DB_DATE));
		journalModel.setAcctId(acctModel.getId());
		journalModel.setVoucherId(voucherId);

		if (acctModel.getObType() == BalanceType.RECIEVABLE_DR_PAID)
		{
			journalModel.setTxType(TxType.DR);
			journalModel.setDr(acctModel.getOb());
			journalModel.setCr(null);
		}
		else
		{
			journalModel.setTxType(TxType.CR);
			journalModel.setDr(null);
			journalModel.setCr(acctModel.getOb());
		}

		List<AcctJournalModel> journalModels = new ArrayList<>();
		journalModels.add(journalModel);

		return journalModels;
	}

	private List<AcctJournalModel> getJournalModels(
			SalesHoDto salesHoDto)
	{

		List<AcctJournalModel> journalModels = new ArrayList<>();

		AcctJournalModel journalModelCustomer = new AcctJournalModel();
		journalModelCustomer.setDate(salesHoDto.getDate());
		journalModelCustomer.setAcctId(salesHoDto.getSalesModel().getCustomerId());
		journalModelCustomer.setVoucherId(salesHoDto.getSalesModel().getId());
		journalModelCustomer.setTxType(TxType.DR);
		journalModelCustomer.setDr(salesHoDto.getSalesModel().getAmtPayable());
		journalModels.add(journalModelCustomer);

		AcctJournalModel journalModelSales = new AcctJournalModel();
		journalModelSales.setDate(salesHoDto.getDate());
		journalModelSales.setAcctId(Account.SALES_CREDIT.getId());
		journalModelSales.setVoucherId(salesHoDto.getSalesModel().getId());
		journalModelSales.setTxType(TxType.CR);
		journalModelSales.setCr(salesHoDto.getSalesModel().getSumQxr());
		journalModels.add(journalModelSales);

		for (SalesOthChTaxableModel salesOthChargeTaxableModel : salesHoDto.getSalesOthChTaxableModels())
		{
			VouOthChModel othChargeTaxableModel = othChargeDao.getById(salesOthChargeTaxableModel.getOthChargeId());

			AcctJournalModel journalModelOthChargeTaxable = new AcctJournalModel();
			journalModelOthChargeTaxable.setDate(salesHoDto.getDate());
			journalModelOthChargeTaxable.setAcctId(othChargeTaxableModel.getSalesAcctId());
			journalModelOthChargeTaxable.setVoucherId(salesHoDto.getSalesModel().getId());
			journalModelOthChargeTaxable.setTxType(TxType.CR);
			journalModelOthChargeTaxable.setCr(salesOthChargeTaxableModel.getTaxableAmt());
			journalModels.add(journalModelOthChargeTaxable);
		}

		for (SalesOthChModel salesOthChargeModel : salesHoDto.getSalesOthChNonTaxModels())
		{
			VouOthChModel othChargeModel = othChargeDao.getById(salesOthChargeModel.getOthChargeId());

			AcctJournalModel journalModelOthCharge = new AcctJournalModel();
			journalModelOthCharge.setDate(salesHoDto.getDate());
			journalModelOthCharge.setAcctId(othChargeModel.getSalesAcctId());
			journalModelOthCharge.setVoucherId(salesHoDto.getSalesModel().getId());
			journalModelOthCharge.setTxType(TxType.CR);
			journalModelOthCharge.setCr(salesOthChargeModel.getAmt());
			journalModels.add(journalModelOthCharge);
		}

		if (salesHoDto.getSalesModel().isIsTax())
		{
			if (salesHoDto.getSalesModel().getCgstA() != null
					&& salesHoDto.getSalesModel().getCgstA().compareTo(BigDecimal.ZERO) != 0)
			{
				AcctJournalModel taxJournalModel = new AcctJournalModel();
				taxJournalModel.setDate(salesHoDto.getDate());
				taxJournalModel.setAcctId(Account.CGST.getId());
				taxJournalModel.setVoucherId(salesHoDto.getSalesModel().getId());
				taxJournalModel.setTxType(TxType.CR);
				taxJournalModel.setCr(salesHoDto.getSalesModel().getCgstA());
				journalModels.add(taxJournalModel);
			}
			if (salesHoDto.getSalesModel().getSgstA() != null
					&& salesHoDto.getSalesModel().getSgstA().compareTo(BigDecimal.ZERO) != 0)
			{
				AcctJournalModel taxJournalModel = new AcctJournalModel();
				taxJournalModel.setDate(salesHoDto.getDate());
				taxJournalModel.setAcctId(Account.SGST.getId());
				taxJournalModel.setVoucherId(salesHoDto.getSalesModel().getId());
				taxJournalModel.setTxType(TxType.CR);
				taxJournalModel.setCr(salesHoDto.getSalesModel().getSgstA());
				journalModels.add(taxJournalModel);
			}

			if (salesHoDto.getSalesModel().getIgstA() != null
					&& salesHoDto.getSalesModel().getIgstA().compareTo(BigDecimal.ZERO) != 0)
			{
				AcctJournalModel taxJournalModel = new AcctJournalModel();
				taxJournalModel.setDate(salesHoDto.getDate());
				taxJournalModel.setAcctId(Account.IGST.getId());
				taxJournalModel.setVoucherId(salesHoDto.getSalesModel().getId());
				taxJournalModel.setTxType(TxType.CR);
				taxJournalModel.setCr(salesHoDto.getSalesModel().getIgstA());
				journalModels.add(taxJournalModel);
			}
		}

		if (salesHoDto.getSalesModel().getRoundOff() != null
				&& salesHoDto.getSalesModel().getRoundOff().compareTo(BigDecimal.ZERO) != 0)
		{
			AcctJournalModel roundOffJournalModel = new AcctJournalModel();
			roundOffJournalModel.setDate(salesHoDto.getDate());
			roundOffJournalModel.setAcctId(Account.ROUND_OFF.getId());
			roundOffJournalModel.setVoucherId(salesHoDto.getSalesModel().getId());
			roundOffJournalModel.setTxType(TxType.CR);
			roundOffJournalModel.setCr(salesHoDto.getSalesModel().getRoundOff());
			journalModels.add(roundOffJournalModel);
		}

		return journalModels;
	}

	private List<AcctJournalModel> getJournalModels(
			SalesReturnHoDto salesReturnHoDto)
	{

		List<AcctJournalModel> journalModels = new ArrayList<>();

		AcctJournalModel journalModelCustomer = new AcctJournalModel();
		journalModelCustomer.setDate(salesReturnHoDto.getDate());
		journalModelCustomer.setAcctId(salesReturnHoDto.getSalesReturnModel().getCustomerId());
		journalModelCustomer.setVoucherId(salesReturnHoDto.getSalesReturnModel().getId());
		journalModelCustomer.setTxType(TxType.CR);
		journalModelCustomer.setCr(salesReturnHoDto.getSalesReturnModel().getAmtPayable());
		journalModels.add(journalModelCustomer);

		AcctJournalModel journalModelSalesReturn = new AcctJournalModel();
		journalModelSalesReturn.setDate(salesReturnHoDto.getDate());
		journalModelSalesReturn.setAcctId(salesReturnHoDto.getSalesReturnModel().getAcctId());
		journalModelSalesReturn.setVoucherId(salesReturnHoDto.getSalesReturnModel().getId());
		journalModelSalesReturn.setTxType(TxType.DR);
		journalModelSalesReturn.setDr(salesReturnHoDto.getSalesReturnModel().getSumQxr());
		journalModels.add(journalModelSalesReturn);

		for (SalesReturnOthChTaxableModel salesReturnOthChargeTaxableModel : salesReturnHoDto.getSalesReturnOthChTaxableModels())
		{
			VouOthChModel othChargeTaxableModel = othChargeDao.getById(salesReturnOthChargeTaxableModel.getOthChargeId());

			AcctJournalModel journalModelOthChargeTaxable = new AcctJournalModel();
			journalModelOthChargeTaxable.setDate(salesReturnHoDto.getDate());
			journalModelOthChargeTaxable.setAcctId(othChargeTaxableModel.getSalesRetAcctId());
			journalModelOthChargeTaxable.setVoucherId(salesReturnHoDto.getSalesReturnModel().getId());
			journalModelOthChargeTaxable.setTxType(TxType.DR);
			journalModelOthChargeTaxable.setDr(salesReturnOthChargeTaxableModel.getTaxableAmt());
			journalModels.add(journalModelOthChargeTaxable);
		}

		for (SalesReturnOthChModel salesReturnOthChargeModel : salesReturnHoDto.getSalesReturnOthChNonTaxModels())
		{
			VouOthChModel othChargeModel = othChargeDao.getById(salesReturnOthChargeModel.getOthChargeId());

			AcctJournalModel journalModelOthCharge = new AcctJournalModel();
			journalModelOthCharge.setDate(salesReturnHoDto.getDate());
			journalModelOthCharge.setAcctId(othChargeModel.getSalesRetAcctId());
			journalModelOthCharge.setVoucherId(salesReturnHoDto.getSalesReturnModel().getId());
			journalModelOthCharge.setTxType(TxType.DR);
			journalModelOthCharge.setDr(salesReturnOthChargeModel.getAmt());
			journalModels.add(journalModelOthCharge);
		}

		if (salesReturnHoDto.getSalesReturnModel().isIsTax())
		{
			if (salesReturnHoDto.getSalesReturnModel().getCgstA() != null
					&& salesReturnHoDto.getSalesReturnModel().getCgstA().compareTo(BigDecimal.ZERO) != 0)
			{
				AcctJournalModel taxJournalModel = new AcctJournalModel();
				taxJournalModel.setDate(salesReturnHoDto.getDate());
				taxJournalModel.setAcctId(Account.CGST.getId());
				taxJournalModel.setVoucherId(salesReturnHoDto.getSalesReturnModel().getId());
				taxJournalModel.setTxType(TxType.DR);
				taxJournalModel.setDr(salesReturnHoDto.getSalesReturnModel().getCgstA());
				journalModels.add(taxJournalModel);
			}
			if (salesReturnHoDto.getSalesReturnModel().getSgstA() != null
					&& salesReturnHoDto.getSalesReturnModel().getSgstA().compareTo(BigDecimal.ZERO) != 0)
			{
				AcctJournalModel taxJournalModel = new AcctJournalModel();
				taxJournalModel.setDate(salesReturnHoDto.getDate());
				taxJournalModel.setAcctId(Account.SGST.getId());
				taxJournalModel.setVoucherId(salesReturnHoDto.getSalesReturnModel().getId());
				taxJournalModel.setTxType(TxType.DR);
				taxJournalModel.setDr(salesReturnHoDto.getSalesReturnModel().getSgstA());
				journalModels.add(taxJournalModel);
			}

			if (salesReturnHoDto.getSalesReturnModel().getIgstA() != null
					&& salesReturnHoDto.getSalesReturnModel().getIgstA().compareTo(BigDecimal.ZERO) != 0)
			{
				AcctJournalModel taxJournalModel = new AcctJournalModel();
				taxJournalModel.setDate(salesReturnHoDto.getDate());
				taxJournalModel.setAcctId(Account.IGST.getId());
				taxJournalModel.setVoucherId(salesReturnHoDto.getSalesReturnModel().getId());
				taxJournalModel.setTxType(TxType.DR);
				taxJournalModel.setDr(salesReturnHoDto.getSalesReturnModel().getIgstA());
				journalModels.add(taxJournalModel);
			}
		}

		if (salesReturnHoDto.getSalesReturnModel().getRoundOff() != null
				&& salesReturnHoDto.getSalesReturnModel().getRoundOff().compareTo(BigDecimal.ZERO) != 0)
		{
			AcctJournalModel roundOffJournalModel = new AcctJournalModel();
			roundOffJournalModel.setDate(salesReturnHoDto.getDate());
			roundOffJournalModel.setAcctId(Account.ROUND_OFF.getId());
			roundOffJournalModel.setVoucherId(salesReturnHoDto.getSalesReturnModel().getId());
			roundOffJournalModel.setTxType(TxType.DR);
			roundOffJournalModel.setDr(salesReturnHoDto.getSalesReturnModel().getRoundOff());
			journalModels.add(roundOffJournalModel);
		}

		return journalModels;
	}

	private List<AcctJournalModel> getJournalModels(
			PurchaseModel purchaseModel,
			List<PurchaseOthChTaxableModel> purchaseOthChargeTaxableModels,
			List<PurchaseOthChModel> purchaseOthChargeModels)
	{

		List<AcctJournalModel> journalModels = new ArrayList<>();

		AcctJournalModel journalModelSupplier = new AcctJournalModel();
		journalModelSupplier.setDate(purchaseModel.getDate());
		journalModelSupplier.setAcctId(purchaseModel.getSupplierId());
		journalModelSupplier.setVoucherId(purchaseModel.getId());
		journalModelSupplier.setTxType(TxType.CR);
		journalModelSupplier.setCr(purchaseModel.getAmtPayable());
		journalModels.add(journalModelSupplier);

		AcctJournalModel journalModelPurchase = new AcctJournalModel();
		journalModelPurchase.setDate(purchaseModel.getDate());
		journalModelPurchase.setAcctId(Account.PURCHASE.getId());
		journalModelPurchase.setVoucherId(purchaseModel.getId());
		journalModelPurchase.setTxType(TxType.DR);
		journalModelPurchase.setDr(purchaseModel.getSumQxr());
		journalModels.add(journalModelPurchase);

		if (purchaseModel.getDiscA() != null && purchaseModel.getDiscA().compareTo(BigDecimal.ZERO) != 0)
		{
			AcctJournalModel journalModelDisc = new AcctJournalModel();
			journalModelDisc.setDate(purchaseModel.getDate());
			journalModelDisc.setAcctId(Account.DISCOUNT_RECEIVED.getId());
			journalModelDisc.setVoucherId(purchaseModel.getId());
			journalModelDisc.setTxType(TxType.CR);
			journalModelDisc.setCr(purchaseModel.getDiscA());
			journalModels.add(journalModelDisc);
		}

		for (PurchaseOthChTaxableModel purchaseOthChargeTaxableModel : purchaseOthChargeTaxableModels)
		{
			VouOthChModel othChargeTaxableModel = othChargeDao.getById(purchaseOthChargeTaxableModel.getOthChargeId());

			AcctJournalModel journalModelOthChargeTaxable = new AcctJournalModel();
			journalModelOthChargeTaxable.setDate(purchaseModel.getDate());
			journalModelOthChargeTaxable.setAcctId(othChargeTaxableModel.getPurchaseAcctId());
			journalModelOthChargeTaxable.setVoucherId(purchaseModel.getId());
			journalModelOthChargeTaxable.setTxType(TxType.DR);
			journalModelOthChargeTaxable.setDr(purchaseOthChargeTaxableModel.getTaxableAmt());
			journalModels.add(journalModelOthChargeTaxable);
		}

		for (PurchaseOthChModel purchaseOthChargeModel : purchaseOthChargeModels)
		{
			VouOthChModel othChargeModel = othChargeDao.getById(purchaseOthChargeModel.getOthChargeId());

			AcctJournalModel journalModelOthCharge = new AcctJournalModel();
			journalModelOthCharge.setDate(purchaseModel.getDate());
			journalModelOthCharge.setAcctId(othChargeModel.getPurchaseAcctId());
			journalModelOthCharge.setVoucherId(purchaseModel.getId());
			journalModelOthCharge.setTxType(TxType.DR);
			journalModelOthCharge.setDr(purchaseOthChargeModel.getAmt());
			journalModels.add(journalModelOthCharge);
		}

		if (purchaseModel.isIsTax())
		{
			if (purchaseModel.getCgstA() != null
					&& purchaseModel.getCgstA().compareTo(BigDecimal.ZERO) != 0)
			{
				AcctJournalModel taxJournalModel = new AcctJournalModel();
				taxJournalModel.setDate(purchaseModel.getDate());
				taxJournalModel.setAcctId(Account.CGST.getId());
				taxJournalModel.setVoucherId(purchaseModel.getId());
				taxJournalModel.setTxType(TxType.DR);
				taxJournalModel.setDr(purchaseModel.getCgstA());
				journalModels.add(taxJournalModel);
			}
			if (purchaseModel.getSgstA() != null
					&& purchaseModel.getSgstA().compareTo(BigDecimal.ZERO) != 0)
			{
				AcctJournalModel taxJournalModel = new AcctJournalModel();
				taxJournalModel.setDate(purchaseModel.getDate());
				taxJournalModel.setAcctId(Account.SGST.getId());
				taxJournalModel.setVoucherId(purchaseModel.getId());
				taxJournalModel.setTxType(TxType.DR);
				taxJournalModel.setDr(purchaseModel.getSgstA());
				journalModels.add(taxJournalModel);
			}

			if (purchaseModel.getIgstA() != null
					&& purchaseModel.getIgstA().compareTo(BigDecimal.ZERO) != 0)
			{
				AcctJournalModel taxJournalModel = new AcctJournalModel();
				taxJournalModel.setDate(purchaseModel.getDate());
				taxJournalModel.setAcctId(Account.IGST.getId());
				taxJournalModel.setVoucherId(purchaseModel.getId());
				taxJournalModel.setTxType(TxType.DR);
				taxJournalModel.setDr(purchaseModel.getIgstA());
				journalModels.add(taxJournalModel);
			}
		}

		if (purchaseModel.getRoundOff() != null
				&& purchaseModel.getRoundOff().compareTo(BigDecimal.ZERO) != 0)
		{
			AcctJournalModel roundOffJournalModel = new AcctJournalModel();
			roundOffJournalModel.setDate(purchaseModel.getDate());
			roundOffJournalModel.setAcctId(Account.ROUND_OFF.getId());
			roundOffJournalModel.setVoucherId(purchaseModel.getId());
			roundOffJournalModel.setTxType(TxType.DR);
			roundOffJournalModel.setDr(purchaseModel.getRoundOff());
			journalModels.add(roundOffJournalModel);
		}

		return journalModels;
	}

	private List<AcctJournalModel> getJournalModels(
			PurchaseReturnHoDto purchaseReturnHoDto)
	{

		List<AcctJournalModel> journalModels = new ArrayList<>();

		AcctJournalModel journalModelSupplier = new AcctJournalModel();
		journalModelSupplier.setDate(purchaseReturnHoDto.getDate());
		journalModelSupplier.setAcctId(purchaseReturnHoDto.getPurchaseReturnModel().getSupplierId());
		journalModelSupplier.setVoucherId(purchaseReturnHoDto.getPurchaseReturnModel().getId());
		journalModelSupplier.setTxType(TxType.DR);
		journalModelSupplier.setDr(purchaseReturnHoDto.getPurchaseReturnModel().getAmtPayable());
		journalModels.add(journalModelSupplier);

		AcctJournalModel journalModelPurchaseReturn = new AcctJournalModel();
		journalModelPurchaseReturn.setDate(purchaseReturnHoDto.getDate());
		journalModelPurchaseReturn.setAcctId(purchaseReturnHoDto.getPurchaseReturnModel().getAcctId());
		journalModelPurchaseReturn.setVoucherId(purchaseReturnHoDto.getPurchaseReturnModel().getId());
		journalModelPurchaseReturn.setTxType(TxType.CR);
		journalModelPurchaseReturn.setCr(purchaseReturnHoDto.getPurchaseReturnModel().getSumQxr());
		journalModels.add(journalModelPurchaseReturn);

		for (PurchaseReturnOthChTaxableModel purchaseReturnOthChargeTaxableModel : purchaseReturnHoDto.getPurchaseReturnOthChTaxableModels())
		{
			VouOthChModel othChargeTaxableModel = othChargeDao.getById(purchaseReturnOthChargeTaxableModel.getOthChargeId());

			AcctJournalModel journalModelOthChargeTaxable = new AcctJournalModel();
			journalModelOthChargeTaxable.setDate(purchaseReturnHoDto.getDate());
			journalModelOthChargeTaxable.setAcctId(othChargeTaxableModel.getPurchaseRetAcctId());
			journalModelOthChargeTaxable.setVoucherId(purchaseReturnHoDto.getPurchaseReturnModel().getId());
			journalModelOthChargeTaxable.setTxType(TxType.CR);
			journalModelOthChargeTaxable.setCr(purchaseReturnOthChargeTaxableModel.getTaxableAmt());
			journalModels.add(journalModelOthChargeTaxable);
		}

		for (PurchaseReturnOthChModel purchaseReturnOthChargeModel : purchaseReturnHoDto.getPurchaseReturnOthChNonTaxModels())
		{
			VouOthChModel othChargeModel = othChargeDao.getById(purchaseReturnOthChargeModel.getOthChargeId());

			AcctJournalModel journalModelOthCharge = new AcctJournalModel();
			journalModelOthCharge.setDate(purchaseReturnHoDto.getDate());
			journalModelOthCharge.setAcctId(othChargeModel.getPurchaseRetAcctId());
			journalModelOthCharge.setVoucherId(purchaseReturnHoDto.getPurchaseReturnModel().getId());
			journalModelOthCharge.setTxType(TxType.CR);
			journalModelOthCharge.setCr(purchaseReturnOthChargeModel.getAmt());
			journalModels.add(journalModelOthCharge);
		}

		if (purchaseReturnHoDto.getPurchaseReturnModel().isIsTax())
		{
			if (purchaseReturnHoDto.getPurchaseReturnModel().getCgstA() != null
					&& purchaseReturnHoDto.getPurchaseReturnModel().getCgstA().compareTo(BigDecimal.ZERO) != 0)
			{
				AcctJournalModel taxJournalModel = new AcctJournalModel();
				taxJournalModel.setDate(purchaseReturnHoDto.getDate());
				taxJournalModel.setAcctId(Account.CGST.getId());
				taxJournalModel.setVoucherId(purchaseReturnHoDto.getPurchaseReturnModel().getId());
				taxJournalModel.setTxType(TxType.CR);
				taxJournalModel.setCr(purchaseReturnHoDto.getPurchaseReturnModel().getCgstA());
				journalModels.add(taxJournalModel);
			}
			if (purchaseReturnHoDto.getPurchaseReturnModel().getSgstA() != null
					&& purchaseReturnHoDto.getPurchaseReturnModel().getSgstA().compareTo(BigDecimal.ZERO) != 0)
			{
				AcctJournalModel taxJournalModel = new AcctJournalModel();
				taxJournalModel.setDate(purchaseReturnHoDto.getDate());
				taxJournalModel.setAcctId(Account.SGST.getId());
				taxJournalModel.setVoucherId(purchaseReturnHoDto.getPurchaseReturnModel().getId());
				taxJournalModel.setTxType(TxType.CR);
				taxJournalModel.setCr(purchaseReturnHoDto.getPurchaseReturnModel().getSgstA());
				journalModels.add(taxJournalModel);
			}

			if (purchaseReturnHoDto.getPurchaseReturnModel().getIgstA() != null
					&& purchaseReturnHoDto.getPurchaseReturnModel().getIgstA().compareTo(BigDecimal.ZERO) != 0)
			{
				AcctJournalModel taxJournalModel = new AcctJournalModel();
				taxJournalModel.setDate(purchaseReturnHoDto.getDate());
				taxJournalModel.setAcctId(Account.IGST.getId());
				taxJournalModel.setVoucherId(purchaseReturnHoDto.getPurchaseReturnModel().getId());
				taxJournalModel.setTxType(TxType.CR);
				taxJournalModel.setCr(purchaseReturnHoDto.getPurchaseReturnModel().getIgstA());
				journalModels.add(taxJournalModel);
			}
		}

		if (purchaseReturnHoDto.getPurchaseReturnModel().getRoundOff() != null
				&& purchaseReturnHoDto.getPurchaseReturnModel().getRoundOff().compareTo(BigDecimal.ZERO) != 0)
		{
			AcctJournalModel roundOffJournalModel = new AcctJournalModel();
			roundOffJournalModel.setDate(purchaseReturnHoDto.getDate());
			roundOffJournalModel.setAcctId(Account.ROUND_OFF.getId());
			roundOffJournalModel.setVoucherId(purchaseReturnHoDto.getPurchaseReturnModel().getId());
			roundOffJournalModel.setTxType(TxType.CR);
			roundOffJournalModel.setCr(purchaseReturnHoDto.getPurchaseReturnModel().getRoundOff());
			journalModels.add(roundOffJournalModel);
		}

		return journalModels;
	}

	private List<AcctJournalModel> getJournalModels(PaymentModel paymentModel)
	{
		AcctJournalModel journalModelCr = new AcctJournalModel();
		journalModelCr.setDate(paymentModel.getDate());
		journalModelCr.setAcctId(paymentModel.getFromAcctId());
		journalModelCr.setVoucherId(paymentModel.getId());
		journalModelCr.setTxType(TxType.CR);
		journalModelCr.setCr(paymentModel.getAmount());

		AcctJournalModel journalModelDr = new AcctJournalModel();
		journalModelDr.setDate(paymentModel.getDate());
		journalModelDr.setAcctId(paymentModel.getToAcctId());
		journalModelDr.setVoucherId(paymentModel.getId());
		journalModelDr.setTxType(TxType.DR);
		journalModelDr.setDr(paymentModel.getAmount());

		List<AcctJournalModel> journalModels = new ArrayList<>();
		journalModels.add(journalModelCr);
		journalModels.add(journalModelDr);

		return journalModels;

	}

	private List<AcctJournalModel> getJournalModels(ContraModel contraModel)
	{
		AcctJournalModel journalModelCr = new AcctJournalModel();
		journalModelCr.setDate(contraModel.getDate());
		journalModelCr.setAcctId(contraModel.getFromAcctId());
		journalModelCr.setVoucherId(contraModel.getId());
		journalModelCr.setTxType(TxType.CR);
		journalModelCr.setCr(contraModel.getAmt());

		AcctJournalModel journalModelDr = new AcctJournalModel();
		journalModelDr.setDate(contraModel.getDate());
		journalModelDr.setAcctId(contraModel.getToAcctId());
		journalModelDr.setVoucherId(contraModel.getId());
		journalModelDr.setTxType(TxType.DR);
		journalModelDr.setDr(contraModel.getAmt());

		List<AcctJournalModel> journalModels = new ArrayList<>();
		journalModels.add(journalModelCr);
		journalModels.add(journalModelDr);

		return journalModels;
	}

	private List<AcctJournalModel> getJournalModels(ReceiptModel receiptModel)
	{
		AcctJournalModel journalModelDr = new AcctJournalModel();
		journalModelDr.setDate(receiptModel.getDate());
		journalModelDr.setAcctId(receiptModel.getToAcctId());
		journalModelDr.setVoucherId(receiptModel.getId());
		journalModelDr.setTxType(TxType.DR);
		journalModelDr.setDr(receiptModel.getAmount());

		AcctJournalModel journalModelCr = new AcctJournalModel();
		journalModelCr.setDate(receiptModel.getDate());
		journalModelCr.setAcctId(receiptModel.getFromAcctId());
		journalModelCr.setVoucherId(receiptModel.getId());
		journalModelCr.setTxType(TxType.CR);
		journalModelCr.setCr(receiptModel.getAmount());

		List<AcctJournalModel> journalModels = new ArrayList<>();
		journalModels.add(journalModelCr);
		journalModels.add(journalModelDr);

		return journalModels;
	}

	private List<AcctJournalModel> getJournalModels(JournalHoDto journalHoDto)
	{
		List<AcctJournalModel> acctJournalModels = new ArrayList<>();

		AcctJournalModel acctJournalModel1 = new AcctJournalModel();
		acctJournalModel1.setDate(journalHoDto.getDate());
		acctJournalModel1.setAcctId(journalHoDto.getJournalModel().getAcctId());
		acctJournalModel1.setVoucherId(journalHoDto.getJournalModel().getId());
		acctJournalModel1.setTxType(journalHoDto.getJournalModel().getTxType());
		if (journalHoDto.getJournalModel().getTxType() == TxType.CR)
		{
			acctJournalModel1.setCr(journalHoDto.getJournalModel().getAmt());
		}
		else
		{
			acctJournalModel1.setDr(journalHoDto.getJournalModel().getAmt());
		}

		acctJournalModels.add(acctJournalModel1);

		for (JournalItemModel journalItemModel : journalHoDto.getJournalItemModels())
		{
			AcctJournalModel acctJournalModel = new AcctJournalModel();
			acctJournalModel.setDate(journalHoDto.getDate());
			acctJournalModel.setAcctId(journalItemModel.getAcctId());
			acctJournalModel.setVoucherId(journalItemModel.getId());
			if (journalHoDto.getJournalModel().getTxType() == TxType.CR)
			{
				acctJournalModel.setTxType(TxType.DR);
				acctJournalModel.setDr(journalItemModel.getAmt());
			}
			else
			{
				acctJournalModel.setTxType(TxType.CR);
				acctJournalModel.setCr(journalItemModel.getAmt());
			}

			acctJournalModels.add(acctJournalModel);
		}

		return acctJournalModels;
	}

	private List<AcctJournalModel> getJournalModels(CdpJournalVouHoDto cdpJournalVouHoDto)
	{
		List<AcctJournalModel> acctJournalModels = new ArrayList<>();

		AcctJournalModel acctJournalModel1 = new AcctJournalModel();
		AcctJournalModel acctJournalModel2 = new AcctJournalModel();

		acctJournalModel1.setDate(cdpJournalVouHoDto.getDate());
		acctJournalModel2.setDate(cdpJournalVouHoDto.getDate());

		acctJournalModel1.setVoucherId(cdpJournalVouHoDto.getCdpJournalVouModel().getId());
		acctJournalModel2.setVoucherId(cdpJournalVouHoDto.getCdpJournalVouModel().getId());

		if (cdpJournalVouHoDto.getCdpJournalVouModel().getCdpAcctId() == Account.CASH_DISCOUNT.getId())
		{
			acctJournalModel1.setAcctId(cdpJournalVouHoDto.getCdpJournalVouModel().getCustomerAcctId());
			acctJournalModel1.setTxType(TxType.CR);
			acctJournalModel1.setCr(cdpJournalVouHoDto.getCdpJournalVouModel().getAmt());

			acctJournalModel2.setAcctId(cdpJournalVouHoDto.getCdpJournalVouModel().getCdpAcctId());
			acctJournalModel2.setTxType(TxType.DR);
			acctJournalModel2.setDr(cdpJournalVouHoDto.getCdpJournalVouModel().getAmt());
		}
		else
		{
			acctJournalModel1.setAcctId(cdpJournalVouHoDto.getCdpJournalVouModel().getCustomerAcctId());
			acctJournalModel1.setTxType(TxType.DR);
			acctJournalModel1.setDr(cdpJournalVouHoDto.getCdpJournalVouModel().getAmt());

			acctJournalModel2.setAcctId(cdpJournalVouHoDto.getCdpJournalVouModel().getCdpAcctId());
			acctJournalModel2.setTxType(TxType.CR);
			acctJournalModel2.setCr(cdpJournalVouHoDto.getCdpJournalVouModel().getAmt());
		}

		acctJournalModels.add(acctJournalModel1);
		acctJournalModels.add(acctJournalModel2);

		return acctJournalModels;
	}

	private List<AcctJournalModel> getJournalModels(CommVouPayableModel commVouPayableModel, int agentAcctId, Date date)
	{
		AcctJournalModel journalModelCr = new AcctJournalModel();
		journalModelCr.setDate(date);
		journalModelCr.setAcctId(agentAcctId);
		journalModelCr.setVoucherId(commVouPayableModel.getId());
		journalModelCr.setTxType(TxType.CR);
		journalModelCr.setCr(commVouPayableModel.getAmt());

		AcctJournalModel journalModelDr = new AcctJournalModel();
		journalModelDr.setDate(date);
		journalModelDr.setAcctId(Account.COMMISSION.getId());
		journalModelDr.setVoucherId(commVouPayableModel.getId());
		journalModelDr.setTxType(TxType.DR);
		journalModelDr.setDr(commVouPayableModel.getAmt());

		List<AcctJournalModel> journalModels = new ArrayList<>();
		journalModels.add(journalModelCr);
		journalModels.add(journalModelDr);

		return journalModels;
	}

	private void saveJournalModels(List<AcctJournalModel> journalModels)
	{
		for (AcctJournalModel journalModel : journalModels)
		{
			session.persist(journalModel);
		}
	}

	public AcctJournalModel getByVoucherId(int voucherId)
	{
		String sql = String.format(sqlGetByVoucherId,
				tableName,
				String.valueOf(voucherId));

		List<AcctJournalModel> journalModels = session.createNativeQuery(sql, AcctJournalModel.class).getResultList();
		if (journalModels == null || journalModels.isEmpty())
		{
			return null;
		}
		return journalModels.get(0);

	}

	public AcctJournalSumHdto getOpeningBalance(Integer acctTypeId, Integer acctId, Date asOnDate, Boolean hideCleared)
	{
		return getAcctJournalSumHdto(acctTypeId, acctId, asOnDate, hideCleared, BalanceTypeByOpCl.OPENING);
	}

	public AcctJournalSumHdto getClosingBalance(Integer acctTypeId, Integer acctId, Date asOnDate, Boolean hideCleared)
	{
		return getAcctJournalSumHdto(acctTypeId, acctId, asOnDate, hideCleared, BalanceTypeByOpCl.CLOSING);
	}

	private AcctJournalSumHdto getAcctJournalSumHdto(Integer acctTypeId, Integer acctId, Date asOnDate, Boolean hideCleared, BalanceTypeByOpCl balanceType)
	{
		String sql = "WITH RECURSIVE cte_acct (root_id, parent_id, child_id) AS (\n"
				+ "	\n"
				+ "	SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		acct_type l1_at\n"
				+ "	WHERE\n";

		if (acctTypeId == null)
		{
			sql = sql + "parent_id is null\n";
		}
		else
		{
			sql = sql + String.format("id = %s\n", acctTypeId);
		}

		sql = sql + "UNION ALL\n"
				+ "	\n"
				+ "	SELECT\n"
				+ "		cte_acct.root_id,\n"
				+ "		cte_acct.child_id,\n"
				+ "		l2_at.id\n"
				+ "	FROM\n"
				+ "		acct_type l2_at\n"
				+ "	INNER JOIN \n"
				+ "		cte_acct\n"
				+ "	ON \n"
				+ "		l2_at.parent_id = cte_acct.child_id\n"
				+ "		\n"
				+ ")\n"
				+ "SELECT\n"
				+ "	SUM(dr) as debit,\n"
				+ "	SUM(cr) as credit\n"
				+ "FROM\n"
				+ "	acct_journal\n"
				+ "LEFT JOIN\n"
				+ "	acct\n"
				+ "ON\n"
				+ "	acct.id = acct_journal.acct_id\n"
				+ "LEFT JOIN\n"
				+ "	cte_acct\n"
				+ "ON\n"
				+ "	cte_acct.child_id = acct.acct_type_id\n";

		List<String> ands = new ArrayList<>();

		if (acctTypeId != null)
		{
			ands.add("root_id =" + String.valueOf(acctTypeId));
		}

		if (acctId != null)
		{
			ands.add(tableName + ".acct_id=" + String.valueOf(acctId));
		}

		if (balanceType == BalanceTypeByOpCl.OPENING)
		{
			if (asOnDate == null)
			{
				ands.add("date(date)<= date('1000-01-01')");
			}
			else
			{
				ands.add(String.format("date(date)< date('%s')", Util.dateToString(asOnDate, Util.Formats.DB_DATE)));
			}
		}
		else if (balanceType == BalanceTypeByOpCl.CLOSING && asOnDate != null)
		{
			ands.add(String.format("date(date)<= date('%s')", Util.dateToString(asOnDate, Util.Formats.DB_DATE)));
		}

		sql = SqlHelper.putWheres(ands, sql);

		return (AcctJournalSumHdto) session.createNativeQuery(sql, AcctJournalSumHdto.class).getResultList().get(0);
	}

	public AcctJournalSumHdto getSumTill(int accountId, Date date, int limitingVoucherId)
	{

		String sqlSum = String.format(sqlPrevTotal, tableName);

		List<String> wheres = new ArrayList<>();

		wheres.add(tableName + ".acct_id=" + String.valueOf(accountId));
		wheres.add("date(" + tableName + ".date)<=date('" + Util.dateToString(date, Util.Formats.DB_DATE) + "')");

		wheres.add(String.format("(%s.voucher_id<=%s  OR %s.voucher_id is null)",
				tableName,
				String.valueOf(limitingVoucherId),
				tableName));

		String sql = SqlHelper.putWheres(wheres, sqlSum);
		List<AcctJournalSumHdto> results = session.createNativeQuery(sql, AcctJournalSumHdto.class).getResultList();
		if (results == null || results.isEmpty())
		{
			return null;
		}

		return results.get(0);

	}

	public List<AcctMonthlySummaryHdto> getAcctMonthlySummary(Integer acctTypeId, Integer acctId, Date dateFrom, Date dateTo)
	{
		String sql = "WITH RECURSIVE cte_name (dt) AS (\n"
				+ "    SELECT DATE_ADD(DATE_ADD(LAST_DAY('{date_from}'),INTERVAL 1 DAY), INTERVAL -1 MONTH)\n"
				+ "    UNION\n"
				+ "    SELECT DATE_ADD(dt, INTERVAL 1 MONTH) FROM cte_name \n"
				+ "	WHERE \n"
				+ "		dt <= '{date_to}'\n"
				+ "),\n"
				+ "cte_acct (root_id, parent_id, child_id) AS (\n"
				+ "	\n"
				+ "	SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		acct_type l1_at "
				+ "	WHERE\n";

		if (acctTypeId == null)
		{
			sql = sql + "parent_id is null\n";
		}
		else
		{
			sql = sql + String.format("id = %s\n", acctTypeId);
		}

		sql = sql + "	UNION ALL\n"
				+ "	\n"
				+ "	SELECT\n"
				+ "		cte_acct.root_id,\n"
				+ "		cte_acct.child_id,\n"
				+ "		l2_at.id\n"
				+ "	FROM\n"
				+ "		acct_type l2_at\n"
				+ "	INNER JOIN \n"
				+ "		cte_acct\n"
				+ "	ON \n"
				+ "		l2_at.parent_id = cte_acct.child_id\n"
				+ "		\n"
				+ ")\n"
				+ "SELECT\n"
				+ "	YEAR(cte_name.dt) * 100 + MONTH(cte_name.dt) month_yr,\n"
				+ "	MONTH(cte_name.dt) month,\n"
				+ "	YEAR(cte_name.dt) yr,\n"
				+ "	IFNULL(SUM(dr),0) dr,\n"
				+ "	IFNULL(SUM(cr),0) cr\n"
				+ "FROM\n"
				+ "	cte_name\n"
				+ "LEFT JOIN\n"
				+ "(\n"
				+ "	SELECT \n"
				+ "		acct_journal.*\n"
				+ "	FROM\n"
				+ "		acct_journal\n"
				+ "	LEFT JOIN\n"
				+ "		acct\n"
				+ "	ON\n"
				+ "		acct.id = acct_journal.acct_id\n"
				+ "	LEFT JOIN\n"
				+ "		cte_acct\n"
				+ "	ON\n"
				+ "		cte_acct.root_id = acct.acct_type_id\n";

		List<String> ands = new ArrayList<>();

		if (acctTypeId != null)
		{
			ands.add("root_id =" + String.valueOf(acctTypeId));
		}

		if (acctId != null)
		{
			ands.add(tableName + ".acct_id=" + String.valueOf(acctId));
		}

		sql = SqlHelper.putWheres(ands, sql);

		sql = sql + "\n"
				+ ") t1\n"
				+ "ON\n"
				+ "	MONTH(cte_name.dt) = MONTH(t1.date)\n"
				+ "AND\n"
				+ "	YEAR(cte_name.dt) = YEAR(t1.date)"
				+ "GROUP BY\n"
				+ "	cte_name.dt\n"
				+ "ORDER BY\n"
				+ "	cte_name.dt";

		Map<String, String> map = new HashMap<>();

		YearModel yearModel = yearDao.getById(1);

		if (dateFrom == null)
		{
			dateFrom = yearModel.getDateFrom();
		}

		if (dateTo == null)
		{
			dateTo = yearModel.getDateTo();
		}

		map.put("date_from", Util.dateToString(dateFrom, Util.Formats.DB_DATE));
		map.put("date_to", Util.dateToString(dateTo, Util.Formats.DB_DATE));
		map.put("table_acct_journal", TableName.ACCT_JOURNAL);

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, AcctMonthlySummaryHdto.class).getResultList();
	}

	public List<AcctSummaryHdto> _getAcctSummary(Integer acctTypeId, Date dateFrom, Date dateTo)
	{
		String sql = "SELECT\n"
				+ "	acct_id,\n"
				+ "	name,\n"
				+ "	IFNULL(SUM(dr),0) as dr,\n"
				+ "	IFNULL(SUM(cr),0) as cr\n"
				+ "FROM\n"
				+ "	acct_journal\n"
				+ "LEFT JOIN\n"
				+ "	acct\n"
				+ "ON\n"
				+ "	acct.id = acct_id ";
		List<String> wheres = new ArrayList<>();

		if (acctTypeId != null)
		{
			wheres.add(tableName + ".acct_type_id=" + String.valueOf(acctTypeId));
		}
		if (dateFrom != null)
		{
			wheres.add(tableName + ".date>='" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "'");
		}
		if (dateTo != null)
		{
			wheres.add(tableName + ".date<='" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "'");
		}

		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " GROUP BY \n"
				+ "	acct_id\n"
				+ "ORDER BY\n"
				+ "	name";

		return session.createNativeQuery(sql, AcctSummaryHdto.class).getResultList();

	}

	public List<AcctSummaryHdto> getAcctSummaryByAcctType(Integer parentAcctTypeId, Integer acctTypeId, Date dateFrom, Date dateTo)
	{
		String sql = getSqlTrialBalanceByAcctType(parentAcctTypeId, acctTypeId, dateFrom, dateTo);
		return session.createNativeQuery(sql, AcctSummaryHdto.class).getResultList();
	}

	public List<AcctSummaryHdto> getAcctSummaryByAcct(Integer acctTypeId, Integer acctId, Date dateFrom, Date dateTo)
	{
		String sql = getSqlTrialBalanceByAcct(acctTypeId, acctId, dateFrom, dateTo);
		return session.createNativeQuery(sql, AcctSummaryHdto.class).getResultList();
	}

	private String getSqlTrialBalanceByAcctType(Integer parentAcctTypeId, Integer acctTypeId, Date dateFrom, Date dateTo)
	{
		String sql = "WITH RECURSIVE cte (root_id, parent_id, child_id) AS (\n"
				+ "\n"
				+ "	SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		acct_type l1_at\n"
				+ "	WHERE\n"
				+ "		parent_id {parent_id_val}\n"
				+ "		\n"
				+ "UNION ALL\n"
				+ "\n"
				+ "	SELECT\n"
				+ "		cte.root_id,\n"
				+ "		cte.child_id,\n"
				+ "		l1_at2.id\n"
				+ "	FROM\n"
				+ "		acct_type l1_at2\n"
				+ "	INNER JOIN \n"
				+ "		cte\n"
				+ "	ON \n"
				+ "		l1_at2.parent_id = cte.child_id\n"
				+ ")\n"
				+ "SELECT \n"
				+ "	acct_type.id,\n"
				+ "	acct_type.name,\n"
				+ "	IFNULL(SUM(dr),0) AS dr,\n"
				+ "	IFNULL(SUM(cr),0) AS cr\n"
				+ "FROM\n"
				+ "	acct_journal\n"
				+ "LEFT JOIN\n"
				+ "	acct\n"
				+ "ON	\n"
				+ "	acct.id = acct_journal.acct_id\n"
				+ "LEFT JOIN\n"
				+ "	cte\n"
				+ "ON\n"
				+ "	cte.child_id = acct.acct_type_id\n"
				+ "LEFT JOIN\n"
				+ "	acct_type\n"
				+ "ON\n"
				+ "	acct_type.id = cte.root_id\n";

		List<String> wheres = new ArrayList<>();

		wheres.add(String.format(" acct_type.id IS NOT NULL\n"));

		if (acctTypeId != null)
		{
			wheres.add(String.format("acct_type.id = %s\n", acctTypeId));
		}

		if (dateFrom != null)
		{
			wheres.add("date(acct_journal.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')\n");
		}
		if (dateTo != null)
		{
			wheres.add("date(acct_journal.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')\n");
		}

		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " GROUP BY\n"
				+ "	cte.root_id\n"
				+ "ORDER BY \n"
				+ "	acct_type.name";

		Map<String, String> map = new HashMap<>();
		if (parentAcctTypeId == null)
		{
			map.put("parent_id_val", " IS NULL");
		}
		else
		{
			map.put("parent_id_val", String.format(" = %s", parentAcctTypeId));
		}

		return Util.formatString(sql, map);
	}

	public String getSqlTrialBalanceByAcct(Integer parentAcctTypeId, Integer acctId, Date dateFrom, Date dateTo)
	{
		String sql = "SELECT \n"
				+ "	acct.id,\n"
				+ "	acct.name,\n"
				+ "	IFNULL(SUM(dr),0) AS dr,\n"
				+ "	IFNULL(SUM(cr),0) AS cr\n"
				+ "FROM\n"
				+ "	acct\n"
				+ "LEFT JOIN\n"
				+ "	acct_journal\n"
				+ "ON\n"
				+ "	acct.id = acct_journal.acct_id\n"
				+ "LEFT JOIN\n"
				+ "	acct_type\n"
				+ "ON	\n"
				+ "	acct_type.id = acct.acct_type_id\n";

		List<String> wheres = new ArrayList<>();

		if (parentAcctTypeId == null)
		{
			wheres.add("acct_type.id IS NULL ");
		}
		else
		{
			wheres.add(String.format(" acct_type.id = %s ", parentAcctTypeId));
		}

		if (acctId != null)
		{
			wheres.add(String.format(" acct.id = %s ", acctId));
		}

		if (dateFrom != null)
		{
			wheres.add("date(acct_journal.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(acct_journal.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}

		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " GROUP BY\n"
				+ "	acct.id\n"
				+ "ORDER BY \n"
				+ "	NAME";

		return sql;
	}

	private void deleteByVoucherId(int voucherId)
	{
		String sql = String.format(sqlDeleteByVoucherId,
				tableName,
				String.valueOf(voucherId));

		session.createNativeQuery(sql).executeUpdate();
	}

	private void deleteByAcctId(int acctId)
	{
		String sql = String.format(sqlDeleteByAcctId,
				tableName,
				String.valueOf(acctId));

		session.createNativeQuery(sql).executeUpdate();
	}

	public void delete(List<Integer> idsToBeDeleted)
	{
		if (idsToBeDeleted != null && !idsToBeDeleted.isEmpty())
		{
			List<String> wheres = new ArrayList<>();

			int[] ids = new int[idsToBeDeleted.size()];
			for (int i = 0; i < idsToBeDeleted.size(); i++)
			{
				ids[i] = idsToBeDeleted.get(i);
			}
			wheres.add(tableName + ".voucher_id IN (" + Util.getCSV(ids) + ")");

			String sql = String.format(sqlDelete, tableName);
			sql = SqlHelper.putWheres(wheres, sql);

			session.createNativeQuery(sql).executeUpdate();
		}
	}

	public AcctJournalSumHdto getAcctJournalSumHdto(Integer accountId, Date dateTo)
	{
		String sqlSum = String.format("SELECT\n"
				+ "	IFNULL(SUM(dr),0) as debit,\n"
				+ "	IFNULL(SUM(cr),0) as credit\n"
				+ "FROM\n"
				+ "	%s", tableName);

		List<String> wheres = new ArrayList<>();

		if (accountId != null)
		{
			wheres.add(tableName + ".acct_id=" + String.valueOf(accountId));
		}
		if (dateTo != null)
		{
			wheres.add(tableName + ".date<=DATE('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}

		String sql = SqlHelper.putWheres(wheres, sqlSum);
		List<AcctJournalSumHdto> results = session.createNativeQuery(sql, AcctJournalSumHdto.class).getResultList();

		return results == null || results.isEmpty() ? null : results.get(0);

	}

	public AcctJournalClrAmtsHdto getFirstUnclearEntry(int acctId, TxType voucherTxType, Date dateFrom, Date dateTo, Boolean mainVoucherOnly)
	{
		List<AcctJournalClrAmtsHdto> results = getUnclearEntries(acctId, voucherTxType, dateFrom, dateTo, true, mainVoucherOnly);
		return results == null || results.isEmpty() ? null : results.get(0);
	}

	public List<AcctJournalClrAmtsHdto> getUnclearEntries(
			int acctId,
			TxType voucherTxType,
			Date dateFrom,
			Date dateTo,
			Boolean isLimit,
			Boolean mainVoucherOnly)
	{
		String sql = "SELECT \n"
				+ "	{table_acct_journal}.*,\n"
				+ "	( \n"
				+ "		CASE WHEN dr IS NULL THEN \n"
				+ "			IFNULL(t_dr_sum.amt_clrd, 0)\n"
				+ "		ELSE\n"
				+ "			IFNULL(t_cr_sum.amt_clrd, 0)\n"
				+ "		END\n"
				+ "	) amt_clrd,\n"
				+ "	( \n"
				+ "		CASE WHEN dr IS NULL THEN \n"
				+ "			cr - IFNULL(t_dr_sum.amt_clrd, 0)\n"
				+ "		ELSE\n"
				+ "			dr - IFNULL(t_cr_sum.amt_clrd, 0)\n"
				+ "		END\n"
				+ "	) amt_unclrd\n"
				+ "FROM\n"
				+ "	{table_acct_journal}\n"
				+ "LEFT JOIN\n"
				+ "	{table_voucher}\n"
				+ "ON\n"
				+ "	{table_voucher}.id = {table_acct_journal}.voucher_id\n"
				+ "LEFT JOIN\n"
				+ "(\n"
				+ "	SELECT\n"
				+ "		IFNULL(SUM(amt),0) amt_clrd,\n"
				+ "		dr_voucher_id\n"
				+ "	FROM\n"
				+ "		{table_set_against}\n"
				+ "	GROUP BY\n"
				+ "		dr_voucher_id\n"
				+ ") t_dr_sum\n"
				+ "ON\n"
				+ "	{table_voucher}.id = t_dr_sum.dr_voucher_id\n"
				+ "LEFT JOIN\n"
				+ "(\n"
				+ "	SELECT\n"
				+ "		IFNULL(SUM(amt),0) amt_clrd,\n"
				+ "		cr_voucher_id\n"
				+ "	FROM\n"
				+ "		{table_set_against}\n"
				+ "	GROUP BY\n"
				+ "		cr_voucher_id\n"
				+ ") t_cr_sum\n"
				+ "ON\n"
				+ "	{table_voucher}.id = t_cr_sum.cr_voucher_id\n";

		List<String> wheres = new ArrayList<>();

		wheres.add("{table_acct_journal}.voucher_id IS NOT NULL\n");

		wheres.add("	-- Amount uncleared\n"
				+ "	( \n"
				+ "		CASE WHEN dr IS NULL THEN \n"
				+ "			cr - IFNULL(t_dr_sum.amt_clrd, 0)\n"
				+ "		ELSE\n"
				+ "			dr - IFNULL(t_cr_sum.amt_clrd, 0)\n"
				+ "		END\n"
				+ "	) > 0\n");

		wheres.add("{table_acct_journal}.acct_id = {acct_id}");

		/*
		if (mainVoucherOnly)
		{
			wheres.add(String.format("{table_voucher}.voucher_type_id IN (%s, %s, %s, %s)",
					VoucherType.SALES.getId(),
					VoucherType.SALES_RETURN.getId(),
					VoucherType.PURCHASE.getId(),
					VoucherType.PURCHASE_RETURN.getId()
			));
		}
		 */
		if (voucherTxType != null)
		{
			wheres.add("{table_acct_journal}.tx_type_id = {tx_type_id}");
		}
		if (dateFrom != null)
		{
			wheres.add("{table_voucher}.date >= date('{date_from}')");
		}
		if (dateTo != null)
		{
			wheres.add("{table_voucher}.date <= date('{date_to}')");
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<String> orderBys = new ArrayList<>();
		orderBys.add("{table_voucher}.date ASC");
		orderBys.add("{table_voucher}.no ASC");
		sql = SqlHelper.putOrderBys(orderBys, sql);

		if (isLimit != null && isLimit)
		{
			sql = sql + " LIMIT 1";
		}

		Map<String, String> map = new HashMap<>();
		map.put("table_acct_journal", TableName.ACCT_JOURNAL);
		map.put("table_voucher", TableName.VOUCHER);
		map.put("table_set_against", TableName.SET_AGAINST);

		map.put("acct_id", String.valueOf(acctId));
		if (voucherTxType != null)
		{
			map.put("tx_type_id", String.valueOf(voucherTxType.getId()));
		}
		if (dateFrom != null)
		{
			map.put("date_from", Util.dateToString(dateFrom, Util.Formats.DB_DATE));
		}
		if (dateTo != null)
		{
			map.put("date_to", Util.dateToString(dateTo, Util.Formats.DB_DATE));
		}
		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, AcctJournalClrAmtsHdto.class).getResultList();
	}

	public String getSqlVoucherIds(
			int acctId,
			Date dateFrom
	)
	{
		String sql = "SELECT \n"
				+ "	voucher_id\n"
				+ "FROM\n"
				+ "	{table_acct_journal}\n";

		List<String> wheres = new ArrayList<>();

		wheres.add(String.format("acct_id = %s", acctId));

		if (dateFrom != null)
		{
			wheres.add("date >= date('{date_from}')");
		}

		sql = SqlHelper.putWheres(wheres, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_acct_journal", TableName.ACCT_JOURNAL);

		map.put("acct_id", String.valueOf(acctId));
		if (dateFrom != null)
		{
			map.put("date_from", Util.dateToString(dateFrom, Util.Formats.DB_DATE));
		}
		return Util.formatString(sql, map);
	}

	public String getTableName()
	{
		return tableName;
	}

}
