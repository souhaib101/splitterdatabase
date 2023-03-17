package com.example.splitter.database.dto.group;

import org.springframework.data.annotation.Id;

import java.util.Set;

//Gruppe

public record Groups(
    @Id
    Long id,

    String name,

    Boolean open,

    Set<Memberref> members, //Mitglieder

    Set<Expenditureref> expenditures
){
}
