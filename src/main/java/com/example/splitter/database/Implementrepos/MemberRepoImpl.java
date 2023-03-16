package com.example.splitter.database.Implementrepos;

import com.example.splitter.database.dao.MemberRepository;
import com.example.splitter.database.dto.user.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class MemberRepoImpl implements com.example.splitter.service.MemberRepository {
    MemberRepository repository;

    public MemberRepoImpl(MemberRepository repository) {
        this.repository = repository;
    }

    public Long save(Member member){
        return repository.save(member).id();
    }

    public Optional<Member> getMemberById(Long id){
        return repository.findById(id);
    }

    public List<Member> getAllMemberById(Set<Long> members){
        return (List<Member>) repository.findAllById(members);
    }

}
