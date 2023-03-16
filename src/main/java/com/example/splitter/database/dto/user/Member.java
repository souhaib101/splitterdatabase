package com.example.splitter.database.dto.user;

import org.springframework.data.annotation.Id;

public record Member (
    @Id
    Long id,
    String github
    ){

}
