package com.demo.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class GetStudentDto {
    private UUID id;
    private String nameAndSurname;
    private String userName;
}