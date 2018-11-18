package YELL.main.Entities;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "e_mail")
    private String email;
    @Column(name = "password")
    private String password;
    //@Column(name = "id_favourites")
    //private long favourites;

    public Account() {

    }

    public Account(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "Comment",
            joinColumns = { @JoinColumn(name = "id_account") },
            inverseJoinColumns = { @JoinColumn(name = "id_medic") })

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    /*public long getFavourites() {
        return favourites;
    }

    public void setFavourites(long favourites) {
        this.favourites = favourites;
    }*/

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
