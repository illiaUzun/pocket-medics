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
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class AccountMedic extends Account implements Serializable {

    private static final long serialVersionUID = 1L;

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
