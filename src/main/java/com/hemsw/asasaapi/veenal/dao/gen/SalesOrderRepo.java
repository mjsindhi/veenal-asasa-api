package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.model.gen.SalesOrderModel;
import org.springframework.data.repository.CrudRepository;

public interface SalesOrderRepo extends CrudRepository<SalesOrderModel, Long> {
}
