package YELL.main.domain;

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
public class AccountMedic implements Serializable {

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

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "address")
    private String adress;

    @Column(name = "info")
    private String info;

    @Column(name = "verification")
    private Boolean verification;

    @Column(name = "category")
    private Categories category;

    @OneToMany(mappedBy = "id")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Comment> comments = new HashSet<>();

//    @OneToMany(mappedBy = "id")
//    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//    private Set<AccountMedic> favourites = new HashSet<>();


    public AccountMedic() {
    }

    public AccountMedic(String name, String surname, String telephone, String eMail, String password, Integer experience, String adress, String info, Boolean verification, Categories category, Set<Comment> comments) {
//        this.favourites = favourites;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.eMail = eMail;
        this.password = password;
        this.experience = experience;
        this.adress = adress;
        this.info = info;
        this.verification = verification;
        this.category = category;
        this.comments = comments;
    }

    /**
     * CATEGORY
     *
     * @return
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountMedic id(Long id) {
        this.id = id;
        return this;
    }
    /**
     * CATEGORY
     *
     * @return
     */
    public Categories getCategory() {
        return category;
    }

    public AccountMedic category(Categories category) {
        this.category = category;
        return this;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

//    /**
//     * FAVOURITES
//     *
//     * @return
//     */
//    public Set<AccountMedic> getFavourites() {
//        return favourites;
//    }
//
//    public void setFavourites(Set<AccountMedic> favourites) {
//        this.favourites = favourites;
//    }
//
//    public AccountMedic favourites(Set<AccountMedic> favourites) {
//        this.favourites = favourites;
//        return this;
//    }

    /**
     * NAME
     *
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountMedic name(String name) {
        this.name = name;
        return this;
    }

    /**
     * SURNAME
     *
     * @return
     */
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public AccountMedic surname(String surname) {
        this.surname = surname;
        return this;
    }

    /**
     * TELEPHONE
     *
     * @return
     */
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public AccountMedic telephone(String surname) {
        this.telephone = telephone;
        return this;
    }

    /**
     * MAIL
     *
     * @return
     */
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public AccountMedic mail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    /**
     * PASSWORD
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountMedic password(String password) {
        this.password = password;
        return this;
    }

    /**
     * VERIFICATION
     *
     * @return
     */
    public Boolean getVerification() {
        return verification;
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

    /**
     * EXPERIENCE
     *
     * @return
     */
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

    /**
     * ADRESS
     *
     * @return
     */
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

    /**
     * INFO
     *
     * @return
     */
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

    /**
     * COMMENTS
     *
     * @return
     */
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
        return "AccountMedic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                ", experience=" + experience +
                ", adress='" + adress + '\'' +
                ", info='" + info + '\'' +
                ", verification=" + verification +
                ", category=" + category +
                ", comments=" + comments +
//                ", favourites=" + favourites +
                '}';
    }
}
