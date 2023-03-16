package com.example.splitter.database.dao;

import com.example.splitter.database.dto.group.Groups;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Groups, Long> {
}
