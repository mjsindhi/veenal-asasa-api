package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dao.gen.AcctDao;
import com.hemsw.asasaapi.veenal.dao.gen.AcctJournalDao;
import com.hemsw.asasaapi.veenal.dao.gen.SetAgainstDao;
import com.hemsw.asasaapi.veenal.dao.gen.VoucherDao;
import com.hemsw.asasaapi.veenal.dto.hdto.AcctJournalClrAmtsHdto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetOneResDto;
import com.hemsw.asasaapi.veenal.dto.res.NextNoResDto;
import com.hemsw.asasaapi.veenal.enums.TxType;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.model.gen.SetAgainstModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class VoucherSer //extends BaseSer<VoucherModel>
{

	@Autowired
	VoucherDao voucherDao;

	@Autowired
	AcctDao acctDao;

	@Autowired
	SetAgainstDao setAgainstDao;

	@Autowired
	AcctJournalDao acctJournalDao;

	@Transactional
	public List<VoucherModel> get(Integer voucherTypeId)
	{
		List<VoucherModel> voucherModels = null;
		voucherModels = voucherDao.get(voucherTypeId);

		return voucherModels;
	}

	public void reclearVouchersForwardWayNonTx(
			int acctId,
			Date date)

	{

		if (acctDao.isMainAcct(acctId))
		{

			setAgainstDao.deleteByAcctDate(acctId, date);
			clearVouchersForwardWayNonTx(acctId, null);
		}
	}

	public void reclearVouchersForwardWayNonTx(
			int oldAcctId,
			Date oldDate,
			int newAcctId,
			Date newDate)

	{

		Date dateToSend = null;
		if (oldDate.getTime() < newDate.getTime())
		{
			dateToSend = oldDate;
		}
		else
		{
			dateToSend = newDate;
		}

		if (oldAcctId != newAcctId)
		{
			//old giver
			if (acctDao.isMainAcct(oldAcctId))
			{
				setAgainstDao.deleteByAcctDate(oldAcctId, oldDate);
				clearVouchersForwardWayNonTx(oldAcctId, null);
			}

			//new giver
			if (acctDao.isMainAcct(newAcctId))
			{

				setAgainstDao.deleteByAcctDate(newAcctId, dateToSend);
				clearVouchersForwardWayNonTx(newAcctId, null);
			}
		}
		else
		{
			if (acctDao.isMainAcct(newAcctId))
			{
				setAgainstDao.deleteByAcctDate(newAcctId, dateToSend);
				clearVouchersForwardWayNonTx(newAcctId, null);
			}
		}
	}

	private void _reclearVouchersForwardWayNonTx(
			int oldAcctId,
			Date oldDate,
			int newAcctId,
			Date newDate)

	{

		if (oldAcctId != newAcctId)
		{
			//old giver
			if (acctDao.isMainAcct(oldAcctId))
			{
				setAgainstDao.deleteByAcctDate(oldAcctId, oldDate);
				clearVouchersForwardWayNonTx(oldAcctId, null);
			}

			//new giver
			if (acctDao.isMainAcct(newAcctId))
			{
				setAgainstDao.deleteByAcctDate(newAcctId, newDate);
				clearVouchersForwardWayNonTx(newAcctId, null);
			}
		}
		else
		{
			Date fromDate;
			if (oldDate.getTime() < newDate.getTime())
			{
				fromDate = oldDate;
			}
			else
			{
				fromDate = newDate;
			}

			if (acctDao.isMainAcct(newAcctId))
			{
				setAgainstDao.deleteByAcctDate(newAcctId, fromDate);
				clearVouchersForwardWayNonTx(newAcctId, null);
			}
		}
	}

	// Voucher which is debit for us for example 
	// Purchase, Sales Return, Receipt, Journal
	private void clearVouchersForwardWayNonTx(int acctId, Date dateTo)
	{
		dateTo = null;

		CommVouPayableSer commVouPayableSer = new CommVouPayableSer();

		Date dateFrom = null;//Util.stringToDate("2021-04-12", Util.Formats.DB_DATE);
		//Date dateTo = null;//Util.stringToDate("2021-07-31", Util.Formats.DB_DATE);

		boolean run = true;
		while (run)
		{
			AcctJournalClrAmtsHdto unclearEntry = acctJournalDao.getFirstUnclearEntry(acctId, null, dateFrom, dateTo, true);

			if (unclearEntry == null)
			{
				run = false;
			}
			else
			{

				AcctJournalClrAmtsHdto oppositeUnclearEntry = null;
				if (unclearEntry.getTxType() == TxType.CR)
				{
					oppositeUnclearEntry = acctJournalDao.getFirstUnclearEntry(acctId, TxType.DR, dateFrom, dateTo, false);
				}
				else if (unclearEntry.getTxType() == TxType.DR)
				{
					oppositeUnclearEntry = acctJournalDao.getFirstUnclearEntry(acctId, TxType.CR, dateFrom, dateTo, false);
				}

				if (oppositeUnclearEntry == null)
				{
					run = false;
				}
				else
				{
					SetAgainstModel setAgainstModel = new SetAgainstModel();
					if (unclearEntry.getTxType() == TxType.CR)
					{
						setAgainstModel.setDrVoucherId(unclearEntry.getVoucherId());
						setAgainstModel.setCrVoucherId(oppositeUnclearEntry.getVoucherId());
					}
					else if (unclearEntry.getTxType() == TxType.DR)
					{
						setAgainstModel.setDrVoucherId(oppositeUnclearEntry.getVoucherId());
						setAgainstModel.setCrVoucherId(unclearEntry.getVoucherId());
					}

					if (unclearEntry.getAmtUnclrd().compareTo(oppositeUnclearEntry.getAmtUnclrd()) >= 0)
					{
						// Clear voucher
						setAgainstModel.setAmt(oppositeUnclearEntry.getAmtUnclrd());
					}
					else
					{
						setAgainstModel.setAmt(unclearEntry.getAmtUnclrd());
					}

					setAgainstDao.create(setAgainstModel);

					VoucherModel mainVoucherModel = voucherDao.getById(unclearEntry.getVoucherId());
					VoucherModel oppositeVoucherModel = voucherDao.getById(oppositeUnclearEntry.getVoucherId());

					if (oppositeVoucherModel.getVoucherType() == VoucherType.SALES)
					{
						commVouPayableSer.createNonTx(oppositeVoucherModel.getId(), setAgainstModel, mainVoucherModel.getId());
					}
					else if (mainVoucherModel.getVoucherType() == VoucherType.SALES)
					{
						commVouPayableSer.createNonTx(mainVoucherModel.getId(), setAgainstModel, oppositeVoucherModel.getId());
					}
				}
			}
		}
	}

	@Transactional
	public CommonGetOneResDto<NextNoResDto> getNextNo(VoucherType voucherType, Date date)
	{
		try
		{
			return new CommonGetOneResDto(new NextNoResDto(voucherDao.getNextNo(voucherType, date)));
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

	//
	public boolean checkIsValidCreate(VoucherModel voucher, StringBuilder errorMsg)
	{
		if (!checkIsValid(voucher, errorMsg))
		{
			return false;
		}

		return true;
	}

	//
	public boolean checkIsValidUpdate(VoucherModel voucher, StringBuilder errorMsg)
	{
		if (!checkIsValid(voucher, errorMsg))
		{
			return false;
		}

		return true;
	}

	//
	public boolean checkIsValid(VoucherModel voucher, StringBuilder errorMsg)
	{

		if (voucher == null)
		{
			errorMsg.append("Voucher dto is null");
			return false;
		}

		return true;
	}

	@Transactional
	public VoucherModel getById(int id)
	{
		VoucherModel voucherModel = null;
		voucherModel = voucherDao.getById(id);

		return voucherModel;
	}
}
