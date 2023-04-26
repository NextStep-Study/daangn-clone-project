package com.daangn.daangn.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Optional<Board> findByName (String name);
    Optional<Board> findByBranchAndName (String branch, String name);

    Optional<Board> findByBranchAndCode (String branch, String code);

    Boolean existsByBranchAndName(String branch, String name);
}
