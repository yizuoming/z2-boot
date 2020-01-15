package com.z2.boot.domain.product.model.valueobject;

/**
 * Created by yzm on 2019.
 * 商品id+ 草稿id 组成一个唯一的键值对对象
 */

public class SkuID {
    private Long skuId;
    private String tmpId;

    public SkuID(Long skuId, String tmpId) {
        this.skuId = skuId;
        this.tmpId = tmpId;
    }

    public String getId() {
        if (null == skuId) {
            return tmpId;
        }
        return String.valueOf(skuId);
    }
}
