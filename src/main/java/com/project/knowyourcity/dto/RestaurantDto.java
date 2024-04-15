package com.project.knowyourcity.dto;

import com.project.knowyourcity.entity.Restaurant;
import lombok.*;

import java.util.List;

@Data
@Builder
public class RestaurantDto {
    public Integer restaurantId;
    public Integer cityId;
    public String name;
    public String address;
}