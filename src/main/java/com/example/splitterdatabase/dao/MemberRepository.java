package com.example.splitterdatabase.dao;

import com.example.splitterdatabase.dto.user.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

}
