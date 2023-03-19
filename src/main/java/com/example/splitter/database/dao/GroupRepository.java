package com.example.splitter.database.dao;

import com.example.splitter.database.dto.group.Groups;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface GroupRepository extends CrudRepository<Groups, Long> {

    @Query("SELECT * FROM groups WHERE id IN (SELECT groups FROM memberref WHERE memberref.id = :memberId);")
    List<Groups> findGroupsForMember(Long memberId);
}
