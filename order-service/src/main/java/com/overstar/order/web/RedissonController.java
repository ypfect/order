package com.overstar.order.web;

import com.overstar.order.export.vo.Ret;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/9/24 19:58
 */
@RestController
public class RedissonController {

    @Autowired
    private RedissonClient client;

    @RequestMapping("/helloRedis")
    public Ret helloRedisson(){
        RBucket<Object> test = client.getBucket("test");
        test.set("he咯");
        return Ret.success("吃了",2);
    }


    @RequestMapping("/get")
    public Ret getRedissonValue(){
        RBucket<Object> test = client.getBucket("test");
        return Ret.success("吃了",test.get());
    }

    @RequestMapping("/clear")
    public Ret clear(){
        RBucket<Object> test = client.getBucket("test");

        return Ret.success("cleared",test.delete());
    }
}
