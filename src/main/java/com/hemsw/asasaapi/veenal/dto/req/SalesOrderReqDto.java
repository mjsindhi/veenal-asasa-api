package com.hemsw.asasaapi.veenal.dto.req;

import java.util.List;
import lombok.Getter;

@Getter
public class SalesOrderReqDto {

    private List<SalesOrderProductReqDto> salesOrderProductReqDtos;
}
