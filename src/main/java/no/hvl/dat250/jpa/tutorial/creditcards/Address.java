package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String street;
    @Getter
    private Integer number;

    public Collection<Customer> getOwners(){
        return new HashSet<>(customers);
    }

    @Getter
    @ManyToMany(mappedBy = "addresses")
    private Collection<Customer> customers;

}
