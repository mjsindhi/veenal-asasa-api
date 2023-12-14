package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dao.app.YearDao;
import com.hemsw.asasaapi.veenal.dto.hdto.DueRcvableByCustomerHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.DueRcvableBySalesHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptSalesByAgentHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptSalesByCityHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptSalesByCustomerHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptSalesByDayHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptSalesByMonthHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptSalesByProdCatHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptSalesByProdHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptSalesByStateHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptSalesDetailedByProdHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptSalesDetailedByVoucherHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptSalesProfitByCustomerHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptSalesProfitByProdHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptSalesProfitBySalesItemHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptSalesProfitBySalesVoucherHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.SalesAnalysisDetHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.SalesAnalysisSummHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.TaxSumHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.TaxSummaryHdto;
import com.hemsw.asasaapi.veenal.dto.ldto.SalesLdto;
import com.hemsw.asasaapi.veenal.enums.ListMenu;
import com.hemsw.asasaapi.veenal.enums.RptSalesAnalysisGroupBy;
import static com.hemsw.asasaapi.veenal.enums.RptSalesAnalysisGroupBy.CATEGORY;
import static com.hemsw.asasaapi.veenal.enums.RptSalesAnalysisGroupBy.CITY;
import static com.hemsw.asasaapi.veenal.enums.RptSalesAnalysisGroupBy.DAY;
import com.hemsw.asasaapi.veenal.enums.SortOrderEnum;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.app.ColSettingModel;
import com.hemsw.asasaapi.veenal.model.app.YearModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import com.hemsw.asasaapi.veenal.service.enums.RptSalesByAgentSortByEnum;
import com.hemsw.asasaapi.veenal.service.enums.RptSalesByCitySortByEnum;
import com.hemsw.asasaapi.veenal.service.enums.RptSalesByCustomerSortByEnum;
import com.hemsw.asasaapi.veenal.service.enums.RptSalesByDaySortByEnum;
import com.hemsw.asasaapi.veenal.service.enums.RptSalesByMonthSortByEnum;
import com.hemsw.asasaapi.veenal.service.enums.RptSalesByProdCatSortByEnum;
import com.hemsw.asasaapi.veenal.service.enums.RptSalesByProdSortByEnum;
import com.hemsw.asasaapi.veenal.service.enums.RptSalesByStateSortByEnum;
import com.hemsw.asasaapi.veenal.service.enums.RptSalesDetailedByProdSortByEnum;
import com.hemsw.asasaapi.veenal.service.enums.RptSalesDetailedByVoucherSortByEnum;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalesDao //extends BaseDao<SalesModel>
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	@Autowired
	private YearDao yearDao;

	@Autowired
	VoucherDao voucherDAO;

	public static final String tableName = "sales";
	String sqlGetNexNo = "SELECT MAX(no) FROM %s";
	String sqlGetSumOfAmtPayable = "SELECT SUM(amt_payable) FROM %s";
	String sqlGetTaxSum = "SELECT\n"
			+ "	sum(sales_item.qty) as qty,\n"
			+ "	sum(sales_item.amt_after_disc) as taxable_amt,\n"
			+ "	sum(sales_item.cgst_a) as cgst_a,\n"
			+ "	sum(sales_item.sgst_a) as sgst_a,\n"
			+ "	sum(sales_item.igst_a) as igst_a,\n"
			+ "	sum(sales_item.cgst_a) + sum(sales_item.sgst_a) + sum(sales_item.igst_a)  as total\n"
			+ "FROM\n"
			+ "	sales_item\n"
			+ "LEFT join\n"
			+ "	product\n"
			+ "ON\n"
			+ "	product.id = sales_item.product_id\n"
			+ "WHERE\n"
			+ "	sales_item.sales_id = %s\n"
			+ "AND\n"
			+ "	(\n"
			+ "		sales_item.cgst_a > 0\n"
			+ "		OR \n"
			+ "		sales_item.sgst_a > 0\n"
			+ "		OR \n"
			+ "		sales_item.igst_a > 0\n"
			+ "	)\n"
			+ "GROUP BY\n"
			+ "	sales_item.sales_id";

	//
	public void create(SalesModel sales, String no, Date date, int createdByUserId)
	{
		VoucherModel voucherModel = voucherDAO.generateVoucherModel(no, date, null, VoucherType.SALES);
		voucherModel.setCreatedByUserId(createdByUserId);
		voucherDAO.create(voucherModel);

		sales.setId(voucherModel.getId());
		session.persist(sales);
	}

	public void update(SalesModel sales, String no, Date date)
	{
		VoucherModel voucherModel = voucherDAO.getById(sales.getId());
		voucherModel.setNo(no);
		voucherModel.setDate(date);

		//voucherDAO.update(voucherModel);
		//miniOrm.update(sales);
	}

	public String getTableName()
	{
		return tableName;
	}

	public int getMinBlankNoToFill()
	{
		String sql = "select MIN(no) + 1 from sales as t1 where ( select count(*) from sales where no = t1.no + 1) = 0 ORDER BY t1.no;";
		List<Integer> integers = session.createNativeQuery(sql, Integer.class).getResultList();
		return integers.get(0);
	}

	public Date getPrevSalesDate(int salesId)
	{
		String sql = "SELECT \n"
				+ "	DATE\n"
				+ "FROM \n"
				+ "	sales \n"
				+ "LEFT JOIN\n"
				+ "	voucher\n"
				+ "ON\n"
				+ "	sales.id = voucher.id\n"
				+ "WHERE \n"
				+ "	DATE < (SELECT DATE FROM sales s LEFT JOIN voucher v ON s.id = v.id WHERE s.id = %s)\n"
				+ "AND\n"
				+ "	customer_id = (SELECT customer_id FROM sales WHERE id = %s)\n"
				+ "ORDER BY \n"
				+ "	DATE DESC,\n"
				+ "	NO DESC,\n"
				+ "	sales.id DESC\n"
				+ "LIMIT 1";

		sql = String.format(sql, salesId, salesId);

		List<Date> results = session.createNativeQuery(sql, Date.class).getResultList();
		return results == null || results.isEmpty() ? null : results.get(0);
	}

	//
	public SalesModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, getTableName(), String.valueOf(id));
		List<SalesModel> dtos = session.createNativeQuery(sql, SalesModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public List<SalesModel> get()
	{
		String sql = String.format("SELECT * FROM %s", tableName);
		sql = sql + " ORDER BY id ASC";
		return session.createNativeQuery(sql, SalesModel.class).getResultList();
	}

	public BigDecimal getSum(int customerId, Date dateFrom, Date dateTo)
	{
		return null; //TODO DAOHelper.getSum(miniOrm, sqlGetSumOfAmtPayable, tableName, "customer_id", customerId, dateFrom, dateTo);
	}

	public List<SalesLdto> getLdtos(
			Integer no,
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			String customerName,
			String city,
			Integer stateId,
			String state,
			String orderNo,
			Date orderDateFrom,
			Date orderDateTo,
			Integer agentId,
			String agentName,
			String lrNo,
			Date lrDateFrom,
			Date lrDateTo,
			Integer transporterId,
			String transporterName,
			Integer companyProfileId,
			String note,
			Boolean isCleared
	)
	{
		String sql = "	SELECT	\n"
				+ "			{table_sales}.id,\n"
				+ "			{table_voucher}.no,	\n"
				+ "			t_sales_ledger_acct.name sales_ledger,	\n"
				+ "			{table_voucher}.date,	\n"
				+ "			{table_sales}.customer_id,\n"
				+ "			{table_acct}.name customer_name,\n"
				+ "			{table_customer}.city,\n"
				+ "			{table_state}.id state_id,\n"
				+ "			{table_state}.name state_name,\n"
				+ "			IF({table_sales}.sales_order_id IS NULL, {table_sales}.order_no, sales_order_voucher.no) order_no,\n"
				+ "			IF({table_sales}.sales_order_id IS NULL, {table_sales}.order_date, sales_order_voucher.date) order_date,\n"
				+ "			{table_sales}.lr_no,\n"
				+ "			{table_sales}.lr_date,\n"
				+ "			{table_transporter}.id transporter_id,\n"
				+ "			{table_transporter}.name transporter_name,\n"
				+ "			{table_company_profile}.id company_profile_id,\n"
				+ "			{table_company_profile}.name company_profile_name,\n"
				+ "			final_invoice_no,\n"
				+ "			{table_sales}.amt_payable,\n"
				+ "			IFNULL(t1.amt_clrd, 0) amt_clrd,\n"
				+ "			({table_sales}.amt_payable - IFNULL(t1.amt_clrd, 0)) amt_unclrd,\n"
				+ "			datediff(NOW(), {table_voucher}.date) days_cnt,\n"
				+ "			DATE_ADD({table_voucher}.date, INTERVAL IFNULL({table_customer}.credit_days, 0) DAY) due_date,\n"
				+ "			IFNULL({table_customer}.credit_days, 0) credit_days,\n"
				+ "			{table_sales}.note,\n"
				+ "			{table_sales}.no_of_carton,\n"
				+ "			{table_sales}.delivery_by,\n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_voucher}.created_at\n"
				+ "		FROM\n"
				+ "			{table_sales}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_voucher}\n"
				+ "		ON\n"
				+ "			{table_sales}.id = {table_voucher}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_acct}\n"
				+ "		ON\n"
				+ "			{table_acct}.id = {table_sales}.customer_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_acct} t_sales_ledger_acct\n"
				+ "		ON\n"
				+ "			t_sales_ledger_acct.id = 15\n"
				+ "		LEFT JOIN\n"
				+ "			{table_customer}\n"
				+ "		ON\n"
				+ "			{table_customer}.id = {table_sales}.customer_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_transporter}\n"
				+ "		ON\n"
				+ "			{table_transporter}.id = {table_sales}.transporter_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_sales_order}\n"
				+ "		ON\n"
				+ "			{table_sales_order}.id = {table_sales}.sales_order_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_voucher} sales_order_voucher\n"
				+ "		ON\n"
				+ "			sales_order_voucher.id = {table_sales_order}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_state}\n"
				+ "		ON\n"
				+ "			{table_state}.id = {table_customer}.state_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_company_profile}\n"
				+ "		ON\n"
				+ "			{table_company_profile}.id = {table_sales}.company_profile_id\n"
				+ "		LEFT JOIN\n"
				+ "			(\n"
				+ "				SELECT\n"
				+ "					SUM(amt) amt_clrd,\n"
				+ "					cr_voucher_id sales_id\n"
				+ "				FROM\n"
				+ "					{table_set_against}\n"
				+ "				GROUP BY\n"
				+ "					cr_voucher_id\n"
				+ "			) as t1\n"
				+ "		ON\n"
				+ "			t1.sales_id = {table_sales}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_voucher}.created_by_user_id\n";

		List<String> wheres = new ArrayList<>();

		if (no != null)
		{
			wheres.add("{table_voucher}.no=" + String.valueOf(no));
		}
		if (dateFrom != null)
		{
			wheres.add("date({table_voucher}.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date({table_voucher}.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add("{table_sales}.customer_id=" + customerId);
		}
		if (customerName != null && !customerName.isEmpty())
		{
			wheres.add("{table_acct}.name LIKE '%" + SqlHelper.escape(customerName) + "%'");
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add("city LIKE '%" + SqlHelper.escape(city) + "%'");
		}
		if (state != null && !state.isEmpty())
		{
			wheres.add("{table_state}.name LIKE '%" + SqlHelper.escape(state) + "%'");
		}
		if (stateId != null)
		{
			wheres.add("state_id = " + stateId + "");
		}
		if (orderNo != null && !orderNo.isEmpty())
		{
			wheres.add("order_no = '" + SqlHelper.escape(orderNo) + "'");
		}
		if (orderDateFrom != null)
		{
			wheres.add("date(order_date)>=date('" + Util.dateToString(orderDateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (orderDateTo != null)
		{
			wheres.add("date(order_date)<=date('" + Util.dateToString(orderDateTo, Util.Formats.DB_DATE) + "')");
		}
		if (agentId != null)
		{
			wheres.add(String.format("%s IN (SELECT agent_id FROM sales_agent WHERE sales_agent.sales_id = sales.id)", agentId));
		}
		if (lrNo != null && !lrNo.isEmpty())
		{
			wheres.add("lr_no LIKE '%" + lrNo + "%'");
		}
		if (lrDateFrom != null)
		{
			wheres.add("date(lr_date)>=date('" + Util.dateToString(lrDateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (lrDateTo != null)
		{
			wheres.add("date(lr_date)<=date('" + Util.dateToString(lrDateTo, Util.Formats.DB_DATE) + "')");
		}
		if (transporterId != null)
		{
			wheres.add("transporter_id=" + transporterId);
		}
		if (transporterName != null && !transporterName.isEmpty())
		{
			wheres.add("{table_transporter).name LIKE '%" + SqlHelper.escape(transporterName) + "%'");
		}
		if (note != null && !note.isEmpty())
		{
			wheres.add("note LIKE '%" + note + "%'");
		}
		if (companyProfileId != null)
		{
			wheres.add("{table_sales}.company_profile_id=" + companyProfileId);
		}

		if (isCleared != null)
		{
			if (isCleared)
			{
				wheres.add("(({table_sales}.amt_payable - IFNULL(t1.amt_clrd, 0))) <= 0");
			}
			else
			{
				wheres.add("(({table_sales}.amt_payable - IFNULL(t1.amt_clrd, 0))) > 0");
			}
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<ColSettingModel> colSettingModels = colSettingDao.getByMenuIdForOrder(ListMenu.SALES.getId(), true);

		List<String> orderBys = new ArrayList<>();
		for (ColSettingModel colSettingModel : colSettingModels)
		{
			orderBys.add(String.format("%s %s", colSettingModel.getColKey(), colSettingModel.getOrderByType().getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_sales", tableName);
		map.put("table_voucher", TableName.VOUCHER);
		map.put("table_acct", TableName.ACCT);
		map.put("table_customer", TableName.CUSTOMER);
		map.put("table_state", TableName.STATE);
		map.put("table_transporter", TableName.TRANSPORTER);
		map.put("table_set_against", TableName.SET_AGAINST);
		map.put("table_company_profile", TableName.COMPANY_PROFILE);
		map.put("table_user", TableName.USER);
		map.put("table_sales_order", TableName.SALES_ORDER);

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, SalesLdto.class).getResultList();
	}

	public List<DueRcvableByCustomerHdto> getDueRcvableByCustomerHdtos(
			Integer no,
			Date dateFrom,
			Date dateTo,
			BigDecimal minAmt,
			Integer customerId,
			String customerName,
			String city,
			Integer stateId,
			String state,
			String orderNo,
			Date orderDateFrom,
			Date orderDateTo,
			Integer agentId,
			String agentName,
			String lrNo,
			Date lrDateFrom,
			Date lrDateTo,
			Integer transporterId,
			String transporterName,
			Integer companyProfileId,
			String note,
			Date asOnDate,
			Boolean isOverdue
	)
	{
		String sql = "	SELECT	\n"
				+ "			{table_sales}.customer_id id,\n"
				+ "			{table_acct}.name customer_name,\n"
				+ "			{table_customer}.city,\n"
				+ "			{table_state}.name state_name,\n"
				+ "			{table_customer}.credit_days credit_days,\n"
				+ "			SUM({table_sales}.amt_payable - IFNULL(t1.amt_clrd, 0)) sum_amt\n"
				+ "		FROM\n"
				+ "			{table_sales}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_voucher}\n"
				+ "		ON\n"
				+ "			{table_sales}.id = {table_voucher}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_acct}\n"
				+ "		ON\n"
				+ "			{table_acct}.id = {table_sales}.customer_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_customer}\n"
				+ "		ON\n"
				+ "			{table_customer}.id = {table_sales}.customer_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_transporter}\n"
				+ "		ON\n"
				+ "			{table_transporter}.id = {table_sales}.transporter_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_sales_order}\n"
				+ "		ON\n"
				+ "			{table_sales_order}.id = {table_sales}.sales_order_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_voucher} sales_order_voucher\n"
				+ "		ON\n"
				+ "			sales_order_voucher.id = {table_sales_order}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_state}\n"
				+ "		ON\n"
				+ "			{table_state}.id = {table_customer}.state_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_company_profile}\n"
				+ "		ON\n"
				+ "			{table_company_profile}.id = {table_sales}.company_profile_id\n"
				+ "		LEFT JOIN\n"
				+ "			(\n"
				+ "				SELECT\n"
				+ "					SUM(amt) amt_clrd,\n"
				+ "					cr_voucher_id sales_id\n"
				+ "				FROM\n"
				+ "					{table_set_against}\n"
				+ "				GROUP BY\n"
				+ "					cr_voucher_id\n"
				+ "			) as t1\n"
				+ "		ON\n"
				+ "			t1.sales_id = {table_sales}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_voucher}.created_by_user_id\n";

		List<String> wheres = new ArrayList<>();

		if (no != null)
		{
			wheres.add("{table_voucher}.no=" + String.valueOf(no));
		}
		if (dateFrom != null)
		{
			wheres.add("date({table_voucher}.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date({table_voucher}.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}

		if (customerId != null)
		{
			wheres.add("{table_sales}.customer_id=" + customerId);
		}
		if (customerName != null && !customerName.isEmpty())
		{
			wheres.add("{table_acct}.name LIKE '%" + SqlHelper.escape(customerName) + "%'");
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add("city LIKE '%" + SqlHelper.escape(city) + "%'");
		}
		if (state != null && !state.isEmpty())
		{
			wheres.add("{table_state}.name LIKE '%" + SqlHelper.escape(state) + "%'");
		}
		if (stateId != null)
		{
			wheres.add("{table_state}.id = " + stateId + "");
		}
		if (orderNo != null && !orderNo.isEmpty())
		{
			wheres.add("order_no = '" + SqlHelper.escape(orderNo) + "'");
		}
		if (orderDateFrom != null)
		{
			wheres.add("date(order_date)>=date('" + Util.dateToString(orderDateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (orderDateTo != null)
		{
			wheres.add("date(order_date)<=date('" + Util.dateToString(orderDateTo, Util.Formats.DB_DATE) + "')");
		}
		if (agentId != null)
		{
			wheres.add(String.format("%s IN (SELECT agent_id FROM sales_agent WHERE sales_agent.sales_id = sales.id)", agentId));
		}
		if (lrNo != null && !lrNo.isEmpty())
		{
			wheres.add("lr_no LIKE '%" + lrNo + "%'");
		}
		if (lrDateFrom != null)
		{
			wheres.add("date(lr_date)>=date('" + Util.dateToString(lrDateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (lrDateTo != null)
		{
			wheres.add("date(lr_date)<=date('" + Util.dateToString(lrDateTo, Util.Formats.DB_DATE) + "')");
		}
		if (transporterId != null)
		{
			wheres.add("{table_sales}.transporter_id=" + transporterId);
		}
		if (transporterName != null && !transporterName.isEmpty())
		{
			wheres.add("{table_transporter}.name LIKE '%" + SqlHelper.escape(transporterName) + "%'");
		}
		if (note != null && !note.isEmpty())
		{
			wheres.add("{table_sales}.note LIKE '%" + note + "%'");
		}
		if (companyProfileId != null)
		{
			wheres.add("{table_sales}.company_profile_id=" + companyProfileId);
		}

		wheres.add("{table_sales}.amt_payable > IFNULL(t1.amt_clrd, 0)");

		if (isOverdue != null)
		{
			wheres.add(String.format(
					"(IF(IFNULL({table_customer}.credit_days, 0) > datediff({as_on_date}, {table_voucher}.date) , 0 , datediff({as_on_date}, {table_voucher}.date) - IFNULL({table_customer}.credit_days, 0) )) %s 0",
					isOverdue ? ">" : "<="
			));
		}

		wheres.add("credit_days IS NOT NULL");

		sql = SqlHelper.putWheres(wheres, sql);

		List<String> groupBys = new ArrayList<>();
		groupBys.add("{table_sales}.customer_id\n");
		sql = SqlHelper.putGroupBys(groupBys, sql);

		List<String> havings = new ArrayList<>();
		if (minAmt != null)
		{
			havings.add(String.format("sum_amt >= %s", minAmt));
		}
		sql = SqlHelper.putHavings(havings, sql);

		List<ColSettingModel> colSettingModels = colSettingDao.getByMenuIdForOrder(ListMenu.DUE_RCVABLE_BY_CUSTOMER.getId(), true);

		List<String> orderBys = new ArrayList<>();
		for (ColSettingModel colSettingModel : colSettingModels)
		{
			orderBys.add(String.format("%s %s", colSettingModel.getColKey(), colSettingModel.getOrderByType().getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_sales", tableName);
		map.put("table_voucher", TableName.VOUCHER);
		map.put("table_acct", TableName.ACCT);
		map.put("table_customer", TableName.CUSTOMER);
		map.put("table_state", TableName.STATE);
		map.put("table_transporter", TableName.TRANSPORTER);
		map.put("table_set_against", TableName.SET_AGAINST);
		map.put("table_company_profile", TableName.COMPANY_PROFILE);
		map.put("table_user", TableName.USER);
		map.put("table_sales_order", TableName.SALES_ORDER);
		if (asOnDate == null)
		{
			map.put("as_on_date", "NOW()");
		}
		else
		{
			map.put("as_on_date", "'" + Util.dateToString(asOnDate, Util.Formats.DB_DATE) + "'");
		}

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, DueRcvableByCustomerHdto.class).getResultList();
	}

	public List<DueRcvableBySalesHdto> getDueRcvableBySalesHdtos(
			Integer no,
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			String customerName,
			String city,
			Integer stateId,
			String state,
			String orderNo,
			Date orderDateFrom,
			Date orderDateTo,
			Integer agentId,
			String agentName,
			String lrNo,
			Date lrDateFrom,
			Date lrDateTo,
			Integer transporterId,
			String transporterName,
			Integer companyProfileId,
			String note,
			Boolean isCleared,
			Date asOnDate,
			Boolean isOverdue
	)
	{
		isCleared = false;

		String sql = "		SELECT	\n"
				+ "			{table_sales}.id,\n"
				+ "			{table_voucher}.no,	\n"
				+ "			{table_voucher}.date,	\n"
				+ "			{table_sales}.customer_id,\n"
				+ "			{table_acct}.name customer_name,\n"
				+ "			{table_customer}.city,\n"
				+ "			{table_state}.id state_id,\n"
				+ "			{table_state}.name state_name,\n"
				+ "			IF({table_sales}.sales_order_id IS NULL, {table_sales}.order_no, sales_order_voucher.no) order_no,\n"
				+ "			IF({table_sales}.sales_order_id IS NULL, {table_sales}.order_date, sales_order_voucher.date) order_date,\n"
				+ "			NULL agent_id,\n"
				+ "			\"\" agent_name,\n"
				+ "			{table_sales}.lr_no,\n"
				+ "			{table_sales}.lr_date,\n"
				+ "			{table_transporter}.id transporter_id,\n"
				+ "			{table_transporter}.name transporter_name,\n"
				+ "			{table_company_profile}.id company_profile_id,\n"
				+ "			{table_company_profile}.name company_profile_name,\n"
				+ "			final_invoice_no,\n"
				+ "			{table_sales}.amt_payable,\n"
				+ "			IFNULL(t1.amt_clrd, 0) amt_clrd,\n"
				+ "			({table_sales}.amt_payable - IFNULL(t1.amt_clrd, 0)) amt_unclrd,\n"
				+ "			{table_customer}.credit_days credit_days,\n"
				+ "			datediff({as_on_date}, {table_voucher}.date) age_days,\n"
				+ "			IF(IFNULL({table_customer}.credit_days, 0) > datediff({as_on_date}, {table_voucher}.date) , 0 , datediff({as_on_date}, {table_voucher}.date) - IFNULL({table_customer}.credit_days, 0) ) overdue_days,\n"
				+ "			DATE_ADD({table_voucher}.date, INTERVAL IFNULL({table_customer}.credit_days, 0) DAY) due_date,\n"
				+ "			{table_sales}.note,\n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_voucher}.created_at\n"
				+ "		FROM\n"
				+ "			{table_sales}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_voucher}\n"
				+ "		ON\n"
				+ "			{table_sales}.id = {table_voucher}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_acct}\n"
				+ "		ON\n"
				+ "			{table_acct}.id = {table_sales}.customer_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_customer}\n"
				+ "		ON\n"
				+ "			{table_customer}.id = {table_sales}.customer_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_transporter}\n"
				+ "		ON\n"
				+ "			{table_transporter}.id = {table_sales}.transporter_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_sales_order}\n"
				+ "		ON\n"
				+ "			{table_sales_order}.id = {table_sales}.sales_order_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_voucher} sales_order_voucher\n"
				+ "		ON\n"
				+ "			sales_order_voucher.id = {table_sales_order}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_state}\n"
				+ "		ON\n"
				+ "			{table_state}.id = {table_customer}.state_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_company_profile}\n"
				+ "		ON\n"
				+ "			{table_company_profile}.id = {table_sales}.company_profile_id\n"
				+ "		LEFT JOIN\n"
				+ "			(\n"
				+ "				SELECT\n"
				+ "					SUM(amt) amt_clrd,\n"
				+ "					cr_voucher_id sales_id\n"
				+ "				FROM\n"
				+ "					{table_set_against}\n"
				+ "				GROUP BY\n"
				+ "					cr_voucher_id\n"
				+ "			) as t1\n"
				+ "		ON\n"
				+ "			t1.sales_id = {table_sales}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_voucher}.created_by_user_id\n";

		List<String> wheres = new ArrayList<>();

		if (no != null)
		{
			wheres.add("{table_voucher}.no=" + String.valueOf(no));
		}
		if (dateFrom != null)
		{
			wheres.add("date({table_voucher}.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date({table_voucher}.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add("{table_sales}.customer_id=" + customerId);
		}
		if (customerName != null && !customerName.isEmpty())
		{
			wheres.add("{table_acct}.name LIKE '%" + SqlHelper.escape(customerName) + "%'");
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add("{table_customer}.city LIKE '%" + SqlHelper.escape(city) + "%'");
		}
		if (state != null && !state.isEmpty())
		{
			wheres.add("{table_state}.name LIKE '%" + SqlHelper.escape(state) + "%'");
		}
		if (stateId != null)
		{
			wheres.add("{table_state}.id = " + stateId + "");
		}
		if (orderNo != null && !orderNo.isEmpty())
		{
			wheres.add("{table_sales}.order_no = '" + SqlHelper.escape(orderNo) + "'");
		}
		if (orderDateFrom != null)
		{
			wheres.add("date({table_sales}.order_date)>=date('" + Util.dateToString(orderDateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (orderDateTo != null)
		{
			wheres.add("date({table_sales}.order_date)<=date('" + Util.dateToString(orderDateTo, Util.Formats.DB_DATE) + "')");
		}
		if (agentId != null)
		{
			wheres.add(String.format("%s IN (SELECT agent_id FROM sales_agent WHERE sales_agent.sales_id = sales.id)", agentId));
		}
		if (lrNo != null && !lrNo.isEmpty())
		{
			wheres.add("{table_sales}.lr_no LIKE '%" + lrNo + "%'");
		}
		if (lrDateFrom != null)
		{
			wheres.add("date({table_sales}.lr_date)>=date('" + Util.dateToString(lrDateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (lrDateTo != null)
		{
			wheres.add("date({table_sales}.lr_date)<=date('" + Util.dateToString(lrDateTo, Util.Formats.DB_DATE) + "')");
		}
		if (transporterId != null)
		{
			wheres.add("{table_sales}.transporter_id=" + transporterId);
		}
		if (transporterName != null && !transporterName.isEmpty())
		{
			wheres.add("{table_transporter}.name LIKE '%" + SqlHelper.escape(transporterName) + "%'");
		}
		if (note != null && !note.isEmpty())
		{
			wheres.add("{table_sales}.note LIKE '%" + note + "%'");
		}
		if (companyProfileId != null)
		{
			wheres.add("{table_sales}.company_profile_id=" + companyProfileId);
		}

		if (isCleared != null)
		{
			if (isCleared)
			{
				wheres.add("(({table_sales}.amt_payable - IFNULL(t1.amt_clrd, 0))) <= 0");
			}
			else
			{
				wheres.add("(({table_sales}.amt_payable - IFNULL(t1.amt_clrd, 0))) > 0");
			}
		}

		if (isOverdue != null)
		{
			if (isOverdue)
			{
				wheres.add("(IF(IFNULL({table_customer}.credit_days, 0) > datediff({as_on_date}, {table_voucher}.date) , 0 , datediff({as_on_date}, {table_voucher}.date) - IFNULL({table_customer}.credit_days, 0) )) > 0");
			}
			else
			{
				wheres.add("(IF(IFNULL({table_customer}.credit_days, 0) > datediff({as_on_date}, {table_voucher}.date) , 0 , datediff({as_on_date}, {table_voucher}.date) - IFNULL({table_customer}.credit_days, 0) )) <= 0");
			}
		}

		wheres.add("credit_days IS NOT NULL");

		sql = SqlHelper.putWheres(wheres, sql);

		List<ColSettingModel> colSettingModels = colSettingDao.getByMenuIdForOrder(ListMenu.DUE_RCVABLE_BY_SALES.getId(), true);

		List<String> orderBys = new ArrayList<>();
		for (ColSettingModel colSettingModel : colSettingModels)
		{
			orderBys.add(String.format("%s %s", colSettingModel.getColKey(), colSettingModel.getOrderByType().getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_sales", tableName);
		map.put("table_voucher", TableName.VOUCHER);
		map.put("table_acct", TableName.ACCT);
		map.put("table_customer", TableName.CUSTOMER);
		map.put("table_state", TableName.STATE);
		map.put("table_transporter", TableName.TRANSPORTER);
		map.put("table_set_against", TableName.SET_AGAINST);
		map.put("table_company_profile", TableName.COMPANY_PROFILE);
		map.put("table_user", TableName.USER);
		map.put("table_sales_order", TableName.SALES_ORDER);
		if (asOnDate == null)
		{
			map.put("as_on_date", "NOW()");
		}
		else
		{
			map.put("as_on_date", "'" + Util.dateToString(asOnDate, Util.Formats.DB_DATE) + "'");
		}

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, DueRcvableBySalesHdto.class).getResultList();
	}

	public List<SalesModel> getForClearing(int customerId, Integer clearedByVoucherId)
	{

		String innerSql = "";
		if (clearedByVoucherId != null)
		{
			innerSql = String.format("	OR\n"
					+ "		id IN (\n"
					+ "			SELECT\n"
					+ "				cr_voucher_id\n"
					+ "			FROM	\n"
					+ "				set_against\n"
					+ "			WHERE\n"
					+ "				dr_voucher_id = %s\n"
					+ "		)\n", clearedByVoucherId);
		}

		String sql = String.format("SELECT\n"
				+ "	*\n"
				+ "FROM\n"
				+ "	%s\n"
				+ "LEFT JOIN\n"
				+ " {table_voucher}\n"
				+ "ON\n"
				+ " {table_voucher}.id = {table_sales}.id\n"
				+ "WHERE\n"
				+ "	customer_id = %s\n"
				+ "AND\n"
				+ "(\n"
				+ "	(amt_payable - (SELECT ifnull(SUM(amt),0) FROM %s WHERE cr_voucher_id = %s.id)) <> 0\n"
				+ " %s "
				+ ")", tableName, customerId, TableName.SET_AGAINST, tableName, innerSql);

		sql = sql + " ORDER BY date ASC, no ASC";

		Map<String, String> map = new HashMap<>();
		map.put("table_sales", tableName);
		map.put("table_voucher", TableName.VOUCHER);

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, SalesModel.class).getResultList();
	}

	public List<TaxSummaryHdto> getTaxSummaryHelperModels(int salesId)
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
				+ "		{table_sales_item}.*,\n"
				+ "		IF({table_product}.tax_cat_id IS NULL, {table_product}.hsn, {table_tax_cat}.hsn) hsn\n"
				+ "	FROM\n"
				+ "		{table_sales_item}\n"
				+ "	LEFT JOIN\n"
				+ "		{table_product}\n"
				+ "	ON\n"
				+ "		{table_product}.id = {table_sales_item}.product_id\n"
				+ "	LEFT JOIN\n"
				+ "		{table_tax_cat}\n"
				+ "	ON\n"
				+ "		{table_tax_cat}.id = {table_product}.tax_cat_id\n"
				+ ") t1\n";

		List<String> wheres = new ArrayList<>();
		wheres.add(String.format("%s = %s", "sales_id", salesId));
		sql = SqlHelper.putWheres(wheres, sql);

		String groupBy = "\nGROUP BY\n"
				+ "	hsn, tax_id";

		sql = sql + groupBy;

		Map<String, String> map = new HashMap<>();
		map.put("table_sales_item", TableName.SALES_ITEM);
		map.put("table_product", TableName.PRODUCT);
		map.put("table_tax_cat", TableName.TAX_CAT);

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, TaxSummaryHdto.class).getResultList();
	}

	public TaxSumHdto getTaxSumHdto(int salesId)
	{
		String sql = String.format(sqlGetTaxSum, salesId);
		List<TaxSumHdto> taxSumHdtos = session.createNativeQuery(sql, TaxSumHdto.class).getResultList();
		if (taxSumHdtos == null || taxSumHdtos.isEmpty())
		{
			return null;
		}
		return taxSumHdtos.get(0);
	}

	public List<RptSalesByMonthHdto> getRptSalesByMonthHdtos(
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			String city,
			String cityExact,
			Integer stateId,
			Integer agentId,
			Integer parentProdCatId,
			Integer prodCatId,
			Integer prodId,
			RptSalesByMonthSortByEnum rptSalesSortByEnum,
			SortOrderEnum sortType
	)
	{

		String sql1 = "SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		product_category l1_pc\n"
				+ "	WHERE\n";

		if (parentProdCatId == null)
		{
			sql1 = sql1 + " parent_id IS NULL\n";
		}
		else
		{
			sql1 = sql1 + String.format("id = %s\n", parentProdCatId);
		}

		sql1 = sql1 + "UNION ALL\n"
				+ "\n"
				+ "	SELECT\n"
				+ "		cte_cat.root_id,\n"
				+ "		cte_cat.child_id,\n"
				+ "		l2_pc.id\n"
				+ "	FROM\n"
				+ "		product_category l2_pc\n"
				+ "	INNER JOIN \n"
				+ "		cte_cat\n"
				+ "	ON \n"
				+ "		l2_pc.parent_id = cte_cat.child_id\n";

		String sql2 = "SELECT\n"
				+ "		sales.id sales_id,\n"
				+ "		sales.customer_id,\n"
				+ "		voucher.date,\n"
				+ "		qty,\n"
				+ "		sales_item.product_id,\n"
				+ "		cte_cat.root_id root_prod_cat_id,\n"
				+ "		customer.city,\n"
				+ "		customer.state_id,\n"
				+ "		sales_item.taxable_amt\n"
				+ "	FROM\n"
				+ "		sales_item\n"
				+ "	LEFT JOIN\n"
				+ "		sales\n"
				+ "	ON\n"
				+ "		sales.id = sales_item.sales_id\n"
				+ "	LEFT JOIN\n"
				+ "		voucher\n"
				+ "	ON\n"
				+ "		voucher.id = sales.id\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	LEFT JOIN\n"
				+ "		product\n"
				+ "	ON\n"
				+ "		product.id = sales_item.product_id\n"
				+ "	LEFT JOIN\n"
				+ "		cte_cat\n"
				+ "	ON\n"
				+ "		cte_cat.child_id = product.category_id";

		String sql3 = "SELECT	\n"
				+ "		(YEAR(t_sales_item.date) * 100 + MONTH(t_sales_item.date)) yr_mnth,\n"
				+ "		COUNT(DISTINCT t_sales_item.customer_id) customer_cnt,\n"
				+ "		COUNT(DISTINCT city) city_cnt,\n"
				+ "		COUNT(DISTINCT state_id) state_cnt,\n"
				+ "		COUNT(DISTINCT YEAR(t_sales_item.date)) year_cnt,\n"
				+ "		COUNT(DISTINCT (YEAR(t_sales_item.date) * 100 + MONTH(t_sales_item.date))) month_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.date) day_cnt,\n"
				+ "		COUNT(DISTINCT sales_id) sales_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.product_id) prod_cnt,\n"
				+ "		SUM(qty) sum_qty,\n"
				+ "		SUM(taxable_amt) sum_item_val\n"
				+ "	FROM\n"
				+ "		t_sales_item\n"
				+ "	GROUP BY\n"
				+ "		(YEAR(t_sales_item.date) * 100 + MONTH(t_sales_item.date))";

		String sql4 = "SELECT\n"
				+ "		(YEAR(voucher.date) * 100 + MONTH(voucher.date)) yr_mnth,\n"
				+ "		COUNT(DISTINCT sales_agent.agent_id) agent_cnt\n"
				+ "	FROM\n"
				+ "		sales_agent\n"
				+ "	LEFT JOIN\n"
				+ "		sales\n"
				+ "	ON\n"
				+ "		sales_agent.sales_id = sales.id\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	LEFT JOIN\n"
				+ "		voucher\n"
				+ "	ON\n"
				+ "		voucher.id = sales.id\n"
				+ "	WHERE\n"
				+ "		sales.id IN (SELECT sales_id FROM t_sales_item)\n"
				+ "	GROUP BY\n"
				+ "		(YEAR(voucher.date) * 100 + MONTH(voucher.date))\n";

		String sql5 = "SELECT\n"
				+ "		(YEAR(voucher.date) * 100 + MONTH(voucher.date)) yr_mnth,\n"
				+ "		SUM(amt_payable) sum_amt_payable\n"
				+ "	FROM\n"
				+ "		sales\n"
				+ "	LEFT JOIN\n"
				+ "		voucher\n"
				+ "	ON\n"
				+ "		voucher.id = sales.id\n"
				+ "	WHERE\n"
				+ "		sales.id IN (SELECT sales_id FROM t_sales_item)\n"
				+ "	GROUP BY\n"
				+ "		(YEAR(voucher.date) * 100 + MONTH(voucher.date))\n";

		List<String> wheres = new ArrayList<>();

		if (dateFrom != null)
		{
			wheres.add("date(voucher.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(voucher.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add(String.format("sales.customer_id = %s", customerId));
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%%%s%%\'", "city", SqlHelper.escape(city)));
		}
		if (cityExact != null && !cityExact.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%s\'", "city", SqlHelper.escape(cityExact)));
		}
		if (stateId != null)
		{
			if (stateId == -1)
			{
				wheres.add("state_id IS NULL");
			}
			else
			{
				wheres.add(String.format("%s = %s", "state_id", stateId));
			}
		}
		if (agentId != null)
		{
			if (agentId == -1)
			{
				wheres.add("(SELECT COUNT(*) FROM sales_agent WHERE sales_agent.sales_id = sales.id) = 0");
			}
			else
			{
				wheres.add(String.format("%s IN (SELECT agent_id FROM sales_agent WHERE sales_agent.sales_id = sales.id)", agentId));
			}
		}

		if (prodId != null)
		{
			wheres.add(String.format("sales_item.product_id = %s", prodId));
		}
		if (prodCatId != null)
		{
			wheres.add(String.format("product.category_id = %s", prodCatId));
		}
		if (parentProdCatId != null)
		{
			wheres.add(String.format("cte_cat.root_id IS NOT NULL"));
		}
		sql2 = SqlHelper.putWheres(wheres, sql2);

		String sql = String.format("WITH RECURSIVE cte_cat (root_id, parent_id, child_id) AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item_summ AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_agent_summ AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_summ AS (\n"
				+ "	%s\n"
				+ ")\n"
				+ "SELECT\n"
				+ "	t_sales_summ.yr_mnth,\n"
				+ "	t_sales_item_summ.customer_cnt,\n"
				+ "	t_sales_item_summ.city_cnt,\n"
				+ "	t_sales_item_summ.state_cnt,\n"
				+ "	t_sales_agent_summ.agent_cnt,\n"
				+ "	t_sales_item_summ.year_cnt,\n"
				+ "	t_sales_item_summ.month_cnt,\n"
				+ "	t_sales_item_summ.day_cnt,\n"
				+ "	t_sales_item_summ.sales_cnt,\n"
				+ "	t_sales_item_summ.prod_cnt,\n"
				+ "	t_sales_item_summ.sum_qty,\n"
				+ "	t_sales_item_summ.sum_item_val,\n"
				+ "	t_sales_summ.sum_amt_payable\n"
				+ "FROM\n"
				+ "	t_sales_summ\n"
				+ "LEFT JOIN\n"
				+ "	t_sales_item_summ\n"
				+ "ON\n"
				+ "	t_sales_summ.yr_mnth = t_sales_item_summ.yr_mnth\n"
				+ "LEFT JOIN\n"
				+ "	t_sales_agent_summ\n"
				+ "ON\n"
				+ "	t_sales_agent_summ.yr_mnth = t_sales_item_summ.yr_mnth", sql1, sql2, sql3, sql4, sql5);

		List<String> orderBys = new ArrayList<>();

		if (rptSalesSortByEnum != null)
		{
			orderBys.add(String.format("%s %s", rptSalesSortByEnum.getKey(), sortType.getSqlName()));
		}

		orderBys.add(String.format("%s %s", rptSalesSortByEnum.YR_MNTH.getKey(), sortType.ASC.getSqlName()));

		sql = SqlHelper.putOrderBys(orderBys, sql);

		YearModel yearModel = yearDao.getById(1);

		Map<String, String> map = new HashMap<>();

		if (dateFrom == null)
		{
			dateFrom = yearModel.getDateFrom();
		}
		map.put("date_from", Util.dateToString(dateFrom, Util.Formats.DB_DATE));

		if (dateTo == null)
		{
			dateTo = yearModel.getDateTo();
		}
		map.put("date_to", Util.dateToString(dateTo, Util.Formats.DB_DATE));

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, RptSalesByMonthHdto.class).getResultList();
	}

	public List<RptSalesByDayHdto> getRptSalesByDayHdtos(
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			String city,
			String cityExact,
			Integer stateId,
			Integer agentId,
			Integer parentProdCatId,
			Integer prodCatId,
			Integer prodId,
			RptSalesByDaySortByEnum rptSalesSortByEnum,
			SortOrderEnum sortType
	)
	{
		String sql1 = "SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		product_category l1_pc\n"
				+ "	WHERE\n";

		if (parentProdCatId == null)
		{
			sql1 = sql1 + " parent_id IS NULL\n";
		}
		else
		{
			sql1 = sql1 + String.format("id = %s\n", parentProdCatId);
		}

		sql1 = sql1 + "UNION ALL\n"
				+ "\n"
				+ "	SELECT\n"
				+ "		cte_cat.root_id,\n"
				+ "		cte_cat.child_id,\n"
				+ "		l2_pc.id\n"
				+ "	FROM\n"
				+ "		product_category l2_pc\n"
				+ "	INNER JOIN \n"
				+ "		cte_cat\n"
				+ "	ON \n"
				+ "		l2_pc.parent_id = cte_cat.child_id\n";

		String sql2 = "SELECT\n"
				+ "		sales.id sales_id,\n"
				+ "		sales.customer_id,\n"
				+ "		voucher.date,\n"
				+ "		qty,\n"
				+ "		sales_item.product_id,\n"
				+ "		cte_cat.root_id root_prod_cat_id,\n"
				+ "		customer.city,\n"
				+ "		customer.state_id,\n"
				+ "		sales_item.taxable_amt\n"
				+ "	FROM\n"
				+ "		sales_item\n"
				+ "	LEFT JOIN\n"
				+ "		sales\n"
				+ "	ON\n"
				+ "		sales.id = sales_item.sales_id\n"
				+ "	LEFT JOIN\n"
				+ "		voucher\n"
				+ "	ON\n"
				+ "		voucher.id = sales.id\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	LEFT JOIN\n"
				+ "		product\n"
				+ "	ON\n"
				+ "		product.id = sales_item.product_id\n"
				+ "	LEFT JOIN\n"
				+ "		cte_cat\n"
				+ "	ON\n"
				+ "		cte_cat.child_id = product.category_id";

		String sql3 = "SELECT	\n"
				+ "		date,\n"
				+ "		COUNT(DISTINCT t_sales_item.customer_id) customer_cnt,\n"
				+ "		COUNT(DISTINCT city) city_cnt,\n"
				+ "		COUNT(DISTINCT state_id) state_cnt,\n"
				+ "		COUNT(DISTINCT YEAR(t_sales_item.date)) year_cnt,\n"
				+ "		COUNT(DISTINCT (YEAR(t_sales_item.date) * 100 + MONTH(t_sales_item.date))) month_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.date) day_cnt,\n"
				+ "		COUNT(DISTINCT sales_id) sales_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.product_id) prod_cnt,\n"
				+ "		SUM(qty) sum_qty,\n"
				+ "		SUM(taxable_amt) sum_item_val\n"
				+ "	FROM\n"
				+ "		t_sales_item\n"
				+ "	GROUP BY\n"
				+ "		date";

		String sql4 = "SELECT\n"
				+ "		date,\n"
				+ "		COUNT(DISTINCT sales_agent.agent_id) agent_cnt\n"
				+ "	FROM\n"
				+ "		sales_agent\n"
				+ "	LEFT JOIN\n"
				+ "		sales\n"
				+ "	ON\n"
				+ "		sales_agent.sales_id = sales.id\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	LEFT JOIN\n"
				+ "		voucher\n"
				+ "	ON\n"
				+ "		voucher.id = sales.id\n"
				+ "	WHERE\n"
				+ "		sales.id IN (SELECT sales_id FROM t_sales_item)\n"
				+ "	GROUP BY\n"
				+ "		date\n";

		String sql5 = "SELECT\n"
				+ "		date,\n"
				+ "		SUM(amt_payable) sum_amt_payable\n"
				+ "	FROM\n"
				+ "		sales\n"
				+ "	LEFT JOIN\n"
				+ "		voucher\n"
				+ "	ON\n"
				+ "		voucher.id = sales.id\n"
				+ "	WHERE\n"
				+ "		sales.id IN (SELECT sales_id FROM t_sales_item)\n"
				+ "	GROUP BY\n"
				+ "		date\n";

		List<String> wheres = new ArrayList<>();

		if (dateFrom != null)
		{
			wheres.add("date(voucher.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(voucher.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add(String.format("sales.customer_id = %s", customerId));
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%%%s%%\'", "city", SqlHelper.escape(city)));
		}
		if (cityExact != null && !cityExact.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%s\'", "city", SqlHelper.escape(cityExact)));
		}
		if (stateId != null)
		{
			if (stateId == -1)
			{
				wheres.add("state_id IS NULL");
			}
			else
			{
				wheres.add(String.format("%s = %s", "state_id", stateId));
			}
		}
		if (agentId != null)
		{
			if (agentId == -1)
			{
				wheres.add("(SELECT COUNT(*) FROM sales_agent WHERE sales_agent.sales_id = sales.id) = 0");
			}
			else
			{
				wheres.add(String.format("%s IN (SELECT agent_id FROM sales_agent WHERE sales_agent.sales_id = sales.id)", agentId));
			}
		}

		if (prodId != null)
		{
			wheres.add(String.format("sales_item.product_id = %s", prodId));
		}
		if (prodCatId != null)
		{
			wheres.add(String.format("product.category_id = %s", prodCatId));
		}
		if (parentProdCatId != null)
		{
			wheres.add(String.format("cte_cat.root_id IS NOT NULL"));
		}
		sql2 = SqlHelper.putWheres(wheres, sql2);

		String sql = String.format("WITH RECURSIVE cte_cat (root_id, parent_id, child_id) AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item_summ AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_agent_summ AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_summ AS (\n"
				+ "	%s\n"
				+ ")\n"
				+ "SELECT\n"
				+ "	t_sales_summ.date,\n"
				+ "	t_sales_item_summ.customer_cnt,\n"
				+ "	t_sales_item_summ.city_cnt,\n"
				+ "	t_sales_item_summ.state_cnt,\n"
				+ "	t_sales_agent_summ.agent_cnt,\n"
				+ "	t_sales_item_summ.year_cnt,\n"
				+ "	t_sales_item_summ.month_cnt,\n"
				+ "	t_sales_item_summ.day_cnt,\n"
				+ "	t_sales_item_summ.sales_cnt,\n"
				+ "	t_sales_item_summ.prod_cnt,\n"
				+ "	t_sales_item_summ.sum_qty,\n"
				+ "	t_sales_item_summ.sum_item_val,\n"
				+ "	t_sales_summ.sum_amt_payable\n"
				+ "FROM\n"
				+ "	t_sales_summ\n"
				+ "LEFT JOIN\n"
				+ "	t_sales_item_summ\n"
				+ "ON\n"
				+ "	t_sales_summ.date = t_sales_item_summ.date\n"
				+ "LEFT JOIN\n"
				+ "	t_sales_agent_summ\n"
				+ "ON\n"
				+ "	t_sales_agent_summ.date = t_sales_item_summ.date", sql1, sql2, sql3, sql4, sql5);

		List<String> orderBys = new ArrayList<>();

		if (rptSalesSortByEnum != null)
		{
			orderBys.add(String.format("%s %s", rptSalesSortByEnum.getKey(), sortType.getSqlName()));
		}

		orderBys.add(String.format("%s %s", rptSalesSortByEnum.DATE.getKey(), sortType.ASC.getSqlName()));

		sql = SqlHelper.putOrderBys(orderBys, sql);

		return session.createNativeQuery(sql, RptSalesByDayHdto.class).getResultList();
	}

	public List<RptSalesByAgentHdto> getRptSalesByAgentHdtos(
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			String city,
			String cityExact,
			Integer stateId,
			Integer agentId,
			Integer parentProdCatId,
			Integer prodCatId,
			Integer prodId,
			RptSalesByAgentSortByEnum rptSalesSortByEnum,
			SortOrderEnum sortType
	)
	{
		String sql1 = "SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		product_category l1_pc\n"
				+ "	WHERE\n";

		if (parentProdCatId == null)
		{
			sql1 = sql1 + " parent_id IS NULL\n";
		}
		else
		{
			sql1 = sql1 + String.format("id = %s\n", parentProdCatId);
		}

		sql1 = sql1 + "UNION ALL\n"
				+ "\n"
				+ "	SELECT\n"
				+ "		cte_cat.root_id,\n"
				+ "		cte_cat.child_id,\n"
				+ "		l2_pc.id\n"
				+ "	FROM\n"
				+ "		product_category l2_pc\n"
				+ "	INNER JOIN \n"
				+ "		cte_cat\n"
				+ "	ON \n"
				+ "		l2_pc.parent_id = cte_cat.child_id\n";

		String sql2 = "SELECT\n"
				+ "		sales.id sales_id,\n"
				+ "		sales.customer_id,\n"
				+ "		voucher.date,\n"
				+ "		qty,\n"
				+ "		sales_item.product_id,\n"
				+ "		cte_cat.root_id root_prod_cat_id,\n"
				+ "		customer.city,\n"
				+ "		customer.state_id,\n"
				+ "		sales_item.taxable_amt\n"
				+ "	FROM\n"
				+ "		sales_item\n"
				+ "	LEFT JOIN\n"
				+ "		sales\n"
				+ "	ON\n"
				+ "		sales.id = sales_item.sales_id\n"
				+ "	LEFT JOIN\n"
				+ "		voucher\n"
				+ "	ON\n"
				+ "		voucher.id = sales.id\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	LEFT JOIN\n"
				+ "		product\n"
				+ "	ON\n"
				+ "		product.id = sales_item.product_id\n"
				+ "	LEFT JOIN\n"
				+ "		cte_cat\n"
				+ "	ON\n"
				+ "		cte_cat.child_id = product.category_id";

		String sql3 = "SELECT	\n"
				+ "		agent_id,\n"
				+ "		COUNT(DISTINCT t_sales_item.customer_id) customer_cnt,\n"
				+ "		COUNT(DISTINCT city) city_cnt,\n"
				+ "		COUNT(DISTINCT state_id) state_cnt,\n"
				+ "		COUNT(DISTINCT YEAR(t_sales_item.date)) year_cnt,\n"
				+ "		COUNT(DISTINCT (YEAR(t_sales_item.date) * 100 + MONTH(t_sales_item.date))) month_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.date) day_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.sales_id) sales_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.product_id) prod_cnt,\n"
				+ "		SUM(qty) sum_qty,\n"
				+ "		SUM(taxable_amt) sum_item_val\n"
				+ "	FROM\n"
				+ "		t_sales_item\n"
				+ "	LEFT JOIN\n"
				+ "		sales_agent\n"
				+ "	ON\n"
				+ "		sales_agent.sales_id = t_sales_item.sales_id\n"
				+ "	GROUP BY\n"
				+ "		agent_id\n";

		String sql4 = "SELECT\n"
				+ "		sales_agent.agent_id,\n"
				+ "		SUM(amt_payable) sum_amt_payable\n"
				+ "	FROM\n"
				+ "		sales\n"
				+ "	LEFT JOIN\n"
				+ "		sales_agent\n"
				+ "	ON\n"
				+ "		sales_agent.sales_id = sales.id\n"
				+ "	LEFT JOIN\n"
				+ "		acct\n"
				+ "	ON\n"
				+ "		acct.id = sales_agent.agent_id\n"
				+ "	WHERE\n"
				+ "		sales.id IN (SELECT sales_id FROM t_sales_item)\n"
				+ "	GROUP BY\n"
				+ "		sales_agent.agent_id\n";

		List<String> wheres = new ArrayList<>();

		if (dateFrom != null)
		{
			wheres.add("date(voucher.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(voucher.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add(String.format("sales.customer_id = %s", customerId));
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%%%s%%\'", "city", SqlHelper.escape(city)));
		}
		if (cityExact != null && !cityExact.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%s\'", "city", SqlHelper.escape(cityExact)));
		}
		if (stateId != null)
		{
			if (stateId == -1)
			{
				wheres.add("state_id IS NULL");
			}
			else
			{
				wheres.add(String.format("%s = %s", "state_id", stateId));
			}
		}
		if (agentId != null)
		{
			if (agentId == -1)
			{
				wheres.add("(SELECT COUNT(*) FROM sales_agent WHERE sales_agent.sales_id = sales.id) = 0");
			}
			else
			{
				wheres.add(String.format("%s IN (SELECT agent_id FROM sales_agent WHERE sales_agent.sales_id = sales.id)", agentId));
			}
		}

		if (prodId != null)
		{
			wheres.add(String.format("sales_item.product_id = %s", prodId));
		}
		if (prodCatId != null)
		{
			wheres.add(String.format("product.category_id = %s", prodCatId));
		}
		if (parentProdCatId != null)
		{
			wheres.add(String.format("cte_cat.root_id IS NOT NULL"));
		}
		sql2 = SqlHelper.putWheres(wheres, sql2);

		String sql = String.format("WITH RECURSIVE cte_cat (root_id, parent_id, child_id) AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item_summ AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_summ AS (\n"
				+ "	%s\n"
				+ ")\n"
				+ "SELECT\n"
				+ "	t_sales_summ.agent_id,\n"
				+ "	acct.name agent_name,\n"
				+ "	t_sales_item_summ.customer_cnt,\n"
				+ "	t_sales_item_summ.city_cnt,\n"
				+ "	t_sales_item_summ.state_cnt,\n"
				+ "	1 agent_cnt,\n"
				+ "	t_sales_item_summ.year_cnt,\n"
				+ "	t_sales_item_summ.month_cnt,\n"
				+ "	t_sales_item_summ.day_cnt,\n"
				+ "	t_sales_item_summ.sales_cnt,\n"
				+ "	t_sales_item_summ.prod_cnt,\n"
				+ "	t_sales_item_summ.sum_qty,\n"
				+ "	t_sales_item_summ.sum_item_val,\n"
				+ "	t_sales_summ.sum_amt_payable\n"
				+ "FROM\n"
				+ "	t_sales_summ\n"
				+ "LEFT JOIN\n"
				+ "	t_sales_item_summ\n"
				+ "ON\n"
				+ "	t_sales_summ.agent_id = t_sales_item_summ.agent_id\n"
				+ "LEFT JOIN\n"
				+ "	acct\n"
				+ "ON\n"
				+ "	acct.id = t_sales_summ.agent_id", sql1, sql2, sql3, sql4);

		List<String> orderBys = new ArrayList<>();

		if (rptSalesSortByEnum != null)
		{
			orderBys.add(String.format("%s %s", rptSalesSortByEnum.getKey(), sortType.getSqlName()));
		}

		orderBys.add(String.format("%s %s", rptSalesSortByEnum.NAME.getKey(), sortType.ASC.getSqlName()));

		sql = SqlHelper.putOrderBys(orderBys, sql);

		return session.createNativeQuery(sql, RptSalesByAgentHdto.class).getResultList();
	}

	public List<RptSalesByCityHdto> getRptSalesByCityHdtos(
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			String city,
			String cityExact,
			Integer stateId,
			Integer agentId,
			Integer parentProdCatId,
			Integer prodCatId,
			Integer prodId,
			RptSalesByCitySortByEnum rptSalesSortByEnum,
			SortOrderEnum sortType
	)
	{
		String sql1 = "SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		product_category l1_pc\n"
				+ "	WHERE\n";

		if (parentProdCatId == null)
		{
			sql1 = sql1 + " parent_id IS NULL\n";
		}
		else
		{
			sql1 = sql1 + String.format("id = %s\n", parentProdCatId);
		}

		sql1 = sql1 + "UNION ALL\n"
				+ "\n"
				+ "	SELECT\n"
				+ "		cte_cat.root_id,\n"
				+ "		cte_cat.child_id,\n"
				+ "		l2_pc.id\n"
				+ "	FROM\n"
				+ "		product_category l2_pc\n"
				+ "	INNER JOIN \n"
				+ "		cte_cat\n"
				+ "	ON \n"
				+ "		l2_pc.parent_id = cte_cat.child_id\n";

		String sql2 = "SELECT\n"
				+ "		sales.id sales_id,\n"
				+ "		sales.customer_id,\n"
				+ "		voucher.date,\n"
				+ "		qty,\n"
				+ "		sales_item.product_id,\n"
				+ "		cte_cat.root_id root_prod_cat_id,\n"
				+ "		customer.city,\n"
				+ "		customer.state_id,\n"
				+ "		sales_item.taxable_amt\n"
				+ "	FROM\n"
				+ "		sales_item\n"
				+ "	LEFT JOIN\n"
				+ "		sales\n"
				+ "	ON\n"
				+ "		sales.id = sales_item.sales_id\n"
				+ "	LEFT JOIN\n"
				+ "		voucher\n"
				+ "	ON\n"
				+ "		voucher.id = sales.id\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	LEFT JOIN\n"
				+ "		product\n"
				+ "	ON\n"
				+ "		product.id = sales_item.product_id\n"
				+ "	LEFT JOIN\n"
				+ "		cte_cat\n"
				+ "	ON\n"
				+ "		cte_cat.child_id = product.category_id";

		String sql3 = "SELECT	\n"
				+ "		city,\n"
				+ "		COUNT(DISTINCT t_sales_item.customer_id) customer_cnt,\n"
				+ "		COUNT(DISTINCT city) city_cnt,\n"
				+ "		COUNT(DISTINCT state_id) state_cnt,\n"
				+ "		COUNT(DISTINCT YEAR(t_sales_item.date)) year_cnt,\n"
				+ "		COUNT(DISTINCT (YEAR(t_sales_item.date) * 100 + MONTH(t_sales_item.date))) month_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.date) day_cnt,\n"
				+ "		COUNT(DISTINCT sales_id) sales_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.product_id) prod_cnt,\n"
				+ "		SUM(qty) sum_qty,\n"
				+ "		SUM(taxable_amt) sum_item_val\n"
				+ "	FROM\n"
				+ "		t_sales_item\n"
				+ "	GROUP BY\n"
				+ "		city	";

		String sql4 = "SELECT\n"
				+ "		city,\n"
				+ "		COUNT(DISTINCT sales_agent.agent_id) agent_cnt\n"
				+ "	FROM\n"
				+ "		sales_agent\n"
				+ "	LEFT JOIN\n"
				+ "		sales\n"
				+ "	ON\n"
				+ "		sales_agent.sales_id = sales.id\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	WHERE\n"
				+ "		sales.id IN (SELECT sales_id FROM t_sales_item)\n"
				+ "	GROUP BY\n"
				+ "		city\n";

		String sql5 = "SELECT\n"
				+ "		city,\n"
				+ "		SUM(amt_payable) sum_amt_payable\n"
				+ "	FROM\n"
				+ "		sales\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	WHERE\n"
				+ "		sales.id IN (SELECT sales_id FROM t_sales_item)\n"
				+ "	GROUP BY\n"
				+ "		city\n";

		List<String> wheres = new ArrayList<>();

		if (dateFrom != null)
		{
			wheres.add("date(voucher.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(voucher.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add(String.format("sales.customer_id = %s", customerId));
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%%%s%%\'", "city", SqlHelper.escape(city)));
		}
		if (cityExact != null && !cityExact.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%s\'", "city", SqlHelper.escape(cityExact)));
		}
		if (stateId != null)
		{
			if (stateId == -1)
			{
				wheres.add("state_id IS NULL");
			}
			else
			{
				wheres.add(String.format("%s = %s", "state_id", stateId));
			}
		}
		if (agentId != null)
		{
			if (agentId == -1)
			{
				wheres.add("(SELECT COUNT(*) FROM sales_agent WHERE sales_agent.sales_id = sales.id) = 0");
			}
			else
			{
				wheres.add(String.format("%s IN (SELECT agent_id FROM sales_agent WHERE sales_agent.sales_id = sales.id)", agentId));
			}
		}

		if (prodId != null)
		{
			wheres.add(String.format("sales_item.product_id = %s", prodId));
		}
		if (prodCatId != null)
		{
			wheres.add(String.format("product.category_id = %s", prodCatId));
		}
		if (parentProdCatId != null)
		{
			wheres.add(String.format("cte_cat.root_id IS NOT NULL"));
		}
		sql2 = SqlHelper.putWheres(wheres, sql2);

		String sql = String.format("WITH RECURSIVE cte_cat (root_id, parent_id, child_id) AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item_summ AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_agent_summ AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_summ AS (\n"
				+ "	%s\n"
				+ ")\n"
				+ "SELECT\n"
				+ "	t_sales_summ.city,\n"
				+ "	t_sales_item_summ.customer_cnt,\n"
				+ "	t_sales_item_summ.city_cnt,\n"
				+ "	t_sales_item_summ.state_cnt,\n"
				+ "	t_sales_agent_summ.agent_cnt,\n"
				+ "	t_sales_item_summ.year_cnt,\n"
				+ "	t_sales_item_summ.month_cnt,\n"
				+ "	t_sales_item_summ.day_cnt,\n"
				+ "	t_sales_item_summ.sales_cnt,\n"
				+ "	t_sales_item_summ.prod_cnt,\n"
				+ "	t_sales_item_summ.sum_qty,\n"
				+ "	t_sales_item_summ.sum_item_val,\n"
				+ "	t_sales_summ.sum_amt_payable\n"
				+ "FROM\n"
				+ "	t_sales_summ\n"
				+ "LEFT JOIN\n"
				+ "	t_sales_item_summ\n"
				+ "ON\n"
				+ "	t_sales_summ.city = t_sales_item_summ.city\n"
				+ "LEFT JOIN\n"
				+ "	t_sales_agent_summ\n"
				+ "ON\n"
				+ "	t_sales_agent_summ.city = t_sales_item_summ.city", sql1, sql2, sql3, sql4, sql5);

		List<String> orderBys = new ArrayList<>();

		if (rptSalesSortByEnum != null)
		{
			orderBys.add(String.format("%s %s", rptSalesSortByEnum.getKey(), sortType.getSqlName()));
		}

		orderBys.add(String.format("%s %s", rptSalesSortByEnum.CITY.getKey(), sortType.ASC.getSqlName()));

		sql = SqlHelper.putOrderBys(orderBys, sql);

		return session.createNativeQuery(sql, RptSalesByCityHdto.class).getResultList();
	}

	public List<RptSalesByCustomerHdto> getRptSalesByCustomerHdtos(
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			String city,
			String cityExact,
			Integer stateId,
			Integer agentId,
			Integer parentProdCatId,
			Integer prodCatId,
			Integer prodId,
			RptSalesByCustomerSortByEnum rptSalesSortByEnum,
			SortOrderEnum sortType
	)
	{

		String sql1 = "SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		product_category l1_pc\n"
				+ "	WHERE\n";

		if (parentProdCatId == null)
		{
			sql1 = sql1 + String.format("parent_id IS NULL\n");
		}
		else
		{
			sql1 = sql1 + String.format("id = %s\n", parentProdCatId);
		}

		sql1 = sql1 + "UNION ALL\n"
				+ "\n"
				+ "	SELECT\n"
				+ "		cte_cat.root_id,\n"
				+ "		cte_cat.child_id,\n"
				+ "		l2_pc.id\n"
				+ "	FROM\n"
				+ "		product_category l2_pc\n"
				+ "	INNER JOIN \n"
				+ "		cte_cat\n"
				+ "	ON \n"
				+ "		l2_pc.parent_id = cte_cat.child_id\n";

		String sql2 = "SELECT\n"
				+ "		sales.id sales_id,\n"
				+ "		sales.customer_id,\n"
				+ "		voucher.date,\n"
				+ "		qty,\n"
				+ "		sales_item.product_id,\n"
				+ "		cte_cat.root_id root_prod_cat_id,\n"
				+ "		customer.city,\n"
				+ "		customer.state_id,\n"
				+ "		sales_item.taxable_amt\n"
				+ "	FROM\n"
				+ "		sales_item\n"
				+ "	LEFT JOIN\n"
				+ "		sales\n"
				+ "	ON\n"
				+ "		sales.id = sales_item.sales_id\n"
				+ "	LEFT JOIN\n"
				+ "		voucher\n"
				+ "	ON\n"
				+ "		voucher.id = sales.id\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	LEFT JOIN\n"
				+ "		product\n"
				+ "	ON\n"
				+ "		product.id = sales_item.product_id\n"
				+ "	LEFT JOIN\n"
				+ "		cte_cat\n"
				+ "	ON\n"
				+ "		cte_cat.child_id = product.category_id";

		String sql3 = "SELECT	\n"
				+ "		customer_id,\n"
				+ "		COUNT(DISTINCT t_sales_item.customer_id) customer_cnt,\n"
				+ "		COUNT(DISTINCT city) city_cnt,\n"
				+ "		COUNT(DISTINCT state_id) state_cnt,\n"
				+ "		COUNT(DISTINCT YEAR(t_sales_item.date)) year_cnt,\n"
				+ "		COUNT(DISTINCT (YEAR(t_sales_item.date) * 100 + MONTH(t_sales_item.date))) month_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.date) day_cnt,\n"
				+ "		COUNT(DISTINCT sales_id) sales_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.product_id) prod_cnt,\n"
				+ "		SUM(qty) sum_qty,\n"
				+ "		SUM(taxable_amt) sum_item_val\n"
				+ "	FROM\n"
				+ "		t_sales_item\n"
				+ "	GROUP BY\n"
				+ "		customer_id\n";

		String sql4 = "SELECT\n"
				+ "		customer_id,\n"
				+ "		COUNT(DISTINCT sales_agent.agent_id) agent_cnt\n"
				+ "	FROM\n"
				+ "		sales_agent\n"
				+ "	LEFT JOIN\n"
				+ "		sales\n"
				+ "	ON\n"
				+ "		sales_agent.sales_id = sales.id\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	WHERE\n"
				+ "		sales.id IN (SELECT sales_id FROM t_sales_item)\n"
				+ "	GROUP BY\n"
				+ "		customer_id\n";

		String sql5 = "SELECT\n"
				+ "		customer_id,\n"
				+ "		SUM(amt_payable) sum_amt_payable\n"
				+ "	FROM\n"
				+ "		sales\n"
				+ "	WHERE\n"
				+ "		sales.id IN (SELECT sales_id FROM t_sales_item)\n"
				+ "	GROUP BY\n"
				+ "		customer_id";

		List<String> wheres = new ArrayList<>();

		if (dateFrom != null)
		{
			wheres.add("date(voucher.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(voucher.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add(String.format("sales.customer_id = %s", customerId));
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%%%s%%\'", "city", SqlHelper.escape(city)));
		}
		if (cityExact != null && !cityExact.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%s\'", "city", SqlHelper.escape(cityExact)));
		}
		if (stateId != null)
		{
			if (stateId == -1)
			{
				wheres.add("state_id IS NULL");
			}
			else
			{
				wheres.add(String.format("%s = %s", "state_id", stateId));
			}
		}
		if (agentId != null)
		{
			if (agentId == -1)
			{
				wheres.add("(SELECT COUNT(*) FROM sales_agent WHERE sales_agent.sales_id = sales.id) = 0");
			}
			else
			{
				wheres.add(String.format("%s IN (SELECT agent_id FROM sales_agent WHERE sales_agent.sales_id = sales.id)", agentId));
			}
		}

		if (prodId != null)
		{
			wheres.add(String.format("sales_item.product_id = %s", prodId));
		}
		if (prodCatId != null)
		{
			wheres.add(String.format("product.category_id = %s", prodCatId));
		}
		if (parentProdCatId != null)
		{
			wheres.add(String.format("cte_cat.root_id IS NOT NULL"));
		}
		sql2 = SqlHelper.putWheres(wheres, sql2);

		String sql = String.format("WITH RECURSIVE cte_cat (root_id, parent_id, child_id) AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item_summ AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_agent_summ AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_summ AS (\n"
				+ "	%s\n"
				+ ")\n"
				+ "SELECT\n"
				+ "	t_sales_summ.customer_id,\n"
				+ "	acct.name customer_name,\n"
				+ "	t_sales_item_summ.customer_cnt,\n"
				+ "	t_sales_item_summ.city_cnt,\n"
				+ "	t_sales_item_summ.state_cnt,\n"
				+ "	t_sales_agent_summ.agent_cnt,\n"
				+ "	t_sales_item_summ.year_cnt,\n"
				+ "	t_sales_item_summ.month_cnt,\n"
				+ "	t_sales_item_summ.day_cnt,\n"
				+ "	t_sales_item_summ.sales_cnt,\n"
				+ "	t_sales_item_summ.prod_cnt,\n"
				+ "	t_sales_item_summ.sum_qty,\n"
				+ "	t_sales_item_summ.sum_item_val,\n"
				+ "	t_sales_summ.sum_amt_payable\n"
				+ "FROM\n"
				+ "	t_sales_summ\n"
				+ "LEFT JOIN\n"
				+ "	t_sales_item_summ\n"
				+ "ON\n"
				+ "	t_sales_summ.customer_id = t_sales_item_summ.customer_id\n"
				+ "LEFT JOIN\n"
				+ "	acct\n"
				+ "ON\n"
				+ "	acct.id = t_sales_summ.customer_id\n"
				+ "LEFT JOIN\n"
				+ "	t_sales_agent_summ\n"
				+ "ON\n"
				+ "	t_sales_agent_summ.customer_id = t_sales_item_summ.customer_id", sql1, sql2, sql3, sql4, sql5);

		List<String> orderBys = new ArrayList<>();

		if (rptSalesSortByEnum != null)
		{
			orderBys.add(String.format("%s %s", rptSalesSortByEnum.getKey(), sortType.getSqlName()));
		}

		orderBys.add(String.format("%s %s", rptSalesSortByEnum.NAME.getKey(), sortType.ASC.getSqlName()));

		sql = SqlHelper.putOrderBys(orderBys, sql);

		return session.createNativeQuery(sql, RptSalesByCustomerHdto.class).getResultList();
	}

	public List<RptSalesByProdCatHdto> getRptSalesByProdCatCatHdtos(
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			String city,
			String cityExact,
			Integer stateId,
			Integer agentId,
			Integer parentProdCatId,
			Integer prodCatId,
			Integer prodId,
			RptSalesByProdCatSortByEnum rptSalesSortByEnum,
			SortOrderEnum sortType
	)
	{
		String sql1 = "SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		product_category l1_pc\n"
				+ "	WHERE\n";

		if (parentProdCatId == null)
		{
			sql1 = sql1 + " parent_id IS NULL\n";
		}
		else
		{
			sql1 = sql1 + String.format("parent_id  = %s\n", parentProdCatId);
		}

		sql1 = sql1 + "UNION ALL\n"
				+ "\n"
				+ "	SELECT\n"
				+ "		cte_cat.root_id,\n"
				+ "		cte_cat.child_id,\n"
				+ "		l2_pc.id\n"
				+ "	FROM\n"
				+ "		product_category l2_pc\n"
				+ "	INNER JOIN \n"
				+ "		cte_cat\n"
				+ "	ON \n"
				+ "		l2_pc.parent_id = cte_cat.child_id\n";

		String sql2 = "SELECT\n"
				+ "		sales.id sales_id,\n"
				+ "		sales.customer_id,\n"
				+ "		voucher.date,\n"
				+ "		qty,\n"
				+ "		sales_item.product_id,\n"
				+ "		cte_cat.root_id root_prod_cat_id,\n"
				+ "		customer.city,\n"
				+ "		customer.state_id,\n"
				+ "		sales_item.taxable_amt\n"
				+ "	FROM\n"
				+ "		sales_item\n"
				+ "	LEFT JOIN\n"
				+ "		sales\n"
				+ "	ON\n"
				+ "		sales.id = sales_item.sales_id\n"
				+ "	LEFT JOIN\n"
				+ "		voucher\n"
				+ "	ON\n"
				+ "		voucher.id = sales.id\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	LEFT JOIN\n"
				+ "		product\n"
				+ "	ON\n"
				+ "		product.id = sales_item.product_id\n"
				+ "	LEFT JOIN\n"
				+ "		cte_cat\n"
				+ "	ON\n"
				+ "		cte_cat.child_id = product.category_id";

		String sql3 = "SELECT	\n"
				+ "		root_prod_cat_id,\n"
				+ "		COUNT(DISTINCT t_sales_item.customer_id) customer_cnt,\n"
				+ "		COUNT(DISTINCT city) city_cnt,\n"
				+ "		COUNT(DISTINCT state_id) state_cnt,\n"
				+ "		COUNT(DISTINCT YEAR(t_sales_item.date)) year_cnt,\n"
				+ "		COUNT(DISTINCT (YEAR(t_sales_item.date) * 100 + MONTH(t_sales_item.date))) month_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.date) day_cnt,\n"
				+ "		COUNT(DISTINCT sales_id) sales_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.product_id) prod_cnt,\n"
				+ "		SUM(qty) sum_qty,\n"
				+ "		SUM(taxable_amt) sum_item_val\n"
				+ "	FROM\n"
				+ "		t_sales_item\n"
				+ "	GROUP BY\n"
				+ "		root_prod_cat_id\n";

		String sql4 = "SELECT\n"
				+ "		root_prod_cat_id,\n"
				+ "		COUNT(DISTINCT sales_agent.agent_id) agent_cnt\n"
				+ "	FROM\n"
				+ "		sales_agent\n"
				+ "	JOIN\n"
				+ "		t_sales_item\n"
				+ "	ON\n"
				+ "		t_sales_item.sales_id = sales_agent.sales_id\n"
				+ "	GROUP BY\n"
				+ "		root_prod_cat_id\n";

		List<String> wheres = new ArrayList<>();

		if (dateFrom != null)
		{
			wheres.add("date(voucher.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(voucher.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add(String.format("sales.customer_id = %s", customerId));
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%%%s%%\'", "city", SqlHelper.escape(city)));
		}
		if (cityExact != null && !cityExact.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%s\'", "city", SqlHelper.escape(cityExact)));
		}
		if (stateId != null)
		{
			if (stateId == -1)
			{
				wheres.add("state_id IS NULL");
			}
			else
			{
				wheres.add(String.format("%s = %s", "state_id", stateId));
			}
		}
		if (agentId != null)
		{
			if (agentId == -1)
			{
				wheres.add("(SELECT COUNT(*) FROM sales_agent WHERE sales_agent.sales_id = sales.id) = 0");
			}
			else
			{
				wheres.add(String.format("%s IN (SELECT agent_id FROM sales_agent WHERE sales_agent.sales_id = sales.id)", agentId));
			}
		}

		if (prodId != null)
		{
			wheres.add(String.format("sales_item.product_id = %s", prodId));
		}
		if (prodCatId != null)
		{
			wheres.add(String.format("product.category_id = %s", prodCatId));
		}
		if (parentProdCatId != null)
		{
			wheres.add(String.format("cte_cat.root_id IS NOT NULL"));
		}
		sql2 = SqlHelper.putWheres(wheres, sql2);

		String sql = String.format("WITH RECURSIVE cte_cat (root_id, parent_id, child_id) AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item_summ AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_agent_summ AS (\n"
				+ "	%s\n"
				+ ")\n"
				+ "SELECT\n"
				+ "	product_category.id prod_cat_id,\n"
				+ "	product_category.name prod_cat_name,\n"
				+ "	t_sales_item_summ.customer_cnt,\n"
				+ "	t_sales_item_summ.city_cnt,\n"
				+ "	t_sales_item_summ.state_cnt,\n"
				+ "	t_sales_agent_summ.agent_cnt,\n"
				+ "	t_sales_item_summ.year_cnt,\n"
				+ "	t_sales_item_summ.month_cnt,\n"
				+ "	t_sales_item_summ.day_cnt,\n"
				+ "	t_sales_item_summ.sales_cnt,\n"
				+ "	t_sales_item_summ.prod_cnt,\n"
				+ "	t_sales_item_summ.sum_qty,\n"
				+ "	t_sales_item_summ.sum_item_val,\n"
				+ "	NULL sum_amt_payable\n"
				+ "FROM\n"
				+ "	t_sales_item_summ\n"
				+ "LEFT JOIN\n"
				+ "	product_category\n"
				+ "ON\n"
				+ "	product_category.id = t_sales_item_summ.root_prod_cat_id\n"
				+ "LEFT JOIN\n"
				+ "	t_sales_agent_summ\n"
				+ "ON\n"
				+ "	t_sales_agent_summ.root_prod_cat_id = t_sales_item_summ.root_prod_cat_id", sql1, sql2, sql3, sql4);

		List<String> orderBys = new ArrayList<>();

		if (rptSalesSortByEnum != null)
		{
			orderBys.add(String.format("%s %s", rptSalesSortByEnum.getKey(), sortType.getSqlName()));
		}

		orderBys.add(String.format("%s %s", rptSalesSortByEnum.NAME.getKey(), sortType.ASC.getSqlName()));

		sql = SqlHelper.putOrderBys(orderBys, sql);

		return session.createNativeQuery(sql, RptSalesByProdCatHdto.class).getResultList();
	}

	public List<RptSalesByProdHdto> getRptSalesByProdCatProdHdtos(
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			String city,
			String cityExact,
			Integer stateId,
			Integer agentId,
			Integer parentProdCatId,
			Integer prodCatId,
			Integer prodId,
			RptSalesByProdCatSortByEnum rptSalesSortByEnum,
			SortOrderEnum sortType
	)
	{
		String sql1 = "SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		product_category l1_pc\n"
				+ "	WHERE\n";

		if (parentProdCatId == null)
		{
			sql1 = sql1 + " parent_id IS NULL\n";
		}
		else
		{
			sql1 = sql1 + String.format("id = %s\n", parentProdCatId);
		}

		sql1 = sql1 + "UNION ALL\n"
				+ "\n"
				+ "	SELECT\n"
				+ "		cte_cat.root_id,\n"
				+ "		cte_cat.child_id,\n"
				+ "		l2_pc.id\n"
				+ "	FROM\n"
				+ "		product_category l2_pc\n"
				+ "	INNER JOIN \n"
				+ "		cte_cat\n"
				+ "	ON \n"
				+ "		l2_pc.parent_id = cte_cat.child_id\n";

		String sql2 = "SELECT\n"
				+ "		sales.id sales_id,\n"
				+ "		sales.customer_id,\n"
				+ "		voucher.date,\n"
				+ "		qty,\n"
				+ "		sales_item.product_id,\n"
				+ "		cte_cat.root_id root_prod_cat_id,\n"
				+ "		customer.city,\n"
				+ "		customer.state_id,\n"
				+ "		sales_item.taxable_amt\n"
				+ "	FROM\n"
				+ "		sales_item\n"
				+ "	LEFT JOIN\n"
				+ "		sales\n"
				+ "	ON\n"
				+ "		sales.id = sales_item.sales_id\n"
				+ "	LEFT JOIN\n"
				+ "		voucher\n"
				+ "	ON\n"
				+ "		voucher.id = sales.id\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	LEFT JOIN\n"
				+ "		product\n"
				+ "	ON\n"
				+ "		product.id = sales_item.product_id\n"
				+ "	LEFT JOIN\n"
				+ "		cte_cat\n"
				+ "	ON\n"
				+ "		cte_cat.child_id = product.category_id";

		String sql3 = "SELECT	\n"
				+ "		product_id,\n"
				+ "		COUNT(DISTINCT t_sales_item.customer_id) customer_cnt,\n"
				+ "		COUNT(DISTINCT city) city_cnt,\n"
				+ "		COUNT(DISTINCT state_id) state_cnt,\n"
				+ "		COUNT(DISTINCT YEAR(t_sales_item.date)) year_cnt,\n"
				+ "		COUNT(DISTINCT (YEAR(t_sales_item.date) * 100 + MONTH(t_sales_item.date))) month_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.date) day_cnt,\n"
				+ "		COUNT(DISTINCT sales_id) sales_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.product_id) prod_cnt,\n"
				+ "		SUM(qty) sum_qty,\n"
				+ "		SUM(taxable_amt) sum_item_val\n"
				+ "	FROM\n"
				+ "		t_sales_item\n"
				+ "	GROUP BY\n"
				+ "		product_id\n";

		String sql4 = "SELECT\n"
				+ "		product_id,\n"
				+ "		COUNT(DISTINCT sales_agent.agent_id) agent_cnt\n"
				+ "	FROM\n"
				+ "		sales_agent\n"
				+ "	JOIN\n"
				+ "		t_sales_item\n"
				+ "	ON\n"
				+ "		t_sales_item.sales_id = sales_agent.sales_id\n"
				+ "	GROUP BY\n"
				+ "		product_id\n";

		List<String> wheres = new ArrayList<>();

		if (dateFrom != null)
		{
			wheres.add("date(voucher.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(voucher.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add(String.format("sales.customer_id = %s", customerId));
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%%%s%%\'", "city", SqlHelper.escape(city)));
		}
		if (cityExact != null && !cityExact.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%s\'", "city", SqlHelper.escape(cityExact)));
		}
		if (stateId != null)
		{
			if (stateId == -1)
			{
				wheres.add("state_id IS NULL");
			}
			else
			{
				wheres.add(String.format("%s = %s", "state_id", stateId));
			}
		}
		if (agentId != null)
		{
			if (agentId == -1)
			{
				wheres.add("(SELECT COUNT(*) FROM sales_agent WHERE sales_agent.sales_id = sales.id) = 0");
			}
			else
			{
				wheres.add(String.format("%s IN (SELECT agent_id FROM sales_agent WHERE sales_agent.sales_id = sales.id)", agentId));
			}
		}

		if (prodId != null)
		{
			wheres.add(String.format("sales_item.product_id = %s", prodId));
		}
		if (prodCatId != null)
		{
			if (prodCatId == -1)
			{
				wheres.add(String.format("product.category_id IS NULL"));
			}
			else
			{
				wheres.add(String.format("product.category_id = %s", prodCatId));
			}
		}
		if (parentProdCatId != null)
		{
			wheres.add(String.format("cte_cat.root_id IS NOT NULL"));
		}
		sql2 = SqlHelper.putWheres(wheres, sql2);

		String sql = String.format("WITH RECURSIVE cte_cat (root_id, parent_id, child_id) AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item_summ AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_agent_summ AS (\n"
				+ "	%s\n"
				+ ")\n"
				+ "SELECT\n"
				+ "	product.id prod_id,\n"
				+ "	product.name prod_name,\n"
				+ "	t_sales_item_summ.customer_cnt,\n"
				+ "	t_sales_item_summ.city_cnt,\n"
				+ "	t_sales_item_summ.state_cnt,\n"
				+ "	t_sales_agent_summ.agent_cnt,\n"
				+ "	t_sales_item_summ.year_cnt,\n"
				+ "	t_sales_item_summ.month_cnt,\n"
				+ "	t_sales_item_summ.day_cnt,\n"
				+ "	t_sales_item_summ.sales_cnt,\n"
				+ "	t_sales_item_summ.prod_cnt,\n"
				+ "	t_sales_item_summ.sum_qty,\n"
				+ "	t_sales_item_summ.sum_item_val,\n"
				+ "	NULL sum_amt_payable\n"
				+ "FROM\n"
				+ "	t_sales_item_summ\n"
				+ "LEFT JOIN\n"
				+ "	product\n"
				+ "ON\n"
				+ "	product.id = t_sales_item_summ.product_id\n"
				+ "LEFT JOIN\n"
				+ "	t_sales_agent_summ\n"
				+ "ON\n"
				+ "	t_sales_agent_summ.product_id = t_sales_item_summ.product_id", sql1, sql2, sql3, sql4);

		List<String> orderBys = new ArrayList<>();

		if (rptSalesSortByEnum != null && rptSalesSortByEnum != RptSalesByProdCatSortByEnum.NAME)
		{
			orderBys.add(String.format("%s %s", rptSalesSortByEnum.getKey(), sortType.getSqlName()));
		}

		orderBys.add(String.format("%s %s", "prod_name", sortType.ASC.getSqlName()));

		sql = SqlHelper.putOrderBys(orderBys, sql);

		return session.createNativeQuery(sql, RptSalesByProdHdto.class).getResultList();
	}

	public List<RptSalesByProdHdto> getRptSalesByProdHdtos(
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			String city,
			String cityExact,
			Integer stateId,
			Integer agentId,
			Integer parentProdCatId,
			Integer prodCatId,
			Integer prodId,
			RptSalesByProdSortByEnum rptSalesSortByEnum,
			SortOrderEnum sortType
	)
	{
		String sql1 = "SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		product_category l1_pc\n"
				+ "	WHERE\n";

		if (parentProdCatId == null)
		{
			sql1 = sql1 + " parent_id IS NULL\n";
		}
		else
		{
			sql1 = sql1 + String.format("id = %s\n", parentProdCatId);
		}

		sql1 = sql1 + "UNION ALL\n"
				+ "\n"
				+ "	SELECT\n"
				+ "		cte_cat.root_id,\n"
				+ "		cte_cat.child_id,\n"
				+ "		l2_pc.id\n"
				+ "	FROM\n"
				+ "		product_category l2_pc\n"
				+ "	INNER JOIN \n"
				+ "		cte_cat\n"
				+ "	ON \n"
				+ "		l2_pc.parent_id = cte_cat.child_id\n";

		String sql2 = "SELECT\n"
				+ "		sales.id sales_id,\n"
				+ "		sales.customer_id,\n"
				+ "		voucher.date,\n"
				+ "		qty,\n"
				+ "		sales_item.product_id,\n"
				+ "		cte_cat.root_id root_prod_cat_id,\n"
				+ "		customer.city,\n"
				+ "		customer.state_id,\n"
				+ "		sales_item.taxable_amt\n"
				+ "	FROM\n"
				+ "		sales_item\n"
				+ "	LEFT JOIN\n"
				+ "		sales\n"
				+ "	ON\n"
				+ "		sales.id = sales_item.sales_id\n"
				+ "	LEFT JOIN\n"
				+ "		voucher\n"
				+ "	ON\n"
				+ "		voucher.id = sales.id\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	LEFT JOIN\n"
				+ "		product\n"
				+ "	ON\n"
				+ "		product.id = sales_item.product_id\n"
				+ "	LEFT JOIN\n"
				+ "		cte_cat\n"
				+ "	ON\n"
				+ "		cte_cat.child_id = product.category_id";

		String sql3 = "SELECT	\n"
				+ "		product_id,\n"
				+ "		COUNT(DISTINCT t_sales_item.customer_id) customer_cnt,\n"
				+ "		COUNT(DISTINCT city) city_cnt,\n"
				+ "		COUNT(DISTINCT state_id) state_cnt,\n"
				+ "		COUNT(DISTINCT YEAR(t_sales_item.date)) year_cnt,\n"
				+ "		COUNT(DISTINCT (YEAR(t_sales_item.date) * 100 + MONTH(t_sales_item.date))) month_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.date) day_cnt,\n"
				+ "		COUNT(DISTINCT sales_id) sales_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.product_id) prod_cnt,\n"
				+ "		SUM(qty) sum_qty,\n"
				+ "		SUM(taxable_amt) sum_item_val\n"
				+ "	FROM\n"
				+ "		t_sales_item\n"
				+ "	GROUP BY\n"
				+ "		product_id\n";

		String sql4 = "SELECT\n"
				+ "		product_id,\n"
				+ "		COUNT(DISTINCT sales_agent.agent_id) agent_cnt\n"
				+ "	FROM\n"
				+ "		sales_agent\n"
				+ "	JOIN\n"
				+ "		t_sales_item\n"
				+ "	ON\n"
				+ "		t_sales_item.sales_id = sales_agent.sales_id\n"
				+ "	GROUP BY\n"
				+ "		product_id\n";

		List<String> wheres = new ArrayList<>();

		if (dateFrom != null)
		{
			wheres.add("date(voucher.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(voucher.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add(String.format("sales.customer_id = %s", customerId));
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%%%s%%\'", "city", SqlHelper.escape(city)));
		}
		if (cityExact != null && !cityExact.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%s\'", "city", SqlHelper.escape(cityExact)));
		}
		if (stateId != null)
		{
			if (stateId == -1)
			{
				wheres.add("state_id IS NULL");
			}
			else
			{
				wheres.add(String.format("%s = %s", "state_id", stateId));
			}
		}
		if (agentId != null)
		{
			if (agentId == -1)
			{
				wheres.add("(SELECT COUNT(*) FROM sales_agent WHERE sales_agent.sales_id = sales.id) = 0");
			}
			else
			{
				wheres.add(String.format("%s IN (SELECT agent_id FROM sales_agent WHERE sales_agent.sales_id = sales.id)", agentId));
			}
		}

		if (prodId != null)
		{
			wheres.add(String.format("sales_item.product_id = %s", prodId));
		}
		if (prodCatId != null)
		{
			wheres.add(String.format("product.category_id = %s", prodCatId));
		}
		if (parentProdCatId != null)
		{
			wheres.add(String.format("cte_cat.root_id IS NOT NULL"));
		}
		sql2 = SqlHelper.putWheres(wheres, sql2);

		String sql = String.format("WITH RECURSIVE cte_cat (root_id, parent_id, child_id) AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item_summ AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_agent_summ AS (\n"
				+ "	%s\n"
				+ ")\n"
				+ "SELECT\n"
				+ "	product.id prod_id,\n"
				+ "	product.name prod_name,\n"
				+ "	t_sales_item_summ.customer_cnt,\n"
				+ "	t_sales_item_summ.city_cnt,\n"
				+ "	t_sales_item_summ.state_cnt,\n"
				+ "	t_sales_agent_summ.agent_cnt,\n"
				+ "	t_sales_item_summ.year_cnt,\n"
				+ "	t_sales_item_summ.month_cnt,\n"
				+ "	t_sales_item_summ.day_cnt,\n"
				+ "	t_sales_item_summ.sales_cnt,\n"
				+ "	t_sales_item_summ.prod_cnt,\n"
				+ "	t_sales_item_summ.sum_qty,\n"
				+ "	t_sales_item_summ.sum_item_val,\n"
				+ "	NULL sum_amt_payable\n"
				+ "FROM\n"
				+ "	t_sales_item_summ\n"
				+ "LEFT JOIN\n"
				+ "	product\n"
				+ "ON\n"
				+ "	product.id = t_sales_item_summ.product_id\n"
				+ "LEFT JOIN\n"
				+ "	t_sales_agent_summ\n"
				+ "ON\n"
				+ "	t_sales_agent_summ.product_id = t_sales_item_summ.product_id", sql1, sql2, sql3, sql4);

		List<String> orderBys = new ArrayList<>();

		if (rptSalesSortByEnum != null)
		{
			orderBys.add(String.format("%s %s", rptSalesSortByEnum.getKey(), sortType.getSqlName()));
		}

		orderBys.add(String.format("%s %s", rptSalesSortByEnum.NAME.getKey(), sortType.ASC.getSqlName()));

		sql = SqlHelper.putOrderBys(orderBys, sql);

		return session.createNativeQuery(sql, RptSalesByProdHdto.class).getResultList();
	}

	public List<RptSalesByStateHdto> getRptSalesByStateHdtos(
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			String city,
			String cityExact,
			Integer stateId,
			Integer agentId,
			Integer parentProdCatId,
			Integer prodCatId,
			Integer prodId,
			RptSalesByStateSortByEnum rptSalesSortByEnum,
			SortOrderEnum sortType
	)
	{
		String sql1 = "SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		product_category l1_pc\n"
				+ "	WHERE\n";

		if (parentProdCatId == null)
		{
			sql1 = sql1 + " parent_id IS NULL\n";
		}
		else
		{
			sql1 = sql1 + String.format("id = %s\n", parentProdCatId);
		}

		sql1 = sql1 + "UNION ALL\n"
				+ "\n"
				+ "	SELECT\n"
				+ "		cte_cat.root_id,\n"
				+ "		cte_cat.child_id,\n"
				+ "		l2_pc.id\n"
				+ "	FROM\n"
				+ "		product_category l2_pc\n"
				+ "	INNER JOIN \n"
				+ "		cte_cat\n"
				+ "	ON \n"
				+ "		l2_pc.parent_id = cte_cat.child_id\n";

		String sql2 = "SELECT\n"
				+ "		sales.id sales_id,\n"
				+ "		sales.customer_id,\n"
				+ "		voucher.date,\n"
				+ "		qty,\n"
				+ "		sales_item.product_id,\n"
				+ "		cte_cat.root_id root_prod_cat_id,\n"
				+ "		customer.city,\n"
				+ "		customer.state_id,\n"
				+ "		sales_item.taxable_amt\n"
				+ "	FROM\n"
				+ "		sales_item\n"
				+ "	LEFT JOIN\n"
				+ "		sales\n"
				+ "	ON\n"
				+ "		sales.id = sales_item.sales_id\n"
				+ "	LEFT JOIN\n"
				+ "		voucher\n"
				+ "	ON\n"
				+ "		voucher.id = sales.id\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	LEFT JOIN\n"
				+ "		product\n"
				+ "	ON\n"
				+ "		product.id = sales_item.product_id\n"
				+ "	LEFT JOIN\n"
				+ "		cte_cat\n"
				+ "	ON\n"
				+ "		cte_cat.child_id = product.category_id";

		String sql3 = "SELECT	\n"
				+ "		state_id,\n"
				+ "		COUNT(DISTINCT t_sales_item.customer_id) customer_cnt,\n"
				+ "		COUNT(DISTINCT city) city_cnt,\n"
				+ "		COUNT(DISTINCT state_id) state_cnt,\n"
				+ "		COUNT(DISTINCT YEAR(t_sales_item.date)) year_cnt,\n"
				+ "		COUNT(DISTINCT (YEAR(t_sales_item.date) * 100 + MONTH(t_sales_item.date))) month_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.date) day_cnt,\n"
				+ "		COUNT(DISTINCT sales_id) sales_cnt,\n"
				+ "		COUNT(DISTINCT t_sales_item.product_id) prod_cnt,\n"
				+ "		SUM(qty) sum_qty,\n"
				+ "		SUM(taxable_amt) sum_item_val\n"
				+ "	FROM\n"
				+ "		t_sales_item\n"
				+ "	GROUP BY\n"
				+ "		state_id\n";

		String sql4 = "SELECT\n"
				+ "		state_id,\n"
				+ "		COUNT(DISTINCT sales_agent.agent_id) agent_cnt\n"
				+ "	FROM\n"
				+ "		sales_agent\n"
				+ "	LEFT JOIN\n"
				+ "		sales\n"
				+ "	ON\n"
				+ "		sales_agent.sales_id = sales.id\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	WHERE\n"
				+ "		sales.id IN (SELECT sales_id FROM t_sales_item)\n"
				+ "	GROUP BY\n"
				+ "		state_id\n";

		String sql5 = "SELECT\n"
				+ "		customer.state_id,\n"
				+ "		SUM(amt_payable) sum_amt_payable\n"
				+ "	FROM\n"
				+ "		sales\n"
				+ "	LEFT JOIN\n"
				+ "		voucher\n"
				+ "	ON\n"
				+ "		voucher.id = sales.id\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	WHERE\n"
				+ "		sales.id IN (SELECT sales_id FROM t_sales_item)\n"
				+ "	GROUP BY\n"
				+ "		customer.state_id\n";

		List<String> wheres = new ArrayList<>();

		if (dateFrom != null)
		{
			wheres.add("date(voucher.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(voucher.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add(String.format("sales.customer_id = %s", customerId));
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%%%s%%\'", "city", SqlHelper.escape(city)));
		}
		if (cityExact != null && !cityExact.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%s\'", "city", SqlHelper.escape(cityExact)));
		}
		if (stateId != null)
		{
			if (stateId == -1)
			{
				wheres.add("state_id IS NULL");
			}
			else
			{
				wheres.add(String.format("%s = %s", "state_id", stateId));
			}
		}
		if (agentId != null)
		{
			if (agentId == -1)
			{
				wheres.add("(SELECT COUNT(*) FROM sales_agent WHERE sales_agent.sales_id = sales.id) = 0");
			}
			else
			{
				wheres.add(String.format("%s IN (SELECT agent_id FROM sales_agent WHERE sales_agent.sales_id = sales.id)", agentId));
			}
		}

		if (prodId != null)
		{
			wheres.add(String.format("sales_item.product_id = %s", prodId));
		}
		if (prodCatId != null)
		{
			wheres.add(String.format("product.category_id = %s", prodCatId));
		}
		if (parentProdCatId != null)
		{
			wheres.add(String.format("cte_cat.root_id IS NOT NULL"));
		}
		sql2 = SqlHelper.putWheres(wheres, sql2);

		String sql = String.format("WITH RECURSIVE cte_cat (root_id, parent_id, child_id) AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item_summ AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_agent_summ AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_summ AS (\n"
				+ "	%s\n"
				+ ")\n"
				+ "SELECT\n"
				+ "	state.id state_id,\n"
				+ "	state.name state_name,\n"
				+ "	t_sales_item_summ.customer_cnt,\n"
				+ "	t_sales_item_summ.city_cnt,\n"
				+ "	t_sales_item_summ.state_cnt,\n"
				+ "	t_sales_agent_summ.agent_cnt,\n"
				+ "	t_sales_item_summ.year_cnt,\n"
				+ "	t_sales_item_summ.month_cnt,\n"
				+ "	t_sales_item_summ.day_cnt,\n"
				+ "	t_sales_item_summ.sales_cnt,\n"
				+ "	t_sales_item_summ.prod_cnt,\n"
				+ "	t_sales_item_summ.sum_qty,\n"
				+ "	t_sales_item_summ.sum_item_val,\n"
				+ "	t_sales_summ.sum_amt_payable\n"
				+ "FROM\n"
				+ "	t_sales_summ\n"
				+ "LEFT JOIN\n"
				+ "	t_sales_item_summ\n"
				+ "ON\n"
				+ "	t_sales_summ.state_id = t_sales_item_summ.state_id\n"
				+ "LEFT JOIN\n"
				+ "	state\n"
				+ "ON\n"
				+ "	state.id = t_sales_summ.state_id\n"
				+ "LEFT JOIN\n"
				+ "	t_sales_agent_summ\n"
				+ "ON\n"
				+ "	t_sales_agent_summ.state_id = t_sales_item_summ.state_id", sql1, sql2, sql3, sql4, sql5);

		List<String> orderBys = new ArrayList<>();

		if (rptSalesSortByEnum != null)
		{
			orderBys.add(String.format("%s %s", rptSalesSortByEnum.getKey(), sortType.getSqlName()));
		}

		orderBys.add(String.format("%s %s", rptSalesSortByEnum.NAME.getKey(), sortType.ASC.getSqlName()));

		sql = SqlHelper.putOrderBys(orderBys, sql);

		return session.createNativeQuery(sql, RptSalesByStateHdto.class).getResultList();
	}

	public List<RptSalesDetailedByVoucherHdto> getRptSalesDetailedByVoucherHdtos(
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			String city,
			String cityExact,
			Integer stateId,
			Integer agentId,
			Integer parentProdCatId,
			Integer prodCatId,
			Integer prodId,
			RptSalesDetailedByVoucherSortByEnum rptSalesSortByEnum,
			SortOrderEnum sortType
	)
	{
		String sql1 = "SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		product_category l1_pc\n"
				+ "	WHERE\n";

		if (parentProdCatId == null)
		{
			sql1 = sql1 + " parent_id IS NULL\n";
		}
		else
		{
			sql1 = sql1 + String.format("id = %s\n", parentProdCatId);
		}

		sql1 = sql1 + "UNION ALL\n"
				+ "\n"
				+ "	SELECT\n"
				+ "		cte_cat.root_id,\n"
				+ "		cte_cat.child_id,\n"
				+ "		l2_pc.id\n"
				+ "	FROM\n"
				+ "		product_category l2_pc\n"
				+ "	INNER JOIN \n"
				+ "		cte_cat\n"
				+ "	ON \n"
				+ "		l2_pc.parent_id = cte_cat.child_id\n";

		String sql2 = "SELECT\n"
				+ "		sales.id sales_id,\n"
				+ "		sales.customer_id,\n"
				+ "		voucher.date,\n"
				+ "		qty,\n"
				+ "		sales_item.product_id,\n"
				+ "		cte_cat.root_id root_prod_cat_id,\n"
				+ "		customer.city,\n"
				+ "		customer.state_id,\n"
				+ "		sales_item.taxable_amt\n"
				+ "	FROM\n"
				+ "		sales_item\n"
				+ "	LEFT JOIN\n"
				+ "		sales\n"
				+ "	ON\n"
				+ "		sales.id = sales_item.sales_id\n"
				+ "	LEFT JOIN\n"
				+ "		voucher\n"
				+ "	ON\n"
				+ "		voucher.id = sales.id\n"
				+ "	LEFT JOIN\n"
				+ "		customer\n"
				+ "	ON\n"
				+ "		customer.id = sales.customer_id\n"
				+ "	LEFT JOIN\n"
				+ "		product\n"
				+ "	ON\n"
				+ "		product.id = sales_item.product_id\n"
				+ "	LEFT JOIN\n"
				+ "		cte_cat\n"
				+ "	ON\n"
				+ "		cte_cat.child_id = product.category_id";

		String sql3 = "SELECT	\n"
				+ "		sales_id,\n"
				+ "		COUNT(DISTINCT t_sales_item.product_id) prod_cnt,\n"
				+ "		SUM(qty) sum_qty,\n"
				+ "		SUM(taxable_amt) sum_item_val\n"
				+ "	FROM\n"
				+ "		t_sales_item\n"
				+ "	GROUP BY\n"
				+ "		sales_id	";

		List<String> wheres = new ArrayList<>();

		if (dateFrom != null)
		{
			wheres.add("date(voucher.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(voucher.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add(String.format("sales.customer_id = %s", customerId));
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%%%s%%\'", "city", SqlHelper.escape(city)));
		}
		if (cityExact != null && !cityExact.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%s\'", "city", SqlHelper.escape(cityExact)));
		}
		if (stateId != null)
		{
			if (stateId == -1)
			{
				wheres.add("state_id IS NULL");
			}
			else
			{
				wheres.add(String.format("%s = %s", "state_id", stateId));
			}
		}
		if (agentId != null)
		{
			if (agentId == -1)
			{
				wheres.add("(SELECT COUNT(*) FROM sales_agent WHERE sales_agent.sales_id = sales.id) = 0");
			}
			else
			{
				wheres.add(String.format("%s IN (SELECT agent_id FROM sales_agent WHERE sales_agent.sales_id = sales.id)", agentId));
			}
		}

		if (prodId != null)
		{
			wheres.add(String.format("sales_item.product_id = %s", prodId));
		}
		if (prodCatId != null)
		{
			wheres.add(String.format("product.category_id = %s", prodCatId));
		}
		if (parentProdCatId != null)
		{
			wheres.add(String.format("cte_cat.root_id IS NOT NULL"));
		}
		sql2 = SqlHelper.putWheres(wheres, sql2);

		String sql = String.format("WITH RECURSIVE cte_cat (root_id, parent_id, child_id) AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item AS (\n"
				+ "	%s\n"
				+ "),\n"
				+ "t_sales_item_summ AS (\n"
				+ "	%s\n"
				+ ")\n"
				+ "SELECT\n"
				+ "	sales.id sales_id,\n"
				+ "	voucher.no,\n"
				+ "	voucher.date,\n"
				+ "	acct.id customer_id,\n"
				+ "	acct.name customer_name,\n"
				+ "	customer.city city,\n"
				+ "	state.id state_id,\n"
				+ "	state.name state_name,\n"
				+ "	t_sales_item_summ.prod_cnt,\n"
				+ "	t_sales_item_summ.sum_qty,\n"
				+ "	t_sales_item_summ.sum_item_val,\n"
				+ "	sales.amt_payable\n"
				+ "FROM\n"
				+ "	sales\n"
				+ "LEFT JOIN\n"
				+ "	voucher\n"
				+ "ON\n"
				+ "	voucher.id = sales.id\n"
				+ "LEFT JOIN\n"
				+ "	customer\n"
				+ "ON\n"
				+ "	customer.id = sales.customer_id\n"
				+ "LEFT JOIN\n"
				+ "	acct\n"
				+ "ON\n"
				+ "	acct.id = sales.customer_id\n"
				+ "LEFT JOIN\n"
				+ "	state\n"
				+ "ON\n"
				+ "	state.id = customer.state_id\n"
				+ "JOIN\n"
				+ "	t_sales_item_summ\n"
				+ "ON\n"
				+ "	t_sales_item_summ.sales_id = sales.id", sql1, sql2, sql3);

		List<String> orderBys = new ArrayList<>();

		if (rptSalesSortByEnum != null)
		{
			orderBys.add(String.format("%s %s", rptSalesSortByEnum.getKey(), sortType.getSqlName()));
		}

		orderBys.add(String.format("%s %s", rptSalesSortByEnum.DATE.getKey(), sortType.ASC.getSqlName()));

		sql = SqlHelper.putOrderBys(orderBys, sql);

		return session.createNativeQuery(sql, RptSalesDetailedByVoucherHdto.class).getResultList();
	}

	public List<RptSalesDetailedByProdHdto> getRptSalesDetailedByProdHdtos(
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			String city,
			String cityExact,
			Integer stateId,
			Integer agentId,
			Integer parentProdCatId,
			Integer prodCatId,
			Integer prodId,
			RptSalesDetailedByProdSortByEnum rptSalesSortByEnum,
			SortOrderEnum sortType
	)
	{
		String sql1 = "SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		product_category l1_pc\n"
				+ "	WHERE\n";

		if (parentProdCatId == null)
		{
			sql1 = sql1 + " parent_id IS NULL\n";
		}
		else
		{
			sql1 = sql1 + String.format("id = %s\n", parentProdCatId);
		}

		sql1 = sql1 + "UNION ALL\n"
				+ "\n"
				+ "	SELECT\n"
				+ "		cte_cat.root_id,\n"
				+ "		cte_cat.child_id,\n"
				+ "		l2_pc.id\n"
				+ "	FROM\n"
				+ "		product_category l2_pc\n"
				+ "	INNER JOIN \n"
				+ "		cte_cat\n"
				+ "	ON \n"
				+ "		l2_pc.parent_id = cte_cat.child_id\n";

		String sql = String.format("WITH RECURSIVE cte_cat (root_id, parent_id, child_id) AS (\n"
				+ "	%s\n"
				+ ")\n"
				+ "SELECT\n"
				+ "	sales_item.id sales_item_id,\n"
				+ "	sales.id sales_id,\n"
				+ "	voucher.date,\n"
				+ "	voucher.no,\n"
				+ "	sales.customer_id,\n"
				+ "	acct.name customer_name,\n"
				+ "	customer.city,\n"
				+ "	customer.state_id,\n"
				+ "	state.name state_name,\n"
				+ "	sales_item.product_id prod_id,\n"
				+ "	product.name prod_name,\n"
				+ "	product_category.id prod_cat_id,\n"
				+ "	product_category.name prod_cat_name,\n"
				+ "	qty,\n"
				+ "	rate,\n"
				+ "	sales_item.taxable_amt item_val\n"
				+ "FROM\n"
				+ "	sales_item\n"
				+ "LEFT JOIN\n"
				+ "	sales\n"
				+ "ON\n"
				+ "	sales.id = sales_item.sales_id\n"
				+ "LEFT JOIN\n"
				+ "	voucher\n"
				+ "ON\n"
				+ "	voucher.id = sales.id\n"
				+ "LEFT JOIN\n"
				+ "	customer\n"
				+ "ON\n"
				+ "	customer.id = sales.customer_id\n"
				+ "LEFT JOIN\n"
				+ "	acct\n"
				+ "ON\n"
				+ "	acct.id = sales.customer_id\n"
				+ "LEFT JOIN\n"
				+ "	state\n"
				+ "ON\n"
				+ "	state.id = customer.state_id\n"
				+ "LEFT JOIN\n"
				+ "	product\n"
				+ "ON\n"
				+ "	product.id = sales_item.product_id\n"
				+ "LEFT JOIN\n"
				+ "	product_category\n"
				+ "ON\n"
				+ "	product_category.id = product.category_id\n"
				+ "LEFT JOIN\n"
				+ "	cte_cat\n"
				+ "ON\n"
				+ "	cte_cat.child_id = product.category_id", sql1);

		List<String> wheres = new ArrayList<>();

		if (dateFrom != null)
		{
			wheres.add("date(voucher.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(voucher.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add(String.format("sales.customer_id = %s", customerId));
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%%%s%%\'", "city", SqlHelper.escape(city)));
		}
		if (cityExact != null && !cityExact.isEmpty())
		{
			wheres.add(String.format("IFNULL(%s, '') LIKE \'%s\'", "city", SqlHelper.escape(cityExact)));
		}
		if (stateId != null)
		{
			if (stateId == -1)
			{
				wheres.add("state_id IS NULL");
			}
			else
			{
				wheres.add(String.format("%s = %s", "state_id", stateId));
			}
		}
		if (agentId != null)
		{
			if (agentId == -1)
			{
				wheres.add("(SELECT COUNT(*) FROM sales_agent WHERE sales_agent.sales_id = sales.id) = 0");
			}
			else
			{
				wheres.add(String.format("%s IN (SELECT agent_id FROM sales_agent WHERE sales_agent.sales_id = sales.id)", agentId));
			}
		}

		if (prodId != null)
		{
			wheres.add(String.format("sales_item.product_id = %s", prodId));
		}
		if (prodCatId != null)
		{
			wheres.add(String.format("product.category_id = %s", prodCatId));
		}
		if (parentProdCatId != null)
		{
			wheres.add(String.format("cte_cat.root_id IS NOT NULL"));
		}
		sql = SqlHelper.putWheres(wheres, sql);

		List<String> orderBys = new ArrayList<>();

		if (rptSalesSortByEnum != null)
		{
			orderBys.add(String.format("%s %s", rptSalesSortByEnum.getKey(), sortType.getSqlName()));
		}

		orderBys.add(String.format("%s %s", rptSalesSortByEnum.DATE.getKey(), sortType.ASC.getSqlName()));

		sql = SqlHelper.putOrderBys(orderBys, sql);

		return session.createNativeQuery(sql, RptSalesDetailedByProdHdto.class).getResultList();
	}

	public List<SalesAnalysisDetHdto> getDetReport(
			List<RptSalesAnalysisGroupBy> groupBys,
			Integer customerId,
			String customerName,
			String city,
			Integer stateId,
			String stateName,
			Integer catId,
			String catName,
			Integer prodId,
			String prodName,
			Date dateFrom,
			Date dateTo
	)
	{
		List<String> orderBy = new ArrayList<>();
		List<String> wheres = new ArrayList<>();

		if (customerId != null)
		{
			wheres.add(String.format("%s = %s", "customer_id", customerId));
		}
		if (customerName != null && !customerName.isEmpty())
		{
			wheres.add(String.format("%s LIKE \'%%%s%%\'", "customer_name", SqlHelper.escape(customerName)));
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add(String.format("%s LIKE \'%%%s%%\'", "city", SqlHelper.escape(city)));
		}
		if (stateId != null)
		{
			wheres.add(String.format("%s = %s", "state_id", stateId));
		}
		if (stateName != null && !stateName.isEmpty())
		{
			wheres.add(String.format("%s LIKE \'%%%s%%\'", "state_name", SqlHelper.escape(stateName)));
		}
		if (catId != null)
		{
			wheres.add(String.format("%s = %s", "cat_id", catId));
		}
		if (catName != null && !catName.isEmpty())
		{
			wheres.add(String.format("%s LIKE \'%%%s%%\'", "cat_name", SqlHelper.escape(catName)));
		}
		if (prodId != null)
		{
			wheres.add(String.format("%s = %s", "prod_id", prodId));
		}
		if (prodName != null && !prodName.isEmpty())
		{
			wheres.add(String.format("%s LIKE \'%%%s%%\'", "prod_name", SqlHelper.escape(prodName)));
		}
		if (dateFrom != null)
		{
			wheres.add("date >= '" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "'");
		}
		if (dateTo != null)
		{
			wheres.add("date <= '" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "'");
		}

		if (groupBys != null)
		{
			for (RptSalesAnalysisGroupBy reportGroupBy : groupBys)
			{
				switch (reportGroupBy)
				{
					case CATEGORY:
						orderBy.add("cat_id");
						break;
					case CITY:
						orderBy.add("city");
						break;
					case CUSTOMER:
						orderBy.add("customer_name");
						break;
					case DAY:
						orderBy.add("date");
						break;
					case MONTH:
						orderBy.add("month");
						break;
					case PRODUCT:
						orderBy.add("prod_name");
						break;
					case STATE:
						orderBy.add("state_name");
						break;
					case YEAR:
						orderBy.add("year");
						break;
				}
			}
		}
		orderBy.add("date DESC");

		String finalSql = getReportRowsContainerQuery(
				catId,
				(groupBys != null && groupBys.contains(RptSalesAnalysisGroupBy.PRODUCT))
				|| (groupBys != null && groupBys.contains(RptSalesAnalysisGroupBy.CATEGORY))
				|| prodId != null
				|| (prodName != null && !prodName.isEmpty())
				|| catId != null
				|| (catName != null && !catName.isEmpty())
		);

		finalSql = "SELECT * FROM " + finalSql;
		finalSql = SqlHelper.putWheres(wheres, finalSql);
		finalSql = finalSql + SqlHelper.putOrderBys(orderBy);

		return session.createNativeQuery(finalSql, SalesAnalysisDetHdto.class).getResultList();
	}

	public List<SalesAnalysisSummHdto> getSummReport(
			List<RptSalesAnalysisGroupBy> groupBys,
			Integer customerId,
			String customerName,
			String city,
			Integer stateId,
			String stateName,
			Integer catId,
			String catName,
			Integer prodId,
			String prodName,
			Date dateFrom,
			Date dateTo
	)
	{
		List<String> select = new ArrayList<>();
		List<String> groupBy = new ArrayList<>();
		List<String> wheres = new ArrayList<>();

		if (customerId != null)
		{
			wheres.add(String.format("%s = %s", "customer_id", customerId));
		}
		if (customerName != null && !customerName.isEmpty())
		{
			wheres.add(String.format("%s LIKE \'%%%s%%\'", "customer_name", SqlHelper.escape(customerName)));
		}
		if (city != null && !city.isEmpty())
		{
			wheres.add(String.format("%s LIKE \'%%%s%%\'", "city", SqlHelper.escape(city)));
		}
		if (stateId != null)
		{
			wheres.add(String.format("%s = %s", "state_id", stateId));
		}
		if (stateName != null && !stateName.isEmpty())
		{
			wheres.add(String.format("%s LIKE \'%%%s%%\'", "state_name", SqlHelper.escape(stateName)));
		}
		if (catId != null)
		{
			//wheres.add(String.format("%s = %s", "root_cat_id", catId));
		}
		if (catName != null && !catName.isEmpty())
		{
			wheres.add(String.format("%s LIKE \'%%%s%%\'", "cat_name", SqlHelper.escape(catName)));
		}
		if (prodId != null)
		{
			wheres.add(String.format("%s = %s", "prod_id", prodId));
		}
		if (prodName != null && !prodName.isEmpty())
		{
			wheres.add(String.format("%s LIKE \'%%%s%%\'", "prod_name", SqlHelper.escape(prodName)));
		}
		if (dateFrom != null)
		{
			wheres.add("date >= '" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "'");
		}
		if (dateTo != null)
		{
			wheres.add("date <= '" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "'");
		}

		select.add("COUNT(id) as cnt");
		select.add("SUM(sum_item_taxable_amt) as sum_sum_item_taxable_amt");
		select.add("SUM(cgst_a) as sum_cgst_a");
		select.add("SUM(sgst_a) as sum_sgst_a");
		select.add("SUM(igst_a) as sum_igst_a");
		select.add("SUM(amt_payable) as sum_amt_payable");

		if (groupBys != null)
		{
			for (RptSalesAnalysisGroupBy reportGroupBy : groupBys)
			{
				switch (reportGroupBy)
				{
					case CATEGORY:
						select.add("cat_name");
						groupBy.add("root_cat_id");
						break;
					case CITY:
						select.add("city");
						groupBy.add("city");
						break;
					case CUSTOMER:
						select.add("customer_name");
						groupBy.add("customer_id");
						break;
					case DAY:
						select.add("date");
						groupBy.add("date");
						break;
					case MONTH:
						select.add("month");
						groupBy.add("month");
						break;
					case PRODUCT:
						select.add("prod_name");
						groupBy.add("prod_id");
						break;
					case STATE:
						select.add("state_name");
						groupBy.add("state_id");
						break;
					case YEAR:
						select.add("year");
						groupBy.add("year");
						break;
				}
			}
		}

		if (groupBys.contains(RptSalesAnalysisGroupBy.CATEGORY)
				|| groupBys.contains(RptSalesAnalysisGroupBy.PRODUCT))
		{
			select.add("SUM(sum_prod_qty) sum_prod_qty");
			select.add("SUM(sum_prod_val) sum_prod_val");
		}

		for (RptSalesAnalysisGroupBy reportGroupBy : RptSalesAnalysisGroupBy.values())
		{
			if (!groupBys.contains(reportGroupBy))
			{
				switch (reportGroupBy)
				{
					case CATEGORY:
						select.add("NULL AS cat_name");
						break;
					case CITY:
						select.add("NULL AS city");
						break;
					case CUSTOMER:
						select.add("NULL AS customer_name");
						break;
					case DAY:
						select.add("NULL AS date");
						break;
					case MONTH:
						select.add("NULL AS month");
						break;
					case PRODUCT:
						select.add("NULL AS prod_name");
						break;
					case STATE:
						select.add("NULL AS state_name");
						break;
					case YEAR:
						select.add("NULL AS year");
						break;
				}
			}
		}

		if (!groupBys.contains(RptSalesAnalysisGroupBy.CATEGORY)
				&& !groupBys.contains(RptSalesAnalysisGroupBy.PRODUCT))
		{
			select.add("NULL AS sum_prod_qty");
			select.add("NULL AS sum_prod_val");
		}

		String finalSql = "";
		finalSql = SqlHelper.putSelects(select);

		String tempSql = getReportRowsContainerQuery(
				catId,
				groupBys.contains(RptSalesAnalysisGroupBy.PRODUCT)
				|| groupBys.contains(RptSalesAnalysisGroupBy.CATEGORY)
				|| prodId != null
				|| (prodName != null && !prodName.isEmpty())
				|| catId != null
				|| (catName != null && !catName.isEmpty())
		);

		finalSql = SqlHelper.putFrom(tempSql, finalSql);
		finalSql = SqlHelper.putWheres(wheres, finalSql);
		finalSql = SqlHelper.putGroupBys(groupBy, finalSql);

		return session.createNativeQuery(finalSql, SalesAnalysisSummHdto.class).getResultList();

	}

	private String getReportRowsContainerQuery(Integer catId, boolean hasProduct)
	{

		String part1 = "( \n"
				+ " WITH RECURSIVE cte_cat (root_id, parent_id, child_id) AS (\n"
				+ "	SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		product_category l1_pc\n"
				+ "	WHERE\n";

		if (hasProduct && catId != null)
		{
			part1 = part1 + String.format("parent_id = %s\n", catId);
		}
		else
		{
			part1 = part1 + String.format("parent_id is null\n", catId);
		}

		part1 = part1 + "\n	UNION ALL\n"
				+ "\n"
				+ "	SELECT\n"
				+ "		cte_cat.root_id,\n"
				+ "		cte_cat.child_id,\n"
				+ "		l2_pc.id\n"
				+ "	FROM\n"
				+ "		product_category l2_pc\n"
				+ "	JOIN \n"
				+ "		cte_cat\n"
				+ "	ON \n"
				+ "		l2_pc.parent_id = cte_cat.child_id\n"
				+ "\n"
				+ ")\n"
				+ "	SELECT\n"
				+ "	{table_sales}.`id`, \n"
				+ "	{table_sales}.`sum_amt_after_item_disc`, \n"
				+ "	{table_sales}.`sum_item_taxable_amt`, \n"
				+ "	{table_sales}.`cgst_a`, \n"
				+ "	{table_sales}.`sgst_a`, \n"
				+ "	{table_sales}.`igst_a`, \n"
				+ "	{table_sales}.`amt_payable`, \n"
				+ "	{table_voucher}.`no`, \n"
				+ "	{table_voucher}.`date`, \n"
				+ "	{table_sales}.`customer_id`, \n"
				+ "	{table_acct}.name AS `customer_name`,\n"
				+ "	{table_customer}.city,\n"
				+ "	CONCAT(YEAR({table_voucher}.DATE),\"-\",MONTH({table_voucher}.DATE)) AS `month`,\n"
				+ "	YEAR({table_voucher}.DATE) AS `year`,\n"
				+ "	{table_state}.id AS state_id,\n"
				+ "	{table_state}.name AS state_name ";

		String part2 = "\nFROM\n"
				+ "		{table_sales}\n"
				+ "	LEFT JOIN\n"
				+ "		{table_voucher}\n"
				+ "			ON\n"
				+ "		{table_voucher}.id = {table_sales}.id\n"
				+ "	LEFT JOIN\n"
				+ "		{table_acct}\n"
				+ "			ON\n"
				+ "		{table_acct}.id = {table_sales}.customer_id\n"
				+ "	LEFT JOIN\n"
				+ "		{table_customer}\n"
				+ "			ON\n"
				+ "		{table_customer}.id = {table_acct}.id\n"
				+ "	LEFT JOIN\n"
				+ "		{table_state}\n"
				+ "			ON\n"
				+ "		{table_state}.id = {table_customer}.state_id\n";

		String prodPart1 = ",\n"
				+ "	t2.`product_id` AS prod_id,"
				+ "	t2.`sum_prod_qty`,"
				+ "	t2.`sum_prod_val`,"
				+ "	{table_product}.`name` AS prod_name,"
				+ "	{table_product_category}.`id` AS cat_id,"
				+ "	t_root_cat.`name` AS cat_name,"
				+ "	cte_cat.root_id AS root_cat_id";

		String prodPart1Alt = ",\n"
				+ "	NULL AS prod_id,"
				+ "	NULL AS sum_prod_qty,"
				+ "	NULL AS sum_prod_val,"
				+ "	NULL AS prod_name,"
				+ "	NULL AS cat_id,"
				+ "	NULL AS cat_name,"
				+ "	NULL AS root_cat_id";

		String prodPart2 = "\n		LEFT JOIN\n"
				+ "	("
				+ "SELECT\n"
				+ "	sales_id,\n"
				+ "	product_id,\n"
				+ "	SUM(qty) sum_prod_qty,\n"
				+ "	SUM(taxable_amt) sum_prod_val\n"
				+ "FROM\n"
				+ "	{table_sales_item}\n"
				+ "GROUP BY\n"
				+ "	sales_id,\n"
				+ "	product_id"
				+ ") AS t2\n"
				+ "		ON\n"
				+ "	t2.`sales_id` = {table_sales}.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_product}\n"
				+ "ON\n"
				+ "	{table_product}.id = t2.product_id\n"
				+ "LEFT JOIN	\n"
				+ "	{table_product_category}\n"
				+ "ON\n"
				+ "	{table_product_category}.id = {table_product}.category_id\n"
				+ "LEFT JOIN	\n"
				+ "	cte_cat\n"
				+ "ON\n"
				+ "	cte_cat.child_id = {table_product}.category_id\n"
				+ "LEFT JOIN	\n"
				+ "	{table_product_category} t_root_cat\n"
				+ "ON\n"
				+ "	t_root_cat.id = cte_cat.root_id\n";

		if (hasProduct)
		{
			prodPart2 = prodPart2 + "WHERE\n";
			if (catId == null)
			{
				prodPart2 = prodPart2 + String.format("cte_cat.root_id IS NOT NULL OR product_category.id IS NULL\n");
			}
			else
			{
				prodPart2 = prodPart2 + String.format("cte_cat.root_id IS NOT NULL OR product_category.id = %s\n", catId);
			}
		}

		String part3 = ") as t1";

		String sql = "";
		if (hasProduct)
		{
			sql = part1 + prodPart1 + part2 + prodPart2 + part3;
		}
		else
		{
			sql = part1 + prodPart1Alt + part2 + part3;
		}

		Map<String, String> map = new HashMap<>();
		map.put("table_sales", tableName);
		map.put("table_voucher", TableName.VOUCHER);
		map.put("table_acct", TableName.ACCT);
		map.put("table_customer", TableName.CUSTOMER);
		map.put("table_state", TableName.STATE);
		map.put("table_sales_item", TableName.SALES_ITEM);
		map.put("table_product", TableName.PRODUCT);
		map.put("table_product_category", TableName.PRODUCT_CAT);

		return Util.formatString(sql, map);
	}

	//
	public List<RptSalesProfitByCustomerHdto> getRptSalesProfitByCustomerHdtos(
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			Integer prodId
	)
	{

		String sql = "SELECT \n"
				+ "	sales.customer_id,\n"
				+ "	acct.name customer_name,\n"
				+ "	COUNT(DISTINCT(sales.id)) sales_cnt,\n"
				+ "	COUNT(DISTINCT(sales_item.product_id)) prod_cnt,\n"
				+ "	SUM(amt_after_disc - fifo_val(sales_item.`product_id`, voucher.date) * qty) profit_amt,\n"
				+ "	SUM(amt_after_disc - fifo_val(sales_item.`product_id`, voucher.date) * qty) /\n"
				+ "	SUM(amt_after_disc) * 100 profit_percent\n"
				+ "FROM \n"
				+ "	sales_item\n"
				+ "LEFT JOIN\n"
				+ "	sales\n"
				+ "ON\n"
				+ "	sales.id = sales_item.sales_id\n"
				+ "LEFT JOIN\n"
				+ "	voucher\n"
				+ "ON\n"
				+ "	voucher.id = sales.id\n"
				+ "LEFT JOIN\n"
				+ "	acct\n"
				+ "ON\n"
				+ "	acct.id = sales.customer_id\n"
				+ "LEFT JOIN	\n"
				+ "	product\n"
				+ "ON\n"
				+ "	product.id = sales_item.product_id\n";

		List<String> wheres = new ArrayList<>();

		if (dateFrom != null)
		{
			wheres.add("date(voucher.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(voucher.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add(String.format("sales.customer_id = %s", customerId));
		}
		if (prodId != null)
		{
			wheres.add(String.format("sales_item.product_id = %s", prodId));
		}
		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " GROUP BY customer_id\n";
		sql = sql + " ORDER BY acct.name";

		return session.createNativeQuery(sql, RptSalesProfitByCustomerHdto.class).getResultList();
	}

	public List<RptSalesProfitByProdHdto> getRptSalesProfitByProdHdtos(
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			Integer prodId
	)
	{

		String sql = "SELECT \n"
				+ "	sales_item.product_id prod_id,\n"
				+ "	product.name prod_name,\n"
				+ "	COUNT(DISTINCT(sales.id)) sales_cnt,\n"
				+ "	COUNT(DISTINCT(sales.customer_id)) customer_cnt,\n"
				+ "	SUM(amt_after_disc - fifo_val(sales_item.`product_id`, voucher.date) * qty) profit_amt,\n"
				+ "	SUM(amt_after_disc - fifo_val(sales_item.`product_id`, voucher.date) * qty) /\n"
				+ "	SUM(amt_after_disc) * 100 profit_percent\n"
				+ "FROM \n"
				+ "	sales_item\n"
				+ "LEFT JOIN\n"
				+ "	sales\n"
				+ "ON\n"
				+ "	sales.id = sales_item.sales_id\n"
				+ "LEFT JOIN\n"
				+ "	voucher\n"
				+ "ON\n"
				+ "	voucher.id = sales.id\n"
				+ "LEFT JOIN\n"
				+ "	acct\n"
				+ "ON\n"
				+ "	acct.id = sales.customer_id\n"
				+ "LEFT JOIN	\n"
				+ "	product\n"
				+ "ON\n"
				+ "	product.id = sales_item.product_id\n";

		List<String> wheres = new ArrayList<>();

		if (dateFrom != null)
		{
			wheres.add("date(voucher.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(voucher.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add(String.format("sales.customer_id = %s", customerId));
		}
		if (prodId != null)
		{
			wheres.add(String.format("sales_item.product_id = %s", prodId));
		}
		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " GROUP BY product_id\n";
		sql = sql + " ORDER BY product.name";

		return session.createNativeQuery(sql, RptSalesProfitByProdHdto.class).getResultList();
	}

	public List<RptSalesProfitBySalesVoucherHdto> getRptSalesProfitBySalesVoucherHdtos(
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			Integer prodId,
			String no
	)
	{

		String sql = "SELECT \n"
				+ "	sales_id,\n"
				+ "	voucher.date,\n"
				+ "	voucher.no,\n"
				+ "	sales.customer_id,\n"
				+ "	acct.name customer_name,\n"
				+ "	COUNT(DISTINCT(product_id)) prod_cnt,\n"
				+ "	SUM(amt_after_disc - fifo_val(sales_item.`product_id`, voucher.date) * qty) profit_amt,\n"
				+ "	SUM(amt_after_disc - fifo_val(sales_item.`product_id`, voucher.date) * qty) /\n"
				+ "	SUM(amt_after_disc) * 100 profit_percent\n"
				+ "FROM \n"
				+ "	sales_item\n"
				+ "LEFT JOIN\n"
				+ "	sales\n"
				+ "ON\n"
				+ "	sales.id = sales_item.sales_id\n"
				+ "LEFT JOIN\n"
				+ "	voucher\n"
				+ "ON\n"
				+ "	voucher.id = sales.id\n"
				+ "LEFT JOIN\n"
				+ "	acct\n"
				+ "ON\n"
				+ "	acct.id = sales.customer_id\n";

		List<String> wheres = new ArrayList<>();

		if (dateFrom != null)
		{
			wheres.add("date(voucher.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(voucher.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add(String.format("sales.customer_id = %s", customerId));
		}
		if (prodId != null)
		{
			wheres.add(String.format("sales_item.product_id = %s", prodId));
		}
		if (no != null)
		{
			wheres.add(String.format("voucher.no = %s", no));
		}
		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " GROUP BY sales_id\n";
		sql = sql + " ORDER BY voucher.date";

		return session.createNativeQuery(sql, RptSalesProfitBySalesVoucherHdto.class).getResultList();
	}

	public List<RptSalesProfitBySalesItemHdto> getRptSalesProfitBySalesItemHdtos(
			Date dateFrom,
			Date dateTo,
			Integer customerId,
			Integer prodId,
			String no
	)
	{

		String sql = "SELECT \n"
				+ "	sales_item.id sales_item_id,\n"
				+ "	sales_id,\n"
				+ "	voucher.date,\n"
				+ "	voucher.no,\n"
				+ "	sales.customer_id,\n"
				+ "	acct.name customer_name,\n"
				+ "	sales_item.product_id prod_id,\n"
				+ "	product.name prod_name,\n"
				+ "	qty,\n"
				+ "	amt_after_disc / qty effective_sales_rate,\n"
				+ "	fifo_val(sales_item.`product_id`, voucher.date) cost_price,\n"
				+ "	amt_after_disc - fifo_val(sales_item.`product_id`, voucher.date) * qty profit_amt,\n"
				+ "	(amt_after_disc - fifo_val(sales_item.`product_id`, voucher.date) * qty) /\n"
				+ "	(amt_after_disc) * 100 profit_percent\n"
				+ "FROM \n"
				+ "	sales_item\n"
				+ "LEFT JOIN\n"
				+ "	sales\n"
				+ "ON\n"
				+ "	sales.id = sales_item.sales_id\n"
				+ "LEFT JOIN\n"
				+ "	voucher\n"
				+ "ON\n"
				+ "	voucher.id = sales.id\n"
				+ "LEFT JOIN\n"
				+ "	acct\n"
				+ "ON\n"
				+ "	acct.id = sales.customer_id\n"
				+ "LEFT JOIN	\n"
				+ "	product\n"
				+ "ON\n"
				+ "	product.id = sales_item.product_id\n";

		List<String> wheres = new ArrayList<>();

		if (dateFrom != null)
		{
			wheres.add("date(voucher.date)>=date('" + Util.dateToString(dateFrom, Util.Formats.DB_DATE) + "')");
		}
		if (dateTo != null)
		{
			wheres.add("date(voucher.date)<=date('" + Util.dateToString(dateTo, Util.Formats.DB_DATE) + "')");
		}
		if (customerId != null)
		{
			wheres.add(String.format("sales.customer_id = %s", customerId));
		}
		if (prodId != null)
		{
			wheres.add(String.format("sales_item.product_id = %s", prodId));
		}
		if (no != null)
		{
			wheres.add(String.format("voucher.no = %s", no));
		}
		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " ORDER BY voucher.date, voucher.id, product.name";

		return session.createNativeQuery(sql, RptSalesProfitBySalesItemHdto.class).getResultList();
	}
	//

}
