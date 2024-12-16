package com.example.lab78.Entity;
import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "bai_hat")
public class BaiHat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "ten_bai_hat")
    String ten;
    @Column(name = "thoi_luong")
    Integer thoiLuong;
    @Column(name = "gia")
    Double gia;
    @ManyToOne
    @JoinColumn(name = "ca_si_id", referencedColumnName = "id")
    CaSi cs;
    @Column(name = "ngay_ra_mat")
    String ngayRaMat;
}
