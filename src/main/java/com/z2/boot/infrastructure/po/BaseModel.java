package com.z2.boot.infrastructure.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yzm on 2019.
 */
@Data
public class BaseModel implements Serializable {

    protected Long id;
    protected String createId;
    protected String createName;
    protected String modifyId;
    protected String modifyName;
    protected Date createTime;
    protected Date modifyTime;
}
