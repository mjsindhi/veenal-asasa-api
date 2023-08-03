package com.hemsw.asasaapi.veenal.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class SalesOrderDto {

    private long id;
    private String no;
    private Date date;
    private boolean locked;
}
