package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.SalesOrderDto;
import com.hemsw.asasaapi.veenal.model.gen.SalesOrderModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;

public class SalesOrderMapper
{

	public static SalesOrderDto toSalesOrderDto(SalesOrderModel salesOrderModel, VoucherModel voucherModel)
	{
		return new SalesOrderDto()
				.setId(salesOrderModel.getId())
				.setNo(voucherModel.getNo())
				.setDate(voucherModel.getDate());
	}
}
