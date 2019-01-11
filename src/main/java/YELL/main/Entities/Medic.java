package YELL.main.Entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "medic")
public class Medic {

    /**
    * TO DO:
    * 1. Data (name-lastName, address) integration from common account
    * 2. Add telephone number/email?
    */

    @Id
    @Column(name = "id")
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Account account;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "medic")
    private Set<Comment> users;


    @Column(name = "address")
    private String address;
    @Column(name = "category")
    private String category;
    @Column(name = "experience")
    private double yearsOfExperience;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public Medic(String address, String category, double yearsOfExperience, String firstName, String lastName) {
        this.address = address;
        this.category = category;
        this.yearsOfExperience = yearsOfExperience;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Medic() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(double yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Comment> getUsers() {
        return users;
    }

    public void setUsers(Set<Comment> users) {
        this.users = users;
    }
}
