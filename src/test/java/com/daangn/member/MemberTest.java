//package com.daangn.member;
//
//import com.daangn.daangn.member.repository.MemberRepository;
//import com.daangn.daangn.temp.domain.Member.Member;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import javax.transaction.Transactional;
//import java.util.Optional;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@WebAppConfiguration
//
//public class MemberTest {
//
//    @Autowired
//    MemberRepository memberRepository;
//
//    @Test
//    @Transactional
//    @Rollback(false)
//
//    public void test() throws Exception {
//        //give
//        Member member = new Member();
//        member.setId(123L); //long 타입 int 형 뒤에 L 붙이기
//
//        //when
//        //name 받아와서 저장 = saved  -> name = saved를 통해 ID 찾기
//        String saved = memberRepository.save(member).getName();
//        Optional<Member> findMember = memberRepository.findById(saved);
//
//        //then
//        //@WebAppConfiguration -> 해야 import
//        Assertions.assertThat(findMember).isEqualTo(member);
//
//    }
//
//
//}
