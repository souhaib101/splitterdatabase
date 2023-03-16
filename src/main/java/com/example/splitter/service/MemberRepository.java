package com.example.splitter.service;

import com.example.splitter.database.dto.user.Member;

import java.util.Optional;

public interface MemberRepository {
    public Member save(Member member);
    public Optional<Member> getMemberById(Long id);
    public Member getMemberByGithub(String handle);
}
