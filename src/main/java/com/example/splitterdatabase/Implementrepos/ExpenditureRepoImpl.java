package com.example.splitterdatabase.Implementrepos;

import com.example.splitterdatabase.dao.ExpenditureRepository;
import com.example.splitterdatabase.dto.expenditure.Expenditure;
import com.example.splitterdatabase.dto.group.Group;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ExpenditureRepoImpl {
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
