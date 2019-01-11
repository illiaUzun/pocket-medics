package YELL.main.Entities;

import javax.persistence.*;
import java.util.ArrayList;

@Entity(name = "Account")
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private long account_id;

    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "SECONDNAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FAVOURITES")
    private ArrayList<Medic> favourites;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public ArrayList<Medic> getFavourites() {
        return favourites;
    }

    public void setFavourites(ArrayList<Medic> favourites) {
        this.favourites = favourites;
    }

    //    public List<Favorites> getFavorites() {
//        return favorites;
//    }
//
//    public void setFavorites(List<Favorites> favorites) {
//        this.favorites = favorites;
//    }

    public Account() {
    }

    public Account(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    /*Связи бд*/

//    @OneToMany(
//            mappedBy = "account",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//
//    private List<Favorites> favorites = new ArrayList<>();
//
//    public void addFavorite(Favorites medic) {
//        favorites.add(medic);
//        medic.setAccount(this);
//    }
//
//    public void removeFavorite(Favorites medic) {
//        favorites.remove(medic);
//        medic.setAccount(null);
//    }


}