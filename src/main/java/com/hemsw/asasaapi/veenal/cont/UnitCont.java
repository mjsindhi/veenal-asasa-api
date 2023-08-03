package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.dto.ldto.UnitLdto;
import com.hemsw.asasaapi.veenal.dto.req.UnitReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.dao.gen.UnitRepoImpl;
import com.hemsw.asasaapi.veenal.security.UserDetailsImpl;
import com.hemsw.asasaapi.veenal.service.UnitSer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path = "/units")
public class UnitCont
{

	@Autowired
	UnitSer unitSer;

	@Autowired
	UnitRepoImpl unitRepoImpl;

	@PostMapping("/units")
	public ResponseEntity create(@RequestBody UnitReqDto unitReqDto)
	{

		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserModel userModel = userDetailsImpl.getUserModel();

		CommonUpsertResDto commonUpsertResDto = unitSer.create(unitReqDto, userModel);

		if (commonUpsertResDto.isHasException())
		{
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(commonUpsertResDto.getErrorResDto());
		}

		if (!commonUpsertResDto.isIsSuccess())
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(commonUpsertResDto.getErrorResDto());
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

	@GetMapping("/units")
	public ResponseEntity index()
	{
		List<UnitLdto> unitLdtos = unitRepoImpl.getLdtos(null);
		return ResponseEntity
				.ok(unitLdtos);
	}
}
