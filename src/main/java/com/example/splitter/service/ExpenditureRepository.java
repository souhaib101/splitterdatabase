package com.example.splitter.service;

import com.example.splitter.database.dto.expenditure.Expenditure;

import java.util.Optional;

public interface ExpenditureRepository {
    public Long save(Expenditure expenditure);
    public Optional<Expenditure> getExpenditureById(Long id);
}
