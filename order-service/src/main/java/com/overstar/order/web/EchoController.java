package com.overstar.order.web;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
@Api("test swagger")
public class EchoController {

    @RequestMapping(value = "/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }
}