package com.hemsw.asasaapi.veenal.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesOrderProductDto {

    private long id;
    private BigDecimal qty;
    private int unitId;
    private String unitName;
}
