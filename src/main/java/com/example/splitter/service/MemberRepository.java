package com.example.splitter.service;

import com.example.splitter.database.dto.expenditure.Expenditure;
import com.example.splitter.database.dto.group.Group;
import com.example.splitter.database.dto.user.Member;

import java.util.Optional;

public interface MemberRepository {
    public Long save(Member member);
    public Optional<Member> getMemberById(Long id);
}
