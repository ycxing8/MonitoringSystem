package com.seu.monitor.controller;

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

    @RequestMapping("/helloHtml1")
    public String helloHtml1(Map<String,Object> map){

        map.put("hello","from TemplateController.helloHtml");
        return"/helloHtml1";
    }

    @RequestMapping("/")
    public String index(){
        return "1.html";
    }


}
