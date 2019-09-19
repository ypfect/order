package com.overstar.order.conf;

import com.overstar.order.utils.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

@Slf4j
public class ApplicationEventListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            // 初始化环境变量
            log.info("环境变量初始化...");
        } else if (event instanceof ApplicationPreparedEvent) {
            // 初始化完成
            ApplicationContextUtil.setApplicationContext(((ApplicationPreparedEvent) event).getApplicationContext());
            log.info("applicationContext init ...");
        } else if (event instanceof ContextRefreshedEvent) {
            // 应用刷新
        } else if (event instanceof ApplicationReadyEvent) {
            // 应用已启动完成
            log.info("Application ready...");
        } else if (event instanceof ContextStartedEvent) {
            // 应用启动，需要在代码动态添加监听器才可捕获
            log.info("Application started...");
        } else if (event instanceof ContextStoppedEvent) {
            // 应用停止
            log.info("Application stopped...");
        } else if (event instanceof ContextClosedEvent) {
            // 应用关闭
            log.info("Application closed...");
        }
    }
}
