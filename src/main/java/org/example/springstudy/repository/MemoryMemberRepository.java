package org.example.springstudy.repository;

import org.example.springstudy.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;



@Repository
public class MemoryMemberRepository implements MemberRepository {

    //save를 사용하기 때문에 어디에 저장해 둘 것인지 정해놔야한다.
    private Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;  //회원번호 0 번주터 시작한다.
    
    
    @Override
    //save 하기전에 member 객체에서 setid를 받아오고 store에 member의 정보를 저장한다.
    public Member save(Member member) {
         member.setId(++sequence);  //id을 매번 상승 시킨다.
         store.put(member.getId(), member);  //
         return member;
    }

    @Override
    public Optional<Member> findById(long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
