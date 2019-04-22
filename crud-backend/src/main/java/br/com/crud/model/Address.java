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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
