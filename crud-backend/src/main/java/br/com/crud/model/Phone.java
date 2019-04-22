package br.com.crud.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_PHONE")
public class Phone {

    @Id
    @Column(name = "CO_PHONE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ddd;

    private Long number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDdd() {
        return ddd;
    }

    public void setDdd(Long ddd) {
        this.ddd = ddd;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

}
