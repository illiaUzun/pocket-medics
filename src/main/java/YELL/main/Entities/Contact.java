package YELL.main.Entities;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue
    private long id_Contact;
    private long id_Account;
    @Column(name = "user_comment")
    private String comment;


}
