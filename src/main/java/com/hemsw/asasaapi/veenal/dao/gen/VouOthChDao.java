package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.hdto.VouOthChLdto;
import com.hemsw.asasaapi.veenal.enums.ListMenu;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import static com.hemsw.asasaapi.veenal.enums.VoucherType.PI;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.app.ColSettingModel;
import com.hemsw.asasaapi.veenal.model.gen.VouOthChModel;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VouOthChDao
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	public static final String tableName = "oth_charge";
	String sqlGet = "SELECT * FROM %s ORDER BY seq_no";

	public void create(VouOthChModel VouOthChModel)
	{
		session.persist(VouOthChModel);
	}

	public VouOthChModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, getTableName(), String.valueOf(id));
		List<VouOthChModel> dtos = session.createNativeQuery(sql, VouOthChModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public VouOthChModel getByName(String name)
	{
		String sql = String.format(DaoHelper.SELECT_BY_NAME_SQL, getTableName(), SqlHelper.escape(name));
		List<VouOthChModel> dtos = session.createNativeQuery(sql, VouOthChModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public List<VouOthChModel> get()
	{
		String sql = String.format(sqlGet, tableName);
		return session.createNativeQuery(sql, VouOthChModel.class).getResultList();
	}

	public List<VouOthChModel> get(VouOthChModel.CalcOnType calOnType, Boolean isTaxable, VoucherType voucherType, Boolean isSystem)
	{
		String sql = String.format("SELECT * FROM %s", tableName);

		List<String> wheres = new ArrayList<>();

		if (calOnType != null)
		{
			wheres.add(tableName + ".calc_on_type_id = " + calOnType.getId() + "");
		}
		if (isTaxable != null)
		{
			wheres.add(tableName + ".is_taxable = " + (isTaxable ? "1" : "0") + "");
		}
		if (voucherType != null)
		{
			switch (voucherType)
			{
				case SALES:
				case SALES_ORDER:
				case ESTIMATE:
				case PI:
					wheres.add(tableName + ".is_add_auto_s = 1");
					break;
				case SALES_RETURN:
					wheres.add(tableName + ".is_add_auto_sr = 1");
					break;
				case PURCHASE:
					wheres.add(tableName + ".is_add_auto_p = 1");
					break;
				case PURCHASE_RETURN:
					wheres.add(tableName + ".is_add_auto_pr = 1");
					break;
			}
		}
		if (isSystem != null)
		{
			if (isSystem)
			{
				wheres.add(tableName + ".id <= 100");
			}
			else
			{
				wheres.add(tableName + ".id > 100");
			}
		}

		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " ORDER BY seq_no";

		return session.createNativeQuery(sql, VouOthChModel.class).getResultList();
	}

	public List<VouOthChLdto> getLdtos(String name)
	{
		String sql = String.format("SELECT * FROM %s", "vw_vou_oth_charge_list");

		List<String> wheres = new ArrayList<>();

		if (name != null && !name.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "name", SqlHelper.escape(name)));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<ColSettingModel> colSettingModels = colSettingDao.getByMenuIdForOrder(ListMenu.VOU_OTH_CHARGE.getId(), true);

		List<String> orderBys = new ArrayList<>();
		for (ColSettingModel colSettingModel : colSettingModels)
		{
			orderBys.add(String.format("%s %s", colSettingModel.getColKey(), colSettingModel.getOrderByType().getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		return session.createNativeQuery(sql, VouOthChLdto.class).getResultList();
	}

	public void delete(int id)
	{
		session.createNativeQuery(String.format(DaoHelper.DELETE_BY_ID_SQL, TableName.VOU_OTH_CH, id)).executeUpdate();
	}

	public void delete(VouOthChModel VouOthChModel)
	{
		session.remove(VouOthChModel);
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
