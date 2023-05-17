package com.daangn.daangn.service.member;
import com.daangn.daangn.domain.Member.Member;
import com.daangn.daangn.domain.Member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository userRepository;

    @Autowired
    public MemberService(MemberRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void signUp(Member member) {
        // 회원 가입 로직 구현
        // 예를 들어, 비밀번호 암호화, 데이터베이스에 회원 정보 저장 등을 수행합니다.
        // 비밀번호 암호화
//        String encodedPassword = passwordEncoder.encode(member.getPassword());
//        member.setPassword(encodedPassword);

        // 회원 정보 저장
//        MemberRepository.save(member);
    }
}

