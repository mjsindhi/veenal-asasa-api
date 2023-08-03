package com.hemsw.asasaapi.veenal.dao.gen;

import java.math.BigInteger;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepoImpl
{

	@Autowired
	private EntityManager session;

	public boolean isUserExists(String contactNo)
	{
		String sql = "SELECT IFNULL(COUNT(*),0) FROM user WHERE contact_no = :contactNo";
		BigInteger o = (BigInteger) session.createNativeQuery(sql)
				.setParameter("contactNo", contactNo + "%")
				.getSingleResult();
		return o.doubleValue() > 0;
	}
}
