package com.example.splitter.database.dto.group;

import org.springframework.data.annotation.Id;

import java.util.Set;

//Gruppe
public record Group(
    @Id
    Long id,

    String name,
    Set<Memberref> members, //Mitglieder
    Set<Expenditureref> expenditures
){ //Ausgaben
}
