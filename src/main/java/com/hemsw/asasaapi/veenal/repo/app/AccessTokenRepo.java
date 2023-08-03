package com.hemsw.asasaapi.veenal.repo.app;

import com.hemsw.asasaapi.veenal.model.app.AccessTokenModel;
import org.springframework.data.repository.CrudRepository;

public interface AccessTokenRepo extends CrudRepository<AccessTokenModel, Long> {

	public AccessTokenModel findByToken(String token);
}
