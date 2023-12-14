package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.hdto.CommVouLedger2Hdto;
import com.hemsw.asasaapi.veenal.dto.hdto.CommVouLedgerHdto;
import com.hemsw.asasaapi.veenal.dto.ldto.CommVouLdto;
import com.hemsw.asasaapi.veenal.enums.ListMenu;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.app.ColSettingModel;
import com.hemsw.asasaapi.veenal.model.gen.CommVouModel;
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
public class CommVouDao //extends BaseDao<CommVouModel>
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	@Autowired
	private VoucherDao voucherDao;

	public static final String tableName = "comm_vou";

	public void create(CommVouModel commVou, Date date, Integer parentId,
			int createdByUserId)
	{

		VoucherModel voucherModel = voucherDao.generateVoucherModel(voucherDao.getNextNo(VoucherType.COMM_VOU, date), date, parentId, VoucherType.COMM_VOU);
		voucherModel.setCreatedByUserId(createdByUserId);
		voucherDao.create(voucherModel);

		commVou.setId(voucherModel.getId());
		session.persist(commVou);
	}

	public void update(CommVouModel commVou, Date date)
	{

		VoucherModel voucherModel = voucherDao.getById(commVou.getId());
		voucherModel.setDate(date);

	}

	//
	public String getTableName()
	{
		return tableName;
	}

	public CommVouModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, TableName.COMM_VOU, String.valueOf(id));
		List<CommVouModel> dtos = session.createNativeQuery(sql, CommVouModel.class).getResultList();
		return dtos.isEmpty() ? null : dtos.get(0);
	}

	public List<CommVouModel> getBySalesId(int salesId)
	{
		String sql = String.format("SELECT * FROM %s", getTableName());

		List<String> wheres = new ArrayList<>();
		wheres.add(String.format("sales_id = %s", salesId));
		sql = SqlHelper.putWheres(wheres, sql);

		return session.createNativeQuery(sql, CommVouModel.class).getResultList();
	}

	public CommVouModel getBySalesIdAgentId(int salesId, int agentId)
	{
		String sql = String.format("SELECT * FROM %s", getTableName());

		List<String> wheres = new ArrayList<>();
		wheres.add(String.format("sales_id = %s", salesId));
		wheres.add(String.format("agent_id = %s", agentId));
		sql = SqlHelper.putWheres(wheres, sql);
		List<CommVouModel> dtos = session.createNativeQuery(sql, CommVouModel.class).getResultList();
		return dtos.isEmpty() ? null : dtos.get(0);
	}

	public List<CommVouLdto> getLdtos(
			String no,
			String salesNo,
			Date dateFrom,
			Date dateTo,
			Date salesDateFrom,
			Date salesDateTo,
			Integer customerId,
			String customerName,
			Integer agentId,
			String agentName
	)
	{
		String sql = String.format("SELECT * FROM %s", "vw_comm_vou_list");

		List<String> wheres = new ArrayList<>();

		if (no != null && !no.isEmpty())
		{
			wheres.add("no='" + String.valueOf(no) + "'");
		}
		if (salesNo != null && !salesNo.isEmpty())
		{
			wheres.add("sales_no='" + String.valueOf(salesNo) + "'");
		}

		if (dateFrom != null)
		{
			wheres.add("date(date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}

		if (salesDateFrom != null)
		{
			wheres.add("date(sales_date)>=date('" + Util.dateToString(salesDateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (salesDateTo != null)
		{
			wheres.add("date(sales_date)<=date('" + Util.dateToString(salesDateTo, Util.Formats.DB_DATE) + "')");
		}

		if (customerId != null)
		{
			wheres.add("customer_id=" + customerId);
		}
		if (customerName != null && !customerName.isEmpty())
		{
			wheres.add("customer_name LIKE '%" + SqlHelper.escape(customerName) + "%'");
		}

		if (agentId != null)
		{
			wheres.add("agent_id=" + agentId);
		}
		if (agentName != null && !agentName.isEmpty())
		{
			wheres.add("agent_name LIKE '%" + SqlHelper.escape(agentName) + "%'");
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<ColSettingModel> colSettingModels = colSettingDao.getByMenuIdForOrder(ListMenu.COMM_VOU.getId(), true);

		List<String> orderBys = new ArrayList<>();
		for (ColSettingModel colSettingModel : colSettingModels)
		{
			orderBys.add(String.format("%s %s", colSettingModel.getColKey(), colSettingModel.getOrderByType().getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_comm_vou", tableName);
		map.put("table_sales", TableName.SALES);
		map.put("table_acct", TableName.ACCT);
		map.put("table_voucher", TableName.VOUCHER);
		map.put("table_comm_vou_payable", TableName.COMM_VOU_PAYABLE);

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, CommVouLdto.class).getResultList();
	}

	public List<CommVouLedgerHdto> getLedger(
			Integer agentId,
			Date dateFrom,
			Date dateTo
	)
	{
		String sql = "SELECT\n"
				+ "	*\n"
				+ "FROM\n"
				+ "(\n"
				+ "	(\n"
				+ "		SELECT\n"
				+ "			{table_voucher}.id,\n"
				+ "			{table_voucher}.date,\n"
				+ "			{table_sales}.agent_id,\n"
				+ "			{table_comm_vou}.estimated_comm amt,\n"
				+ "			0 tx_type_id\n"
				+ "		FROM\n"
				+ "			{table_comm_vou}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_voucher}\n"
				+ "		ON\n"
				+ "			{table_voucher}.id = {table_comm_vou}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_sales}\n"
				+ "		ON\n"
				+ "			{table_sales}.id = {table_comm_vou}.sales_id\n"
				+ "	)	\n"
				+ "		\n"
				+ "\n"
				+ "	UNION	\n"
				+ "		\n"
				+ "	(\n"
				+ "		SELECT\n"
				+ "			{table_voucher}.id,\n"
				+ "			{table_voucher}.date,\n"
				+ "			{table_sales}.agent_id,\n"
				+ "			{table_comm_vou_payable}.amt,\n"
				+ "			1 tx_type_id\n"
				+ "		FROM\n"
				+ "			{table_comm_vou_payable}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_voucher}\n"
				+ "		ON\n"
				+ "			{table_voucher}.id = {table_comm_vou_payable}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_comm_vou}\n"
				+ "		ON\n"
				+ "			{table_comm_vou}.id = {table_comm_vou_payable}.comm_vou_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_sales}\n"
				+ "		ON\n"
				+ "			{table_sales}.id = {table_comm_vou}.sales_id\n"
				+ "		\n"
				+ "	)\n"
				+ ") t1\n";

		List<String> wheres = new ArrayList<>();

		if (agentId != null)
		{
			wheres.add("agent_id=" + agentId);
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

		List<String> orderBys = new ArrayList<>();
		orderBys.add(String.format("%s %s", "DATE", "ASC"));
		orderBys.add(String.format("%s %s", "id", "ASC"));

		sql = SqlHelper.putOrderBys(orderBys, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_comm_vou", tableName);
		map.put("table_voucher", TableName.VOUCHER);
		map.put("table_sales", TableName.SALES);
		map.put("table_comm_vou_payable", TableName.COMM_VOU_PAYABLE);

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, CommVouLedgerHdto.class).getResultList();
	}

	public List<CommVouLedger2Hdto> getLedger2(
			Integer agentId,
			Integer customerId,
			Date dateFrom,
			Date dateTo
	)
	{
		String sql = String.format("SELECT * FROM %s", "vw_comm_vou_ledger");

		List<String> wheres = new ArrayList<>();

		if (agentId != null)
		{
			wheres.add("agent_id=" + agentId);
		}
		if (customerId != null)
		{
			wheres.add("customer_id=" + customerId);
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

		List<String> orderBys = new ArrayList<>();
		//orderBys.add(String.format("%s %s", "DATE", "ASC"));
		//orderBys.add(String.format("%s %s", "id", "ASC"));

		sql = SqlHelper.putOrderBys(orderBys, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_comm_vou", tableName);
		map.put("table_voucher", TableName.VOUCHER);
		map.put("table_sales", TableName.SALES);
		map.put("table_comm_vou_payable", TableName.COMM_VOU_PAYABLE);

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, CommVouLedger2Hdto.class).getResultList();
	}
}
