package com.project.knowyourcity.dto;

import com.project.knowyourcity.entity.Restaurant;
import lombok.*;

import java.util.List;

@Data
@Builder
public class TransportationModeDto {
    public Integer transportationModeId;
    public String costLevel;
    public String mode;
}