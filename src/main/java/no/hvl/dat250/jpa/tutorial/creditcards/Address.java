package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;

    @ManyToMany(mappedBy = "addresses")
    private Collection<Customer> owners;

    public Address(){
        // Default constructor
    }

    public Address(String street, Integer number) {
        this.street = street;
        this.number = number;
    }

    public Long getId(){
        return id;
    }

    public String getStreet() {
        // TODO: implement method!
        return this.street;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public Integer getNumber() {
        // TODO: implement method!
        return this.number;
    }

    public void setNumber(Integer number){
        this.number = number;
    }

    public Collection<Customer> getOwners() {
        // TODO: implement method!
        return owners;
    }

    public void setOwners(Collection<Customer> owners){
        this.owners = owners;
    }
}
