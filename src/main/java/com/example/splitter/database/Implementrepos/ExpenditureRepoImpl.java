package com.example.splitter.database.Implementrepos;

import com.example.splitter.database.dao.ExpenditureRepository;
import com.example.splitter.database.dto.expenditure.Expenditure;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ExpenditureRepoImpl implements com.example.splitter.service.ExpenditureRepository {
    ExpenditureRepository repository;

    public ExpenditureRepoImpl(ExpenditureRepository repository) {
        this.repository = repository;
    }
    public Long save(Expenditure expenditure){
        return repository.save(expenditure).id();

    }

    public Optional<Expenditure> getExpenditureById(Long id){
        return repository.findById(id);
    }
}
