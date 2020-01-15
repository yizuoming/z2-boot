package com.z2.boot.domain.user.model;

import lombok.Data;

/**
 * Created by yzm on 2019.
 */
@Data
public class UserBo {

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
    private Integer accountType;
}
