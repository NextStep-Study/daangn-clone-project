package com.daangn.daangn.repository.member;

import com.daangn.daangn.domain.Member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {


}
