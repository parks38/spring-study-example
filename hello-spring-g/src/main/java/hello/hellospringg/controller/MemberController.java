package hello.hellospringg.controller;

import hello.hellospringg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    //private final MemberService memberService = new MemberService();
    // new 로 만들면 memberController 말고도 memberService를 가져다가 쓸수도 있는데
    // 별 기능이없다. 하나만 생성하고 공유하면 되는 memberService 기능
    private final MemberService memberService;

    // 의존관계 주입 - Dependency Injection
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
