package com.daangn.daangn.domain.Member;

import com.daangn.daangn.domain.Member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // 추가적인 쿼리 메서드나 기능이 필요한 경우에는 이곳에 작성합니다.

    Member save(Member member);
}
