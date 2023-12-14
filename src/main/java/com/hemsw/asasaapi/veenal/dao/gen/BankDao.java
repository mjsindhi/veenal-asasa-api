package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.ldto.BankLdto;
import com.hemsw.asasaapi.veenal.enums.ListMenu;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.app.ColSettingModel;
import com.hemsw.asasaapi.veenal.model.gen.BankModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankDao
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	String tableName = "bank";
	String sqlGet = "SELECT * FROM %s ORDER BY name";

	public void create(BankModel bankModel)
	{
		session.persist(bankModel);
	}

	public BankModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, getTableName(), String.valueOf(id));
		List<BankModel> dtos = session.createNativeQuery(sql, BankModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public BankModel getByName(String name)
	{
		String sql = String.format(DaoHelper.SELECT_BY_NAME_SQL, getTableName(), SqlHelper.escape(name));
		List<BankModel> dtos = session.createNativeQuery(sql, BankModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public List<BankLdto> getLdtos(String name)
	{
		String sql = "SELECT\n"
				+ "	*\n"
				+ "FROM\n"
				+ "	(\n"
				+ "		SELECT\n"
				+ "			{table_bank}.id,\n"
				+ "			{table_bank}.name,\n"
				+ "			{table_acct_type}.name acct_type_name,\n"
				+ "			{table_acct}.ob_type_id,\n"
				+ "			{table_acct}.ob,\n"
				+ "			{table_bank}.address,\n"
				+ "			{table_bank}.contact_no,\n"
				+ "			{table_bank}.ifsc,\n"
				+ "			{table_bank}.branch,\n"
				+ "			{table_bank}.note,\n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_acct}.created_at\n"
				+ "		FROM	\n"
				+ "			{table_bank}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_acct}\n"
				+ "		ON\n"
				+ "			{table_acct}.id = {table_bank}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_acct_type}\n"
				+ "		ON\n"
				+ "			{table_acct_type}.id = {table_acct}.acct_type_id\n"
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

		sql = SqlHelper.putWheres(wheres, sql);

		List<ColSettingModel> colSettingModels = colSettingDao.getByMenuIdForOrder(ListMenu.BANK.getId(), true);

		List<String> orderBys = new ArrayList<>();
		for (ColSettingModel colSettingModel : colSettingModels)
		{
			orderBys.add(String.format("%s %s", colSettingModel.getColKey(), colSettingModel.getOrderByType().getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_bank", tableName);
		map.put("table_acct", TableName.ACCT);
		map.put("table_acct_type", TableName.ACCT_TYPE);
		map.put("table_user", TableName.USER);
		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, BankLdto.class).getResultList();
	}

	public List<BankModel> get()
	{
		String sql = String.format(sqlGet, tableName);
		return session.createNativeQuery(sql, BankModel.class).getResultList();
	}

	public void delete(int id)
	{
		session.createNativeQuery(String.format(DaoHelper.DELETE_BY_ID_SQL, TableName.BANK, id)).executeUpdate();
	}

	public void delete(BankModel bankModel)
	{
		session.remove(bankModel);
	}

	public void deleteAll()
	{
		String sql = String.format("DELETE FROM %s", tableName);
		session.createNativeQuery(sql).executeUpdate();
	}

	public String getTableName()
	{
		return tableName;
	}

}
