package com.example.splitter.database.dao;

import com.example.splitter.database.dto.group.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Long> {
}
