//ПОМОЙКА


//package YELL.main.Entities;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "Favorites")
//
//public class Favorites{
//
//    @Id
//    @GeneratedValue
//    private long id_favorites;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "account_id")
//    private Account account;
//
//    @OneToOne(optional = false)
//    @JoinColumn(name="id_medic", unique = true, nullable = false, updatable = false)
//    private Medic medic;
//
//
//    @Column(name = "user_comment")
//    private String comment;
//
//    //храним объекты или их id??
//
//    public Favorites(Account account, Medic medic, String comment) {
//        this.account = account;
//        this.medic = medic;
//        this.comment = comment;
//    }
//
//    public long getId_favorites() {
//        return id_favorites;
//    }
//
//    public void setId_favorites(long id_favorites) {
//        this.id_favorites = id_favorites;
//    }
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    public Medic getMedic() {
//        return medic;
//    }
//
//    public void setMedic(Medic medic) {
//        this.medic = medic;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//}