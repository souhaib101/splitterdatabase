package com.example.splitter.service;

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
}