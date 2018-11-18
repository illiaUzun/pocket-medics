package YELL.main.Entities;

import lombok.experimental.Helper;

//import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name = "Profile")
public class Profile {

    @Id
    @GeneratedValue
    private long id_Profile;
    private long id_Account;
    private long id_Leaf;
    @Column(name = "user_comment")
    private String comment;


}
