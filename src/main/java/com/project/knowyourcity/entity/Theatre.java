package com.project.knowyourcity.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Theatre")
public class Theatre {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Theatre_id")
    private Integer theatreId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="City_id")
    private City city;
    @Column(name="Name")
    private String name;
    @Column(name="Address")
    private String address;
}
