package YELL.main.Entities;

//import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
//import java.util.Optional;

@Entity
@Table(name = "Comment")
public class Comment {


    @Id
    @Column(name = "id")
    private long id;


    @ManyToOne (fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_account", nullable = false)
    private Account account;
    @ManyToOne (fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_medic", nullable = false)
    public Medic medic;


    @Column(name = "comment")
    private String comment;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }
}

