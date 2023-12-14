package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.gen.CommVouPayableModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommVouPayableDao //extends BaseDao<CommVouPayableModel>
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	@Autowired
	private VoucherDao voucherDao;

	public static final String tableName = "comm_vou_payable";

	public void create(CommVouPayableModel commVouPayableModel, Date date, int salesId, int receiptId,
			int createdByUserId)
	{

		VoucherModel voucherModel = voucherDao.generateVoucherModel(null, date, salesId, VoucherType.COMM_VOU_PAYABLE);
		voucherModel.setParentId(salesId);
		voucherModel.setParentId2(receiptId);
		voucherModel.setCreatedByUserId(createdByUserId);
		voucherDao.create(voucherModel);

		commVouPayableModel.setId(voucherModel.getId());
		session.persist(commVouPayableModel);
	}

	public void update(CommVouPayableModel commVouPayableModel, Date date)
	{

		VoucherModel voucherModel = voucherDao.getById(commVouPayableModel.getId());
		voucherModel.setDate(date);

	}

	//
	public String getTableName()
	{
		return tableName;
	}

	public List<CommVouPayableModel> get(Integer fromAccountId, Integer toAccountId, Date dateFrom, Date dateTo)
	{
		String sql = String.format("SELECT * FROM %s", tableName);
		List<String> wheres = new ArrayList<>();

		if (fromAccountId != null)
		{
			wheres.add(tableName + ".from_acct_id=" + fromAccountId);
		}
		if (toAccountId != null)
		{
			wheres.add(tableName + ".to_acct_id=" + fromAccountId);
		}
		if (dateFrom != null)
		{
			wheres.add("date(" + tableName + ".date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(" + tableName + ".date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}

		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " ORDER BY date desc";

		return session.createNativeQuery(sql, CommVouPayableModel.class).getResultList();
	}

	//
	public List<CommVouPayableModel> get()
	{
		String sql = String.format("SELECT * FROM %s ORDER BY date(date) DESC", getTableName());
		return session.createNativeQuery(sql, CommVouPayableModel.class).getResultList();
	}

	public List<CommVouPayableModel> getAllOrderById()
	{
		String sql = String.format("SELECT * FROM %s", tableName);
		sql = sql + " ORDER BY id ASC";
		return session.createNativeQuery(sql, CommVouPayableModel.class).getResultList();
	}

	public CommVouPayableModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, tableName, String.valueOf(id));
		List<CommVouPayableModel> dtos = session.createNativeQuery(sql, CommVouPayableModel.class).getResultList();
		return dtos.isEmpty() ? null : dtos.get(0);
	}

	public CommVouPayableModel getBySetAgainstId(int setAgainstId)
	{
		String sql = String.format("SELECT * FROM %s", tableName);
		List<String> wheres = new ArrayList<>();
		wheres.add("set_against_id=" + setAgainstId);
		sql = SqlHelper.putWheres(wheres, sql);
		List<CommVouPayableModel> dtos = session.createNativeQuery(sql, CommVouPayableModel.class).getResultList();
		return dtos.isEmpty() ? null : dtos.get(0);

	}

}
