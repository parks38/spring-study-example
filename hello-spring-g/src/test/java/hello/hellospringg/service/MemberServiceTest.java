package hello.hellospringg.service;

import hello.hellospringg.domain.Member;
import hello.hellospringg.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    //순서가 보장되지않기 때문에 테스트가 끝날때 마다 데이터를 지워주는 코드 생성
    // 테스트 마다 데이터를 지우기 때문에 순서 의존관계가 상관없어진다.
    // 공용 데이터를 깔끔하게 지워주기
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // 예외로직 - 중복 아이디 체크

        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e =  assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. ");
/*
        try {
            memberService.join(member2);
            fail("예외가 발생해야 합니다 ");
        } catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
            // output: org.opentest4j.AssertionFailedError:
        }
 */

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}