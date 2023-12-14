package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dao.gen.AcctJournalDao;
import com.hemsw.asasaapi.veenal.dao.gen.CommVouDao;
import com.hemsw.asasaapi.veenal.dao.gen.CommVouPayableDao;
import com.hemsw.asasaapi.veenal.dao.gen.JournalDao;
import com.hemsw.asasaapi.veenal.dao.gen.JournalItemDao;
import com.hemsw.asasaapi.veenal.dao.gen.SalesAgentDao;
import com.hemsw.asasaapi.veenal.dao.gen.SalesDao;
import com.hemsw.asasaapi.veenal.dao.gen.VoucherDao;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.helper.UserHelper;
import com.hemsw.asasaapi.veenal.model.gen.CommVouModel;
import com.hemsw.asasaapi.veenal.model.gen.CommVouPayableModel;
import com.hemsw.asasaapi.veenal.model.gen.JournalItemModel;
import com.hemsw.asasaapi.veenal.model.gen.JournalModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesAgentModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesModel;
import com.hemsw.asasaapi.veenal.model.gen.SetAgainstModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommVouPayableSer //extends BaseSer<CommVouPayableModel>
{

	@Autowired
	CommVouPayableDao commVouPayableDao;

	@Autowired
	CommVouDao commVouDao;

	@Autowired
	SalesDao salesDao;

	@Autowired
	AcctJournalDao acctJournalDao;

	@Autowired
	SalesAgentDao salesAgentDao;

	@Autowired
	VoucherDao voucherDao;

	@Autowired
	JournalDao journalDao;

	@Autowired
	JournalItemDao journalItemDao;

	public void createNonTx(int salesId, SetAgainstModel setAgainstModel, int receiptId)
	{

		SalesModel salesModel = salesDao.getById(salesId);

		List<SalesAgentModel> salesAgentModels = salesAgentDao.getBySalesId(salesId);

		if (salesAgentModels != null && !salesAgentModels.isEmpty())
		{
			for (SalesAgentModel salesAgentModel : salesAgentModels)
			{
				CommVouModel commVouModel = commVouDao.getBySalesIdAgentId(salesModel.getId(), salesAgentModel.getAgentId());

				if (commVouModel != null)
				{
					CommVouPayableModel commVouPayableModel;
					commVouPayableModel = commVouPayableDao.getBySetAgainstId(setAgainstModel.getId());
					if (commVouPayableModel == null)
					{
						commVouPayableModel = new CommVouPayableModel();
					}

					commVouPayableModel.setCommVouId(commVouModel.getId());
					commVouPayableModel.setSetAgainstId(setAgainstModel.getId());

					BigDecimal commPayableAmt = BigDecimal.ZERO;

					VoucherModel receiptVoucherModel = voucherDao.getById(receiptId);

					commPayableAmt = setAgainstModel.getAmt()
							.multiply(commVouModel.getEstimatedComm())
							.divide(salesModel.getAmtPayable(), 2, RoundingMode.HALF_UP);

					commVouPayableModel.setAmtPayableEstimated(commPayableAmt);

					commVouPayableModel.setAmt(BigDecimal.ZERO);

					if (receiptVoucherModel.getVoucherType() == VoucherType.RECEIPT)
					{
						commVouPayableModel.setAmt(commPayableAmt);
					}
					else if (receiptVoucherModel.getVoucherType() == VoucherType.JOURNAL)
					{
						JournalModel journalModel = journalDao.getById(receiptVoucherModel.getId());
						if (journalModel.isIsAddComm())
						{
							commVouPayableModel.setAmt(commPayableAmt);
						}
					}
					else if (receiptVoucherModel.getVoucherType() == VoucherType.JOURNAL_ITEM)
					{

						JournalItemModel journalItemModel = journalItemDao.getById(receiptVoucherModel.getId());
						JournalModel journalModel = journalDao.getById(journalItemModel.getJournalId());

						if (journalModel.isIsAddComm())
						{
							commVouPayableModel.setAmt(commPayableAmt);
						}
					}


					/*
				if (receiptVoucherModel.getVoucherType() == VoucherType.RECEIPT
						|| receiptVoucherModel.getVoucherType() == VoucherType.JOURNAL
						|| receiptVoucherModel.getVoucherType() == VoucherType.JOURNAL_ITEM)
				{
					commPayableAmt = setAgainstModel.getAmt()
							.multiply(commVouModel.getEstimatedComm())
							.divide(salesModel.getAmtPayable(), 2, RoundingMode.HALF_UP);
				}
				commVouPayableModel.setAmt(commPayableAmt);
					 */
					VoucherModel salesVoucherModel = voucherDao.getById(salesId);

					Date commVouPayableDate;
					if (salesVoucherModel.getDate().getTime() > receiptVoucherModel.getDate().getTime())
					{
						commVouPayableDate = salesVoucherModel.getDate();
					}
					else
					{
						commVouPayableDate = receiptVoucherModel.getDate();
					}

					commVouPayableDao.create(commVouPayableModel, commVouPayableDate, salesId, receiptId, UserHelper.getUserDetailsImpl().getUserModel().getId());
					acctJournalDao.create(commVouPayableModel, salesAgentModel.getAgentId(), commVouPayableDate);
				}
			}

		}
	}

	@Transactional
	public CommVouPayableModel getById(int id)
	{
		CommVouPayableModel commVouPayableModel = null;
		commVouPayableModel = commVouPayableDao.getById(id);

		return commVouPayableModel;
	}

}
