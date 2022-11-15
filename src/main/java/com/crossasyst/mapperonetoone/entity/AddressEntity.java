package com.crossasyst.mapperonetoone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    @Column(name = "address_1")
    private String address1;
    @Column(name = "address_2")
    private String address2;
    private String city;
    private String state;
    @Column(name = "zip_Code")
    private String zipCode;


    @OneToOne(mappedBy = "address")
    @PrimaryKeyJoinColumn

    private PersonEntity personEntity;
}
