package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.dto.ldto.TransporterLdto;
import com.hemsw.asasaapi.veenal.dto.req.TransporterReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.dao.gen.TransporterDao;
import com.hemsw.asasaapi.veenal.security.UserDetailsImpl;
import com.hemsw.asasaapi.veenal.service.TransporterSer;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Test")
public class TransporterCont
{
	
	@Autowired
	TransporterDao transporterRepoImpl;
	
	@Autowired
	TransporterSer transporterSer;
	
	@PostMapping("/transporters")
	public ResponseEntity create(@RequestBody TransporterReqDto transporterReqDto)
	{
		
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserModel userModel = userDetailsImpl.getUserModel();
		
		CommonUpsertResDto commonUpsertResDto = transporterSer.create(transporterReqDto, userModel);
		
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
	
	@GetMapping("/transporters")
	public ResponseEntity index()
	{
		List<TransporterLdto> transporterLdtos = transporterRepoImpl.getLdtos(null, null);
		return ResponseEntity
				.ok(transporterLdtos);
	}
}
