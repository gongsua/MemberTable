package service;

import domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberserviceTest {

    Memberservice memberservice = new Memberservice();

    @Test
    void join() {
        //given
        Member m = new Member();
        m.setName("회원1");
        //when
        Long saveId = memberservice.join(m);

        //then
        Member findMembers = memberservice.findMemberById(saveId).get();
        Assertions.assertThat(m.getName()).isEqualTo(findMembers.getName());

    }

    @Test
    void 중복회원예외() {
        //given
    }

    @Test
    void findMemberById() {
    }
}