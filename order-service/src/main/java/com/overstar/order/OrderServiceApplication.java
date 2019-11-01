package com.overstar.order;

import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.overstar.order.conf.ApplicationEventListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.overstar.order.mapper")
@SpringBootApplication
@NacosPropertySource(dataId = "service_order", groupId = "BASE", autoRefreshed = true)
@Slf4j
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(OrderServiceApplication.class);
        //添加监听器
        springApplication.addListeners(new ApplicationEventListener());
        springApplication.run(args);
    }

    //监听nacos配置文件的变化
    @NacosConfigListener(dataId = "service_order", groupId = "BASE",timeout = 500)
    public void onChange(String newContent) {
       log.info("config has refresh ,content ={}",newContent);
    }

}

