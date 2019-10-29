package com.overstar.order.web;

import com.overstar.search.export.api.ISearchAsYouTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/10/29 23:35
 */
@RestController
public class DubboController {

    @Autowired
    private ISearchAsYouTypeService asYouTypeService;

    @RequestMapping("/dubbo")
    public List<String> test(){
        return asYouTypeService.search();
    }
}
