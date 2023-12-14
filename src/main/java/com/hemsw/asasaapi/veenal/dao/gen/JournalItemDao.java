package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.gen.JournalItemModel;
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
public class JournalItemDao //extends BaseDao<JournalItemModel>
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	@Autowired
	private VoucherDao voucherDao;

	public static final String tableName = "journal_item";

	public void create(JournalItemModel journalItemModel, Date date, int parentId, int createdByUserId)
	{

		VoucherModel voucherModel = voucherDao.generateVoucherModel(null, date, parentId, VoucherType.JOURNAL_ITEM);
		voucherModel.setCreatedByUserId(createdByUserId);
		voucherDao.create(voucherModel);

		journalItemModel.setId(voucherModel.getId());
		session.persist(journalItemModel);
	}

	public void update(JournalItemModel journalItemModel, Date date)
	{

		VoucherModel voucherModel = voucherDao.getById(journalItemModel.getId());
		voucherModel.setDate(date);
	}

	public JournalItemModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, tableName, String.valueOf(id));
		List<JournalItemModel> dtos = session.createNativeQuery(sql, JournalItemModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public List<JournalItemModel> getByJournalId(int journalId)
	{
		String sql = String.format("SELECT * FROM %s", tableName);
		List<String> conditions = new ArrayList<>();
		conditions.add(String.format("%s = '%s'", "journal_id", journalId));
		sql = SqlHelper.putWheres(conditions, sql);
		sql = sql + " ORDER BY id";
		return session.createNativeQuery(sql, JournalItemModel.class).getResultList();
	}

	public void deleteExtra(int acctId, List<JournalItemModel> journalItemModels)
	{
		String sql = String.format("DELETE FROM %s", tableName);

		List<String> conditions = new ArrayList<>();
		conditions.add(String.format("%s = %s", "journal_id", acctId));

		if (journalItemModels.size() > 0)
		{
			int[] nos = new int[journalItemModels.size()];
			for (int i = 0; i < journalItemModels.size(); i++)
			{
				nos[i] = journalItemModels.get(i).getId();
			}

			conditions.add(String.format("%s NOT IN (%s)", "id", Util.getCSV(nos)));
		}

		sql = SqlHelper.putWheres(conditions, sql);
		session.createNativeQuery(sql).executeUpdate();

		//Need to delete from voucher also because journal item also is one kind of voucher
		sql = "DELETE\n"
				+ "FROM \n"
				+ "	{table_voucher}\n"
				+ "WHERE \n"
				+ "	voucher_type_id = {voucher_type_id} \n"
				+ "AND \n"
				+ "	id NOT IN (\n"
				+ "		SELECT	\n"
				+ "			id\n"
				+ "		FROM	\n"
				+ "			{table_journal_item}\n"
				+ "	)";

		Map map = new HashMap();
		map.put("table_voucher", TableName.VOUCHER);
		map.put("voucher_type_id", VoucherType.JOURNAL_ITEM.getId());
		map.put("table_journal_item", TableName.JOURNAL_ITEM
		);
		sql = Util.formatString(sql, map);

		session.createNativeQuery(sql).executeUpdate();
	}

	public void deleteByJournalId(int journalId)
	{
		String sql = String.format("DELETE FROM %s", tableName);
		List<String> conditions = new ArrayList<>();
		conditions.add(String.format("%s = '%s'", "journal_id", journalId));
		sql = SqlHelper.putWheres(conditions, sql);
		session.createNativeQuery(sql).executeUpdate();
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
