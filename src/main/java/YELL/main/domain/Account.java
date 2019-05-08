package YELL.main.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A AccountM.
 */
@Entity
@Table(name = "account")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "e_mail")
    private String eMail;

    @Column(name = "jhi_password")
    private String password;

//    @OneToMany(mappedBy = "id")
//    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//    private Set<AccountMedic> favourites = new HashSet<>();

    public Account() {
    }

    public Account(String name, String surname, String telephone, String eMail, String password, Set<AccountMedic> favourites) {
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.eMail = eMail;
        this.password = password;
//        this.favourites = favourites;
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove

    /**
     * ID
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * NAME
     *
     * @return
     */
    public String getName() {
        return name;
    }

    public Account name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * SURNAME
     *
     * @return
     */
    public String getSurname() {
        return surname;
    }

    public Account surname(String surname) {
        this.surname = surname;
        return this;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * TELEPHONE
     *
     * @return
     */
    public String getTelephone() {
        return telephone;
    }

    public Account telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * MAIL
     *
     * @return
     */
    public String geteMail() {
        return eMail;
    }

    public Account eMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * PASSWORD
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    public Account password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    /**
//     * FAVOURITES
//     *
//     * @return
//     */
//    public Account favourites(Set<AccountMedic> favourites) {
//        this.favourites = favourites;
//        return this;
//    }
//
//    public Account addFavourites(AccountMedic favourite) {
//        this.favourites.add(favourite);
//        return this;
//    }
//
//    public Account removeFavourites(AccountMedic favourite) {
//        this.favourites.remove(favourite);
//        return this;
//    }
//
//    public void setFavourites(Set<AccountMedic> favourites) {
//        this.favourites = favourites;
//    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account accountM = (Account) o;
        if (accountM.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), accountM.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AccountM{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                ", surname='" + getSurname() + "'" +
                ", telephone='" + getTelephone() + "'" +
                ", eMail='" + geteMail() + "'" +
                ", password='" + getPassword() + "'" +
                "}";
    }
}
