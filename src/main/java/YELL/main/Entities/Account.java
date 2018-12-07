package YELL.main.Entities;

//import javax.annotation.processing.Generated;

import javax.persistence.*;
import java.util.Set;
//import java.util.Optional;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "account", unique = true, nullable = false, updatable = false)
    private Medic medic;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "account")
    private Set<Favorites> favorites;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "account")
    private Set<Comment>comments;


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

    /*
    Методы для связей в БД
     */

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public Set<Favorites> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorites> favorites) {
        this.favorites = favorites;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
