package com.example.splitter.controllers;

import com.example.splitter.service.AppService;
import com.example.splitter.service.ExpenditureRepository;
import com.example.splitter.service.GroupRepoitory;
import com.example.splitter.service.MemberRepository;

public class MemberController {
    AppService service;

    public MemberController(AppService service) {
        this.service = service;
    }
}
