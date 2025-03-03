package org.example.springstudy.controller;

import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;
import org.example.springstudy.domain.Member;
import org.springframework.stereotype.Controller;
import org.example.springstudy.service.Memberservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final Memberservice memberservice;

    @GetMapping("/members/new")
    public String createForm() {
        return "/members/creatememberForm";
    }


    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberservice.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberservice.findMembers();
        model.addAttribute("members", members);
        return "/members/list";
    }
}

