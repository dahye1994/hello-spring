package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // 바로 객체 생성을 하지 않음 -> 다른 컨트롤러에서 MemberService를 쓸 수 있기 때문
    private final MemberService memberService;

    @Autowired
    // 생성자에서 연결 -> Dependency Injection
    public MemberController(MemberService memberService){

        this.memberService = memberService;
    }
}
