package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "customer_address",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private Collection<Address> addresses;

    @ManyToMany
    @JoinTable(
            name = "customer_address",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private Collection<CreditCard> creditCards;

    public Customer(){
        // default
    }

    public Customer(String name){
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

    public Collection<Address> getAddresses() {
        // TODO: implement method!
        return this.addresses;
    }

    public void setAddresses(Collection<Address> addresses){
        this.addresses = addresses;
    }

    public Collection<CreditCard> getCreditCards() {
        // TODO: implement method!
        return this.creditCards;
    }

    public void setCreditCards(Collection<CreditCard> creditCards){
        this.creditCards = creditCards;
    }
}
