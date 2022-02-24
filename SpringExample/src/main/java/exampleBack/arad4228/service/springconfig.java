package exampleBack.arad4228.service;

import exampleBack.arad4228.repository.JpaMemberRepository;
import exampleBack.arad4228.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class springconfig {

    //private DataSource dataSource;

    //@Autowired
    //public springconfig(DataSource dataSource) {
    //    this.dataSource = dataSource;
    //}

    private EntityManager em;

    @Autowired
    public springconfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // 메모리 관련
        //return new MemoryMemberRepository();
        // JDBC관련
        //return new JdbcMemberRepository(dataSource);
        // JDBC Template 관련
        //return  new JdbcTemplateMemverRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}

