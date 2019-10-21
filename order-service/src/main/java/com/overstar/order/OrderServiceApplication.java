package com.overstar.order;

import com.overstar.order.conf.ApplicationEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.overstar.order.mapper")
@SpringBootApplication
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(OrderServiceApplication.class);
        //添加监听器
        springApplication.addListeners(new ApplicationEventListener());
        springApplication.run(args);
    }

}

