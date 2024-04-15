package com.project.knowyourcity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLandmarkDto {
    public Integer id;
    public Integer landmarkId;
    public Integer userId;
}