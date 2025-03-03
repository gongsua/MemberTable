package org.example.springstudy.repository;

import org.example.springstudy.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }


    @Test
    public void findById() {
        Member member1 = new Member();
        member1.setName("회원1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("회원2");
        repository.save(member2);

        Member result = repository.findById(member2.getId()).get();
        Assertions.assertThat(result).isEqualTo(member1);



    }
}
