package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.ldto.CustomerLdto;
import com.hemsw.asasaapi.veenal.enums.AccountType;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.gen.CustomerModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDao
{

	@Autowired
	private EntityManager session;

	public void create(CustomerModel customerModel)
	{
		session.persist(customerModel);
	}

	public boolean isNameExists(String name)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_customer} WHERE name = '%s'", SqlHelper.escape(name));
		Map<String, String> map = new HashMap<>();
		map.put("table_customer", "customer");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public List<CustomerLdto> getLdtos(
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
				+ "			{table_customer}.address,\n"
				+ "			{table_customer}.city,\n"
				+ "			{table_customer}.state_id,\n"
				+ "			{table_state}.name state_name,\n"
				+ "			{table_customer}.pin,\n"
				+ "			{table_customer}.email,\n"
				+ "			{table_customer}.gst_no,\n"
				+ "			{table_customer}.bank_name,\n"
				+ "			{table_customer}.bank_branch_name,\n"
				+ "			{table_customer}.bank_acct_name,\n"
				+ "			{table_customer}.bank_acct_no,\n"
				+ "			{table_customer}.bank_ifsc,\n"
				+ "			{table_customer}.credit_days,\n"
				+ "			{table_customer}.credit_amt_limit,\n"
				+ "			{table_customer}.pref_trans_id,\n"
				+ "			{table_transporter}.name pref_trans_name,\n"
				+ "			{table_customer}.pref_agent_id,\n"
				+ "			t_acct_pref_agent.name pref_agent_name,\n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_acct}.created_at\n"
				+ "		FROM	\n"
				+ "			{table_acct}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_customer}\n"
				+ "		ON\n"
				+ "			{table_acct}.id = {table_customer}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_acct_type}\n"
				+ "		ON\n"
				+ "			{table_acct_type}.id = {table_acct}.acct_type_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_acct} t_acct_pref_agent\n"
				+ "		ON\n"
				+ "			t_acct_pref_agent.id = {table_customer}.pref_agent_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_state}\n"
				+ "		ON\n"
				+ "			{table_customer}.state_id = {table_state}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_transporter}\n"
				+ "		ON\n"
				+ "			{table_transporter}.id = {table_customer}.pref_trans_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_acct}.created_by_user_id\n"
				+ "		WHERE\n"
				+ "			{table_acct}.acct_type_id IN (\n"
				+ "				WITH RECURSIVE \n"
				+ "					types(x) AS ( \n"
				+ "						SELECT {customer_acct_type_id} \n"
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
		map.put("table_customer", TableName.CUSTOMER);
		map.put("table_acct", TableName.ACCT);
		map.put("table_acct_contact_no", TableName.ACCT_CONTACT_NO);
		map.put("table_acct_type", TableName.ACCT_TYPE);
		map.put("table_state", TableName.STATE);
		map.put("table_transporter", TableName.TRANSPORTER);
		map.put("table_user", TableName.USER);

		map.put("customer_acct_type_id", String.valueOf(AccountType.CUSTOMER.getId()));
		sql = Util.formatString(sql, map);

		List<CustomerLdto> customerLdtos = session
				.createNativeQuery(sql, CustomerLdto.class)
				.getResultList();

		return customerLdtos;
	}

	public void delete(int id)
	{
		session.createNativeQuery(String.format(DaoHelper.DELETE_BY_ID_SQL, TableName.CUSTOMER, id)).executeUpdate();
	}

	public void delete(CustomerModel customerModel)
	{
		session.remove(customerModel);
	}

	public void deleteAll()
	{
		String sql = String.format("DELETE FROM %s", TableName.CUSTOMER);
		session.createNativeQuery(sql).executeUpdate();
	}
}
