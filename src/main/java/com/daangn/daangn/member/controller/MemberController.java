package com.daangn.daangn.member.controller;

import java.util.HashMap;
import java.util.Map;

import com.daangn.daangn.member.dto.LoginMemberDTO;
import com.daangn.daangn.member.entity.Member;
import com.daangn.daangn.member.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/members")
@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
public class MemberController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private final MemberService memberService;



    @PostMapping(value ="/login")
    public ResponseEntity<String> loginMember(@RequestBody LoginMemberDTO memberDTO) {
        Map<String, Object> resultMap = new HashMap<>();

        String token = null;
        try {
            token = memberService.loginMember(memberDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body(token);
    }


    @GetMapping(value = "/logout/{userId}")
    public ResponseEntity<?> logoutMember(@PathVariable("userId") String userid) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        try {
            resultMap.put("message", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            log.error("로그아웃 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;

        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    // 회원 가입
    @PostMapping(value ="/join")
    public String joinMember(@RequestBody Member member) {
        try {
            log.info("save 전 : member info : {}", member);
            Member temp= memberService.joinMember(member);
            log.info(" save  후 : member info : {}", member);
            return temp + "";
        } catch (Exception e) {
            log.info("회원가입 실패 " +e.getMessage());
            return 0 + "";
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteMember(@PathVariable("userId") String userId) {
        return null;
    }



    @PutMapping(value ="/")
    public ResponseEntity<?> modifyMemberInfo(@RequestBody LoginMemberDTO memberDTO) {
        return null;
    }

    @GetMapping(value ="/{userId}")
    public ResponseEntity<?> getMemberInfo(@PathVariable("userId") String userId) {
        return null;
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
