package com.bank.accounts.details;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "balance")
    private Long balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public Account(){}

    public Account(String type, Long balance){
        this.type = type;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance)
    {
        this.balance = balance;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
}
