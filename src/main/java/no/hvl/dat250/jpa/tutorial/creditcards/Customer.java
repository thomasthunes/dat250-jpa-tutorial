package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.ArrayList;
import java.util.Collection;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @Getter
    private Collection<Address> addresses = new ArrayList<>();

    @ManyToMany
    @Getter
    private Collection<CreditCard> creditCards = new ArrayList<>();
}