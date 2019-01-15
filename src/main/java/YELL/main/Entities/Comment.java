package YELL.main.Entities;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue
    private long id;
    //@Column(name = "accountId")
    //public long accountId;
    @Column(name = "comment")
    private String comment;

    @OneToOne(mappedBy = "comment", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Comment() {
    }

    public Comment(long accountId, String comment) {
        //this.accountId = accountId;
        this.comment = comment;
    }

//    public long getAccountId() {
//        return accountId;
//    }
//
//    public void setAccountId(long accountId) {
//        this.accountId = accountId;
//    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

