package YELL.main.Entities;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue
    private long id_Profile;
    private long id_Account;
    private long id_Leaf;
    @Column(name = "user_comment")
    private String comment;


}
