package exampleBack.arad4228.repository;

import exampleBack.arad4228.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

// 현재의방식은 컨포넌트 스캔과 자동 의존관계 설정이다.
@Repository
public class MemoryMemberRepository implements  MemberRepository{

    // 실무에서는 동시성을 고려하기
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // lamda표현(공부해야할듯)
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
