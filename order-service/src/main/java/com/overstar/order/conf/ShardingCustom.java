package com.overstar.order.conf;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/12/5 15:11
 */
public class ShardingCustom implements PreciseShardingAlgorithm {

    public ShardingCustom() {
    }

    @Override
    public String doSharding(Collection collection, PreciseShardingValue preciseShardingValue) {
        return null;
    }
}
