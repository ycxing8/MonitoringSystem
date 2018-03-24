package com.bob.test_my_sql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class TemplateController {

    @RequestMapping("/helloHtml")
    public String helloHtml(Map<String,Object> map){

        map.put("hello","from TemplateController.helloHtml");
        return"/helloHtml";
    }

}
