package com.project.knowyourcity.dto;

import lombok.*;

@Data
@Builder
public class UserDto {
    public Integer userId;
    public String name;
    public String email;
    public String password;
    public String role;
}