package com.warehouse.domain.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductFilter{

    private String name;
    private String type;
    private Date afterDate;
    private Date beforeDate;
    private String productCode;
    private String barCode;
}
