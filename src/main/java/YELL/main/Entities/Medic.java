package YELL.main.Entities;


import javax.persistence.*;

@Entity
@Table(name = "Medics")
public class Medic{

    /*
    TO DO:
    1. Data (name-lastName, address) integration from common account
    2.
     */

    @Id
    @GeneratedValue
    private long id;
    @OneToOne(optional = false, mappedBy="medic")
    public Account account;
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


}
