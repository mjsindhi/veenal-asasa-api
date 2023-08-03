package com.hemsw.asasaapi.veenal.dto.req;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class SalesOrderProductReqDto {

    private long productId;
    private BigDecimal qty;
    private int unitId;
}
