package com.z2.boot.interfaces.dto;

import com.z2.boot.infrastructure.common.enums.AccountType;
import lombok.Builder;
import lombok.Data;

/**
 * Created by yzm on 2019.
 */
@Data
@Builder
public class UserDTO {
    /**
     * 数据库主键id
     */
    private Long id;
    /**
     * 用户编码
     */
    private String code;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 用户类型
     */
    private AccountType accountType;
}
