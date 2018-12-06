package YELL.main.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Comment")
public class Comment {


    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "id_medic")
    private long medicId;
    @Column(name = "id_account")
    private long accountId;
    @Column(name = "comment")
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    public Comment(long medicId, long accountId, String comment) {
        this.medicId = medicId;
        this.accountId = accountId;
        this.comment = comment;
    }

    public long getMedicId() {
        return medicId;
    }

    public void setMedicId(long medicId) {
        this.medicId = medicId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public Comment() {
    }


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
}
