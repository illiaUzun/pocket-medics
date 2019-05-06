package YELL.main.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Comment.
 */
@Entity
@Table(name = "comment")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "patient_id")
    private Integer patientID;

    @Column(name = "anonymous")
    private Boolean anonymous;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "text")
    private String text;

    public Comment() {
    }

    public Comment(Integer patientID, Boolean anonymous, Integer rating, String text) {
        this.patientID = patientID;
        this.anonymous = anonymous;
        this.rating = rating;
        this.text = text;
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public Comment patientID(Integer patientID) {
        this.patientID = patientID;
        return this;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public Boolean isAnonymous() {
        return anonymous;
    }

    public Comment anonymous(Boolean anonymous) {
        this.anonymous = anonymous;
        return this;
    }

    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }

    public Integer getRating() {
        return rating;
    }

    public Comment rating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public Comment text(String text) {
        this.text = text;
        return this;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public Comment id(Long id) {
        this.id = id;
        return this;
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
        Comment comment = (Comment) o;
        if (comment.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), comment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Comment{" +
            "id=" + getId() +
            ", patientID=" + getPatientID() +
            ", anonymous='" + isAnonymous() + "'" +
            ", rating=" + getRating() +
            ", text='" + getText() + "'" +
            "}";
    }
}
