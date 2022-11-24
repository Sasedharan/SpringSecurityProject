package com.em.ProjectSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
    private Long id;
    private String userID;
    private String pwd;
    private String name;
    private Long age;
    private String emailID;
    private String address;
    private Long code;
}


