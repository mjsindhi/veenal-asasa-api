package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.dto.res.CommonGetOneResDto;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.service.gen.VoucherSer;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoucherCont
{

	@Autowired
	VoucherSer voucherSer;

	@GetMapping("/vouchers/next-no")
	public ResponseEntity getVoucheres(
			@RequestParam(required = false) VoucherType voucherType,
			@RequestParam(required = false) Date date
	)
	{
		CommonGetOneResDto commonGetOneResDto = voucherSer.getNextNo(voucherType, date);

		if (commonGetOneResDto.isHasException())
		{
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(commonGetOneResDto.getErrorResDto());
		}

		if (!commonGetOneResDto.isIsSuccess())
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(commonGetOneResDto.getErrorResDto());
		}

		return ResponseEntity.ok(commonGetOneResDto.getItem());
	}
}
