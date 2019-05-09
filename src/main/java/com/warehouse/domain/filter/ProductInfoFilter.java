package com.warehouse.domain.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductInfoFilter implements Serializable {
    private static final long serialVersionUID = 6653040569274078624L;

    private String barCode;
    private Date startDate;
    private Date endDate;
}
