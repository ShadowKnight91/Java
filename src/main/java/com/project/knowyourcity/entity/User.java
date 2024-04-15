package com.project.knowyourcity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="User_id")
    private Integer UserId;
    @Column(name="Name")
    private String Name;
    @Column(name="Email")
    private String Email;
    @Column(name="Password")
    private String Password;
    @Column(name="Role")
    private String Role; 
}
