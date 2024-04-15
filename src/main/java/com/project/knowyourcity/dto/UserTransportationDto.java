package com.project.knowyourcity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserTransportationDto {
    public Integer id;
    public Integer transportationId;
    public Integer userId;
}