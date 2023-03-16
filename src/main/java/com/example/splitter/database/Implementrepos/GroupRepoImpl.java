package com.example.splitter.database.Implementrepos;

import com.example.splitter.database.dao.GroupRepository;
import com.example.splitter.database.dto.group.Group;
import com.example.splitter.service.GroupRepoitory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class GroupRepoImpl implements GroupRepoitory {
    GroupRepository repository;

    public GroupRepoImpl(GroupRepository repository) {
        this.repository = repository;
    }

    public Long save(Group group){
        Group savedGroup = repository.save(group);
        return savedGroup.id();
    }

    public Optional<Group> getGroupById(Long id){
        return repository.findById(id);
    }
}
