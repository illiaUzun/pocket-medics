package YELL.main.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A AccountMedic.
 */
@Entity
@Table(name = "account_medic")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AccountMedic extends Account implements Serializable {

    private static final long serialVersionUID = 1L;


//    @ElementCollection
    @OneToMany(mappedBy = "id")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<AccountMedic> favourites = new HashSet<>();

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "adress")
    private String adress;

    @Column(name = "info")
    private String info;

    @Column(name = "verification")
    private Boolean verification;

    @Column(name = "catagory")
    private Catagories catagory;

    @OneToMany(mappedBy = "id")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Comment> comments = new HashSet<>();

    public Catagories getCatagory() {
        return catagory;
    }

    public AccountMedic catagory(Catagories catagory) {
        this.catagory = catagory;
        return this;
    }

    public AccountMedic() {
    }

    public AccountMedic(String name, String surname, String telephone, String eMail, String password, Set<AccountMedic> favourites, Integer experience, String adress, String info, Boolean verification, Catagories catagory, Set<Comment> comments) {
        super(name, surname, telephone, eMail, password, favourites);
        this.experience = experience;
        this.adress = adress;
        this.info = info;
        this.verification = verification;
        this.catagory = catagory;
        this.comments = comments;
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Account name(String name) {
        return super.name(name);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public Account surname(String surname) {
        return super.surname(surname);
    }

    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
    }

    @Override
    public String getTelephone() {
        return super.getTelephone();
    }

    @Override
    public Account telephone(String telephone) {
        return super.telephone(telephone);
    }

    @Override
    public void setTelephone(String telephone) {
        super.setTelephone(telephone);
    }

    @Override
    public String geteMail() {
        return super.geteMail();
    }

    @Override
    public Account eMail(String eMail) {
        return super.eMail(eMail);
    }

    @Override
    public void seteMail(String eMail) {
        super.seteMail(eMail);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public Account password(String password) {
        return super.password(password);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public Account favourites(Set<AccountMedic> favourites) {
        return super.favourites(favourites);
    }

    @Override
    public Account addFavourites(AccountMedic favourite) {
        return super.addFavourites(favourite);
    }

    @Override
    public Account removeFavourites(AccountMedic favourite) {
        return super.removeFavourites(favourite);
    }

    @Override
    public void setFavourites(Set<AccountMedic> favourites) {
        super.setFavourites(favourites);
    }

    public void setCatagory(Catagories catagory) {
        this.catagory = catagory;
    }

    public Integer getExperience() {
        return experience;
    }

    public AccountMedic experience(Integer experience) {
        this.experience = experience;
        return this;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getAdress() {
        return adress;
    }

    public AccountMedic adress(String adress) {
        this.adress = adress;
        return this;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getInfo() {
        return info;
    }

    public AccountMedic info(String info) {
        this.info = info;
        return this;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean isVerification() {
        return verification;
    }

    public AccountMedic verification(Boolean verification) {
        this.verification = verification;
        return this;
    }

    public void setVerification(Boolean verification) {
        this.verification = verification;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public AccountMedic comments(Set<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public AccountMedic addComment(Comment comment) {
        this.comments.add(comment);
        return this;
    }

    public AccountMedic removeComment(Comment comment) {
        this.comments.remove(comment);
        comment.setId(null);
        return this;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }


    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountMedic accountMedic = (AccountMedic) o;
        if (accountMedic.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), accountMedic.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AccountMedic{" +
            "id=" + getId() +
            ", catagory=" + getCatagory() +
            ", experience=" + getExperience() +
            ", adress='" + getAdress() + "'" +
            ", info='" + getInfo() + "'" +
            ", verification='" + isVerification() + "'" +
            "}";
    }
}
