package com.overstar.order;

import com.overstar.order.conf.ApplicationEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.overstar.order.mapper")
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(OrderServiceApplication.class);
        //添加监听器
        springApplication.addListeners(new ApplicationEventListener());
        springApplication.run(args);
    }

}
