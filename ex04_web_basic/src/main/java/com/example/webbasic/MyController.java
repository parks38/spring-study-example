package com.example.webbasic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping("/")
    public @ResponseBody
    String root() throws Exception {
        return "JSP in Gradle";
    }

    @RequestMapping("/test1")
    public String test1() {
        return "test1"; // 실제 호출됨 /web-inf/views/test1.jsp
    }

    @RequestMapping("/test2")
    public String test2() {
        return "/sub/test2";
    }
}
