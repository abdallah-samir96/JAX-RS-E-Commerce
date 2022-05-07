package iti.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @ManyToMany(fetch =  FetchType.EAGER)
    private List<Order> orders ;
    private String name;
    private String email;
    private String gender;


    public Customer(){

    }
    public Customer(List<Order> orders, String name, String email, String gender) {
        this.orders = orders;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
    
    public List<Order> getOrders() {
        return orders;
    }

   

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    
}
