package com.project.knowyourcity.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="City")
public class City {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="City_id")
    private Integer CityId;
    @Column(name="Name")
    private String Name;
    @Column(name="State")
    private String State;
}
