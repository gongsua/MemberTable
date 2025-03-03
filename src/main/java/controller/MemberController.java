package controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import service.Memberservice;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final Memberservice memberservice;
}
