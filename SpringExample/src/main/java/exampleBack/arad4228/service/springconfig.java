package exampleBack.arad4228.service;

import exampleBack.arad4228.domain.Member;
import exampleBack.arad4228.repository.MemberRepository;
import exampleBack.arad4228.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class springconfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
        }
}

