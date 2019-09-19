package com.overstar.order.mapper;

import com.overstar.order.export.domain.OrderAddress;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface OrderAddressMapper extends Mapper<OrderAddress>, MySqlMapper<OrderAddress> {
}