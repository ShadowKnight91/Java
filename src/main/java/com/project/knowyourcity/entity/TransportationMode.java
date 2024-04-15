package com.project.knowyourcity.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Transportation_Mode")
public class TransportationMode {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Transportation_Mode_id")
    private Integer transportationModeId;
    @Column(name="Mode")
    private String mode;
    @Column(name="Cost_Level")
    private String costLevel;

}
