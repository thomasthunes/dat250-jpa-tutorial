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
    private Integer number;
    private Integer balance;
    private Integer creditLimit;

    @ManyToOne
    @JoinColumn(name = "pincode_id")
    private Pincode pincode;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank owningBank;

    public CreditCard(){
        // default
    }

    public CreditCard(Integer number, Integer balance, Integer creditLimit){ //, Pincode pincode, Bank owningBank){
        this.number = number;
        this.balance = balance;
        this.creditLimit = creditLimit;
        //this.pincode = pincode;
        //this.owningBank = owningBank;
    }

    public Integer getNumber() {
        // TODO: implement method!
        return this.number;
    }

    public void setNumber(Integer number){
        this.number = number;
    }

    public Integer getBalance() {
        // TODO: implement method!
        return this.balance;
    }
    public void setBalance(Integer balance){
        this.balance = balance;
    }


    public Integer getCreditLimit() {
        // TODO: implement method!
        return this.creditLimit;
    }

    public void setCreditLimit(Integer creditLimit){
        this.creditLimit = creditLimit;
    }

    public Pincode getPincode() {
        // TODO: implement method!
        return this.pincode;
    }

    public void setPincode(Pincode pincode){
        this.pincode = pincode;
    }

    public Bank getOwningBank() {
        // TODO: implement method!
        return this.owningBank;
    }

    public void setOwningBank(Bank bank){
        this.owningBank = bank;
    }
}
