package iti.domain.customers.dtos;

public class CustomerGetDto {
    
    private long id;
    private String name;
    private String email;
    private String gender;

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
    @Override
    public String toString() {
        return "CustomerGetDto [email=" + email + ", gender=" + gender + ", id=" + id + ", name=" + name + "]";
    }


    


    
}
