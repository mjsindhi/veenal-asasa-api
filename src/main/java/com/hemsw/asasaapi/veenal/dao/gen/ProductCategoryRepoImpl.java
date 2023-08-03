package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryRepoImpl
{

	@Autowired
	private EntityManager session;

	public boolean isIdExists(int id)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_product_category} WHERE id = %s", id);
		Map<String, String> map = new HashMap<>();
		map.put("table_product_category", TableName.PRODUCT_CATEGORY);
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}
}