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

    @ManyToOne
    @JoinColumn(name = "co_user")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
