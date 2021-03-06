package com.overstar.order.mapper;

import com.overstar.order.export.domain.OrderBase;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface OrderBaseMapper extends Mapper<OrderBase>, MySqlMapper<OrderBase> {
}