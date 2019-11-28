package com.overstar.order.web;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.overstar.search.export.api.ISearchAsYouTypeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/10/29 23:35
 */
@RestController
@Slf4j
public class DubboController {

    @Reference
    private ISearchAsYouTypeService asYouTypeService;

    @NacosValue(value = "${test:test-nacos}", autoRefreshed = true)
    private String test;

    @RequestMapping("/dubbo")
    public List<String> test() {
        log.info(test);
        return asYouTypeService.search();
    }

}
