package com.daangn.daangn.web;

import com.daangn.daangn.domain.Member.Member;
import com.daangn.daangn.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class MemberController {

    // 서비스를 호출하여 서비스에 등록되어 있는 메소드를 사용한다.
    @Autowired // 생략 가능
    private MemberService memberService;

    // 생성자를 통해 자동으로 빈에 주입!!!
    public MemberController(MemberService memberService) {
        super();
        this.memberService = memberService;
    }

    /**
     * jsp파일에서 /user/join이라고 GET방식으로 보낼때 여기로 오게된다. (참고) jsp파일에서 <a href =
     * "${root}/user/join" 이런식으로 보낸다. a tag는 무조건 GET 방식임에 주의!!!
     *
     * @return
     */
    @GetMapping("/join")
    public String join() {
        // 기본은 forward형식, 아래의 메소드로 이동하라는 것.
        return "user/join";
    }

    @PostMapping("/join")
    public String join(Member memberDto, Model model) throws Exception {
        // 서비스에서 회원가입 메소드를 호출하여 DB에 값을 저장해준다.
        memberService.joinMember(memberDto);
        // 값을 저장해 주었고, 넘길 값이 없으니 redirect 형식으로 login.jsp페이지로 이동한다.
        return "redirect:/user/login";
    }
}