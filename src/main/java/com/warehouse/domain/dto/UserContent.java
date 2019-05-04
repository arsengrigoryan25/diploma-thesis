package com.warehouse.domain.dto;

import com.warehouse.domain.entity.UserEntity;
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
public class UserContent implements Serializable{

    private static final long serialVersionUID = -8534466736389213305L;
    private List<UserEntity> userEntityList;
}
