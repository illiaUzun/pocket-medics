package YELL.main.Entities;

import javax.persistence.*;

@Embeddable
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue
    private long id;
    @Column(name = "accountId")
    public long accountId;
    @Column(name = "comment")
    private String comment;

    public Comment() {
    }

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

