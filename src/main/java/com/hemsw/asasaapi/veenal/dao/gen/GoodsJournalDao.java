package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dao.app.YearDao;
import com.hemsw.asasaapi.veenal.dto.hdto.CurrentStockHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.ProductMonthlySummaryHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptIoDetHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptIoSummByMonthHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptIoSummByProdCatHdto;
import com.hemsw.asasaapi.veenal.dto.hdto.RptIoSummByProdHdto;
import com.hemsw.asasaapi.veenal.enums.SortOrderEnum;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.app.YearModel;
import com.hemsw.asasaapi.veenal.model.gen.GoodsJournalModel;
import com.hemsw.asasaapi.veenal.model.gen.InvAdjustInModel;
import com.hemsw.asasaapi.veenal.model.gen.InvAdjustOutModel;
import com.hemsw.asasaapi.veenal.model.gen.OpeningStockModel;
import com.hemsw.asasaapi.veenal.model.gen.ProductModel;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseItemModel;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseReturnItemModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesItemModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesReturnItemModel;
import com.hemsw.asasaapi.veenal.service.enums.RptIoDetSortByEnum;
import com.hemsw.asasaapi.veenal.service.enums.RptIoSummByMonthSortByEnum;
import com.hemsw.asasaapi.veenal.service.enums.RptIoSummByProdCatSortByEnum;
import com.hemsw.asasaapi.veenal.service.enums.RptIoSummByProdSortByEnum;
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
public class GoodsJournalDao
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	@Autowired
	private YearDao yearDao;

	public static final String tableName = "goods_journal";
	String selectSql = "SELECT\n"
			+ "	id,\n"
			+ "	date,\n"
			+ "	product_id,\n"
			+ "	tx_type,\n"
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
			+ "	rate,\n"
			+ "	amt,\n"
			+ "	voucher_id,\n"
			+ "	voucher_item_id\n"
			+ "FROM\n"
			+ "	%s";
	String sqlGetOSById = "SELECT * FROM %s WHERE voucher_id IS NULL AND voucher_item_id = %s;";
	String sqlGetByAllIds = "SELECT * FROM %s WHERE voucher_id = %s AND voucher_item_id = %s;";

	/*
	String DaoHelper.SELECT_SQLPrevTotal = "SELECT \n"
			+ "	0 as id,\n"
			+ "	NULL as date,\n"
			+ "	product_id, \n"
			+ "	0 as tx_type,\n"
			+ "	ifnull(SUM(tx_type * qty_28), 0) as qty_28,\n"
			+ "	ifnull(SUM(tx_type * qty_30), 0) as qty_30,\n"
			+ "	ifnull(SUM(tx_type * qty_32), 0) as qty_32,\n"
			+ "	ifnull(SUM(tx_type * qty_34), 0) as qty_34,\n"
			+ "	ifnull(SUM(tx_type * qty_36), 0) as qty_36,\n"
			+ "	ifnull(SUM(tx_type * qty_38), 0) as qty_38,\n"
			+ "	ifnull(SUM(tx_type * qty_40), 0) as qty_40,\n"
			+ "	ifnull(SUM(tx_type * qty_42), 0) as qty_42,\n"
			+ "	ifnull(SUM(tx_type * qty_44), 0) as qty_44,\n"
			+ "	ifnull(SUM(tx_type * qty_46), 0) as qty_46,\n"
			+ "	ifnull(SUM(tx_type * qty), 0) as qty,\n"
			+ "	0 as rate,\n"
			+ "	0 as amt,\n"
			+ "	9 as voucher_type_id,\n"
			+ "	0 as voucher_id,\n"
			+ "	0 as voucher_item_id\n"
			+ "FROM \n"
			+ "	goods_journal ";
	String sqlGroupByPrevTotal = "GROUP BY \n"
			+ "	product_id;";
	 */
	public void create(OpeningStockModel openingStockModel)
	{
		GoodsJournalModel goodsJournalModel = new GoodsJournalModel();
		setInJournal(openingStockModel, goodsJournalModel);
		session.persist(goodsJournalModel);
	}

	public void create(Date date, PurchaseItemModel purchaseItemModel)
	{
		GoodsJournalModel goodsJournalModel = new GoodsJournalModel();
		setInJournal(date, purchaseItemModel, goodsJournalModel);
		session.persist(goodsJournalModel);
	}

	public void create(Date date, PurchaseReturnItemModel purchasereturnItemModel)
	{
		if (purchasereturnItemModel.isIsSetInStock())
		{
			GoodsJournalModel goodsJournalModel = new GoodsJournalModel();
			setInJournal(date, purchasereturnItemModel, goodsJournalModel);
			session.persist(goodsJournalModel);
		}
	}

	public void create(Date date, SalesItemModel salesItemModel)
	{
		GoodsJournalModel goodsJournalModel = new GoodsJournalModel();
		setInJournal(date, salesItemModel, goodsJournalModel);
		session.persist(goodsJournalModel);
	}

	public void create(Date date, SalesReturnItemModel salesreturnItemModel)
	{
		if (salesreturnItemModel.isIsSetInStock())
		{
			GoodsJournalModel goodsJournalModel = new GoodsJournalModel();
			setInJournal(date, salesreturnItemModel, goodsJournalModel);
			session.persist(goodsJournalModel);
		}
	}

	public void create(Date date, InvAdjustInModel invAdjustInModel)
	{
		GoodsJournalModel goodsJournalModel = new GoodsJournalModel();
		setInJournal(date, invAdjustInModel, goodsJournalModel);
		session.persist(goodsJournalModel);
	}

	public void create(Date date, InvAdjustOutModel invAdjustOutModel)
	{
		GoodsJournalModel goodsJournalModel = new GoodsJournalModel();
		setInJournal(date, invAdjustOutModel, goodsJournalModel);
		session.persist(goodsJournalModel);
	}

	public void update(OpeningStockModel openingstockModel)
	{
		GoodsJournalModel goodsjournalModel = getOSById(openingstockModel.getId());
		setInJournal(openingstockModel, goodsjournalModel);

	}

	public void update(Date date, PurchaseItemModel purchaseItemModel)
	{
		GoodsJournalModel goodsjournalModel = getByAllIds(purchaseItemModel.getPurchaseId(), purchaseItemModel.getId());
		setInJournal(date, purchaseItemModel, goodsjournalModel);

	}

	public void update(Date date, PurchaseReturnItemModel purchasereturnItemModel)
	{
		GoodsJournalModel goodsjournalModel = getByAllIds(purchasereturnItemModel.getPurchaseReturnId(), purchasereturnItemModel.getId());
		if (purchasereturnItemModel.isIsSetInStock())
		{
			if (goodsjournalModel == null)
			{
				create(date, purchasereturnItemModel);
			}
			else
			{
				setInJournal(date, purchasereturnItemModel, goodsjournalModel);

			}
		}
		else
		{
			if (goodsjournalModel != null)
			{
				session.remove(goodsjournalModel.getId());
			}
		}

	}

	public void update(Date date, SalesItemModel salesItemModel)
	{
		GoodsJournalModel goodsjournalModel = getByAllIds(salesItemModel.getSalesId(), salesItemModel.getId());
		setInJournal(date, salesItemModel, goodsjournalModel);

	}

	public void update(Date date, SalesReturnItemModel salesreturnItemModel)
	{
		GoodsJournalModel goodsjournalModel = getByAllIds(salesreturnItemModel.getSalesReturnId(), salesreturnItemModel.getId());
		if (salesreturnItemModel.isIsSetInStock())
		{
			if (goodsjournalModel == null)
			{
				create(date, salesreturnItemModel);
			}
			else
			{
				setInJournal(date, salesreturnItemModel, goodsjournalModel);

			}
		}
		else
		{
			if (goodsjournalModel != null)
			{
				session.remove(goodsjournalModel.getId());
			}
		}
	}

	public void update(Date date, InvAdjustInModel invAdjustInModel)
	{
		GoodsJournalModel goodsjournalModel = getByAllIds(invAdjustInModel.getInvAdjustId(), invAdjustInModel.getId());
		setInJournal(date, invAdjustInModel, goodsjournalModel);

	}

	public void update(Date date, InvAdjustOutModel invAdjustOutModel)
	{
		GoodsJournalModel goodsjournalModel = getByAllIds(invAdjustOutModel.getInvAdjustId(), invAdjustOutModel.getId());
		setInJournal(date, invAdjustOutModel, goodsjournalModel);

	}

	public void deleteByVoucherItemId(int voucherId, int voucherItemId)
	{
		List<String> wheres = new ArrayList<>();

		wheres.add(tableName + ".voucher_id = " + voucherId + "");
		wheres.add(tableName + ".voucher_item_id = " + voucherItemId + "");

		String sql = String.format("DELETE FROM %s", tableName);
		sql = SqlHelper.putWheres(wheres, sql);

		session.createNativeQuery(sql).executeUpdate();
	}

	private void deleteAllVoucherItemIds(int voucherId, List<Integer> idsToBeDeleted)
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

	public void deleteOSVoucherItemId(int idToBeDeleted)
	{
		List<String> wheres = new ArrayList<>();

		wheres.add(tableName + ".voucher_id IS NULL");
		wheres.add(tableName + ".voucher_item_id = " + idToBeDeleted + "");

		String sql = String.format("DELETE FROM %s", tableName);
		sql = SqlHelper.putWheres(wheres, sql);

		session.createNativeQuery(sql).executeUpdate();
	}

	public void deleteAllOSVoucherItemIds(List<Integer> idsToBeDeleted)
	{
		if (idsToBeDeleted != null && !idsToBeDeleted.isEmpty())
		{
			List<String> wheres = new ArrayList<>();

			wheres.add(tableName + ".voucher_id IS NULL");
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

	/*
	This tx type argument is speciall for inventory adjust
	Because there in one voucher, additing is also there
	And subtraction is also there
	So each different Dao will be calling this function different times
	Which will delete previously set values for same voucher id
	 */
	public void deleteAllByVoucherId(int voucherId, Integer txType)
	{
		String sql = String.format("DELETE FROM %s", tableName);

		List<String> wheres = new ArrayList<>();
		wheres.add(String.format("voucher_id = %s", voucherId));

		if (txType != null && (txType == -1 || txType == 1))
		{
			wheres.add(String.format("tx_type = %s", txType));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		session.createNativeQuery(sql).executeUpdate();
	}

	private void setInJournal(OpeningStockModel openingStockModel, GoodsJournalModel goodsJournalModel)
	{
		goodsJournalModel.setDate(Util.stringToDate("1000-01-01", Util.Formats.DB_DATE));
		goodsJournalModel.setProductId(openingStockModel.getProductId());
		goodsJournalModel.setTxType(1);

		goodsJournalModel.setQty28(openingStockModel.getQty28());
		goodsJournalModel.setQty30(openingStockModel.getQty30());
		goodsJournalModel.setQty32(openingStockModel.getQty32());
		goodsJournalModel.setQty34(openingStockModel.getQty34());
		goodsJournalModel.setQty36(openingStockModel.getQty36());
		goodsJournalModel.setQty38(openingStockModel.getQty38());
		goodsJournalModel.setQty40(openingStockModel.getQty40());
		goodsJournalModel.setQty42(openingStockModel.getQty42());
		goodsJournalModel.setQty44(openingStockModel.getQty44());
		goodsJournalModel.setQty46(openingStockModel.getQty46());

		goodsJournalModel.setQty(openingStockModel.getQuantity());
		goodsJournalModel.setRate(openingStockModel.getRate());
		goodsJournalModel.setAmt(openingStockModel.getAmount());
		goodsJournalModel.setVoucherItemId(openingStockModel.getId());
	}

	private void setInJournal(Date date, PurchaseItemModel purchaseItemModel, GoodsJournalModel goodsJournalModel)
	{
		goodsJournalModel.setDate(date);
		goodsJournalModel.setProductId(purchaseItemModel.getProductId());
		goodsJournalModel.setTxType(1);

		goodsJournalModel.setQty28(purchaseItemModel.getQty28());
		goodsJournalModel.setQty30(purchaseItemModel.getQty30());
		goodsJournalModel.setQty32(purchaseItemModel.getQty32());
		goodsJournalModel.setQty34(purchaseItemModel.getQty34());
		goodsJournalModel.setQty36(purchaseItemModel.getQty36());
		goodsJournalModel.setQty38(purchaseItemModel.getQty38());
		goodsJournalModel.setQty40(purchaseItemModel.getQty40());
		goodsJournalModel.setQty42(purchaseItemModel.getQty42());
		goodsJournalModel.setQty44(purchaseItemModel.getQty44());
		goodsJournalModel.setQty46(purchaseItemModel.getQty46());

		goodsJournalModel.setQty(purchaseItemModel.getQty());
		goodsJournalModel.setRate(purchaseItemModel.getRate());
		goodsJournalModel.setAmt(purchaseItemModel.getAmt());
		goodsJournalModel.setVoucherId(purchaseItemModel.getPurchaseId());
		goodsJournalModel.setVoucherItemId(purchaseItemModel.getId());
	}

	private void setInJournal(Date date, PurchaseReturnItemModel purchaseReturnItemModel, GoodsJournalModel goodsJournalModel)
	{
		goodsJournalModel.setDate(date);
		goodsJournalModel.setProductId(purchaseReturnItemModel.getProductId());
		goodsJournalModel.setTxType(-1);

		goodsJournalModel.setQty(purchaseReturnItemModel.getQty());
		goodsJournalModel.setRate(purchaseReturnItemModel.getRate());
		goodsJournalModel.setAmt(purchaseReturnItemModel.getAmt());
		goodsJournalModel.setVoucherId(purchaseReturnItemModel.getPurchaseReturnId());
		goodsJournalModel.setVoucherItemId(purchaseReturnItemModel.getId());
	}

	private void setInJournal(Date date, SalesItemModel salesItemModel, GoodsJournalModel goodsJournalModel)
	{
		goodsJournalModel.setDate(date);
		goodsJournalModel.setProductId(salesItemModel.getProductId());
		goodsJournalModel.setTxType(-1);

		goodsJournalModel.setQty(salesItemModel.getQty());
		goodsJournalModel.setRate(salesItemModel.getRate());
		goodsJournalModel.setAmt(salesItemModel.getAmt());
		goodsJournalModel.setVoucherId(salesItemModel.getSalesId());
		goodsJournalModel.setVoucherItemId(salesItemModel.getId());
	}

	private void setInJournal(Date date, SalesReturnItemModel salesReturnItemModel, GoodsJournalModel goodsJournalModel)
	{
		goodsJournalModel.setDate(date);
		goodsJournalModel.setProductId(salesReturnItemModel.getProductId());
		goodsJournalModel.setTxType(1);

		goodsJournalModel.setQty(salesReturnItemModel.getQty());
		goodsJournalModel.setRate(salesReturnItemModel.getRate());
		goodsJournalModel.setAmt(salesReturnItemModel.getAmt());
		goodsJournalModel.setVoucherId(salesReturnItemModel.getSalesReturnId());
		goodsJournalModel.setVoucherItemId(salesReturnItemModel.getId());
	}

	private void setInJournal(Date date, InvAdjustInModel invAdjustInModel, GoodsJournalModel goodsJournalModel)
	{
		goodsJournalModel.setDate(date);
		goodsJournalModel.setProductId(invAdjustInModel.getProductId());
		goodsJournalModel.setTxType(1);

		goodsJournalModel.setQty(invAdjustInModel.getQty());
		goodsJournalModel.setRate(invAdjustInModel.getRate());
		goodsJournalModel.setAmt(invAdjustInModel.getAmt());
		goodsJournalModel.setVoucherId(invAdjustInModel.getInvAdjustId());
		goodsJournalModel.setVoucherItemId(invAdjustInModel.getId());
	}

	private void setInJournal(Date date, InvAdjustOutModel invAdjustOutModel, GoodsJournalModel goodsJournalModel)
	{
		goodsJournalModel.setDate(date);
		goodsJournalModel.setProductId(invAdjustOutModel.getProductId());
		goodsJournalModel.setTxType(-1);

		goodsJournalModel.setQty(invAdjustOutModel.getQty());
		goodsJournalModel.setRate(invAdjustOutModel.getRate());
		goodsJournalModel.setAmt(invAdjustOutModel.getAmt());
		goodsJournalModel.setVoucherId(invAdjustOutModel.getInvAdjustId());
		goodsJournalModel.setVoucherItemId(invAdjustOutModel.getId());
	}

	private GoodsJournalModel getOSById(int voucherItemId)
	{
		String sql = String.format("SELECT * FROM %s WHERE voucher_id is null AND voucher_item_id = %s;",
				tableName,
				String.valueOf(voucherItemId));

		List<GoodsJournalModel> goodsJournalModels = session.createNativeQuery(sql, GoodsJournalModel.class).getResultList();
		if (goodsJournalModels == null || goodsJournalModels.isEmpty())
		{
			return null;
		}
		return goodsJournalModels.get(0);

	}

	public GoodsJournalModel getByAllIds(int voucherId, int voucherItemId)
	{
		String sql = String.format(sqlGetByAllIds,
				tableName,
				String.valueOf(voucherId),
				String.valueOf(voucherItemId));

		List<GoodsJournalModel> goodsJournalModels = session.createNativeQuery(sql, GoodsJournalModel.class).getResultList();
		if (goodsJournalModels == null || goodsJournalModels.isEmpty())
		{
			return null;
		}
		return goodsJournalModels.get(0);

	}

	public List<CurrentStockHdto> getOpeningStock(Integer productId, Date asOnDate)
	{
		return getTotalStock(productId, asOnDate, TotalStockType.OPENING);
	}

	public List<CurrentStockHdto> getClosingStock(Integer productId, Date asOnDate)
	{
		return getTotalStock(productId, asOnDate, TotalStockType.CLOSING);
	}

	private enum TotalStockType
	{
		OPENING,
		CLOSING
	}

	private List<CurrentStockHdto> getTotalStock(Integer productId, Date asOnDate, TotalStockType stockType)
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
		if (productId != null)
		{
			sql = sql + "WHERE\n"
					+ "	product.id = " + productId + " ";
		}

		sql = sql + "ORDER BY \n"
				+ "	product.name";

		return session.createNativeQuery(sql, CurrentStockHdto.class).getResultList();

	}

	private CurrentStockHdto getSumTill(ProductModel productModel, Date date)
	{
		String sqlCurrentStockPart1 = "SELECT \n"
				+ "	product.id,\n"
				+ "	product.name as name,\n"
				+ "	unit.name as unit,\n"
				+ "	product.hsn,\n"
				+ "	SUM(tx_type * qty_28) as qty_28,\n"
				+ "	SUM(tx_type * qty_30) as qty_30,\n"
				+ "	SUM(tx_type * qty_32) as qty_32,\n"
				+ "	SUM(tx_type * qty_34) as qty_34,\n"
				+ "	SUM(tx_type * qty_36) as qty_36,\n"
				+ "	SUM(tx_type * qty_38) as qty_38,\n"
				+ "	SUM(tx_type * qty_40) as qty_40,\n"
				+ "	SUM(tx_type * qty_42) as qty_42,\n"
				+ "	SUM(tx_type * qty_44) as qty_44,\n"
				+ "	SUM(tx_type * qty_46) as qty_46,\n"
				+ "	SUM(tx_type * qty) as qty,\n"
				+ "	SUM(tx_type * amt) as amt\n"
				+ "FROM\n"
				+ "	(\n"
				+ "		SELECT \n"
				+ "			* \n"
				+ "		FROM \n"
				+ "			goods_journal ";

		String sql = sqlCurrentStockPart1;

		List<String> wheres = new ArrayList<>();
		if (productModel != null)
		{
			wheres.add(String.format("product_id = %s", productModel.getId()));
		}
		if (date != null)
		{
			wheres.add(String.format("date(date) <= date('%s')", Util.dateToString(date, Util.Formats.DB_DATE)));
		}
		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " ORDER BY \n"
				+ "			date(date) ";

		sql = sql + "	) as t1\n"
				+ "LEFT JOIN\n"
				+ "	product\n"
				+ "ON\n"
				+ "	product.id = t1.product_id\n"
				+ "LEFT JOIN\n"
				+ "	unit\n"
				+ "ON\n"
				+ "	unit.id = product.unit_id\n"
				+ "GROUP BY\n"
				+ "	product_id";

		List<CurrentStockHdto> stockModels = session.createNativeQuery(sql, CurrentStockHdto.class).getResultList();
		if (stockModels == null || stockModels.isEmpty())
		{
			return null;
		}
		return stockModels.get(0);
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

	public List<GoodsJournalModel> getLedger(ProductModel productModel, Date dateFrom, Date dateTo)
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

		return session.createNativeQuery(sql, GoodsJournalModel.class).getResultList();

	}

	public List<ProductMonthlySummaryHdto> getProductMonthlySummary(Date dateFrom, Date dateTo, int productId)
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

		if (dateFrom == null)
		{
			dateFrom = yearModel.getDateFrom();
		}

		if (dateTo == null)
		{
			dateTo = yearModel.getDateTo();
		}

		map.put("product_id", String.valueOf(productId));
		map.put("date_from", Util.dateToString(dateFrom, Util.Formats.DB_DATE));
		map.put("date_to", Util.dateToString(dateTo, Util.Formats.DB_DATE));
		map.put("table_goods_journal", TableName.GOODS_JOURNAL);

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, ProductMonthlySummaryHdto.class).getResultList();
	}

	public List<RptIoSummByProdCatHdto> getRptIoSummByProdCatHdtos(
			Date dateFrom,
			Date dateTo,
			Integer parentProdCatId,
			Integer acctId,
			RptIoSummByProdCatSortByEnum rptIoSummByProdCatSortByEnum,
			SortOrderEnum sortOrderEnum
	)
	{
		String sql = "WITH RECURSIVE cte_cat (root_id, parent_id, child_id) AS (\n"
				+ "\n"
				+ "	SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		product_category l1_pc\n"
				+ "	WHERE\n";

		if (parentProdCatId == null)
		{
			sql = sql + "parent_id is null\n";
		}
		else
		{
			sql = sql + String.format("parent_id = %s\n", parentProdCatId);
		}

		sql = sql + "UNION ALL\n"
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
				+ "		l2_pc.parent_id = cte_cat.child_id\n"
				+ "\n"
				+ ")\n"
				+ "SELECT\n"
				+ "	cte_cat.root_id prod_cat_id,\n"
				+ "	product_category.name prod_cat_name,\n"
				+ "	IFNULL(SUM(qty_in),0) qty_in,\n"
				+ "	IFNULL(SUM(qty_out),0) qty_out\n"
				+ "FROM\n"
				+ "(\n"
				+ "	SELECT\n"
				+ "		goods_journal.date,\n"
				+ "		product_id,\n"
				+ "		voucher_id,\n"
				+ "		qty qty_in,\n"
				+ "		NULL qty_out\n"
				+ "	FROM\n"
				+ "		goods_journal\n"
				+ "	WHERE\n"
				+ "		tx_type = 1\n"
				+ "\n"
				+ "	UNION ALL	\n"
				+ "		\n"
				+ "	SELECT\n"
				+ "		goods_journal.date,\n"
				+ "		product_id,\n"
				+ "		voucher_id,\n"
				+ "		NULL qty_in,\n"
				+ "		qty qty_out\n"
				+ "	FROM\n"
				+ "		goods_journal\n"
				+ "	WHERE\n"
				+ "		tx_type = -1\n"
				+ ") t1	\n"
				+ "LEFT JOIN\n"
				+ "	voucher\n"
				+ "ON	\n"
				+ "	voucher.id = t1.voucher_id\n"
				+ "LEFT JOIN\n"
				+ "	product\n"
				+ "ON\n"
				+ "	product.id = t1.product_id\n"
				+ "JOIN\n"
				+ "	cte_cat\n"
				+ "ON		\n"
				+ "	cte_cat.child_id = product.category_id\n"
				+ "LEFT JOIN\n"
				+ "	product_category\n"
				+ "ON\n"
				+ "	product_category.id = cte_cat.root_id\n";

		List<String> wheres = new ArrayList<>();
		if (acctId != null)
		{
			wheres.add(String.format("(\n"
					+ "		CASE\n"
					+ "			WHEN voucher.voucher_type_id = 1 THEN (SELECT supplier_id FROM purchase WHERE purchase.id = voucher_id)\n"
					+ "			WHEN voucher.voucher_type_id = 2 THEN (SELECT customer_id FROM sales WHERE sales.id = voucher_id)\n"
					+ "			WHEN voucher.voucher_type_id = 3 THEN (SELECT supplier_id FROM purchase_return WHERE purchase_return.id = voucher_id)\n"
					+ "			WHEN voucher.voucher_type_id = 4 THEN (SELECT customer_id FROM sales_return WHERE sales_return.id = voucher_id)\n"
					+ "		END\n"
					+ "	) = %s", acctId));
		}

		if (dateFrom != null)
		{
			wheres.add(String.format("t1.date>='%s'", Util.dateToString(dateFrom, Util.Formats.DB_DATE)));
		}
		if (dateTo != null)
		{
			wheres.add(String.format("t1.date<='%s'", Util.dateToString(dateTo, Util.Formats.DB_DATE)));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<String> groupBys = new ArrayList<>();
		groupBys.add("cte_cat.root_id");
		sql = SqlHelper.putGroupBys(groupBys, sql);

		List<String> orderBys = new ArrayList<>();
		if (rptIoSummByProdCatSortByEnum != null)
		{
			orderBys.add(String.format("%s %s", rptIoSummByProdCatSortByEnum.getKey(), sortOrderEnum.getSqlName()));
		}
		else
		{
			orderBys.add(String.format("%s %s", rptIoSummByProdCatSortByEnum.NAME.getKey(), sortOrderEnum.ASC.getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		YearModel yearModel = yearDao.getById(1);

		if (dateFrom == null)
		{
			dateFrom = yearModel.getDateFrom();
		}

		if (dateTo == null)
		{
			dateTo = yearModel.getDateTo();
		}

		Map<String, String> map = new HashMap<>();

		map.put("date_from", Util.dateToString(dateFrom, Util.Formats.DB_DATE));
		map.put("date_to", Util.dateToString(dateTo, Util.Formats.DB_DATE));

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, RptIoSummByProdCatHdto.class).getResultList();
	}

	public List<RptIoSummByProdHdto> getRptIoSummByProdHdtos(
			Date dateFrom,
			Date dateTo,
			Integer prodCatId,
			Integer acctId,
			RptIoSummByProdSortByEnum rptIoSummByProdSortByEnum,
			SortOrderEnum sortOrderEnum
	)
	{
		String sql = "SELECT\n"
				+ "	product.id prod_id,\n"
				+ "	product.name prod_name,\n"
				+ "	IFNULL(SUM(qty_in),0) qty_in,\n"
				+ "	IFNULL(SUM(qty_out),0) qty_out\n"
				+ "FROM\n"
				+ "(\n"
				+ "	SELECT\n"
				+ "		goods_journal.date,\n"
				+ "		product_id,\n"
				+ "		voucher_id,\n"
				+ "		qty qty_in,\n"
				+ "		NULL qty_out\n"
				+ "	FROM\n"
				+ "		goods_journal\n"
				+ "	WHERE\n"
				+ "		tx_type = 1\n"
				+ "\n"
				+ "	UNION ALL	\n"
				+ "		\n"
				+ "	SELECT\n"
				+ "		goods_journal.date,\n"
				+ "		product_id,\n"
				+ "		voucher_id,\n"
				+ "		NULL qty_in,\n"
				+ "		qty qty_out\n"
				+ "	FROM\n"
				+ "		goods_journal\n"
				+ "	WHERE\n"
				+ "		tx_type = -1\n"
				+ ") t1	\n"
				+ "LEFT JOIN\n"
				+ "	voucher\n"
				+ "ON	\n"
				+ "	voucher.id = t1.voucher_id\n"
				+ "LEFT JOIN\n"
				+ "	product\n"
				+ "ON\n"
				+ "	product.id = t1.product_id\n"
				+ "LEFT JOIN\n"
				+ "	product_category\n"
				+ "ON\n"
				+ "	product_category.id = product.category_id\n";

		List<String> wheres = new ArrayList<>();

		if (dateFrom != null)
		{
			wheres.add(String.format("t1.date>='%s'", Util.dateToString(dateFrom, Util.Formats.DB_DATE)));
		}
		if (dateTo != null)
		{
			wheres.add(String.format("t1.date<='%s'", Util.dateToString(dateTo, Util.Formats.DB_DATE)));
		}

		if (acctId != null)
		{
			wheres.add(String.format("(\n"
					+ "		CASE\n"
					+ "			WHEN voucher.voucher_type_id = 1 THEN (SELECT supplier_id FROM purchase WHERE purchase.id = voucher_id)\n"
					+ "			WHEN voucher.voucher_type_id = 2 THEN (SELECT customer_id FROM sales WHERE sales.id = voucher_id)\n"
					+ "			WHEN voucher.voucher_type_id = 3 THEN (SELECT supplier_id FROM purchase_return WHERE purchase_return.id = voucher_id)\n"
					+ "			WHEN voucher.voucher_type_id = 4 THEN (SELECT customer_id FROM sales_return WHERE sales_return.id = voucher_id)\n"
					+ "		END\n"
					+ "	) = %s", acctId));
		}

		if (prodCatId != null)
		{
			if (prodCatId == -1)
			{
				wheres.add("product.category_id IS NULL");
			}
			else
			{
				wheres.add(String.format("product.category_id = %s", prodCatId));
			}
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<String> groupBys = new ArrayList<>();
		groupBys.add("product.id");
		sql = SqlHelper.putGroupBys(groupBys, sql);

		List<String> orderBys = new ArrayList<>();
		if (rptIoSummByProdSortByEnum != null)
		{
			orderBys.add(String.format("%s %s", rptIoSummByProdSortByEnum.getKey(), sortOrderEnum.getSqlName()));
		}
		else
		{
			orderBys.add(String.format("%s %s", rptIoSummByProdSortByEnum.NAME.getKey(), sortOrderEnum.ASC.getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		YearModel yearModel = yearDao.getById(1);

		if (dateFrom == null)
		{
			dateFrom = yearModel.getDateFrom();
		}

		if (dateTo == null)
		{
			dateTo = yearModel.getDateTo();
		}

		Map<String, String> map = new HashMap<>();

		map.put("date_from", Util.dateToString(dateFrom, Util.Formats.DB_DATE));
		map.put("date_to", Util.dateToString(dateTo, Util.Formats.DB_DATE));

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, RptIoSummByProdHdto.class).getResultList();
	}

	public List<RptIoSummByMonthHdto> getRptIoSummByMonthHdtos(
			Date dateFrom,
			Date dateTo,
			Integer prodCatId,
			Boolean recursiveProdCat,
			Integer prodId,
			Integer acctId,
			RptIoSummByMonthSortByEnum rptIoSummByMonthSortByEnum,
			SortOrderEnum sortOrderEnum
	)
	{
		String sql = "WITH RECURSIVE cte_dt (dt) AS (\n"
				+ "    SELECT DATE_ADD(DATE_ADD(LAST_DAY('{date_from}'),INTERVAL 1 DAY), INTERVAL -1 MONTH)\n"
				+ "    UNION\n"
				+ "    SELECT DATE_ADD(dt, INTERVAL 1 MONTH) FROM cte_dt \n"
				+ "    WHERE \n"
				+ "	dt < DATE_ADD(DATE_ADD(LAST_DAY('{date_to}'),INTERVAL 1 DAY), INTERVAL -1 MONTH)\n"
				+ "),\n"
				+ "cte_cat (root_id, parent_id, child_id) AS (\n"
				+ "\n"
				+ "	SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		product_category l1_pc\n"
				+ "	WHERE\n";

		if (recursiveProdCat != null && recursiveProdCat)
		{
			if (prodCatId == -1)
			{
				sql = sql + "parent_id is null\n";
			}
			else
			{
				sql = sql + String.format("parent_id = %s\n", prodCatId);
			}
		}
		else
		{
			sql = sql + "parent_id is null\n";
		}

		if (prodCatId != null && recursiveProdCat != null && recursiveProdCat)
		{
		}

		sql = sql + "UNION ALL\n"
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
				+ "		l2_pc.parent_id = cte_cat.child_id\n"
				+ "\n"
				+ ")\n"
				+ "SELECT\n"
				+ "	YEAR(cte_dt.dt)*1000 + MONTH(cte_dt.dt) yr_month,\n"
				+ "	MONTH(cte_dt.dt) month,\n"
				+ "	YEAR(cte_dt.dt) yr,\n"
				+ "	IFNULL(SUM(qty_in),0) qty_in,\n"
				+ "	IFNULL(SUM(qty_out),0) qty_out\n"
				+ "FROM\n"
				+ "(\n"
				+ "	SELECT\n"
				+ "		goods_journal.date,\n"
				+ "		product_id,\n"
				+ "		voucher_id,\n"
				+ "		qty qty_in,\n"
				+ "		NULL qty_out\n"
				+ "	FROM\n"
				+ "		goods_journal\n"
				+ "	WHERE\n"
				+ "		tx_type = 1\n"
				+ "\n"
				+ "	UNION ALL	\n"
				+ "		\n"
				+ "	SELECT\n"
				+ "		goods_journal.date,\n"
				+ "		product_id,\n"
				+ "		voucher_id,\n"
				+ "		NULL qty_in,\n"
				+ "		qty qty_out\n"
				+ "	FROM\n"
				+ "		goods_journal\n"
				+ "	WHERE\n"
				+ "		tx_type = -1\n"
				+ ") t1	\n"
				+ "LEFT JOIN\n"
				+ "	voucher\n"
				+ "ON	\n"
				+ "	voucher.id = t1.voucher_id\n"
				+ "LEFT JOIN\n"
				+ "	product\n"
				+ "ON\n"
				+ "	product.id = t1.product_id\n"
				+ "LEFT JOIN\n"
				+ "	cte_cat\n"
				+ "ON		\n"
				+ "	cte_cat.child_id = product.category_id\n"
				+ "LEFT JOIN\n"
				+ "	product_category\n"
				+ "ON\n"
				+ "	product_category.id = cte_cat.root_id\n"
				+ "LEFT JOIN\n"
				+ "	cte_dt\n"
				+ "ON\n"
				+ "	MONTH(cte_dt.dt) = MONTH(t1.date)\n"
				+ "AND\n"
				+ "	YEAR(cte_dt.dt) = YEAR(t1.date)\n";

		List<String> wheres = new ArrayList<>();

		wheres.add("cte_dt.dt IS NOT NULL");

		if (recursiveProdCat == null || !recursiveProdCat)
		{
			if (prodCatId != null)
			{
				wheres.add(String.format("product.category_id = %s", prodCatId));
			}
		}

		if (prodId != null)
		{
			wheres.add(String.format("product.id = %s", prodId));
		}

		if (acctId != null)
		{
			wheres.add(String.format("(\n"
					+ "		CASE\n"
					+ "			WHEN voucher.voucher_type_id = 1 THEN (SELECT supplier_id FROM purchase WHERE purchase.id = voucher_id)\n"
					+ "			WHEN voucher.voucher_type_id = 2 THEN (SELECT customer_id FROM sales WHERE sales.id = voucher_id)\n"
					+ "			WHEN voucher.voucher_type_id = 3 THEN (SELECT supplier_id FROM purchase_return WHERE purchase_return.id = voucher_id)\n"
					+ "			WHEN voucher.voucher_type_id = 4 THEN (SELECT customer_id FROM sales_return WHERE sales_return.id = voucher_id)\n"
					+ "		END \n"
					+ "	) = %s", acctId));
		}

		if (dateFrom != null)
		{
			wheres.add(String.format("t1.date>='%s'", Util.dateToString(dateFrom, Util.Formats.DB_DATE)));
		}
		if (dateTo != null)
		{
			wheres.add(String.format("t1.date<='%s'", Util.dateToString(dateTo, Util.Formats.DB_DATE)));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<String> groupBys = new ArrayList<>();
		groupBys.add("cte_dt.dt");
		sql = SqlHelper.putGroupBys(groupBys, sql);

		List<String> orderBys = new ArrayList<>();
		if (rptIoSummByMonthSortByEnum != null)
		{
			orderBys.add(String.format("%s %s", rptIoSummByMonthSortByEnum.getKey(), sortOrderEnum.getSqlName()));
		}
		else
		{
			orderBys.add(String.format("%s %s", rptIoSummByMonthSortByEnum.MONTH.getKey(), sortOrderEnum.ASC.getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		YearModel yearModel = yearDao.getById(1);

		if (dateFrom == null)
		{
			dateFrom = yearModel.getDateFrom();
		}

		if (dateTo == null)
		{
			dateTo = yearModel.getDateTo();
		}

		Map<String, String> map = new HashMap<>();

		map.put("date_from", Util.dateToString(dateFrom, Util.Formats.DB_DATE));
		map.put("date_to", Util.dateToString(dateTo, Util.Formats.DB_DATE));

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, RptIoSummByMonthHdto.class).getResultList();
	}

	public List<RptIoDetHdto> getRptIoDetHdtos(
			Date dateFrom,
			Date dateTo,
			Integer prodId,
			Integer acctId,
			RptIoDetSortByEnum rptIoDetSortByEnum,
			SortOrderEnum sortOrderEnum
	)
	{
		String sql = "SELECT\n"
				+ "	goods_journal.voucher_id,\n"
				+ "	goods_journal.date,\n"
				+ "	voucher.voucher_type_id,\n"
				+ "	voucher.no voucher_no,\n"
				+ "	acct.id acct_id,\n"
				+ "	acct.name acct_name,\n"
				+ "	product.id prod_id,\n"
				+ "	product.name prod_name,\n"
				+ "	IF(tx_type = 1, qty, NULL) qty_in,\n"
				+ "	IF(tx_type = -1, qty, NULL) qty_out\n"
				+ "FROM\n"
				+ "	goods_journal\n"
				+ "LEFT JOIN\n"
				+ "	voucher\n"
				+ "ON	\n"
				+ "	voucher.id = goods_journal.voucher_id\n"
				+ "LEFT JOIN\n"
				+ "	product\n"
				+ "ON\n"
				+ "	product.id = goods_journal.product_id\n"
				+ "LEFT JOIN\n"
				+ "	product_category\n"
				+ "ON\n"
				+ "	product_category.id = product.category_id\n"
				+ "LEFT JOIN\n"
				+ "	acct\n"
				+ "ON\n"
				+ "	acct.id = (\n"
				+ "		CASE\n"
				+ "			WHEN voucher.voucher_type_id = 1 THEN (SELECT supplier_id FROM purchase WHERE purchase.id = voucher_id)\n"
				+ "			WHEN voucher.voucher_type_id = 2 THEN (SELECT customer_id FROM sales WHERE sales.id = voucher_id)\n"
				+ "			WHEN voucher.voucher_type_id = 3 THEN (SELECT supplier_id FROM purchase_return WHERE purchase_return.id = voucher_id)\n"
				+ "			WHEN voucher.voucher_type_id = 4 THEN (SELECT customer_id FROM sales_return WHERE sales_return.id = voucher_id)\n"
				+ "		END\n"
				+ "	)\n";

		List<String> wheres = new ArrayList<>();
		if (acctId != null)
		{
			wheres.add(String.format("acct.id = %s", acctId));
		}
		if (prodId != null)
		{
			wheres.add(String.format("product.id = %s", prodId));
		}
		if (dateFrom != null)
		{
			wheres.add(String.format("goods_journal.date>='%s'", Util.dateToString(dateFrom, Util.Formats.DB_DATE)));
		}
		if (dateTo != null)
		{
			wheres.add(String.format("goods_journal.date<='%s'", Util.dateToString(dateTo, Util.Formats.DB_DATE)));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<String> orderBys = new ArrayList<>();
		if (rptIoDetSortByEnum != null)
		{
			orderBys.add(String.format("%s %s", rptIoDetSortByEnum.getKey(), sortOrderEnum.getSqlName()));
		}
		else
		{
			orderBys.add(String.format("%s %s", rptIoDetSortByEnum.DATE.getKey(), sortOrderEnum.ASC.getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		YearModel yearModel = yearDao.getById(1);

		if (dateFrom == null)
		{
			dateFrom = yearModel.getDateFrom();
		}

		if (dateTo == null)
		{
			dateTo = yearModel.getDateTo();
		}

		return session.createNativeQuery(sql, RptIoDetHdto.class).getResultList();
	}

	public String getTableName()
	{
		return tableName;
	}

}
