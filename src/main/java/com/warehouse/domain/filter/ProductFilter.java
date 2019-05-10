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
public class ProductFilter implements Serializable{
    private static final long serialVersionUID = 1048334372865360593L;

    private String name;
    private String type;
    private String productCode;
    private String barcode;
}
