package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoucherDao
{

	@PersistenceContext
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	public static String tableName = "voucher";
	String sqlGetNexNo = "SELECT MAX(no) FROM %s WHERE voucher_type_id = %s;";
	String sqlDeleteByParentId = "DELETE FROM %s WHERE parent_id = %s;";
	String sqlDeleteExtrasByParentId = "DELETE FROM %s WHERE voucher_type_id = %s AND parent_id = %s AND id NOT IN (%s)";

	public void create(VoucherModel voucherModel)
	{
		session.persist(voucherModel);
	}

	public String getNextNo(VoucherType voucherType, Date date)
	{
		String sql = String.format("SELECT IFNULL(MAX(CAST(NO AS UNSIGNED)),0) FROM %s", tableName);

		List<String> wheres = new ArrayList<>();
		wheres.add(String.format("voucher_type_id=%s", voucherType.getId()));

		if (voucherType == VoucherType.SALES
				&& date != null
				&& date.getTime() >= Util.stringToDate("2022-01-05", Util.Formats.DB_DATE).getTime())
		{
			wheres.add(String.format("date(date) >= date('%s')", "2022-01-05"));
		}

		if (voucherType == VoucherType.SALES)
		{
			//wheres.add("date>=date('2021-12-28')");
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<String> integers = session.createNativeQuery(sql, String.class).getResultList();

		if (integers == null || integers.get(0) == null || !Util.isInt(integers.get(0)))
		{
			return "";
		}

		return String.valueOf(Integer.parseInt(integers.get(0)) + 1);
	}

	public List<VoucherModel> get(Integer voucherTypeId)
	{
		String sql = String.format("SELECT * FROM %s", tableName);
		List<String> wheres = new ArrayList<>();

		if (voucherTypeId != null)
		{
			wheres.add(tableName + ".voucher_type_id=" + String.valueOf(voucherTypeId));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " ORDER BY " + tableName + ".date ASC, no ASC";

		return session.createNativeQuery(sql, VoucherModel.class).getResultList();
	}

	public VoucherModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, tableName, String.valueOf(id));
		List<VoucherModel> dtos = session.createNativeQuery(sql, VoucherModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	/*
	* Main vouchers such as payment sales receipt for main accounts such as customer supplier etc
	 */
	public String getSqlForMainVouIdsByMainAcctId(int acctId, Date dateFrom)
	{
		String sql = "SELECT	\n"
				+ "	id\n"
				+ "FROM\n"
				+ "	{table_voucher}\n";

		List<String> wheres = new ArrayList<>();

		wheres.add("	(\n"
				+ "id IN\n"
				+ "(\n"
				+ "	(SELECT id FROM {table_purchase} WHERE supplier_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_purchase_return} WHERE supplier_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_sales} WHERE customer_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_sales_return} WHERE customer_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_payment} WHERE to_acct_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_receipt} WHERE from_acct_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_journal} WHERE acct_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_journal_item} WHERE acct_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_comm_vou_payable} WHERE acct_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_cdp_journal_vou} WHERE customer_acct_id = {acct_id})\n"
				+ ")\n"
				+ "OR\n"
				+ "	acct_id = {acct_id}\n"
				+ ")\n");

		if (dateFrom != null)
		{
			wheres.add(" date >= date('{date_from}')\n");
		}

		sql = SqlHelper.putWheres(wheres, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_voucher", TableName.VOUCHER);
		map.put("table_purchase", TableName.PURCHASE);
		map.put("table_purchase_return", TableName.PURCHASE_RETURN);
		map.put("table_sales", TableName.SALES);
		map.put("table_sales_return", TableName.SALES_RETURN);
		map.put("table_payment", TableName.PAYMENT);
		map.put("table_receipt", TableName.RECEIPT);
		map.put("table_journal", TableName.JOURNAL);
		map.put("table_journal_item", TableName.JOURNAL_ITEM);
		map.put("table_comm_vou_payable", TableName.COMM_VOU_PAYABLE);
		map.put("table_cdp_journal_vou", TableName.CDP_JOURNAL_VOU);

		map.put("acct_id", String.valueOf(acctId));
		if (dateFrom != null)
		{
			map.put("date_from", Util.dateToString(dateFrom, Util.Formats.DB_DATE));
		}

		return Util.formatString(sql, map);
	}

	public List<Integer> _getIdsByAcctId(int acctId, Date dateFrom)
	{
		String sql = "SELECT	\n"
				+ "	id\n"
				+ "FROM\n"
				+ "	{table_voucher}\n";

		List<String> wheres = new ArrayList<>();

		wheres.add("	(\n"
				+ "id IN\n"
				+ "(\n"
				+ "	(SELECT id FROM {table_purchase} WHERE supplier_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_purchase_return} WHERE supplier_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_sales} WHERE customer_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_sales_return} WHERE customer_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_payment} WHERE to_acct_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_receipt} WHERE from_acct_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_journal} WHERE acct_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_journal_item} WHERE acct_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_comm_vou_payable} WHERE acct_id = {acct_id})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_cdp_journal_vou} WHERE customer_acct_id = {acct_id})\n"
				+ ")\n"
				+ "OR\n"
				+ "	acct_id = {acct_id}\n"
				+ ")\n");

		if (dateFrom != null)
		{
			wheres.add(" date >= date('{date_from}')\n");
		}

		sql = SqlHelper.putWheres(wheres, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_voucher", TableName.VOUCHER);
		map.put("table_purchase", TableName.PURCHASE);
		map.put("table_purchase_return", TableName.PURCHASE_RETURN);
		map.put("table_sales", TableName.SALES);
		map.put("table_sales_return", TableName.SALES_RETURN);
		map.put("table_payment", TableName.PAYMENT);
		map.put("table_receipt", TableName.RECEIPT);
		map.put("table_journal", TableName.JOURNAL);
		map.put("table_journal_item", TableName.JOURNAL_ITEM
		);
		map.put("table_comm_vou_payable", TableName.COMM_VOU_PAYABLE);
		map.put("table_cdp_journal_vou", TableName.CDP_JOURNAL_VOU);

		map.put("acct_id", String.valueOf(acctId));
		if (dateFrom != null)
		{
			map.put("date_from", Util.dateToString(dateFrom, Util.Formats.DB_DATE));
		}

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, Integer.class).getResultList();
	}

	public VoucherModel getByNo(String no, VoucherType voucherType)
	{
		String sql = String.format("SELECT * FROM %s", tableName);
		List<String> wheres = new ArrayList<>();

		wheres.add(String.format("no='%s'", no));
		wheres.add(String.format("voucher_type_id=%s", voucherType.getId()));

		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " ORDER BY " + tableName + ".date ASC, no ASC";

		List<VoucherModel> voucherModels = session.createNativeQuery(sql, VoucherModel.class).getResultList();

		return voucherModels == null || voucherModels.isEmpty() ? null : voucherModels.get(0);
	}

	public VoucherModel getOb(int acctId)
	{
		String sql = String.format("SELECT * FROM %s", tableName);
		List<String> wheres = new ArrayList<>();

		wheres.add(String.format("acct_id=%s", acctId));
		wheres.add(String.format("date=date('%s')", "1000-01-01"));

		sql = SqlHelper.putWheres(wheres, sql);

		List<VoucherModel> voucherModels = session.createNativeQuery(sql, VoucherModel.class).getResultList();
		return voucherModels == null || voucherModels.isEmpty() ? null : voucherModels.get(0);
	}

	public VoucherModel generateVoucherModel(String no, Date date, Integer parentId, VoucherType voucherType)
	{
		VoucherModel voucherModel = new VoucherModel();

		if (no == null)
		{
			voucherModel.setNo(getNextNo(voucherType, date));
		}
		else
		{
			voucherModel.setNo(no);
		}
		voucherModel.setDate(date);
		voucherModel.setVoucherType(voucherType);
		voucherModel.setParentId(parentId);

		return voucherModel;
	}

	public void delete(int id)
	{
		session.createNativeQuery(String.format(DaoHelper.DELETE_BY_ID_SQL, TableName.VOUCHER, id)).executeUpdate();
	}

	public void deleteByParentId(int parentId)
	{
		String sql = String.format(sqlDeleteByParentId, parentId);
		session.createNativeQuery(sql).executeUpdate();
	}

	public void deleteExtrasByParentId(VoucherType voucherType, int parentId, int[] idsToExclude)
	{
		String sql = String.format(sqlDeleteExtrasByParentId, tableName, voucherType.getId(), parentId, Util.getCSV(idsToExclude));
		session.createNativeQuery(sql).executeUpdate();
	}

	//
	public String getTableName()
	{
		return tableName;
	}

}
