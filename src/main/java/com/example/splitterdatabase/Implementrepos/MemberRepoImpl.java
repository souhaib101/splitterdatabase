package com.example.splitterdatabase.Implementrepos;

import com.example.splitterdatabase.dao.MemberRepository;
import com.example.splitterdatabase.dto.expenditure.InvolvedParty;
import com.example.splitterdatabase.dto.user.Member;
import com.sun.source.doctree.SeeTree;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class MemberRepoImpl {
    MemberRepository repository;

    public MemberRepoImpl(MemberRepository repository) {
        this.repository = repository;
    }

    public void save(Member member){
        repository.save(member);
    }

    public Optional<Member> getMember(Long id){
        return repository.findById(id);
    }

    public List<Member> getAllMemberById(Set<Long> members){
        return (List<Member>) repository.findAllById(members);
    }

}
