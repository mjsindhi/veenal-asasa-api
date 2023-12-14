package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.gen.SetAgainstModel;
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
public class SetAgainstDao
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	@Autowired
	private AcctJournalDao acctJournalDao;

	public static final String tableName = "set_against";

	/*
	private boolean _doTrigger(int voucherId)
	{
		VoucherModel voucherModel = new VoucherDao(miniOrm).getById(voucherId);
		switch (voucherModel.getVoucherType())
		{
			case SALES:
				SalesDao salesDao = new SalesDao(miniOrm);
				if (!salesDao.setDueAmt(voucherModel.getId()))
				{
					return false;
				}
				break;
			case PURCHASE:
				PurchaseDao purchaseDao = new PurchaseDao(miniOrm);
				if (!purchaseDao.setDueAmt(voucherModel.getId()))
				{
					return false;
				}
				break;
			case SALES_RETURN:
				SalesReturnDao salesreturnDao = new SalesReturnDao(miniOrm);
				if (!salesreturnDao.setDueAmt(voucherModel.getId()))
				{
					return false;
				}
				break;
			case PURCHASE_RETURN:
				PurchaseReturnDao purchasereturnDao = new PurchaseReturnDao(miniOrm);
				if (!purchasereturnDao.setDueAmt(voucherModel.getId()))
				{
					return false;
				}
				break;
			default:
				break;
		}
		return true;
	}
	 */
	public void create(SetAgainstModel setAgainstModel)
	{
		session.persist(setAgainstModel);
	}

	private void deleteByCrId1(int crId)
	{
		String sql = String.format("DELETE FROM %s", tableName);

		List<String> wheres = new ArrayList<>();
		wheres.add("cr_voucher_id=" + String.valueOf(crId));
		sql = SqlHelper.putWheres(wheres, sql);

		session.createNativeQuery(sql).executeUpdate();
	}

	private void deleteByDrId(int drId)
	{
		String sql = String.format("DELETE FROM %s", tableName);

		List<String> wheres = new ArrayList<>();
		wheres.add("dr_voucher_id=" + String.valueOf(drId));
		sql = SqlHelper.putWheres(wheres, sql);

		session.createNativeQuery(sql).executeUpdate();
	}

	private void deleteByCrIds(List<Integer> crIds)
	{
		String sql = String.format("DELETE FROM %s", tableName);
		List<String> wheres = new ArrayList<>();

		if (crIds != null && !crIds.isEmpty())
		{
			int[] nos = new int[crIds.size()];
			for (int i = 0; i < crIds.size(); i++)
			{
				nos[i] = crIds.get(i);
			}
			wheres.add(String.format("cr_voucher_id IN (%s)", Util.getCSV(nos)));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		session.createNativeQuery(sql).executeUpdate();
	}

	private void deleteByDrIds(List<Integer> drIds)
	{
		String sql = String.format("DELETE FROM %s", tableName);
		List<String> wheres = new ArrayList<>();

		if (drIds != null && !drIds.isEmpty())
		{
			int[] nos = new int[drIds.size()];
			for (int i = 0; i < drIds.size(); i++)
			{
				nos[i] = drIds.get(i);
			}
			wheres.add(String.format("dr_voucher_id IN (%s)", Util.getCSV(nos)));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		session.createNativeQuery(sql).executeUpdate();
	}

	public void deleteExtra(Integer drVoucherId, Integer crVoucherId, List<SetAgainstModel> setAgainstModels)
	{
		String sql = String.format("DELETE FROM %s", tableName);
		List<String> wheres = new ArrayList<>();

		if (crVoucherId != null)
		{
			wheres.add("cr_voucher_id=" + String.valueOf(crVoucherId));
		}

		if (drVoucherId != null)
		{
			wheres.add("dr_voucher_id=" + String.valueOf(drVoucherId));
		}

		if (setAgainstModels != null && !setAgainstModels.isEmpty())
		{
			int[] nos = new int[setAgainstModels.size()];
			for (int i = 0; i < setAgainstModels.size(); i++)
			{
				nos[i] = setAgainstModels.get(i).getId();
			}
			wheres.add(String.format("%s.id NOT IN (%s)", tableName, Util.getCSV(nos)));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		session.createNativeQuery(sql).executeUpdate();

		deleteRelatedRecords();
	}

	public void deleteAll()
	{
		String sql = String.format("DELETE FROM %s", tableName);
		session.createNativeQuery(sql).executeUpdate();

		deleteRelatedRecords();
	}

	public List<SetAgainstModel> get()
	{
		String sql = String.format(DaoHelper.SELECT_SQL, tableName);
		return session.createNativeQuery(sql, SetAgainstModel.class).getResultList();
	}

	public List<SetAgainstModel> getNew(Integer drVoucherId, Integer crVoucherId)
	{
		String sql = String.format("SELECT * FROM %s", tableName);
		List<String> wheres = new ArrayList<>();

		if (drVoucherId != null)
		{
			wheres.add("dr_voucher_id=" + String.valueOf(drVoucherId));
		}
		if (crVoucherId != null)
		{
			wheres.add("cr_voucher_id=" + String.valueOf(crVoucherId));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		//sql = sql + " ORDER BY " + tableName + ".no DESC";
		return session.createNativeQuery(sql, SetAgainstModel.class).getResultList();
	}

	public BigDecimal getSumNew(Integer drVoucherId, Integer crVoucherId)
	{
		String sql = String.format("SELECT SUM(amt) FROM %s", tableName);
		List<String> wheres = new ArrayList<>();

		if (drVoucherId != null)
		{
			wheres.add("dr_voucher_id=" + String.valueOf(drVoucherId));
		}
		if (crVoucherId != null)
		{
			wheres.add("cr_voucher_id=" + String.valueOf(crVoucherId));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<BigDecimal> rows = session.createNativeQuery(sql, BigDecimal.class).getResultList();

		if (rows == null || rows.isEmpty() || rows.get(0) == null)
		{
			return BigDecimal.ZERO;
		}
		return rows.get(0);
	}

	public void deleteByAcctDate(int acctId, Date dateFrom)
	{
		String sql = "DELETE\n"
				+ "FROM\n"
				+ "	{table_set_against}\n"
				+ "WHERE\n"
				+ "	dr_voucher_id IN ({sql_part_1})\n"
				+ "OR\n"
				+ "	cr_voucher_id IN ({sql_part_1})";

		Map<String, String> map = new HashMap<>();
		map.put("table_acct_journal", TableName.ACCT_JOURNAL);
		map.put("table_set_against", TableName.SET_AGAINST);
		map.put("sql_part_1", acctJournalDao.getSqlVoucherIds(acctId, dateFrom));

		sql = Util.formatString(sql, map);

		session.createNativeQuery(sql).executeUpdate();

		deleteRelatedRecords();
	}

	private void deleteRelatedRecords()
	{
		String sql;
		sql = String.format("DELETE FROM %s", TableName.VOUCHER);
		List<String> wheres = new ArrayList<>();
		wheres.add(String.format("voucher_type_id=%s", VoucherType.CASH_DISC_VOU.getId()));
		wheres.add(String.format("id NOT IN (SELECT id FROM %s)", TableName.CASH_DISC_VOU));
		sql = SqlHelper.putWheres(wheres, sql);
		session.createNativeQuery(sql).executeUpdate();

		sql = String.format("DELETE FROM %s", TableName.VOUCHER);
		wheres = new ArrayList<>();
		wheres.add(String.format("voucher_type_id=%s", VoucherType.COMM_VOU_PAYABLE.getId()));
		wheres.add(String.format("id NOT IN (SELECT id FROM %s)", TableName.COMM_VOU_PAYABLE));
		sql = SqlHelper.putWheres(wheres, sql);
		session.createNativeQuery(sql).executeUpdate();
	}

	public String getTableName()
	{
		return tableName;
	}

}
