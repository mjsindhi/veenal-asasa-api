package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dao.app.YearDao;
import com.hemsw.asasaapi.veenal.dto.hdto.CurrentStockHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.OrderLedgerHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.OrderPendingByAcctHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.OrderPendingByProductHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.ProductMonthlySummaryHdto;
import com.hemsw.asasaapi.veenal.enums.OrderType;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.app.YearModel;
import com.hemsw.asasaapi.veenal.model.gen.OrderAdjustItemModel;
import com.hemsw.asasaapi.veenal.model.gen.OrderJournalModel;
import com.hemsw.asasaapi.veenal.model.gen.ProductModel;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseItemModel;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseOrderItemModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesItemModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesOrderItemModel;
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
public class OrderJournalDao
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	@Autowired
	private YearDao yearDao;

	public static final String tableName = "order_journal";

	public void create(Date date, int acctId, PurchaseItemModel purchaseItemModel)
	{
		OrderJournalModel orderJournalModel = new OrderJournalModel();
		setInJournal(date, acctId, purchaseItemModel, orderJournalModel);
		session.persist(orderJournalModel);
	}

	public void create(Date date, int acctId, PurchaseOrderItemModel purchaseOrderItemModel)
	{
		OrderJournalModel orderJournalModel = new OrderJournalModel();
		setInJournal(date, acctId, purchaseOrderItemModel, orderJournalModel);
		session.persist(orderJournalModel);
	}

	public void create(Date date, int acctId, SalesItemModel salesItemModel)
	{
		OrderJournalModel orderJournalModel = new OrderJournalModel();
		setInJournal(date, acctId, salesItemModel, orderJournalModel);
		session.persist(orderJournalModel);
	}

	public void create(Date date, int acctId, SalesOrderItemModel salesOrderItemModel)
	{
		OrderJournalModel orderJournalModel = new OrderJournalModel();
		setInJournal(date, acctId, salesOrderItemModel, orderJournalModel);
		session.persist(orderJournalModel);
	}

	public void create(Date date, int acctId, OrderAdjustItemModel orderAdjustItemModel, OrderType orderType)
	{
		OrderJournalModel orderJournalModel = new OrderJournalModel();
		setInJournal(date, acctId, orderAdjustItemModel, orderType, orderJournalModel);
		session.persist(orderJournalModel);
	}

	public void update(Date date, int acctId, PurchaseItemModel purchaseItemModel)
	{
		OrderJournalModel orderJournalModel = getByAllIds(purchaseItemModel.getPurchaseId(), purchaseItemModel.getId());
		if (orderJournalModel == null)
		{
			create(date, acctId, purchaseItemModel);
		}
		else
		{
			setInJournal(date, acctId, purchaseItemModel, orderJournalModel);

		}
	}

	public void update(Date date, int acctId, PurchaseOrderItemModel purchaseOrderItemModel)
	{
		OrderJournalModel orderJournalModel = getByAllIds(purchaseOrderItemModel.getPurchaseOrderId(), purchaseOrderItemModel.getId());
		if (orderJournalModel == null)
		{
			create(date, acctId, purchaseOrderItemModel);
		}
		else
		{
			setInJournal(date, acctId, purchaseOrderItemModel, orderJournalModel);

		}
	}

	public void update(Date date, int acctId, SalesItemModel salesItemModel)
	{
		OrderJournalModel orderJournalModel = getByAllIds(salesItemModel.getSalesId(), salesItemModel.getId());
		if (orderJournalModel == null)
		{
			create(date, acctId, salesItemModel);
		}
		else
		{
			setInJournal(date, acctId, salesItemModel, orderJournalModel);

		}
	}

	public void update(Date date, int acctId, SalesOrderItemModel salesOrderItemModel)
	{
		OrderJournalModel orderJournalModel = getByAllIds(salesOrderItemModel.getSalesOrderId(), salesOrderItemModel.getId());
		if (orderJournalModel == null)
		{
			create(date, acctId, salesOrderItemModel);
		}
		else
		{
			setInJournal(date, acctId, salesOrderItemModel, orderJournalModel);

		}
	}

	public void update(Date date, int acctId, OrderAdjustItemModel orderAdjustItemModel, OrderType orderType)
	{
		OrderJournalModel orderJournalModel = getByAllIds(orderAdjustItemModel.getOrderAdjustId(), orderAdjustItemModel.getId());
		if (orderJournalModel == null)
		{
			create(date, acctId, orderAdjustItemModel, orderType);
		}
		else
		{
			setInJournal(date, acctId, orderAdjustItemModel, orderType, orderJournalModel);

		}
	}

	public void _deleteByVoucherItemId(int voucherId, int voucherItemId)
	{
		List<String> wheres = new ArrayList<>();

		wheres.add(tableName + ".voucher_id = " + voucherId + "");
		wheres.add(tableName + ".voucher_item_id = " + voucherItemId + "");

		String sql = String.format("DELETE FROM %s", tableName);
		sql = SqlHelper.putWheres(wheres, sql);

		session.createNativeQuery(sql).executeUpdate();
	}

	public void _deleteAllVoucherItemIds(int voucherId, List<Integer> idsToBeDeleted)
	{
		if (idsToBeDeleted != null && !idsToBeDeleted.isEmpty())
		{
			List<String> wheres = new ArrayList<>();

			wheres.add(tableName + ".voucher_id = " + voucherId + "");
			int[] ids = new int[idsToBeDeleted.size()];
			for (int i = 0; i < idsToBeDeleted.size(); i++)
			{
				ids[i] = idsToBeDeleted.get(i);
			}
			wheres.add(tableName + ".voucher_item_id IN (" + Util.getCSV(ids) + ")");

			String sql = String.format("DELETE FROM %s", tableName);
			sql = SqlHelper.putWheres(wheres, sql);

			session.createNativeQuery(sql).executeUpdate();
		}
	}

	public void deleteAllVoucherItemIds(int voucherId)
	{
		String sql = String.format("DELETE FROM %s", tableName);

		List<String> wheres = new ArrayList<>();
		wheres.add(String.format("voucher_id = %s", voucherId));

		sql = SqlHelper.putWheres(wheres, sql);

		session.createNativeQuery(sql).executeUpdate();
	}

	private void setInJournal(Date date, int acctId, PurchaseItemModel purchaseItemModel, OrderJournalModel orderJournalModel)
	{
		orderJournalModel.setDate(date);
		orderJournalModel.setProductId(purchaseItemModel.getProductId());
		orderJournalModel.setAcctId(acctId);

		orderJournalModel.setOrderType(OrderType.PURCHASE);

		orderJournalModel.setOrderQty(null);
		orderJournalModel.setPusaQty(purchaseItemModel.getQty());

		orderJournalModel.setVoucherId(purchaseItemModel.getPurchaseId());
		orderJournalModel.setVoucherItemId(purchaseItemModel.getId());
	}

	private void setInJournal(Date date, int acctId, PurchaseOrderItemModel purchaseOrderItemModel, OrderJournalModel orderJournalModel)
	{
		orderJournalModel.setDate(date);
		orderJournalModel.setProductId(purchaseOrderItemModel.getProductId());
		orderJournalModel.setAcctId(acctId);

		orderJournalModel.setOrderType(OrderType.PURCHASE);

		orderJournalModel.setOrderQty(purchaseOrderItemModel.getQty());
		orderJournalModel.setPusaQty(null);

		orderJournalModel.setVoucherId(purchaseOrderItemModel.getPurchaseOrderId());
		orderJournalModel.setVoucherItemId(purchaseOrderItemModel.getId());
	}

	private void setInJournal(Date date, int acctId, SalesItemModel salesItemModel, OrderJournalModel orderJournalModel)
	{
		orderJournalModel.setDate(date);
		orderJournalModel.setProductId(salesItemModel.getProductId());
		orderJournalModel.setAcctId(acctId);

		orderJournalModel.setOrderType(OrderType.SALES);

		orderJournalModel.setOrderQty(null);
		orderJournalModel.setPusaQty(salesItemModel.getQty());

		orderJournalModel.setVoucherId(salesItemModel.getSalesId());
		orderJournalModel.setVoucherItemId(salesItemModel.getId());
	}

	private void setInJournal(Date date, int acctId, SalesOrderItemModel salesOrderItemModel, OrderJournalModel orderJournalModel)
	{
		orderJournalModel.setDate(date);
		orderJournalModel.setProductId(salesOrderItemModel.getProductId());
		orderJournalModel.setAcctId(acctId);

		orderJournalModel.setOrderType(OrderType.SALES);

		orderJournalModel.setOrderQty(salesOrderItemModel.getQty());

		orderJournalModel.setPusaQty(null);

		orderJournalModel.setVoucherId(salesOrderItemModel.getSalesOrderId());
		orderJournalModel.setVoucherItemId(salesOrderItemModel.getId());
	}

	private void setInJournal(Date date, int acctId, OrderAdjustItemModel orderAdjustItemModel, OrderType orderType, OrderJournalModel orderJournalModel)
	{
		orderJournalModel.setDate(date);
		orderJournalModel.setProductId(orderAdjustItemModel.getProdId());
		orderJournalModel.setAcctId(acctId);

		orderJournalModel.setOrderType(orderType);

		orderJournalModel.setOrderQty(orderAdjustItemModel.getOrderQty());
		orderJournalModel.setPusaQty(orderAdjustItemModel.getPusaQty());

		orderJournalModel.setVoucherId(orderAdjustItemModel.getOrderAdjustId());
		orderJournalModel.setVoucherItemId(orderAdjustItemModel.getId());
	}

	public OrderJournalModel getByAllIds(int voucherId, int voucherItemId)
	{
		String sql = String.format("SELECT * FROM %s WHERE voucher_id = %s AND voucher_item_id = %s;",
				tableName,
				String.valueOf(voucherId),
				String.valueOf(voucherItemId));

		List<OrderJournalModel> orderJournalModels = session.createNativeQuery(sql, OrderJournalModel.class).getResultList();
		if (orderJournalModels == null || orderJournalModels.isEmpty())
		{
			return null;
		}
		return orderJournalModels.get(0);

	}

	public List<CurrentStockHdto> getOpeningStock(ProductModel productModel, Date asOnDate)
	{
		return getTotalStock(productModel, asOnDate, TotalStockType.OPENING);
	}

	public List<CurrentStockHdto> getClosingStock(ProductModel productModel, Date asOnDate)
	{
		return getTotalStock(productModel, asOnDate, TotalStockType.CLOSING);
	}

	private enum TotalStockType
	{
		OPENING,
		CLOSING
	}

	private List<CurrentStockHdto> getTotalStock(ProductModel productModel, Date asOnDate, TotalStockType stockType)
	{
		String sql = "SELECT\n"
				+ "	product.id,\n"
				+ "	product.name,\n"
				+ "	unit.code as unit,\n"
				+ "	product.hsn,\n"
				+ "	ifnull(qty_28, 0) as qty_28,\n"
				+ "	ifnull(qty_30, 0) as qty_30,\n"
				+ "	ifnull(qty_32, 0) as qty_32,\n"
				+ "	ifnull(qty_34, 0) as qty_34,\n"
				+ "	ifnull(qty_36, 0) as qty_36,\n"
				+ "	ifnull(qty_38, 0) as qty_38,\n"
				+ "	ifnull(qty_40, 0) as qty_40,\n"
				+ "	ifnull(qty_42, 0) as qty_42,\n"
				+ "	ifnull(qty_44, 0) as qty_44,\n"
				+ "	ifnull(qty_46, 0) as qty_46,\n"
				+ "	ifnull(qty, 0) as qty,\n"
				+ "	ifnull(amt, 0) as amt\n"
				+ "FROM\n"
				+ "	product\n"
				+ "LEFT JOIN	\n"
				+ "	(\n"
				+ "		SELECT\n"
				+ "			product_id,\n"
				+ "			SUM(tx_type * qty_28) as qty_28,\n"
				+ "			SUM(tx_type * qty_30) as qty_30,\n"
				+ "			SUM(tx_type * qty_32) as qty_32,\n"
				+ "			SUM(tx_type * qty_34) as qty_34,\n"
				+ "			SUM(tx_type * qty_36) as qty_36,\n"
				+ "			SUM(tx_type * qty_38) as qty_38,\n"
				+ "			SUM(tx_type * qty_40) as qty_40,\n"
				+ "			SUM(tx_type * qty_42) as qty_42,\n"
				+ "			SUM(tx_type * qty_44) as qty_44,\n"
				+ "			SUM(tx_type * qty_46) as qty_46,\n"
				+ "			SUM(tx_type * qty) as qty,\n"
				+ "			SUM(tx_type * amt) as amt\n"
				+ "		FROM\n"
				+ "			goods_journal\n";

		if (stockType == TotalStockType.OPENING)
		{
			if (asOnDate == null)
			{
				sql = sql + " WHERE\n"
						+ "	date(goods_journal.`date`) <= date('1000-01-01')\n";
			}
			else
			{
				sql = sql + " WHERE\n"
						+ "	date(goods_journal.`date`) < date('" + Util.dateToString(asOnDate, Util.Formats.DB_DATE) + "')\n";
			}
		}
		else if (stockType == TotalStockType.CLOSING && asOnDate != null)
		{
			sql = sql + " WHERE\n"
					+ "	date(goods_journal.`date`) <= date('" + Util.dateToString(asOnDate, Util.Formats.DB_DATE) + "')\n";
		}

		sql = sql + "		GROUP BY\n"
				+ "			product_id\n"
				+ "	) as t1\n"
				+ "ON\n"
				+ "	product.id = t1.product_id\n"
				+ "LEFT JOIN\n"
				+ "	unit\n"
				+ "ON\n"
				+ "	unit.id = product.unit_id\n";
		if (productModel != null)
		{
			sql = sql + "WHERE\n"
					+ "	product.id = " + productModel.getId() + " ";
		}

		sql = sql + "ORDER BY \n"
				+ "	product.name";

		return session.createNativeQuery(sql, CurrentStockHdto.class).getResultList();

	}

	private List<CurrentStockHdto> getReportCurrentStock(ProductModel productModel)
	{

		String sqlCurrentStockPart1 = "SELECT "
				+ "	product.id, "
				+ "	product.name, "
				+ "	unit.name as unit, "
				+ "	product.hsn, "
				+ "	ifnull(qty28, 0) as qty_28, "
				+ "	ifnull(qty30, 0) as qty_30, "
				+ "	ifnull(qty32, 0) as qty_32, "
				+ "	ifnull(qty34, 0) as qty_34, "
				+ "	ifnull(qty36, 0) as qty_36, "
				+ "	ifnull(qty38, 0) as qty_38, "
				+ "	ifnull(qty40, 0) as qty_40, "
				+ "	ifnull(qty42, 0) as qty_42, "
				+ "	ifnull(qty44, 0) as qty_44, "
				+ "	ifnull(qty46, 0) as qty_46, "
				+ "	ifnull(qty, 0) as qty, "
				+ "	ifnull(amt, 0) as amt "
				+ "FROM "
				+ "	product "
				+ "LEFT JOIN "
				+ "	unit "
				+ "ON "
				+ "	product.unit_id = unit.id	 "
				+ "LEFT JOIN "
				+ "	( "
				+ "	SELECT  "
				+ "		product_id,  "
				+ "		SUM(tx_type * qty_28) as qty28, "
				+ "		SUM(tx_type * qty_30) as qty30, "
				+ "		SUM(tx_type * qty_32) as qty32, "
				+ "		SUM(tx_type * qty_34) as qty34, "
				+ "		SUM(tx_type * qty_36) as qty36, "
				+ "		SUM(tx_type * qty_38) as qty38, "
				+ "		SUM(tx_type * qty_40) as qty40, "
				+ "		SUM(tx_type * qty_42) as qty42, "
				+ "		SUM(tx_type * qty_44) as qty44, "
				+ "		SUM(tx_type * qty_46) as qty46, "
				+ "		SUM(tx_type * qty) as qty, "
				+ "		SUM(tx_type * amt) as amt "
				+ "	FROM "
				+ "		goods_journal "
				+ "	GROUP BY  "
				+ "		product_id "
				+ "	) as t2 "
				+ "ON "
				+ "	product.id = t2.product_id ";

		String sql = sqlCurrentStockPart1;

		List<String> wheres = new ArrayList<>();

		if (productModel != null)
		{
			wheres.add(String.format("product.id = %s", productModel.getId()));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " ORDER BY product.name ASC";

		return session.createNativeQuery(sql, CurrentStockHdto.class).getResultList();

	}

	public List<OrderJournalModel> getLedger(ProductModel productModel, Date dateFrom, Date dateTo)
	{

		dateFrom = dateFrom == null ? Util.stringToDate("02-01-1000", Util.Formats.APP_DATE) : dateFrom;

		String sql = String.format(DaoHelper.SELECT_SQL, tableName);
		List<String> wheres = new ArrayList<>();

		wheres.add(tableName + ".product_id=" + String.valueOf(productModel.getId()));

		if (dateFrom != null)
		{
			wheres.add(tableName + ".date>='" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "'");
		}
		if (dateTo != null)
		{
			wheres.add(tableName + ".date<='" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "'");
		}

		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " ORDER BY " + tableName + ".date ASC, id ASC";

		return session.createNativeQuery(sql, OrderJournalModel.class).getResultList();

	}

	public List<OrderJournalModel> getSortByDate(int acctId, Date dateFrom, OrderType orderType, boolean loadOrders, boolean loadPusa)
	{
		String sql = String.format("SELECT * FROM %s", tableName);
		List<String> wheres = new ArrayList<>();

		wheres.add(tableName + ".acct_id =" + String.valueOf(acctId));
		wheres.add(String.format("order_type_id = %s", orderType.getId()));

		if (dateFrom != null)
		{
			wheres.add(String.format("date(date) >= date('%s')", Util.dateToString(dateFrom, Util.Formats.DB_DATE)));
		}

		if (loadOrders)
		{
			wheres.add("order_qty IS NOT NULL");
		}
		else if (loadPusa)
		{
			wheres.add("pusa_qty IS NOT NULL");
		}

		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " ORDER BY " + tableName + ".date ASC, id ASC";

		return session.createNativeQuery(sql, OrderJournalModel.class).getResultList();

	}

	public List<ProductMonthlySummaryHdto> getProductMonthlySummary(int productId)
	{
		String sql = String.format("WITH RECURSIVE cte_name (dt) AS (\n"
				+ "    SELECT DATE_ADD(DATE_ADD(LAST_DAY('{date_from}'),INTERVAL 1 DAY), INTERVAL -1 MONTH)\n"
				+ "    UNION\n"
				+ "    SELECT DATE_ADD(dt, INTERVAL 1 MONTH) FROM cte_name \n"
				+ "	WHERE \n"
				+ "		dt <= '{date_to}'\n"
				+ ") \n"
				+ "SELECT 	\n"
				+ "	YEAR(cte_name.dt) * 100 + MONTH(cte_name.dt) month_yr,\n"
				+ "	YEAR(cte_name.dt) yr,\n"
				+ "	MONTH(cte_name.dt) month, \n"
				+ "	qty_in,\n"
				+ "	qty_out,\n"
				+ "	cte_name.dt\n"
				+ "FROM \n"
				+ "	cte_name\n"
				+ "LEFT JOIN\n"
				+ "(\n"
				+ "	SELECT\n"
				+ "		MONTH(DATE) mm,\n"
				+ "		YEAR(DATE) yy,\n"
				+ "		SUM(qty) qty_in,\n"
				+ "		product_id\n"
				+ "	FROM\n"
				+ "		{table_goods_journal}\n"
				+ "	WHERE\n"
				+ "		product_id = {product_id}\n"
				+ "	AND\n"
				+ "		tx_type = 1\n"
				+ "	GROUP BY\n"
				+ "		MONTH(DATE),\n"
				+ "		YEAR(DATE),\n"
				+ "		product_id\n"
				+ ") t1\n"
				+ "ON\n"
				+ "	MONTH(cte_name.dt) = t1.mm\n"
				+ "AND\n"
				+ "	YEAR(cte_name.dt) = t1.yy\n"
				+ "LEFT JOIN\n"
				+ "(\n"
				+ "	SELECT\n"
				+ "		MONTH(DATE) mm,\n"
				+ "		YEAR(DATE) yy,\n"
				+ "		SUM(qty) qty_out,\n"
				+ "		product_id\n"
				+ "	FROM\n"
				+ "		{table_goods_journal}\n"
				+ "	WHERE\n"
				+ "		product_id = {product_id}\n"
				+ "	AND\n"
				+ "		tx_type = -1\n"
				+ "	GROUP BY\n"
				+ "		MONTH(DATE),\n"
				+ "		YEAR(DATE),\n"
				+ "		product_id\n"
				+ ") t2\n"
				+ "ON\n"
				+ "	MONTH(cte_name.dt) = t2.mm\n"
				+ "AND\n"
				+ "	YEAR(cte_name.dt) = t2.yy\n"
				+ "ORDER BY\n"
				+ "	dt\n"
				+ ";");

		Map<String, String> map = new HashMap<>();

		YearModel yearModel = yearDao.getById(1);

		map.put("product_id", String.valueOf(productId));
		map.put("date_from", Util.dateToString(yearModel.getDateFrom(), Util.Formats.DB_DATE));
		map.put("date_to", Util.dateToString(yearModel.getDateTo(), Util.Formats.DB_DATE));
		map.put("table_goods_journal", TableName.ORDER_JOURNAL);

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, ProductMonthlySummaryHdto.class).getResultList();
	}

	public List<OrderPendingByAcctHdto> getReportByAcct(
			OrderType orderType,
			Integer acctId,
			Integer productId,
			Boolean pending
	)
	{
		String sql = "SELECT\n"
				+ "	acct_id, \n"
				+ "	acct.name acct_name,\n"
				+ "	COUNT(*) product_cnt,\n"
				+ "	IFNULL(SUM(IF(pending_qty > 0, pending_qty , 0)),0) qty_total\n"
				+ "FROM \n"
				+ "	vw_order_pending_qty_det\n"
				+ "LEFT JOIN\n"
				+ "	acct\n"
				+ "ON\n"
				+ "	acct.id = acct_id\n"
				+ "LEFT JOIN\n"
				+ "	product\n"
				+ "ON\n"
				+ "	product.id = product_id\n";

		List<String> wheres = new ArrayList<>();

		if (orderType != null)
		{
			wheres.add(String.format("order_type_id = %s\n", orderType.getId()));
		}
		if (acctId != null)
		{
			wheres.add(String.format("acct_id = %s\n", acctId));
		}
		if (productId != null)
		{
			wheres.add(String.format("product_id = %s\n", productId));
		}
		if (pending != null)
		{
			if (pending)
			{
				wheres.add(String.format("pending_qty > 0\n"));
			}
			else
			{
				wheres.add(String.format("pending_qty <= 0\n"));
			}
		}

		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + "GROUP BY\n"
				+ "	acct_id";

		return session.createNativeQuery(sql, OrderPendingByAcctHdto.class).getResultList();
	}

	public List<OrderPendingByProductHdto> getReportByProduct(
			OrderType orderType,
			Integer acctId,
			Integer productId,
			Boolean pending
	)
	{
		String sql = "SELECT\n"
				+ "	product_id, \n"
				+ "	product.name product_name,\n"
				+ "	COUNT(*) acct_cnt,\n"
				+ "	SUM(pending_qty) qty_total\n"
				+ "FROM \n"
				+ "	vw_order_pending_qty_det\n"
				+ "LEFT JOIN\n"
				+ "	acct\n"
				+ "ON\n"
				+ "	acct.id = acct_id\n"
				+ "LEFT JOIN\n"
				+ "	product\n"
				+ "ON\n"
				+ "	product.id = product_id\n";

		List<String> wheres = new ArrayList<>();

		if (orderType != null)
		{
			wheres.add(String.format("order_type_id = %s\n", orderType.getId()));
		}
		if (acctId != null)
		{
			wheres.add(String.format("acct_id = %s\n", acctId));
		}
		if (productId != null)
		{
			wheres.add(String.format("product_id = %s\n", productId));
		}
		if (pending != null)
		{
			if (pending)
			{
				wheres.add(String.format("pending_qty > 0\n"));
			}
			else
			{
				wheres.add(String.format("pending_qty <= 0\n"));
			}
		}

		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + "GROUP BY\n"
				+ "	product_id";

		return session.createNativeQuery(sql, OrderPendingByProductHdto.class).getResultList();
	}

	public List<OrderLedgerHdto> getOrderLedgerHdtos(
			OrderType orderType,
			Integer acctId,
			Integer prodId
	)
	{
		String sql = "SELECT\n"
				+ "	order_journal.voucher_id id,\n"
				+ "	voucher.voucher_type_id,\n"
				+ "	voucher.no,\n"
				+ "	order_journal.date,\n"
				+ "	acct.id acct_id,\n"
				+ "	acct.name acct_name,\n"
				+ "	product.id product_id,\n"
				+ "	product.name product_name,\n"
				+ "	order_journal.order_qty,\n"
				+ "	order_journal.pusa_qty\n"
				+ "FROM\n"
				+ "	order_journal\n"
				+ "LEFT JOIN\n"
				+ "	acct\n"
				+ "ON\n"
				+ "	acct.id = order_journal.acct_id\n"
				+ "LEFT JOIN\n"
				+ "	product\n"
				+ "ON\n"
				+ "	product.id = order_journal.product_id\n"
				+ "LEFT JOIN\n"
				+ "	voucher\n"
				+ "ON	\n"
				+ "	voucher.id = order_journal.voucher_id\n"
				+ "WHERE\n"
				+ "	order_journal.acct_id = {acct_id}\n"
				+ "AND\n"
				+ "	order_journal.product_id = {product_id}\n"
				+ "AND\n"
				+ "	order_journal.date >= (\n"
				+ "		SELECT\n"
				+ "			MIN(oj_in.DATE)\n"
				+ "		FROM\n"
				+ "			order_journal oj_in\n"
				+ "		WHERE\n"
				+ "			oj_in.acct_id = order_journal.acct_id\n"
				+ "		AND\n"
				+ "			oj_in.product_id = order_journal.product_id\n"
				+ "		AND\n"
				+ "			oj_in.order_type_id = order_journal.order_type_id\n"
				+ "		AND\n"
				+ "			oj_in.order_qty IS NOT NULL\n"
				+ "	)\n"
				+ "AND\n"
				+ "	order_type_id = {order_type_id}\n"
				+ "ORDER BY \n"
				+ "	order_journal.DATE,"
				+ "	voucher.voucher_type_id DESC";

		Map<String, String> map = new HashMap<>();
		map.put("table_voucher", TableName.VOUCHER);

		map.put("table_sales_order", tableName);
		map.put("table_sales_order_item", TableName.SALES_ORDER_ITEM);

		map.put("table_sales", TableName.SALES);
		map.put("table_sales_item", TableName.SALES_ITEM);

		map.put("table_acct", TableName.ACCT);
		map.put("table_product", TableName.PRODUCT);

		map.put("order_type_id", String.valueOf(orderType.getId()));
		map.put("acct_id", String.valueOf(acctId));
		map.put("product_id", String.valueOf(prodId));

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, OrderLedgerHdto.class).getResultList();
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
