package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.model.gen.StateModel;
import com.hemsw.asasaapi.veenal.dao.gen.StateDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path = "/states")
public class StateCont
{

	@Autowired
	StateDao stateDao;

	@GetMapping("/states")
	public ResponseEntity index()
	{
		List<StateModel> stateModels = stateDao.getLdtos(null);
		return ResponseEntity
				.ok(stateModels);
	}
}
