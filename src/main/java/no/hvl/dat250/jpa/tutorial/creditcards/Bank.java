package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Getter
@Setter
@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String name;

    public Collection<CreditCard> getOwnedCards(){
        return new HashSet<>(ownedCards);
    }

    @Getter
    @OneToMany(mappedBy = "owningBank")
    private Collection<CreditCard> ownedCards;
}