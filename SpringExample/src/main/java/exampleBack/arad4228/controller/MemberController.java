package exampleBack.arad4228.controller;

import exampleBack.arad4228.domain.Member;
import exampleBack.arad4228.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 의존관계 주입.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //조회할 때 사용.
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    // 데이터를 form에 넣어 전달할 때 사용.
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
         List<Member> members = memberService.findMembers();
         model.addAttribute("members", members);
         return "members/memberList";
    }
}
