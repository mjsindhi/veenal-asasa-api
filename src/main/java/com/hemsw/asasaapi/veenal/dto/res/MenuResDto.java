package com.hemsw.asasaapi.veenal.dto.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class MenuResDto
{

	private int id;
	private int seqNo;
	private String name;
	private String displayName;
	private Integer parentId;
	private boolean isSystemMenu;
	private boolean hasAdd;

	@JsonProperty("children")
	List<MenuResDto> menuResDtos;
}
