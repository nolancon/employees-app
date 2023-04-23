package com.bank.accounts.details;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    private String branch;
    private String email;

    public Customer(){}

    public Customer(String email, String name, String branch) {    
        this.name = name;
    	this.email = email;
    	this.branch = branch;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String getBranch(){
        return branch;
    }

    public void setBranch(String branch){
        this.branch = branch;
    }
}
