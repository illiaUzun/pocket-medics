package YELL.main.Entities;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name = "DefaultUser")
public class Account {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "iq")
    private int iq;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "e_mail")
    private String email;

    public Account() {

    }

    public Account(int iq, String firstName, String lastName, String email) {
        this.iq = iq;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
