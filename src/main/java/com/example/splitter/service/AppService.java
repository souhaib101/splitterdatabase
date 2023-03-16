package com.example.splitter.service;

import com.example.splitter.database.dto.group.Groups;
import com.example.splitter.database.dto.group.Memberref;
import com.example.splitter.database.dto.user.Member;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class AppService {
    GroupRepoitory groupRepoitory;
    ExpenditureRepository expenditureRepository;
    MemberRepository memberRepository;

    public AppService(
            GroupRepoitory groupRepoitory,
            ExpenditureRepository expenditureRepository,
            MemberRepository memberRepository) {
        this.groupRepoitory = groupRepoitory;
        this.expenditureRepository = expenditureRepository;
        this.memberRepository = memberRepository;
    }

    public Member getMember(String handle) {
        Member member = memberRepository.getMemberByGithub(handle);
        if (member != null){
            return member;
        }
        return memberRepository.save(new Member(null, handle));
    }

    public Groups makeGroup(String name, String handle) {
        Member member = getMember(handle);
        Groups group = new Groups(null, name, new HashSet<>(), new HashSet<>());
        group.members().add(new Memberref(member.id()));
        return groupRepoitory.save(group);
    }
}
