package com.example.splitterdatabase.dao;

import com.example.splitterdatabase.dto.expenditure.Expenditure;
import org.springframework.data.repository.CrudRepository;

public interface ExpenditureRepository extends CrudRepository<Expenditure, Long> {
}
