package com.example.splitter.database.dao;

import com.example.splitter.database.dto.user.Member;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends CrudRepository<Member, Long> {
    Member findMemberByGithub(String handle);
}
