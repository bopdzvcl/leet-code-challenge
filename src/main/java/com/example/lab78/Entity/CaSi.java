package com.example.lab78.Entity;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "ca_si")
public class CaSi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "ten_ca_si")
    String ten;
}
