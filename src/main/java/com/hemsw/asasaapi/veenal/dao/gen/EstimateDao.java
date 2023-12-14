package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.hdto.EstimatePendingProductHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.OrderPendingByAcctHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.OrderPendingByProductHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.PicklistItemHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptEstimatePendingByAcctHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptEstimatePendingByProdHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptEstimatePendingDetHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.TaxSumHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.TaxSummaryHdto;
import com.hemsw.asasaapi.veenal.dto.ldto.EstimateLdto;
import com.hemsw.asasaapi.veenal.enums.ListMenu;
import com.hemsw.asasaapi.veenal.enums.SortOrderEnum;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.app.ColSettingModel;
import com.hemsw.asasaapi.veenal.model.gen.EstimateModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import com.hemsw.asasaapi.veenal.service.enums.RptEstimatePendingByAcctSortByEnum;
import com.hemsw.asasaapi.veenal.service.enums.RptEstimatePendingByProdSortByEnum;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstimateDao //extends BaseDao<EstimateModel>
{

	@PersistenceContext
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	@Autowired
	private VoucherDao voucherDao;

	public static final String tableName = "estimate";

	public void create(EstimateModel estimateModel, String no, Date date, int createdByUserId)
	{

		VoucherModel voucherModel = voucherDao.generateVoucherModel(no, date, null, VoucherType.ESTIMATE);
		voucherModel.setCreatedByUserId(createdByUserId);
		voucherDao.create(voucherModel);

		estimateModel.setVoucherModel(voucherModel);
		session.persist(estimateModel);
	}

	public void update(EstimateModel Estimate, String no, Date date)
	{

		VoucherModel voucherModel = voucherDao.getById(Estimate.getVoucherModel().getId());
		voucherModel.setNo(no);
		voucherModel.setDate(date);
	}

	public List<EstimateLdto> getLdtos(
			Integer no,
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			String customerName,
			String city,
			Integer stateId,
			String state,
			String note,
			Boolean convertedToSo,
			Integer statusId
	)
	{
		String sql = "SELECT\n"
				+ "	*\n"
				+ "FROM\n"
				+ "(\n"
				+ "	SELECT	\n"
				+ "		{table_estimate}.id,\n"
				+ "		{table_voucher}.no,	\n"
				+ "		{table_voucher}.date,	\n"
				+ "		{table_estimate}.customer_id,\n"
				+ "		{table_acct}.name customer_name,\n"
				+ "		{table_customer}.city,\n"
				+ "		{table_state}.id state_id,\n"
				+ "		{table_state}.name state_name,\n"
				+ "		{table_estimate}.note,\n"
				+ "		{table_estimate}.sum_qty,\n"
				+ "		(SELECT no FROM {table_voucher} WHERE {table_voucher}.id = (SELECT id FROM {table_sales_order} WHERE {table_sales_order}.estimate_id = {table_estimate}.id LIMIT 1)) sales_order_no,\n"
				+ "		{table_estimate_status}.name status_name,\n"
				+ "		{table_estimate}.status_id,\n"
				+ "		{table_estimate}.lock_stock_for_days,\n"
				+ "		{table_user}.name created_by_user_name,\n"
				+ "		{table_voucher}.created_at\n"
				+ "	FROM\n"
				+ "		{table_estimate}\n"
				+ "	LEFT JOIN\n"
				+ "		{table_voucher}\n"
				+ "	ON\n"
				+ "		{table_estimate}.id = {table_voucher}.id\n"
				+ "	LEFT JOIN\n"
				+ "		{table_acct}\n"
				+ "	ON\n"
				+ "		{table_acct}.id = {table_estimate}.customer_id\n"
				+ "	LEFT JOIN\n"
				+ "		{table_customer}\n"
				+ "	ON\n"
				+ "		{table_customer}.id = {table_estimate}.customer_id\n"
				+ "	LEFT JOIN\n"
				+ "		{table_state}\n"
				+ "	ON\n"
				+ "		{table_state}.id = {table_customer}.state_id\n"
				+ "	LEFT JOIN\n"
				+ "		{table_user}\n"
				+ "	ON\n"
				+ "		{table_user}.id = {table_voucher}.created_by_user_id\n"
				+ "	LEFT JOIN\n"
				+ "		{table_estimate_status}\n"
				+ "	ON\n"
				+ "		{table_estimate_status}.id = {table_estimate}.status_id\n"
				+ "	LEFT JOIN\n"
				+ "		(	\n"
				+ "			SELECT\n"
				+ "				voucher_id,\n"
				+ "				SUM({table_order_journal}.order_qty - IFNULL(t_order_set_qty.set_qty, 0)) pending_qty\n"
				+ "			FROM\n"
				+ "				{table_order_journal}\n"
				+ "			LEFT JOIN\n"
				+ "				(\n"
				+ "					SELECT\n"
				+ "						order_journal_id_order,\n"
				+ "						IFNULL(SUM(QTY),0) set_qty\n"
				+ "					FROM\n"
				+ "						{table_order_set_against}\n"
				+ "					GROUP BY\n"
				+ "						order_journal_id_order\n"
				+ "				) t_order_set_qty\n"
				+ "			ON\n"
				+ "				t_order_set_qty.order_journal_id_order = {table_order_journal}.id	\n"
				+ "			WHERE\n"
				+ "				order_type_id = 2\n"
				+ "			AND\n"
				+ "				order_qty IS NOT NULL\n"
				+ "			AND\n"
				+ "				{table_order_journal}.order_qty > IFNULL(t_order_set_qty.set_qty, 0)\n"
				+ "			GROUP BY \n"
				+ "				voucher_id\n"
				+ "		) t_pending_qty\n"
				+ "	ON\n"
				+ "		t_pending_qty.voucher_id = {table_estimate}.id\n"
				+ ") t_final";

		List<String> wheres = new ArrayList<>();

		if (no != null)
		{
			wheres.add("no=" + String.valueOf(no));
		}
		if (dateFrom != null)
		{
			wheres.add("date(date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add("customer_id=" + customerId);
		}
		if (customerName != null && !customerName.isEmpty())
		{
			wheres.add("customer_name LIKE '%" + SqlHelper.escape(customerName) + "%'");
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add("city LIKE '%" + SqlHelper.escape(city) + "%'");
		}
		if (state != null && !state.isEmpty())
		{
			wheres.add("state_name LIKE '%" + SqlHelper.escape(state) + "%'");
		}
		if (stateId != null)
		{
			wheres.add("state_id = " + stateId + "");
		}
		if (note != null && !note.isEmpty())
		{
			wheres.add("note LIKE '%" + note + "%'");
		}
		if (convertedToSo != null)
		{
			if (convertedToSo)
			{
				wheres.add("(SELECT sales_order_no) IS NOT NULL");
			}
			else
			{
				wheres.add("(SELECT sales_order_no) IS NULL");
			}
		}
		if (statusId != null)
		{
			wheres.add("status_id = " + statusId + "");
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<ColSettingModel> colSettingModels = colSettingDao.getByMenuIdForOrder(ListMenu.ESTIMATE.getId(), true);

		List<String> orderBys = new ArrayList<>();
		for (ColSettingModel colSettingModel : colSettingModels)
		{
			orderBys.add(String.format("%s %s", colSettingModel.getColKey(), colSettingModel.getOrderByType().getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_estimate", tableName);
		map.put("table_voucher", TableName.VOUCHER);
		map.put("table_acct", TableName.ACCT);
		map.put("table_customer", TableName.CUSTOMER);
		map.put("table_state", TableName.STATE);
		map.put("table_user", TableName.USER);
		map.put("table_order_journal", TableName.ORDER_JOURNAL);
		map.put("table_order_set_against", TableName.ORDER_SET_AGAINST);
		map.put("table_sales_order", TableName.SALES_ORDER);
		map.put("table_estimate_status", TableName.ESTIMATE_STATUS);
		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, EstimateLdto.class).getResultList();
	}

	public List<EstimateLdto> get(
			Integer no,
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			String customerName,
			String city,
			Integer stateId,
			String state,
			String note,
			Boolean convertedToSo
	)
	{
		String sql = "SELECT\n"
				+ "	*\n"
				+ "FROM\n"
				+ "	(\n"
				+ "		SELECT	\n"
				+ "			{table_estimate}.id,\n"
				+ "			{table_voucher}.no,	\n"
				+ "			{table_voucher}.date,	\n"
				+ "			{table_estimate}.customer_id,\n"
				+ "			{table_acct}.name customer_name,\n"
				+ "			{table_customer}.city,\n"
				+ "			{table_state}.id state_id,\n"
				+ "			{table_state}.name state_name,\n"
				+ "			{table_estimate}.note,\n"
				+ "			{table_estimate}.sum_qty,\n"
				+ "			(SELECT no FROM {table_voucher} WHERE {table_voucher}.id = (SELECT id FROM {table_sales_order} WHERE {table_sales_order}.estimate_id = {table_estimate}.id LIMIT 1)) sales_order_no,\n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_voucher}.created_at\n"
				+ "		FROM\n"
				+ "			{table_estimate}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_voucher}\n"
				+ "		ON\n"
				+ "			{table_estimate}.id = {table_voucher}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_acct}\n"
				+ "		ON\n"
				+ "			{table_acct}.id = {table_estimate}.customer_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_customer}\n"
				+ "		ON\n"
				+ "			{table_customer}.id = {table_estimate}.customer_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_state}\n"
				+ "		ON\n"
				+ "			{table_state}.id = {table_customer}.state_id\n"
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
		if (dateFrom != null)
		{
			wheres.add("date(date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add("customer_id=" + customerId);
		}
		if (customerName != null && !customerName.isEmpty())
		{
			wheres.add("customer_name LIKE '%" + SqlHelper.escape(customerName) + "%'");
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add("city LIKE '%" + SqlHelper.escape(city) + "%'");
		}
		if (state != null && !state.isEmpty())
		{
			wheres.add("state_name LIKE '%" + SqlHelper.escape(state) + "%'");
		}
		if (stateId != null)
		{
			wheres.add("state_id = " + stateId + "");
		}
		if (note != null && !note.isEmpty())
		{
			wheres.add("note LIKE '%" + note + "%'");
		}
		if (convertedToSo != null)
		{
			if (convertedToSo)
			{
				wheres.add("(SELECT sales_order_no) IS NOT NULL");
			}
			else
			{
				wheres.add("(SELECT sales_order_no) IS NULL");
			}
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<ColSettingModel> colSettingModels = colSettingDao.getByMenuIdForOrder(ListMenu.ESTIMATE.getId(), true);

		List<String> orderBys = new ArrayList<>();
		for (ColSettingModel colSettingModel : colSettingModels)
		{
			orderBys.add(String.format("%s %s", colSettingModel.getColKey(), colSettingModel.getOrderByType().getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_estimate", tableName);
		map.put("table_voucher", TableName.VOUCHER);
		map.put("table_acct", TableName.ACCT);
		map.put("table_customer", TableName.CUSTOMER);
		map.put("table_state", TableName.STATE);
		map.put("table_user", TableName.USER);
		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, EstimateLdto.class).getResultList();
	}

	public EstimateModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, tableName, String.valueOf(id));
		List<EstimateModel> dtos = session.createNativeQuery(sql, EstimateModel.class).getResultList();
		return dtos.isEmpty() ? null : dtos.get(0);
	}

	public EstimateModel getByNo(String no)
	{
		String sql = String.format("SELECT * FROM %s", tableName);
		List<String> wheres = new ArrayList<>();
		wheres.add(String.format("no='%s'", no));
		sql = SqlHelper.putWheres(wheres, sql);
		sql = sql + " ORDER BY " + tableName + ".date ASC, no ASC";
		List<EstimateModel> EstimateModels = session.createNativeQuery(sql, EstimateModel.class).getResultList();
		return EstimateModels == null || EstimateModels.isEmpty() ? null : EstimateModels.get(0);
	}

	public List<PicklistItemHdto> getPicklistItemHdtos(int estimateId)
	{
		String sql = "SELECT\n"
				+ "	product_id,\n"
				+ "	SUM(order_qty) order_qty,\n"
				+ "	order_unit_id\n"
				+ "FROM\n"
				+ "	estimate_item\n"
				+ "WHERE\n"
				+ "	estimate_id = %s\n"
				+ "GROUP BY\n"
				+ "	product_id,\n"
				+ "	order_unit_id";

		sql = String.format(sql, estimateId);

		return session.createNativeQuery(sql, PicklistItemHdto.class).getResultList();
	}

	public List<OrderPendingByAcctHdto> getEstimatePendingByCustomerHdto(
			Integer acctId,
			String acctName,
			Integer productId,
			String productName,
			boolean pending
	)
	{

		String sql = String.format("SELECT 	\n"
				+ "	acct_id, \n"
				+ "	acct_name,\n"
				+ "	COUNT(DISTINCT(voucher_id)) order_cnt,\n"
				+ "	COUNT(DISTINCT(product_id)) product_cnt,\n"
				+ "	SUM(qty_pending) qty_total\n"
				+ "FROM\n"
				+ "	%s\n", "vw_estimate_item_qty_det_qty_pending");

		List<String> wheres = new ArrayList<>();

		if (acctId != null)
		{
			wheres.add("acct_id=" + acctId);
		}
		if (acctName != null && !acctName.isEmpty())
		{
			wheres.add("acct_name LIKE '%" + SqlHelper.escape(acctName) + "%'");
		}
		if (productId != null)
		{
			wheres.add("product_id=" + productId);
		}
		if (productName != null && !productName.isEmpty())
		{
			wheres.add("product_name LIKE '%" + SqlHelper.escape(productName) + "%'");
		}
		if (pending)
		{
			wheres.add("qty_order > qty_sold");
		}

		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + "\nGROUP BY\n"
				+ "	acct_id\n";

		sql = sql + "ORDER BY\n"
				+ "	acct_name";

		/*
		
		List<ColSettingModel> colSettingModels = colSettingDao.getByMenuIdForOrder(ListMenu.SALES_ORDER_PENDING.getId(), true);

		List<String> orderBys = new ArrayList<>();
		for (ColSettingModel colSettingModel : colSettingModels)
		{
			orderBys.add(String.format("%s %s", colSettingModel.getColKey(), colSettingModel.getOrderByType().getSqlName()));
		}
		sql = SqlHelper.putOrderBys(orderBys, sql);
		 */
		return session.createNativeQuery(sql, OrderPendingByAcctHdto.class).getResultList();
	}

	public List<OrderPendingByProductHdto> getEstimatePendingByProductHdto(
			Integer acctId,
			String acctName,
			Integer productId,
			String productName,
			boolean pending
	)
	{
		String sql = String.format("SELECT 	\n"
				+ "	product_id, \n"
				+ "	product_name,\n"
				+ "	COUNT(DISTINCT(voucher_id)) order_cnt,\n"
				+ "	COUNT(DISTINCT(acct_id)) acct_cnt,\n"
				+ "	SUM(qty_pending) qty_total\n"
				+ "FROM\n"
				+ "	%s\n", "vw_estimate_item_qty_det_qty_pending");

		List<String> wheres = new ArrayList<>();

		if (acctId != null)
		{
			wheres.add("acct_id=" + acctId);
		}
		if (acctName != null && !acctName.isEmpty())
		{
			wheres.add("acct_name LIKE '%" + SqlHelper.escape(acctName) + "%'");
		}
		if (productId != null)
		{
			wheres.add("product_id=" + productId);
		}
		if (productName != null && !productName.isEmpty())
		{
			wheres.add("product_name LIKE '%" + SqlHelper.escape(productName) + "%'");
		}
		if (pending)
		{
			wheres.add("qty_order > qty_sold");
		}

		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + "\nGROUP BY\n"
				+ "	product_id\n";

		sql = sql + "ORDER BY\n"
				+ "	product_name";

		/*
		
		List<ColSettingModel> colSettingModels = colSettingDao.getByMenuIdForOrder(ListMenu.SALES_ORDER_PENDING.getId(), true);

		List<String> orderBys = new ArrayList<>();
		for (ColSettingModel colSettingModel : colSettingModels)
		{
			orderBys.add(String.format("%s %s", colSettingModel.getColKey(), colSettingModel.getOrderByType().getSqlName()));
		}
		sql = SqlHelper.putOrderBys(orderBys, sql);
		 */
		return session.createNativeQuery(sql, OrderPendingByProductHdto.class).getResultList();
	}

	public List<EstimatePendingProductHdto> getPendingProduct(int estimateId)
	{
		String sql = "SELECT\n"
				+ "	product_id, \n"
				+ "	product.name product_name,\n"
				+ "	SUM(qty) qty_total\n"
				+ "FROM \n"
				+ "	estimate_item\n"
				+ "LEFT JOIN\n"
				+ "	product\n"
				+ "ON\n"
				+ "	product.id = product_id\n";

		List<String> wheres = new ArrayList<>();
		wheres.add(String.format("estimate_id = %s\n", estimateId));
		wheres.add(String.format("is_pending = 1\n"));

		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + "GROUP BY\n"
				+ "	product_id";

		return session.createNativeQuery(sql, EstimatePendingProductHdto.class).getResultList();
	}

	public List<TaxSummaryHdto> getTaxSummaryHelperModels(int estimateId)
	{
		String sql = "SELECT\n"
				+ "	hsn,\n"
				+ "	tax_id,\n"
				+ "	SUM(qty) sum_qty,\n"
				+ "	SUM(taxable_amt) taxable_amt,\n"
				+ "	SUM(cgst_a) cgst_a,\n"
				+ "	SUM(sgst_a) sgst_a,\n"
				+ "	SUM(igst_a) igst_a\n"
				+ "FROM\n"
				+ "(\n"
				+ "	SELECT\n"
				+ "		{table_estimate_item}.*,\n"
				+ "		IF({table_product}.tax_cat_id IS NULL, {table_product}.hsn, {table_tax_cat}.hsn) hsn\n"
				+ "	FROM\n"
				+ "		{table_estimate_item}\n"
				+ "	LEFT JOIN\n"
				+ "		{table_product}\n"
				+ "	ON\n"
				+ "		{table_product}.id = {table_estimate_item}.product_id\n"
				+ "	LEFT JOIN\n"
				+ "		{table_tax_cat}\n"
				+ "	ON\n"
				+ "		{table_tax_cat}.id = {table_product}.tax_cat_id\n"
				+ ") t1\n";

		List<String> wheres = new ArrayList<>();
		wheres.add(String.format("%s = %s", "estimate_id", estimateId));
		sql = SqlHelper.putWheres(wheres, sql);

		String groupBy = "\nGROUP BY\n"
				+ "	hsn, tax_id";

		sql = sql + groupBy;

		Map<String, String> map = new HashMap<>();
		map.put("table_estimate_item", TableName.ESTIMATE_ITEM);
		map.put("table_product", TableName.PRODUCT);
		map.put("table_tax_cat", TableName.TAX_CAT);

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, TaxSummaryHdto.class).getResultList();
	}

	public TaxSumHdto getTaxSumHdto(int estimateId)
	{

		String sql = "SELECT\n"
				+ "	sum(estimate_item.qty) as qty,\n"
				+ "	sum(estimate_item.amt_after_disc) as taxable_amt,\n"
				+ "	sum(estimate_item.cgst_a) as cgst_a,\n"
				+ "	sum(estimate_item.sgst_a) as sgst_a,\n"
				+ "	sum(estimate_item.igst_a) as igst_a,\n"
				+ "	sum(estimate_item.cgst_a) + sum(estimate_item.sgst_a) + sum(estimate_item.igst_a)  as total\n"
				+ "FROM\n"
				+ "	estimate_item\n"
				+ "LEFT join\n"
				+ "	product\n"
				+ "ON\n"
				+ "	product.id = estimate_item.product_id\n"
				+ "WHERE\n"
				+ "	estimate_item.estimate_id = %s\n"
				+ "AND\n"
				+ "	(\n"
				+ "		estimate_item.cgst_a > 0\n"
				+ "		OR \n"
				+ "		estimate_item.sgst_a > 0\n"
				+ "		OR \n"
				+ "		estimate_item.igst_a > 0\n"
				+ "	)\n"
				+ "GROUP BY\n"
				+ "	estimate_item.estimate_id";

		sql = String.format(sql, estimateId);

		List<TaxSumHdto> taxSumHdtos = session.createNativeQuery(sql, TaxSumHdto.class).getResultList();
		if (taxSumHdtos == null || taxSumHdtos.isEmpty())
		{
			return null;
		}
		return taxSumHdtos.get(0);
	}

	public BigDecimal getPendingQty(int productId)
	{
		String sql = String.format("SELECT\n"
				+ "	IFNULL(SUM(qty),0)\n"
				+ "FROM\n"
				+ "	estimate_item\n"
				+ "LEFT JOIN\n"
				+ "	estimate\n"
				+ "ON\n"
				+ "	estimate.id = estimate_item.estimate_id\n"
				+ "LEFT JOIN\n"
				+ "	voucher\n"
				+ "ON\n"
				+ "	voucher.id = estimate_item.estimate_id\n"
				+ "WHERE\n"
				+ "	estimate.status_id = 2\n"
				+ "AND\n"
				+ "	estimate.lock_stock_for_days IS NOT NULL\n"
				+ "AND\n"
				+ "	NOW() <= DATE_ADD(voucher.date, INTERVAL estimate.lock_stock_for_days DAY)\n"
				+ "AND\n"
				+ "	estimate_item.is_pending = 1\n"
				+ "AND\n"
				+ "	product_id = %s", productId);

		List<BigDecimal> res = session.createNativeQuery(sql, BigDecimal.class).getResultList();
		if (res == null || res.isEmpty())
		{
			return BigDecimal.ZERO;
		}
		return res.get(0);
	}

	public List<RptEstimatePendingDetHdto> getRptEstimatePendingDetHdtos(
			Date dateFrom,
			Date dateTo,
			Integer acctId,
			Integer productId
	)
	{
		String sql = "SELECT \n"
				+ "	{table_estimate_item}.estimate_id,\n"
				+ "	{table_voucher}.date,\n"
				+ "	{table_voucher}.no,\n"
				+ "	{table_product}.name product_name,\n"
				+ "	{table_acct}.name customer_name,\n"
				+ "	{table_estimate_item}.qty,"
				+ "	current_stock_qty\n"
				+ "FROM \n"
				+ "	{table_estimate_item} \n"
				+ "LEFT JOIN\n"
				+ "	{table_product}\n"
				+ "ON\n"
				+ "	{table_product}.id = {table_estimate_item}.product_id\n"
				+ "LEFT JOIN\n"
				+ "	{table_estimate}\n"
				+ "ON\n"
				+ "	{table_estimate}.id = {table_estimate_item}.estimate_id\n"
				+ "LEFT JOIN\n"
				+ "	{table_voucher}\n"
				+ "ON\n"
				+ "	{table_voucher}.id = estimate.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_acct}\n"
				+ "ON\n"
				+ "	{table_acct}.id = {table_estimate}.customer_id\n"
				+ "LEFT JOIN\n"
				+ "	(\n"
				+ "		SELECT\n"
				+ "			product_id,\n"
				+ "			IFNULL(SUM(tx_type * qty), 0) current_stock_qty\n"
				+ "		FROM	\n"
				+ "			{table_goods_journal}\n"
				+ "		GROUP BY\n"
				+ "			product_id\n"
				+ "	) t1\n"
				+ "ON\n"
				+ "	t1.product_id = {table_estimate_item}.product_id\n";

		List<String> wheres = new ArrayList<>();

		wheres.add("is_pending = 1");
		wheres.add("{table_estimate_item}.product_id NOT IN (\n"
				+ "		SELECT \n"
				+ "			product_id\n"
				+ "		FROM\n"
				+ "			{table_sales_item}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_sales}\n"
				+ "		ON\n"
				+ "			{table_sales}.id = {table_sales_item}.sales_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_voucher} vou_sales\n"
				+ "		ON\n"
				+ "			vou_sales.id = {table_sales}.id\n"
				+ "		WHERE\n"
				+ "			{table_sales}.customer_id = {table_estimate}.customer_id\n"
				+ "		AND\n"
				+ "			vou_sales.date >= {table_voucher}.date\n"
				+ "	)");

		if (dateFrom != null)
		{
			wheres.add("date({table_voucher}.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date({table_voucher}.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (acctId != null)
		{
			wheres.add(String.format("{table_acct}.id = %s", acctId));
		}
		if (productId != null)
		{
			wheres.add(String.format("{table_product}.id = %s", productId));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<ColSettingModel> colSettingModels = colSettingDao.getByMenuIdForOrder(ListMenu.RPT_ESTIMATE_PENDING_PRODUCT.getId(), true);

		List<String> orderBys = new ArrayList<>();
		for (ColSettingModel colSettingModel : colSettingModels)
		{
			orderBys.add(String.format("%s %s", colSettingModel.getColKey(), colSettingModel.getOrderByType().getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_estimate_item", TableName.ESTIMATE_ITEM);
		map.put("table_product", TableName.PRODUCT);
		map.put("table_estimate", TableName.ESTIMATE);
		map.put("table_voucher", TableName.VOUCHER);
		map.put("table_acct", TableName.ACCT);
		map.put("table_sales_item", TableName.SALES_ITEM);
		map.put("table_sales", TableName.SALES);
		map.put("table_goods_journal", TableName.GOODS_JOURNAL);

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, RptEstimatePendingDetHdto.class).getResultList();
	}

	public List<RptEstimatePendingByProdHdto> getRptEstimatePendingByProdHdtos(
			Date dateFrom,
			Date dateTo,
			Integer acctId,
			Integer productId,
			RptEstimatePendingByProdSortByEnum rptEstimatePendingByProdSortByEnum,
			SortOrderEnum sortOrderEnum
	)
	{
		String sql = "SELECT \n"
				+ "	product.id product_id,\n"
				+ "	product.name product_name,\n"
				+ "	COUNT( DISTINCT voucher.no) cnt_estimate,\n"
				+ "	COUNT( DISTINCT acct.id ) cnt_customer,\n"
				+ "	SUM(estimate_item.qty) sum_qty,\n"
				+ "	current_stock_qty\n"
				+ "FROM \n"
				+ "	estimate_item \n"
				+ "LEFT JOIN\n"
				+ "	product\n"
				+ "ON\n"
				+ "	product.id = estimate_item.product_id\n"
				+ "LEFT JOIN\n"
				+ "	estimate\n"
				+ "ON\n"
				+ "	estimate.id = estimate_item.estimate_id\n"
				+ "LEFT JOIN\n"
				+ "	voucher\n"
				+ "ON\n"
				+ "	voucher.id = estimate.id\n"
				+ "LEFT JOIN\n"
				+ "	acct\n"
				+ "ON\n"
				+ "	acct.id = estimate.customer_id\n"
				+ "LEFT JOIN\n"
				+ "	(\n"
				+ "		SELECT\n"
				+ "			product_id,\n"
				+ "			IFNULL(SUM(tx_type * qty), 0) current_stock_qty\n"
				+ "		FROM	\n"
				+ "			goods_journal\n"
				+ "		GROUP BY\n"
				+ "			product_id\n"
				+ "	) t1\n"
				+ "ON\n"
				+ "	t1.product_id = product.id\n";

		List<String> wheres = new ArrayList<>();

		wheres.add("is_pending = 1");
		wheres.add("estimate_item.product_id NOT IN (\n"
				+ "		SELECT \n"
				+ "			product_id\n"
				+ "		FROM\n"
				+ "			sales_item\n"
				+ "		LEFT JOIN\n"
				+ "			sales\n"
				+ "		ON\n"
				+ "			sales.id = sales_item.sales_id\n"
				+ "		LEFT JOIN\n"
				+ "			voucher vou_sales\n"
				+ "		ON\n"
				+ "			vou_sales.id = sales.id\n"
				+ "		WHERE\n"
				+ "			sales.customer_id = estimate.customer_id\n"
				+ "		AND\n"
				+ "			vou_sales.date >= voucher.date\n"
				+ "	)\n");

		if (dateFrom != null)
		{
			wheres.add("date(voucher.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(voucher.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (acctId != null)
		{
			wheres.add(String.format("acct.id = %s", acctId));
		}
		if (productId != null)
		{
			wheres.add(String.format("product.id = %s", productId));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<String> groupBys = new ArrayList<>();
		groupBys.add("product.id");
		sql = SqlHelper.putGroupBys(groupBys, sql);

		List<String> orderBys = new ArrayList<>();
		if (rptEstimatePendingByProdSortByEnum != null)
		{
			orderBys.add(String.format("%s %s", rptEstimatePendingByProdSortByEnum.getKey(), sortOrderEnum.getSqlName()));
		}
		else
		{
			orderBys.add(String.format("%s %s", rptEstimatePendingByProdSortByEnum.NAME.getKey(), sortOrderEnum.ASC.getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		return session.createNativeQuery(sql, RptEstimatePendingByProdHdto.class).getResultList();
	}

	public List<RptEstimatePendingByAcctHdto> getRptEstimatePendingByAcctHdtos(
			Date dateFrom,
			Date dateTo,
			Integer acctId,
			Integer productId,
			RptEstimatePendingByAcctSortByEnum rptEstimatePendingByAcctSortByEnum,
			SortOrderEnum sortOrderEnum
	)
	{
		String sql = "SELECT \n"
				+ "	acct.id acct_id,\n"
				+ "	acct.name acct_name,\n"
				+ "	COUNT(DISTINCT voucher.no) cnt_estimate,\n"
				+ "	COUNT(DISTINCT estimate_item.product_id) cnt_prod,\n"
				+ "	SUM(estimate_item.qty) sum_qty\n"
				+ "FROM \n"
				+ "	estimate_item \n"
				+ "LEFT JOIN\n"
				+ "	estimate\n"
				+ "ON\n"
				+ "	estimate.id = estimate_item.estimate_id\n"
				+ "LEFT JOIN\n"
				+ "	voucher\n"
				+ "ON\n"
				+ "	voucher.id = estimate.id\n"
				+ "LEFT JOIN\n"
				+ "	acct\n"
				+ "ON\n"
				+ "	acct.id = estimate.customer_id\n";

		List<String> wheres = new ArrayList<>();

		wheres.add("is_pending = 1");
		wheres.add("estimate_item.product_id NOT IN (\n"
				+ "		SELECT \n"
				+ "			product_id\n"
				+ "		FROM\n"
				+ "			sales_item\n"
				+ "		LEFT JOIN\n"
				+ "			sales\n"
				+ "		ON\n"
				+ "			sales.id = sales_item.sales_id\n"
				+ "		LEFT JOIN\n"
				+ "			voucher vou_sales\n"
				+ "		ON\n"
				+ "			vou_sales.id = sales.id\n"
				+ "		WHERE\n"
				+ "			sales.customer_id = estimate.customer_id\n"
				+ "		AND\n"
				+ "			vou_sales.date >= voucher.date\n"
				+ "	)\n");

		if (dateFrom != null)
		{
			wheres.add("date(voucher.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(voucher.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (acctId != null)
		{
			wheres.add(String.format("acct.id = %s", acctId));
		}
		if (productId != null)
		{
			wheres.add(String.format("estimate_item.product_id = %s", productId));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<String> groupBys = new ArrayList<>();
		groupBys.add("acct.id");
		sql = SqlHelper.putGroupBys(groupBys, sql);

		List<String> orderBys = new ArrayList<>();
		if (rptEstimatePendingByAcctSortByEnum != null)
		{
			orderBys.add(String.format("%s %s", rptEstimatePendingByAcctSortByEnum.getKey(), sortOrderEnum.getSqlName()));
		}
		else
		{
			orderBys.add(String.format("%s %s", rptEstimatePendingByAcctSortByEnum.NAME.getKey(), sortOrderEnum.ASC.getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		return session.createNativeQuery(sql, RptEstimatePendingByAcctHdto.class).getResultList();
	}

	public void setSuccess(int estimateId)
	{
		String sql = String.format("UPDATE %s SET status_id = %s WHERE id = %s", tableName, 1, estimateId);
		session.createNativeQuery(sql).executeUpdate();
	}

	public String getTableName()
	{
		return tableName;
	}

}
