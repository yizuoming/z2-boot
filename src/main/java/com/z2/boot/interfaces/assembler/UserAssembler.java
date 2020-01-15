package com.z2.boot.interfaces.assembler;

import com.z2.boot.domain.user.model.UserBo;
import com.z2.boot.infrastructure.common.enums.AccountType;
import com.z2.boot.interfaces.dto.UserDTO;

/**
 * Created by yzm on 2019.
 * 领域对象&DTO对象相互转换
 *
 */
public class UserAssembler {

    public static UserDTO toDto(UserBo bo) {
        UserDTO userDTO = null;
        if (null == bo) {
            return userDTO;
        }
        userDTO = UserDTO.builder()
                .id(bo.getId())
                .code(bo.getCode())
                .name(bo.getName())
                .accountType(AccountType.toEnum(bo.getAccountType()))
                .build();
        return userDTO;
    }

    public static UserBo toBo(UserDTO dto) {
        UserBo bo = null;
        if (null == dto) {
            return bo;
        }
        bo = UserBo.builder()
                .id(dto.getId())
                .code(dto.getCode())
                .name(dto.getName())
                .accountType(AccountType.toCode(dto.getAccountType()))
                .build();
        return bo;
    }
}
