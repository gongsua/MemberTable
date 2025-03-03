package org.example.springstudy.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.example.springstudy.service.Memberservice;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final Memberservice memberservice;
}
