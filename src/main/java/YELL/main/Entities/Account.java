package YELL.main.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    /**
     * @Column(name = "FAVOURITES")
     */
    @ElementCollection
    @CollectionTable(name = "favourites", joinColumns = @JoinColumn(name = "account_id"))
    @Column(name = "favourite_medic")
    private List<Medic> favourites = new ArrayList<>();


    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Medic medic;

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

    public List<Medic> getFavourites() {
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