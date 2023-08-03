package com.hemsw.asasaapi.veenal.cont;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hemsw.asasaapi.veenal.dto.req.LoginReqDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Test")
public class TestCont
{

	@GetMapping("/")
	public String index()
	{
		return "index...";
	}

	@GetMapping("/test")
	public String test()
	{
		return "working...";
	}

	@PostMapping(path = "/test/post-check")
	//public String checkPost(@RequestBody(required = false) Optional<Object> obj)
	//public String checkPost(HttpServletRequest request)
	public String checkPost(@RequestBody(required = false) String stringToParse)
	{
		System.out.println(stringToParse);

		ObjectMapper objectMapper = new ObjectMapper();

		LoginReqDto json = null;
		try
		{
			json = objectMapper.readValue(stringToParse, LoginReqDto.class);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return "working...";
	}
}
