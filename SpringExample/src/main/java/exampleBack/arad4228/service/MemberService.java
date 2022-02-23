package exampleBack.arad4228.service;

import exampleBack.arad4228.domain.Member;
import exampleBack.arad4228.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private  final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
     * 회원가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 회원은 불가능 하다.
        /*
        Optional <Member> result = memberRepository.findByName(member.getName());
        // 요즘은 null을 optional로 감싼다.
        result.ifPresent(m ->{
               throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
         */
        // 중복회원 검증
        ValidateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void ValidateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }
    /*
        전체 회원 조회.
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
