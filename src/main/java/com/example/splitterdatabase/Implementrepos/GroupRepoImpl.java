package com.example.splitterdatabase.Implementrepos;

import com.example.splitterdatabase.dao.GroupRepository;
import com.example.splitterdatabase.dto.group.Group;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class GroupRepoImpl {
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
