package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Integer count;

    public Pincode(){
        // default
    }

    public Pincode(String code, Integer count){
        this.code = code;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        // TODO: implement method!
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCount() {
        // TODO: implement method!
        return this.count;
    }

    public void setCount(Integer count){
        this.count = count;
    }
}
