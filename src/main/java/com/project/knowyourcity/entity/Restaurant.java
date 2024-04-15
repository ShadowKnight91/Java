package com.project.knowyourcity.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Restaurant_id")
    private Integer RestaurantId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="City_id")
    private City city;
    @Column(name="Name")
    private String name;
    @Column(name="Address")
    private String address;
}
