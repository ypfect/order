package com.overstar.order.abs;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/10/18 9:43
 */
public class MQQueueSelector implements MessageQueueSelector {
    /**
     * 根据参数选择队列存放。一般用来保证消息的顺序性
     * @param list  队列集合
     * @param message 消息
     * @param o 参数
     * @return
     */
    @Override
    public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
        String s = o.toString();
        int toInt = NumberUtils.toInt(s);
        //320
        return list.get(toInt%list.size());
    }

    public static void main(String[] args) {
        int size=4;
        int businessId=22010;
        System.out.println(businessId % size);
    }
}
