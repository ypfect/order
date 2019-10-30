package com.overstar.order.web;

import com.overstar.search.export.api.ISearchAsYouTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ISearchAsYouTypeService asYouTypeService;

    @RequestMapping("/dubbo")
    public List<String> test() {
        return asYouTypeService.search();
    }
}
