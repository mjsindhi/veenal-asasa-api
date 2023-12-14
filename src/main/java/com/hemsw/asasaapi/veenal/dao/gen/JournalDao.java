package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.ldto.JournalLdto;
import com.hemsw.asasaapi.veenal.enums.ListMenu;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.app.ColSettingModel;
import com.hemsw.asasaapi.veenal.model.gen.JournalModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JournalDao //extends BaseDao<JournalModel>
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	@Autowired
	private VoucherDao voucherDao;

	public static final String tableName = "journal";

	public void create(JournalModel journalModel, Date date, int createdByUserId)
	{

		VoucherModel voucherModel = voucherDao.generateVoucherModel(null, date, null, VoucherType.JOURNAL);
		voucherModel.setCreatedByUserId(createdByUserId);
		voucherDao.create(voucherModel);

		journalModel.setId(voucherModel.getId());
		session.persist(journalModel);
	}

	public void update(JournalModel journalModel, Date date)
	{

		VoucherModel voucherModel = voucherDao.getById(journalModel.getId());
		voucherModel.setDate(date);
	}

	//
	public String getTableName()
	{
		return tableName;
	}

	public JournalModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, tableName, String.valueOf(id));
		List<JournalModel> dtos = session.createNativeQuery(sql, JournalModel.class).getResultList();
		return dtos.isEmpty() ? null : dtos.get(0);

	}

	public List<JournalLdto> getLdtos(
			Integer no,
			Integer acctId,
			String acctName,
			Date dateFrom,
			Date dateTo)
	{

		String sql = "SELECT\n"
				+ "	*\n"
				+ "FROM\n"
				+ "	(\n"
				+ "		SELECT	\n"
				+ "			{table_journal}.id,\n"
				+ "			{table_voucher}.no,\n"
				+ "			{table_voucher}.date,\n"
				+ "			{table_journal}.tx_type_id,\n"
				+ "			{table_journal}.acct_id,\n"
				+ "			{table_acct}.name acct_name,\n"
				+ "			{table_journal}.note,\n"
				+ "			{table_journal}.amt,\n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_voucher}.created_at\n"
				+ "		FROM\n"
				+ "			{table_journal}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_voucher}\n"
				+ "		ON\n"
				+ "			{table_voucher}.id = {table_journal}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_acct}\n"
				+ "		ON\n"
				+ "			{table_acct}.id = {table_journal}.acct_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_voucher}.created_by_user_id\n"
				+ "	) t_final";

		List<String> wheres = new ArrayList<>();

		if (no != null)
		{
			wheres.add("no=" + String.valueOf(no));
		}
		if (acctId != null)
		{
			wheres.add("acct_id=" + acctId);
		}
		if (acctName != null && !acctName.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "acct_name", SqlHelper.escape(acctName)));
		}
		if (dateFrom != null)
		{
			wheres.add("date(date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<ColSettingModel> colSettingModels = colSettingDao.getByMenuIdForOrder(ListMenu.JOURNAL.getId(), true);

		List<String> orderBys = new ArrayList<>();
		for (ColSettingModel colSettingModel : colSettingModels)
		{
			orderBys.add(String.format("%s %s", colSettingModel.getColKey(), colSettingModel.getOrderByType().getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_journal", tableName);
		map.put("table_acct", TableName.ACCT);
		map.put("table_voucher", TableName.VOUCHER);
		map.put("table_user", TableName.USER);

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, JournalLdto.class).getResultList();
	}

	public List<Integer> getIds()
	{
		String sql = String.format(DaoHelper.SELECT_ID_SQL, tableName);
		sql = sql + " ORDER BY id";
		return session.createNativeQuery(sql, Integer.class).getResultList();
	}

	public void deleteAll()
	{
		String sql = String.format("DELETE FROM %s", tableName);
		session.createNativeQuery(sql).executeUpdate();
	}
}
