package com.overstar.order.conf;

import com.alibaba.dubbo.config.ConsumerConfig;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/10/29 22:09
 */
//@Configuration
public class BeanCenter {

//    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setFilter("-sentinel.dubbo.consumer.filter");
        return consumerConfig;
    }
}
