package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.ldto.AgentLdto;
import com.hemsw.asasaapi.veenal.enums.AccountType;
import com.hemsw.asasaapi.veenal.enums.ListMenu;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.app.ColSettingModel;
import com.hemsw.asasaapi.veenal.model.gen.AgentModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AgentDao
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;
	public static final String tableName = "agent";
	String sqlGet = "SELECT * FROM %s ORDER BY name ASC";
	String sqlGetByType = "SELECT * FROM %s WHERE id IN (SELECT id FROM %s WHERE acct_type_id = %s) ORDER BY name ASC";

	public void create(AgentModel vObj)
	{
		session.persist(vObj);
	}

	public AgentModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, getTableName(), String.valueOf(id));
		List<AgentModel> dtos = session.createNativeQuery(sql, AgentModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public List<AgentModel> get()
	{
		String sql = String.format(sqlGet, tableName);
		return session.createNativeQuery(sql, AgentModel.class).getResultList();
	}

	public List<AgentLdto> getLdtos(
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
				+ "			{table_agent}.name_to_print,\n"
				+ "			{table_agent}.address,\n"
				+ "			{table_agent}.city,\n"
				+ "			{table_agent}.state_id,\n"
				+ "			{table_state}.name state_name,\n"
				+ "			{table_agent}.pin,\n"
				+ "			{table_agent}.email,\n"
				+ "			{table_agent}.gst_no,\n"
				+ "			{table_agent}.bank_name,\n"
				+ "			{table_agent}.bank_branch_name,\n"
				+ "			{table_agent}.bank_acct_name,\n"
				+ "			{table_agent}.bank_acct_no,\n"
				+ "			{table_agent}.bank_ifsc,\n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_acct}.created_at\n"
				+ "		FROM	\n"
				+ "			{table_acct}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_agent}\n"
				+ "		ON\n"
				+ "			{table_acct}.id = {table_agent}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_state}\n"
				+ "		ON\n"
				+ "			{table_agent}.state_id = {table_state}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_acct_type}\n"
				+ "		ON\n"
				+ "			{table_acct}.acct_type_id = {table_acct_type}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_acct}.created_by_user_id\n"
				+ "		WHERE\n"
				+ "			{table_acct}.acct_type_id IN (\n"
				+ "				WITH RECURSIVE \n"
				+ "					types(x) AS ( \n"
				+ "						SELECT {agent_acct_type_id} \n"
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

		List<ColSettingModel> colSettingModels = colSettingDao.getByMenuIdForOrder(ListMenu.AGENT.getId(), true);

		List<String> orderBys = new ArrayList<>();
		for (ColSettingModel colSettingModel : colSettingModels)
		{
			orderBys.add(String.format("%s %s", colSettingModel.getColKey(), colSettingModel.getOrderByType().getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_agent", tableName);
		map.put("table_acct", TableName.ACCT);
		map.put("table_acct_contact_no", TableName.ACCT_CONTACT_NO);
		map.put("table_acct_type", TableName.ACCT_TYPE);
		map.put("table_state", TableName.STATE);
		map.put("table_user", TableName.USER);

		map.put("agent_acct_type_id", String.valueOf(AccountType.AGENT.getId()));
		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, AgentLdto.class).getResultList();
	}

	public List<AgentModel> getOrderById()
	{
		String sql = String.format("SELECT * FROM %s ORDER BY id ASC", tableName);
		return session.createNativeQuery(sql, AgentModel.class).getResultList();
	}

	public void delete(int id)
	{
		session.createNativeQuery(String.format(DaoHelper.DELETE_BY_ID_SQL, TableName.AGENT, id)).executeUpdate();
	}

	public void delete(AgentModel objBank)
	{
		session.remove(objBank);
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
