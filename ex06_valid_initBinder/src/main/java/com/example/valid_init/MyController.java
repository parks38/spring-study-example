package com.example.valid_init;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    // 약한결합과 디펜던시를 적용시킴
    @RequestMapping("/")
    public @ResponseBody
    String root() throws Exception {
        return "Valid_initBinder (3)";

    }

    @RequestMapping("/insertForm")
    public String insert1() {
        return "createPage";
    }

    // @Valid contentDto 객체변수에 대한 유효성 검증을 하겠다고 표시하는 것이다
    // 객체 변수가 들어오면 스프링이 binder변수에 저장된 갹체를 통해서 즉시 유효성 검사를 하고
    // 에러가 있다면 result 변수에 담아둔다.
    @RequestMapping("/create")
    public String insert2(@ModelAttribute("dto") @Valid ContentDto contentDto,
                          BindingResult result) {
        String page = "createDonePage";
        System.out.println(contentDto);

        // ContentValidator validator = new ContentValidator();
        // validator.validate(contentDto, result);
        if (result.hasErrors()) {
            System.out.println("getAllErrors: " + result.getAllErrors());
            if (result.getFieldError("writer") != null) {
                System.out.println("1:" + result.getFieldError("writer").getCode());

            }
            if (result.getFieldError("content") != null) {
                System.out.println("1:" + result.getFieldError("content").getCode());

            }
            page = "createPage";
        }
        return page;
        /**
         * ContentValidator 클래스에 유효성 검증 에러를 출력, 스프링에서 제공되는 Api 를 사용
         * 에러를 담은 결과만 리턴받기 때문에 MyController 클래스에서 에러를 출력하도록 수정하였다.
         */
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new ContentValidator());
    }


}
