package exampleBack.arad4228.service;

import exampleBack.arad4228.aop.TimeTraceAop;
import exampleBack.arad4228.repository.JpaMemberRepository;
import exampleBack.arad4228.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class springconfig {

    //private DataSource dataSource;

    //@Autowired
    //public springconfig(DataSource dataSource) {
    //    this.dataSource = dataSource;
    //}

    //private EntityManager em;
    //
    //@Autowired
    //public springconfig(EntityManager em) {
    //    this.em = em;
    //}

    private MemberRepository memberRepository;

    @Autowired
    public springconfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // 해당 방법을 통해 AOP를 하거나 Component Scan을 사용.
/*    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }
    */

/*    @Bean
    public MemberRepository memberRepository() {
        // 메모리 관련
        //return new MemoryMemberRepository();
        // JDBC관련
        //return new JdbcMemberRepository(dataSource);
        // JDBC Template 관련
        //return  new JdbcTemplateMemverRepository(dataSource);
        // Jpa 관련
        //return new JpaMemberRepository(em);

    }
 */
}

