package com.hemsw.asasaapi.veenal.dto.ldto;

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
	private String currencyName;
	private String currencyCode;
	private int createdByUserId;
	private String createdByUserName;
	private Date createdAt;

}
