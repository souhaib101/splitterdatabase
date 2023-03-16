package com.example.splitter.database.dao;

import com.example.splitter.database.dto.expenditure.Expenditure;
import org.springframework.data.repository.CrudRepository;

public interface ExpenditureRepository extends CrudRepository<Expenditure, Long> {
}
