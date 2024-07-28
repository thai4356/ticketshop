package web.thaiticketmajor.Models.bill;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import web.thaiticketmajor.Models.concert.Concert;
import web.thaiticketmajor.Models.user.User;

@Entity
@Getter
@Setter
public class Bill
{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;

    private int User_id;
    @ManyToOne @JoinColumn(name="user_id",insertable=false,updatable=false)
    private User user;

    private int Detail_id;
    @ManyToOne @JoinColumn(name="detail_id",insertable=false,updatable=false)
    private Concert Concert;

    private int total;
    private boolean status;
}  