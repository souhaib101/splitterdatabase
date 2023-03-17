package com.example.splitter.database.dao;

import com.example.splitter.database.dto.user.Member;
import org.springframework.data.repository.CrudRepository;


public interface MemberRepository extends CrudRepository<Member, Long> {
    Member findMemberByGithub(String handle);
}
