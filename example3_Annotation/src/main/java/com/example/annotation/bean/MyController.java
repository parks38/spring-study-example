package com.example.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MyController {
    // MyController 클래스를 빈으로 등록
    @Autowired
    Member member1;
    //빈이 생성될때 member1변수가 참조할 객체를 자동으로 가져온다

    @Autowired
    @Qualifier("printerB")
    Printer printer;

    @Autowired
    Member member2;

    @RequestMapping("/")
    public @ResponseBody
    String root() { // get 방식의 url 호출하면 root() 실행 시킴
        // @ResponseBody : html 태그없이 순수하게 그대로 스트링 데이터만으로 응답을 할 경우 지정

        //1, Member Bean 가져오기
        member1.print();

        // 2. PrinterB Bean 가져오기
        member1.setPrinter(printer);
        member1.print();

        //3. 싱글톤 확인
        if (member1 == member2) {
            System.out.println("동일한 객체입니다. ");
        } else {
            System.out.println("서로 다른 객체입니다. ");
        }
        return "Annotation 사용하기 ";

    }

}
