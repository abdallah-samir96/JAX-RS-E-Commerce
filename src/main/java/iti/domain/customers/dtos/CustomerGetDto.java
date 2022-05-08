package iti.domain.customers.dtos;

import java.util.ArrayList;
import java.util.List;

import iti.domain.links.Link;

public class CustomerGetDto {
    
    private long id;
    private String name;
    private String email;
    private String gender;
    private List<Link> links = new ArrayList<>();

    public CustomerGetDto(){

    }
    public CustomerGetDto(long id, String name, String email, String gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
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
    public List<Link> getLinks() {
        return links;
  }

  public void setLinks(List<Link> links) {
        this.links = links;
  }
    @Override
    public String toString() {
        return "CustomerGetDto [email=" + email + ", gender=" + gender + ", id=" + id + ", name=" + name + "]";
    }


    


    
}
