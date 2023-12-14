package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.dto.ldto.TaxLdto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.service.gen.TaxSer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path = "/taxs")
public class TaxCont
{

	@Autowired
	TaxSer taxSer;

	@GetMapping("/taxes")
	public ResponseEntity getTaxes(
			@RequestParam(required = false) String name
	)
	{
		CommonGetResDto<List<TaxLdto>> commonGetResDto = taxSer.getLdtos(name);

		if (commonGetResDto.isHasException())
		{
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(commonGetResDto.getErrorResDto());
		}

		if (!commonGetResDto.isIsSuccess())
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(commonGetResDto.getErrorResDto());
		}

		return ResponseEntity.ok(commonGetResDto.getRows());
	}
}
