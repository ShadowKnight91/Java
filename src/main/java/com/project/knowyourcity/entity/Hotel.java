package com.project.knowyourcity.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Hotel_id")
    private Integer hotelId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="City_id")
    private City city;
    @Column(name="Name")
    private String name;
    @Column(name="Address")
    private String address;
}
