package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import static com.hemsw.asasaapi.veenal.dao.gen.TaxCatDao.tableName;
import com.hemsw.asasaapi.veenal.dto.hdto.AcctListForCustomerHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.AcctListForSupplierHdto;
import com.hemsw.asasaapi.veenal.dto.ldto.AcctLdto;
import com.hemsw.asasaapi.veenal.enums.AccountType;
import com.hemsw.asasaapi.veenal.enums.ListMenu;
import com.hemsw.asasaapi.veenal.enums.SortOrderEnum;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.app.ColSettingModel;
import com.hemsw.asasaapi.veenal.model.gen.AcctModel;
import com.hemsw.asasaapi.veenal.model.gen.AcctTypeModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AcctDao
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	@Autowired
	private AcctJournalDao acctJournalDao;

	@Autowired
	private VoucherDao voucherDao;

	String sqlGet = "SELECT * FROM %s ORDER BY name";
	String sqlGetExcept = "SELECT * FROM %s WHERE id <> %s ORDER BY name;";

	//@Override
	public void create(AcctModel vObj, int createdByUserId)
	{
		vObj.setCreatedByUserId(createdByUserId);
		session.persist(vObj);

		VoucherModel voucherModel = voucherDao.generateVoucherModel(null, Util.stringToDate("1000-01-01", Util.Formats.DB_DATE), null, VoucherType.OPENING_BALANCE);
		voucherModel.setAcctId(vObj.getId());
		voucherModel.setCreatedByUserId(createdByUserId);
		voucherDao.create(voucherModel);

		acctJournalDao.create(vObj, voucherModel.getId());
	}

	//@Override
	public void update(AcctModel vObj)
	{
		VoucherModel voucherModel = voucherDao.getOb(vObj.getId());

		if (voucherModel == null)
		{
			voucherModel = voucherDao.generateVoucherModel(null, Util.stringToDate("1000-01-01", Util.Formats.DB_DATE), null, VoucherType.OPENING_BALANCE);
			voucherModel.setAcctId(vObj.getId());
			voucherDao.create(voucherModel);
		}

		acctJournalDao.update(vObj, voucherModel.getId());
	}

	public List<AcctLdto> getLdtos(String name, Integer acctTypeId, String acctType)
	{
		String sql = "SELECT\n"
				+ "	*\n"
				+ "FROM\n"
				+ "	(\n"
				+ "		SELECT	\n"
				+ "			{table_acct}.id,\n"
				+ "			{table_acct}.name,\n"
				+ "			{table_acct}.acct_type_id,\n"
				+ "			{table_acct_type}.name acct_type_name,\n"
				+ "			{table_acct}.ob_type_id,\n"
				+ "			{table_acct}.ob,\n"
				+ "			{table_acct}.clear_upto,\n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_acct}.created_at\n"
				+ "		FROM\n"
				+ "			{table_acct}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_acct_type}\n"
				+ "		ON\n"
				+ "			{table_acct}.acct_type_id = {table_acct_type}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_acct}.created_by_user_id\n"
				+ "	) t_final";

		List<String> wheres = new ArrayList<>();

		if (name != null && !name.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "name", SqlHelper.escape(name)));
		}
		if (acctTypeId != null)
		{
			wheres.add(String.format("%s = %s", "acct_type_id", acctTypeId));
		}
		if (acctType != null && !acctType.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "acct_type_name", SqlHelper.escape(acctType)));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<ColSettingModel> colSettingModels = colSettingDao.getByMenuIdForOrder(ListMenu.ACCT.getId(), true);

		List<String> orderBys = new ArrayList<>();
		for (ColSettingModel colSettingModel : colSettingModels)
		{
			orderBys.add(String.format("%s %s", colSettingModel.getColKey(), colSettingModel.getOrderByType().getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_acct", TableName.ACCT);
		map.put("table_acct_type", TableName.ACCT_TYPE);
		map.put("table_user", TableName.USER);
		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, AcctLdto.class).getResultList();
	}

	public List<AcctListForCustomerHdto> getAcctListForCustomerHdtos(Integer id)
	{
		String sql = "SELECT\n"
				+ "	acct.id,\n"
				+ "	acct.name,\n"
				+ "	address,\n"
				+ "	city,\n"
				+ "	state_id,\n"
				+ "	state.name state_name,\n"
				+ "	pin,\n"
				+ "	email,\n"
				+ "	gst_no,\n"
				+ "	bank_name,\n"
				+ "	bank_branch_name,\n"
				+ "	bank_acct_name,\n"
				+ "	bank_acct_no,\n"
				+ "	bank_ifsc,\n"
				+ "	credit_days,\n"
				+ "	credit_amt_limit,\n"
				+ "	disc,\n"
				+ "	pref_trans_id,\n"
				+ "	transporter.name pref_trans_name,\n"
				+ "	note,\n"
				+ "	overdue_days,\n"
				+ "	overdue_amt,\n"
				+ "	sum_debit,\n"
				+ "	sum_credit\n"
				+ "FROM\n"
				+ "	acct\n"
				+ "LEFT JOIN\n"
				+ "	customer\n"
				+ "ON\n"
				+ "	acct.id = customer.id\n"
				+ "LEFT JOIN\n"
				+ "	state\n"
				+ "ON\n"
				+ "	state.id = customer.state_id\n"
				+ "LEFT JOIN\n"
				+ "	transporter\n"
				+ "ON	\n"
				+ "	transporter.id = customer.pref_trans_id\n"
				+ "LEFT JOIN\n"
				+ "	(\n"
				+ "	SELECT	\n"
				+ "		sales.customer_id,\n"
				+ "		MAX(datediff(NOW(), voucher.date)) overdue_days,\n"
				+ "		IFNULL(SUM((sales.amt_payable - IFNULL(t1.amt_clrd, 0))),0) overdue_amt\n"
				+ "	FROM\n"
				+ "		sales\n"
				+ "	LEFT JOIN\n"
				+ "		voucher\n"
				+ "	ON\n"
				+ "		sales.id = voucher.id\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	LEFT JOIN\n"
				+ "		(\n"
				+ "			SELECT\n"
				+ "				SUM(amt) amt_clrd,\n"
				+ "				cr_voucher_id sales_id\n"
				+ "			FROM\n"
				+ "				set_against\n"
				+ "			GROUP BY\n"
				+ "				cr_voucher_id\n"
				+ "		) as t1\n"
				+ "	ON\n"
				+ "		t1.sales_id = sales.id\n"
				+ "	WHERE\n"
				+ "		datediff(NOW(), voucher.date) > IFNULL(customer.credit_days, 0)\n"
				+ "	AND\n"
				+ "		sales.amt_payable - IFNULL(t1.amt_clrd, 0) > 0\n"
				+ "	GROUP BY\n"
				+ "		sales.customer_id\n"
				+ ") t_overdue_detail\n"
				+ "ON	\n"
				+ "	t_overdue_detail.customer_id = acct.id\n"
				+ "LEFT JOIN\n"
				+ "	(\n"
				+ "	SELECT	\n"
				+ "		acct_id,\n"
				+ "		IFNULL(SUM(dr),0) as sum_debit,\n"
				+ "		IFNULL(SUM(cr),0) as sum_credit\n"
				+ "	FROM\n"
				+ "		acct_journal\n"
				+ "	GROUP BY\n"
				+ "		acct_id\n"
				+ ") t_acct_journal_sum_detail\n"
				+ "ON	\n"
				+ "	t_acct_journal_sum_detail.acct_id = acct.id\n";

		List<String> wheres = new ArrayList<>();

		if (id != null && id > 0)
		{
			wheres.add(String.format("acct.id = %s", id));
		}
		sql = SqlHelper.putWheres(wheres, sql);

		List<String> orderBys = new ArrayList<>();
		orderBys.add(String.format("%s %s", "TRIM(acct.name)", SortOrderEnum.ASC.getSqlName()));
		sql = SqlHelper.putOrderBys(orderBys, sql);

		return session.createNativeQuery(sql, AcctListForCustomerHdto.class).getResultList();
	}

	public List<AcctListForSupplierHdto> getAcctListForSupplierHdtos(Integer id)
	{
		String sql = "SELECT\n"
				+ "	acct.id,\n"
				+ "	acct.name,\n"
				+ "	name_to_print,\n"
				+ "	address,\n"
				+ "	city,\n"
				+ "	state_id,\n"
				+ "	state.name state_name,\n"
				+ "	pin,\n"
				+ "	gst_no,\n"
				+ "	credit_days\n"
				+ "FROM\n"
				+ "	acct\n"
				+ "LEFT JOIN\n"
				+ "	supplier\n"
				+ "ON\n"
				+ "	acct.id = supplier.id\n"
				+ "LEFT JOIN\n"
				+ "	state\n"
				+ "ON\n"
				+ "	state.id = supplier.state_id\n";

		List<String> wheres = new ArrayList<>();

		if (id != null && id > 0)
		{
			wheres.add(String.format("acct.id = %s", id));
		}
		sql = SqlHelper.putWheres(wheres, sql);

		List<String> orderBys = new ArrayList<>();
		orderBys.add(String.format("%s %s", "TRIM(acct.name)", SortOrderEnum.ASC.getSqlName()));
		sql = SqlHelper.putOrderBys(orderBys, sql);

		return session.createNativeQuery(sql, AcctListForSupplierHdto.class).getResultList();
	}

	//@Override
	public void delete(int id)
	{
		session.createNativeQuery(String.format(DaoHelper.DELETE_BY_ID_SQL, TableName.ACCT, id)).executeUpdate();
	}

	public void delete(AcctModel objBank)
	{
		acctJournalDao.delete(objBank);
		session.remove(objBank);
	}

	public boolean isUnder(int acctId, AccountType accountType)
	{
		String sql = "SELECT * from acct where acct_type_id IN ( \n"
				+ "	WITH RECURSIVE \n"
				+ "	  types(x) AS ( \n"
				+ "		 SELECT %s \n"
				+ "		 UNION ALL \n"
				+ "		 SELECT id FROM acct_type, types where parent_id in (types.x) \n"
				+ "	  ) \n"
				+ "	SELECT * FROM types \n"
				+ ") \n"
				+ "and \n"
				+ "	acct.id = %s";

		sql = String.format(sql,
				accountType.getId(),
				acctId
		);

		List<AcctModel> acctModels = session.createNativeQuery(sql, AcctModel.class).getResultList();

		return !(acctModels == null || acctModels.isEmpty());
	}

	public List<AcctModel> getUnder(int acctTypeId)
	{
		String sql = "SELECT * from acct where acct_type_id IN ( \n"
				+ "	WITH RECURSIVE \n"
				+ "	  types(x) AS ( \n"
				+ "		 SELECT %s \n"
				+ "		 UNION ALL \n"
				+ "		 SELECT id FROM acct_type, types where parent_id in (types.x) \n"
				+ "	  ) \n"
				+ "	SELECT * FROM types \n"
				+ ") ORDER BY name";

		sql = String.format(sql, acctTypeId);

		return session.createNativeQuery(sql, AcctModel.class).getResultList();
	}

	public List<AcctModel> getExcept(AcctModel acctTypeModel)
	{
		String sql = String.format(sqlGetExcept, tableName, acctTypeModel.getId());
		return session.createNativeQuery(sql, AcctModel.class).getResultList();
	}

	public List<AcctTypeModel> _getAccountTypesExceptBC()
	{
		String sql = "SELECT * FROM acct_type\n"
				+ "WHERE id NOT IN\n"
				+ "(\n"
				+ "	WITH RECURSIVE\n"
				+ "	  types(x) AS (\n"
				+ "		 VALUES (%s),(%s)\n"
				+ "		 UNION ALL\n"
				+ "		 SELECT id FROM acct_type, types where parent_id in (types.x)\n"
				+ "	  )\n"
				+ "	SELECT x FROM types\n"
				+ ")\n"
				+ "and\n"
				+ "id IN ( SELECT DISTINCT(acct_type_id) from acct )";

		sql = String.format(sql,
				AccountType.BANK_ACCOUNT.getId(),
				AccountType.CASH_ACCOUNT.getId());

		return session.createNativeQuery(sql, AcctTypeModel.class).getResultList();
	}

	public List<AcctTypeModel> _getAccountTypes()
	{
		String sql = "SELECT * FROM acct_type\n"
				+ "WHERE \n"
				+ "id IN ( SELECT DISTINCT(acct_type_id) from acct )";

		return session.createNativeQuery(sql, AcctTypeModel.class).getResultList();
	}

	public List<AcctModel> getAllExceptUnder(List<AccountType> accountTypes)
	{
		String sql = "SELECT * FROM acct\n"
				+ "WHERE acct_type_id NOT IN\n"
				+ "(\n"
				+ "	WITH RECURSIVE\n"
				+ "	  types(x) AS (\n"
				+ "		 VALUES %s\n"
				+ "		 UNION ALL\n"
				+ "		 SELECT id FROM acct_type, types where parent_id in (types.x)\n"
				+ "	  )\n"
				+ "	SELECT x FROM types\n"
				+ ")\n";

		String typeVal = "";
		for (int i = 0; i < accountTypes.size(); i++)
		{
			if (i > 0)
			{
				typeVal = typeVal + ", ";
			}

			typeVal = typeVal + "(" + accountTypes.get(i).getId() + ")";
		}

		sql = String.format(sql, typeVal);

		return session.createNativeQuery(sql, AcctModel.class).getResultList();
	}

	public AcctModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, getTableName(), String.valueOf(id));
		List<AcctModel> dtos = session.createNativeQuery(sql, AcctModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	//@Override
	public List<AcctModel> get()
	{
		String sql = String.format(sqlGet, tableName);
		return session.createNativeQuery(sql, AcctModel.class).getResultList();
	}

	public AcctModel getByName(String name)
	{
		String sql = String.format(DaoHelper.SELECT_BY_NAME_SQL, getTableName(), SqlHelper.escape(name));
		List<AcctModel> dtos = session.createNativeQuery(sql, AcctModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public boolean isMainAcct(int acctId)
	{
		String sql = "SELECT {acct_id} \n"
				+ "IN \n"
				+ "(\n"
				+ "	(SELECT id FROM {table_customer})\n"
				+ "	UNION\n"
				+ "	(SELECT id FROM {table_supplier})\n"
				+ ")";

		Map<String, String> map = new HashMap<>();
		map.put("table_customer", TableName.CUSTOMER);
		map.put("table_supplier", TableName.SUPPLIER);
		map.put("acct_id", String.valueOf(acctId));

		sql = Util.formatString(sql, map);
		List<Boolean> res = session.createNativeQuery(sql, Boolean.class).getResultList();
		return res.get(0);
	}

	public void deleteAll() throws SQLException
	{
		String sql = String.format(DaoHelper.DELETE_SQL, tableName);
		session.createNativeQuery(sql).executeUpdate();
	}

	public List<String> getNames(Integer acctTypeId)
	{
		String sql = String.format(DaoHelper.SELECT_NAME_SQL, tableName);
		List<String> wheres = new ArrayList<>();
		if (acctTypeId != null)
		{
			wheres.add(String.format("acct_type_id IN ( \n"
					+ "	WITH RECURSIVE \n"
					+ "	  types(x) AS ( \n"
					+ "		 SELECT %s \n"
					+ "		 UNION ALL \n"
					+ "		 SELECT id FROM acct_type, types where parent_id in (types.x) \n"
					+ "	  ) \n"
					+ "	SELECT * FROM types \n"
					+ ")\n", acctTypeId));
		}
		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " ORDER BY name";

		return session.createNativeQuery(sql, String.class).getResultList();
	}

	//@Override
	public String getTableName()
	{
		return tableName;
	}

	public void create(AcctModel acctModel)
	{
		session.persist(acctModel);
	}

	public AcctModel getById(long id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, TableName.ACCT, String.valueOf(id));
		List<AcctModel> unitModels = session.createNativeQuery(sql, AcctModel.class).getResultList();
		if (unitModels == null || unitModels.size() != 1)
		{
			return null;
		}

		return unitModels.get(0);
	}

	public boolean isNameExists(String name)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_acct} WHERE name = '%s'", SqlHelper.escape(name));
		Map<String, String> map = new HashMap<>();
		map.put("table_acct", "acct");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public boolean isIdExists(int id)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_acct} WHERE id = %s", id);
		Map<String, String> map = new HashMap<>();
		map.put("table_acct", TableName.ACCT);
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}
}
