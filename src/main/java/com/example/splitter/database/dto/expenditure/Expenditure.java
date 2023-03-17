package com.example.splitter.database.dto.expenditure;

import org.springframework.data.annotation.Id;

import java.util.Set;

// Ausgabe
public record Expenditure (
        @Id
        Long id,

        int expense, // Beitrag

        String description,

        Long payer, // bezaltvonUser also das ist die Id vom Member (user)

        Set<InvolvedParty> members  // beteiligte das sind die Id's vom Member
){
}
