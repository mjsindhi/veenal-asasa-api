package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.ldto.SupplierLdto;
import com.hemsw.asasaapi.veenal.enums.AccountType;
import com.hemsw.asasaapi.veenal.model.gen.SupplierModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SupplierDao
{

	@Autowired
	private EntityManager session;

	public void create(SupplierModel supplierModel)
	{
		session.persist(supplierModel);
	}

	public boolean isIdExists(int id)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_supplier} WHERE id = %s", id);
		Map<String, String> map = new HashMap<>();
		map.put("table_supplier", TableName.SUPPLIER);
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public boolean isNameExists(String name)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_supplier} WHERE name = '%s'", SqlHelper.escape(name));
		Map<String, String> map = new HashMap<>();
		map.put("table_supplier", "supplier");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public List<SupplierLdto> getLdtos(
			String name,
			String city,
			Integer stateId,
			String state,
			String no
	)
	{
		String sql = "SELECT\n"
				+ "	*\n"
				+ "FROM\n"
				+ "	(\n"
				+ "		SELECT\n"
				+ "			{table_acct}.id,\n"
				+ "			{table_acct}.name,\n"
				+ "			{table_acct_type}.name acct_type_name,\n"
				+ "			{table_acct}.ob_type_id,\n"
				+ "			{table_acct}.ob,\n"
				+ "			{table_supplier}.address,\n"
				+ "			{table_supplier}.city,\n"
				+ "			{table_supplier}.state_id,\n"
				+ "			{table_state}.name state_name,\n"
				+ "			{table_supplier}.pin,\n"
				+ "			{table_supplier}.email,\n"
				+ "			{table_supplier}.gst_no,\n"
				+ "			{table_supplier}.bank_name,\n"
				+ "			{table_supplier}.bank_branch_name,\n"
				+ "			{table_supplier}.bank_acct_name,\n"
				+ "			{table_supplier}.bank_acct_no,\n"
				+ "			{table_supplier}.bank_ifsc,\n"
				+ "			{table_supplier}.credit_days,\n"
				+ "			{table_supplier}.delivery_days,\n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_acct}.created_at\n"
				+ "		FROM	\n"
				+ "			{table_acct}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_supplier}\n"
				+ "		ON\n"
				+ "			{table_acct}.id = {table_supplier}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_acct_type}\n"
				+ "		ON\n"
				+ "			{table_acct_type}.id = {table_acct}.acct_type_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_state}\n"
				+ "		ON\n"
				+ "			{table_supplier}.state_id = {table_state}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_acct}.created_by_user_id\n"
				+ "		WHERE\n"
				+ "			{table_acct}.acct_type_id IN (\n"
				+ "				WITH RECURSIVE \n"
				+ "					types(x) AS ( \n"
				+ "						SELECT {supplier_acct_type_id} \n"
				+ "						UNION ALL \n"
				+ "						SELECT id FROM acct_type, types where parent_id in (types.x) \n"
				+ "					)\n"
				+ "					SELECT * FROM types \n"
				+ "				)\n"
				+ "	) t1";

		List<String> wheres = new ArrayList<>();

		if (name != null && !name.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "name", SqlHelper.escape(name)));
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "city", SqlHelper.escape(city)));
		}
		if (stateId != null)
		{
			wheres.add(String.format("%s = %s", "state_id", stateId));
		}
		if (state != null && !state.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "state_name", SqlHelper.escape(state)));
		}
		if (no != null && !no.isEmpty())
		{
			wheres.add(String.format("%s IN (\n"
					+ "	SELECT\n"
					+ "		acct_id\n"
					+ "	FROM\n"
					+ "		{table_acct_contact_no}\n"
					+ "	WHERE\n"
					+ "		no LIKE '%%%s%%'\n"
					+ ")", "id", no));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_supplier", TableName.SUPPLIER);
		map.put("table_acct", TableName.ACCT);
		map.put("table_acct_contact_no", TableName.ACCT_CONTACT_NO);
		map.put("table_acct_type", TableName.ACCT_TYPE);
		map.put("table_state", TableName.STATE);
		map.put("table_user", TableName.USER);

		map.put("supplier_acct_type_id", String.valueOf(AccountType.SUPPLIER.getId()));
		sql = Util.formatString(sql, map);

		List<SupplierLdto> supplierLdtos = session
				.createNativeQuery(sql, SupplierLdto.class)
				.getResultList();

		return supplierLdtos;
	}
}
