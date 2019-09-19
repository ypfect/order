package com.overstar.order.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/9/19 15:34
 */
@ControllerAdvice
@Slf4j
public class AdvanceController {

    @ExceptionHandler(Exception.class)
    public void globalExceptionFetch(Exception e){
        log.error("未知错误..."+e);
    }
}
