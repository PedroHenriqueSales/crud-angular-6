package br.com.crud.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_ADDRESS")
public class Address {

    @Id
    @Column(name = "CO_ADDRESS")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    private String number;

}
