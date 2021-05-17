package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@Controller
public class MyController {

    @RequestMapping("/")
    public @ResponseBody
    String root() throws Exception {
        return "Validator (1)";
    }

    @RequestMapping("/test3")
    public String test3(Member member, Model model) {
        //파라미터와 일치하는 빈을 만들어서 사용
        // view 페이지에서 model을 사용하지않고 member 사용
        System.out.println(member);
        return "test3";
    }

    @RequestMapping("/insertForm")
    public String insert1() {
        return "createPage";
    }

    @RequestMapping("/create")
    public String insert2(@ModelAttribute("dto") ContentDto contentDto, BindingResult result) {
        // 커맨드 객체 파라미터로 폼 데이터를 받아서 처리코자

        String page = "createDonePage";
        System.out.println(contentDto);

        ContentValidator validator = new ContentValidator(); // 유효성 검증 객체를 만든다.
        validator.validate(contentDto, result); // 파라미터로 받음

        // result 값이 있다면 에러가 있다. -> 체크를 한다.
        if (result.hasErrors()) {
            page = "createPage";
        }
        // 에러가 없다면 결과페이지 jsp를 호출,에러가 있다면 입력 페이지의 jsp 를 리턴
        return page;
    }

}
