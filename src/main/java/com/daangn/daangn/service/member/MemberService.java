package com.daangn.daangn.service.member;

import com.daangn.daangn.domain.Member.Member;

public interface MemberService {
    int joinMember(Member memberDto) throws Exception;
    Member loginMember(String userId, String userPwd) throws Exception;
}
