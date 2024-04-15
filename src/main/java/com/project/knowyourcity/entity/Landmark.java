package com.project.knowyourcity.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Landmark")
public class Landmark {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Landmark_id")
    private Integer landmarkId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="City_id")
    private City city;
    @Column(name="Name")
    private String name;
    @Column(name="Address")
    private String address;
}
