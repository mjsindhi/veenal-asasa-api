package com.hemsw.asasaapi.veenal.service;

import com.hemsw.asasaapi.veenal.dto.req.ProductReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.model.app.UserModel;

public interface ProductSer
{

	public CommonUpsertResDto create(ProductReqDto productReqDto, UserModel userModel);
}
