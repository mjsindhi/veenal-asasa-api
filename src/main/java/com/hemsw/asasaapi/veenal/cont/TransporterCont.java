package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.dto.req.TransporterReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonDeleteResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetOneResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.dto.res.TransporterResDto;
import com.hemsw.asasaapi.veenal.security.UserDetailsImpl;
import com.hemsw.asasaapi.veenal.service.gen.TransporterSer;
import com.hemsw.asasaapi.veenal.util.Util;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Test")
public class TransporterCont
{

	@Autowired
	TransporterSer transporterSer;

	@PostMapping("/transporters")
	public ResponseEntity createTransporter(@RequestBody TransporterReqDto transporterReqDto)
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
	public ResponseEntity getTransporters(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String transporterId
	)
	{
		CommonGetResDto commonGetResDto = null;

		commonGetResDto = transporterSer.getLdtos(name, transporterId);

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

	@GetMapping("/transporters/{id}")
	public ResponseEntity getTransporter(@PathVariable("id") String idStr)
	{
		if (idStr == null)
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResDto(
							new Date(),
							"id_invalid",
							"Enter valid id",
							"Enter valid id"
					));
		}

		if (!Util.isInt(idStr))
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResDto(
							new Date(),
							"id_invalid",
							"Enter valid id",
							"Enter valid id"
					));
		}

		int id = Integer.parseInt(idStr);

		CommonGetOneResDto<TransporterResDto> commonGetOneResDto = transporterSer.getById(id);

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

	@PutMapping("/transporters/{id}")
	public ResponseEntity updateTransporter(@PathVariable("id") int id, @RequestBody TransporterReqDto transporterReqDto)
	{

		CommonUpsertResDto commonUpsertResDto = transporterSer.update(id, transporterReqDto);

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

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@DeleteMapping("/transporters/{id}")
	public ResponseEntity deleteTransporter(@PathVariable("id") int id)
	{
		CommonDeleteResDto commonDeleteResDto = transporterSer.delete(id);

		if (commonDeleteResDto.isHasException())
		{
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(commonDeleteResDto.getErrorResDto());
		}

		if (!commonDeleteResDto.isIsSuccess())
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(commonDeleteResDto.getErrorResDto());
		}

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}
