package exampleBack.arad4228.repository;

import exampleBack.arad4228.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    // 자바 8에서 나옴.
    // null을 처리하는 방법중 하나로 null을 감싸서 처리
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
