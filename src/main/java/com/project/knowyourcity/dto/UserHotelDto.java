package com.project.knowyourcity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserHotelDto {
    public Integer id;
    public Integer hotelId;
    public Integer userId;
}