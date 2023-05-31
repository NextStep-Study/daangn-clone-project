package com.daangn.daangn.member.service;


import com.daangn.daangn.member.dto.LoginMemberDTO;
import com.daangn.daangn.member.entity.Member;
import com.daangn.daangn.member.repository.MemberRepository;
import com.daangn.daangn.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final BCryptPasswordEncoder encoder;
    private final MemberRepository memberRepository;
    @Value("${jwt.secret}")
    private String key;

    // 한시간
    private Long expireTimeMs = 1000 * 60 * 60L;


    public int idCheck(String userId) throws Exception {
        return 1;

    }

    public Member joinMember(Member member) throws Exception {
        // encoder를 통하여 비밀번호를 암호화 시켜준다.

        member.builder().pwd(encoder.encode(member.getPwd())).build();
        return memberRepository.save(member);

    }

    public String loginMember(LoginMemberDTO loginMemberDTO) throws Exception {
        // userName 없음
        Member selectedMember = getOne(loginMemberDTO.getEmail());

        // password 틀림
        if(!encoder.matches( loginMemberDTO.getPwd(),selectedMember.getPwd())){
            throw new Exception();
        }
        // 앞에서 Exception안났으면 토큰 발행
        String token = JwtUtil.createJwt(selectedMember.getEmail(),key,expireTimeMs);

        return token;

    }

    public int modifyInfo(LoginMemberDTO LoginMemberDTO) {
        return 1;
    }

    public int deleteMember(String userId) {
        return  1;
    }

    public Member getOne(String email) {

        return memberRepository.findByEmail(email);
    }

}
