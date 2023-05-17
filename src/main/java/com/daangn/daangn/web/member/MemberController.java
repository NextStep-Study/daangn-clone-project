package com.daangn.daangn.web.member;

import com.daangn.daangn.domain.Member.Member;
import com.daangn.daangn.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    // 서비스를 호출하여 서비스에 등록되어 있는 메소드를 사용한다.
    @Autowired // 생략 가능
    private MemberService memberService;

    // 생성자를 통해 자동으로 빈에 주입!!!
    public MemberController(MemberService memberService) {
        super();
        this.memberService = memberService;
    }

//    @GetMapping("/register")
//    public String join() {
//        // 기본은 forward 형식, 아래의 메소드로 이동하라는 것.
//        return "register_form";
//
//    }
//
//    @PostMapping("/register")
//    public String join(Member memberDto, Model model) throws Exception {
//        memberService.joinMember(memberDto);
//        return "redirect:/register_form.html";
//    }

    @PostMapping("/signup")
    public String signUp(@RequestBody Member member) {
        MemberService.signUp(member);
        return "회원가입이 완료되었습니다.";
    }
}