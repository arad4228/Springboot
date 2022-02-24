package exampleBack.arad4228.service;

import exampleBack.arad4228.repository.JdbcMemberRepository;
import exampleBack.arad4228.repository.JdbcTemplateMemverRepository;
import exampleBack.arad4228.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class springconfig {

    private DataSource dataSource;

    @Autowired
    public springconfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return  new JdbcTemplateMemverRepository(dataSource);
    }
}

