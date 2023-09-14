package no.hvl.dat250.jpa.tutorial.creditcards.driver;
import no.hvl.dat250.jpa.tutorial.creditcards.*;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
    // Create Pincode for the first card
    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);
    em.persist(pincode);

    // Create Bank
    Bank bank = new Bank();
    bank.setName("Pengebank");
    em.persist(bank);

    // Create Address
    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);
    em.persist(address);

    // Create Customer
    Customer customer = new Customer();
    customer.setName("Max Mustermann");
    //address.getOwners().add(customer);
    customer.getAddresses().add(address);
    em.persist(customer);

    //System.out.println("owner: " +  address.getOwners());

    // Create First CreditCard
    CreditCard firstCard = new CreditCard();
    firstCard.setNumber(12345);
    firstCard.setBalance(-5000);
    firstCard.setCreditLimit(-5000);
    firstCard.setPincode(pincode);
    firstCard.setOwningBank(bank);
    customer.getCreditCards().add(firstCard);
    em.persist(firstCard);

    // Create Second CreditCard
    CreditCard secondCard = new CreditCard();
    secondCard.setNumber(123);
    secondCard.setBalance(1);
    secondCard.setCreditLimit(2000);
    secondCard.setPincode(pincode);
    secondCard.setOwningBank(bank);
    customer.getCreditCards().add(secondCard);
    em.persist(secondCard);
  }

}
