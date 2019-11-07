package com.overstar.order;

import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.overstar.order.conf.ApplicationEventListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.overstar.order.mapper")
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(OrderServiceApplication.class);
        //添加监听器
        springApplication.addListeners(new ApplicationEventListener());
        springApplication.run(args);
    }

    //监听nacos配置文件的变化
    @NacosConfigListener(dataId = "overstar-order.properties", groupId = "BASE",timeout = 500)
    public void onChange(String newContent) {
       log.info("config has refresh ,content ={}",newContent);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

