package com.daangn.daangn.member.repository;


import com.daangn.daangn.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    Member findByEmail(String email);


}
