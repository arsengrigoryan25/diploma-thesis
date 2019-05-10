package com.warehouse.domain;

import com.warehouse.domain.entity.ProductTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryContent implements Serializable {
    private static final long serialVersionUID = -3242148698352390171L;

    private List<ProductTypeEntity> productTypeList;
}
