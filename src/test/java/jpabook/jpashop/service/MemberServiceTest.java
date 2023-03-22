package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("Kim");
        member.setLoginId("Lim");
        member.setPassword("1");

        //when
        Long savedId = memberService.join(member);

        //then
        assertEquals(member,memberRepository.findById(savedId).get());
    }

    @Test
    public void 중복회원체크() throws Exception {
        //given
        Member member = new Member();
        member.setName("Kim");
        member.setLoginId("Lim");
        member.setPassword("1");

        Member member2 = new Member();
        member2.setName("Kim");
        member.setLoginId("Lim");
        member.setPassword("1");
        //when
        memberService.join(member);

        //then
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertEquals("이미 존재하는 회원입니다.", thrown.getMessage());
    }




}