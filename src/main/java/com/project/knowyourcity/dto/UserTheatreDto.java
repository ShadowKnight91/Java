package com.project.knowyourcity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserTheatreDto {
    public Integer id;
    public Integer theatreId;
    public Integer userId;
}