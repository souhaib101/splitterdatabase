package com.example.splitter.service;

import com.example.splitter.database.dto.group.Group;

import java.util.Optional;

public interface GroupRepoitory {
    public Long save(Group group);
    public Optional<Group> getGroupById(Long id);
}
