package YELL.main.Entities;

import javax.persistence.*;

@Entity
@Table(name = "comments_")
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue
    private long id;
    @Column(name = "address")
    public long accountId;
    @Column(name = "address")
    private String comment;

    public Comment(long accountId, String comment) {
        this.accountId = accountId;
        this.comment = comment;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

