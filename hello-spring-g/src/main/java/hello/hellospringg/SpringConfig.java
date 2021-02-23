package hello.hellospringg;

import hello.hellospringg.repository.MemberRepository;
import hello.hellospringg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    // H2 / JdbcTemplate private DataSource dataSource;
    /* 2. JPA
    @PersistenceContext
    private EntityManager em;
     */
    private final MemberRepository memberRepository;
    // SprinvDataJPAMemberRepository interface만 만들어 놓으면
    // JpaRepositoru가 spring Bean 에 등록을 해서 injection을 받을 수 있다.
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    //@Bean
    //public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // 1. h2 return new JdbcMemberRepository(dataSource);
        // 2. JdbcTemplate return new JdbcTemplateMemberRepository(dataSource);
        // 3. JPA return new JpaMemberRepository(em);

    //}


}
