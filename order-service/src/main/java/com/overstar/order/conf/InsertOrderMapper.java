package com.overstar.order.conf;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.provider.SpecialProvider;

public interface InsertOrderMapper<T> {
    @Options(useGeneratedKeys = true, keyProperty = "orderNo")
    @InsertProvider(type = SpecialProvider.class, method = "dynamicSQL")
    int insertUseGeneratedKeys(T record);
}