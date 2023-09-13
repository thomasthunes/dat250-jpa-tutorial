package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.text.CollationElementIterator;
import java.util.Collection;
import java.util.List;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "owningBank")
    private Collection<CreditCard> ownedCards;

    public Bank(){
        // Default
    }

    public Bank(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        // TODO: implement method!
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Collection<CreditCard> getOwnedCards() {
        // TODO: implement method!
        return ownedCards;
    }

    public void setOwnedCards(Collection<CreditCard> ownedCards){
        this.ownedCards = ownedCards;
    }
}
