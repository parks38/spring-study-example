package hello.hellospringg.repository;

import hello.hellospringg.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    //순서가 보장되지않기 때문에 테스트가 끝날때 마다 데이터를 지워주는 코드 생성
    // 테스트 마다 데이터를 지우기 때문에 순서 의존관계가 상관없어진다.
    // 공용 데이터를 깔끔하게 지워주기
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        // System.out.println("result = " + (result == member));
        //Assertions.assertEquals(member, result); - junit
        //듈이 같은지 확인하기 - true : green false : red (error)
        assertThat(member).isEqualTo(result); //assertj.core.api


    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
