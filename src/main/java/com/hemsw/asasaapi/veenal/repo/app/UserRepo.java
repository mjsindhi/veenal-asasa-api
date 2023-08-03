package com.hemsw.asasaapi.veenal.repo.app;

import com.hemsw.asasaapi.veenal.model.app.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserModel, Integer>
{

	public boolean isUserExists(String contactNo);

	public UserModel findByUsername(String username);

	public UserModel findByContactNo(String contactNo);
}
