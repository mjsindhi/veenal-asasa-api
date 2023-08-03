package com.hemsw.asasaapi.veenal.repo.app;

import com.hemsw.asasaapi.veenal.model.app.RefreshTokenModel;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepo extends CrudRepository<RefreshTokenModel, Long>
{

	public RefreshTokenModel findByUserId(int userId);

	public RefreshTokenModel findByToken(String token);
}
