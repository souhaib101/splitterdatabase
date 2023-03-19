package com.example.splitter.database.Implementrepos;

import com.example.splitter.database.dao.GroupRepository;
import com.example.splitter.database.dto.group.Groups;

import com.example.splitter.service.GroupRepoitory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GroupRepoImpl implements GroupRepoitory {
    GroupRepository repository;

    public GroupRepoImpl(GroupRepository repository) {
        this.repository = repository;
    }

    public Groups save(Groups group){
        return repository.save(group);
    }

    public Optional<Groups> getGroupById(Long id){
        return repository.findById(id);
    }

    @Override
    public List<Groups> getGroupsForMember(Long memberId) {
        return repository.findGroupsForMember(memberId);
    }
}
