package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoucherDao
{

	@Autowired
	private EntityManager session;

	public void create(VoucherModel voucherModel)
	{
		session.persist(voucherModel);
	}

	public String getNextNo(VoucherType voucherType, Date date)
	{
		String sql = String.format("SELECT IFNULL(MAX(CAST(NO AS UNSIGNED)),0) FROM %s", TableName.VOUCHER);

		List<String> wheres = new ArrayList<>();
		wheres.add(String.format("voucher_type_id=%s", voucherType.getId()));

		sql = SqlHelper.putWheres(wheres, sql);

		String lastNumbrStr = (String) session.createNativeQuery(sql).getSingleResult();

		if (lastNumbrStr == null || !Util.isInt(lastNumbrStr))
		{
			return "";
		}

		return String.valueOf(Integer.parseInt(lastNumbrStr) + 1);
	}
}
