package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private Integer number;
    @Getter
    private Integer balance;
    @Getter
    private Integer creditLimit;

    @ManyToOne
    @Getter
    private Pincode pincode;

    @ManyToOne
    @Getter
    private Bank owningBank;
}