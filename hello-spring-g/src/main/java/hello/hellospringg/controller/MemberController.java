package hello.hellospringg.controller;

import hello.hellospringg.domain.Member;
import hello.hellospringg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        System.out.println("member = " + member.getName());
        memberService.join(member);

        return "redirect:/";
    }
}
