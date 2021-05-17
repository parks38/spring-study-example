package com.example.valid_anno;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MyController {

    @RequestMapping("/")
    public @ResponseBody
    String root() throws Exception {
        return "Valid_Annotation (4)";
    }

    @RequestMapping("/insertForm")
    public String insert1() {
        return "createPage";
    }

    @RequestMapping("/create")
    public String insert2(@ModelAttribute("dto") @Valid ContentDto contentDto,
                          BindingResult result) {
        String page = "createDonePage";
        System.out.println(contentDto);

        if (result.hasErrors()) {
            if (result.getFieldError("writer") != null) {
                System.out.println("1: " + result.getFieldError("writer").getDefaultMessage());
            }
            // 에러가 있을때 에러 내용을 가져오는 코드
            if (result.getFieldError("content") != null) {
                System.out.println("2: " + result.getFieldError("content").getDefaultMessage());
            }
            page = "createPage";
        }
        return page;
    }

}
