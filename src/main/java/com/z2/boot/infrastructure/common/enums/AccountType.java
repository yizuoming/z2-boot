package com.z2.boot.infrastructure.common.enums;

/**
 * Created by yzm on 2019.
 */
public enum AccountType {
    vc(1, "自营"),
    pop(2, "第三方"),
    inner(3, "内部员工");

    private Integer code;
    private String desc;

    AccountType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public static Integer toCode(AccountType type) {
        if (null == type) {
            return null;
        }
        AccountType[] types = AccountType.values();
        for (AccountType tp : types) {
            if (tp.equals(type)) {
                return tp.getCode();
            }
        }
        return null;
    }

    public static AccountType toEnum(Integer code) {
        if (null == code) {
            return null;
        }
        AccountType[] types = AccountType.values();
        for (AccountType tp : types) {
            if (code.intValue() == tp.code.intValue()) {
                return tp;
            }
        }
        return null;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
