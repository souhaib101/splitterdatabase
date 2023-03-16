package com.example.splitter.service;

import com.example.splitter.database.dto.group.Groups;

import java.util.Optional;

public interface GroupRepoitory {
    public Groups save(Groups group);
    public Optional<Groups> getGroupById(Long id);
}
