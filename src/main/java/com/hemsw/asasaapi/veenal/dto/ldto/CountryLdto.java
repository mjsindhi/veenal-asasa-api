package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Getter;
import org.springframework.data.annotation.Immutable;

@Getter
@Entity
@Immutable
public class CountryLdto
{

	@Id
	private int id;
	private String name;
	private String code;

	@Column(name = "currency_name")
	private String currencyName;

	@Column(name = "currency_code")
	private String currencyCode;

	@Column(name = "created_by_user_id")
	private int createdByUserId;

	@Column(name = "created_by_user_name")
	private String createdByUserName;

	@Column(name = "created_at")
	private Date createdAt;

}
