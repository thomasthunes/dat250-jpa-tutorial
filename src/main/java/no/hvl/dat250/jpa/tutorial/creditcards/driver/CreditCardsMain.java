package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;
import org.hibernate.mapping.Collection;

import java.util.ArrayList;
import java.util.List;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    // TODO: Create object world as shown in the README.md.
    // create customers
    Customer customer = new Customer("Max Mustermann");

    // create adresses
    Address address = new Address("Inndalsveien", 28);
    List<Customer> addressOwners = new ArrayList<>();
    addressOwners.add(customer);
    address.setOwners(addressOwners);

    // Set the address for the customer
    List<Address> customerAddresses = new ArrayList<>();
    customerAddresses.add(address);
    customer.setAddresses(customerAddresses);


    // Create credit cards
    CreditCard firstCard = new CreditCard(12345, -5000, -5000);
    Pincode firstPin = new Pincode("123", 1);
    firstCard.setPincode(firstPin);
    Bank owningBank = new Bank("Pengebank");
    firstCard.setOwningBank(owningBank);

    CreditCard secondCard = new CreditCard(34252, 5000, 5000);
    Pincode secondPin = new Pincode("3323", 1);
    firstCard.setPincode(secondPin);
    firstCard.setOwningBank(owningBank);

    /*List<CreditCard> customerCards = new ArrayList<>();
    customerCards.add(firstCard);
    customerCards.add(secondCard);
    customer.setCreditCards(customerCards);*/

    System.out.println("Adresses: " + customer.getAddresses());
    System.out.println("Adresses count: " + customer.getAddresses().size());
    System.out.println("Adresses owners: " + address.getOwners());



    // Persist the objects to the database
    //em.getTransaction().begin();
    em.persist(customer);
    em.persist(address);
    em.persist(firstPin);
    em.persist(secondPin);
    em.persist(owningBank);
    em.persist(firstCard);
    em.persist(secondCard);
    //em.getTransaction().commit();
  }
}
