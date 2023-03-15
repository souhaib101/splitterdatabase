package com.example.splitterdatabase.dao;

import com.example.splitterdatabase.dto.group.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Long> {
}
