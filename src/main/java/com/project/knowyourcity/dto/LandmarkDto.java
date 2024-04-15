package com.project.knowyourcity.dto;

import com.project.knowyourcity.entity.Restaurant;
import lombok.*;

import java.util.List;

@Data
@Builder
public class LandmarkDto {
    public Integer landmarkId;
    public Integer cityId;
    public String name;
    public String address;
}