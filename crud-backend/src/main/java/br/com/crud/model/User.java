package br.com.crud.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_USER")
public class User {

    @Id
    @Column(name = "CO_USER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long age;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Phone> phones;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CO_ADDRESS")
    private Address address;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
