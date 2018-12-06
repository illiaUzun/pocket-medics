package YELL.main.Entities;

//import javax.annotation.processing.Generated;

import javax.persistence.*;
import java.util.Set;
//import java.util.Optional;

@Entity
@Table(name = "account")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class Account {

    /*@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;*/
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @Id
    private long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_medic", unique = true, nullable = false, updatable = false)
    private Medic medic;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "account")
    private Set<Favorites> favorites;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "account")
    private Set<Comment>comments;


    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "SECONDNAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;

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

