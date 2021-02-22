package hello.hellospringg.service;

import hello.hellospringg.domain.Member;
import hello.hellospringg.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {
    private final MemberRepository memberRepository;

    /**
     *  외부에서 넣어주도록 memberservice 를 memberReposutory를 new 로 설정하는것이 아님
     *  Depedency Injection가능
     *  직접 new를 만들어주지 않고 외부에서 memberRepository를 넣어준다
     * @param memberRepository
     */
    @Autowired
    public MemberService(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }


    /**
     *  회원가입
     * @param member
     * @return member.Id()
     */
    public Long join(Member member){
        //같은 이름 중복 아이디는 안된다.
        //Optional<Member> result = memberRepository.findByName(member.getName());
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    /**
     *  중복회원 검증
     * @param member
     */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent( m -> {
                        throw new IllegalStateException("이미 존재하는 회원입니다. ");
                });

        // result.get().orElseGet() 와 같은
    }

    /**
     *  전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
