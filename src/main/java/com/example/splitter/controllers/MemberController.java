package com.example.splitter.controllers;

import com.example.splitter.database.dto.group.Groups;
import com.example.splitter.database.dto.user.Member;
import com.example.splitter.service.AppService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    AppService service;

    public MemberController(AppService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getHome(Model model, @AuthenticationPrincipal OAuth2User token){
        String handle = token.getAttribute("login");
        Member member = service.getMember(handle);
        System.out.println("githubename = "+handle);
        model.addAttribute("member", member);
        model.addAttribute("groups", service.getAllGroupForMember(member.github()));
        return "index";
    }

    @GetMapping("/creatGroup")
    public String getGroupeSite(){
        return "creatgroup";
    }

    @PostMapping("makegroupe")
    public String creatGroup(@ModelAttribute("handle") String handle,
                             String name,// name der Gruppe
                             Model model){
        Groups group = service.makeGroup(name, handle);
        System.out.println(group);
        return "redirect:/";
    }

}
