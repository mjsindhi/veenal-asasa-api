package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.model.gen.ProductModel;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<ProductModel, Long> {

	@Query(value = "SELECT * FROM product WHERE is_service = 0", nativeQuery = true)
	public List<ProductModel> getProducts();

	@Query(value = "SELECT IFNULL(SUM(tx_type * qty), 0) current_stock_qty FROM goods_journal WHERE product_id = ?1", nativeQuery = true)
	public BigDecimal getCurrentStock(long productId);
}
