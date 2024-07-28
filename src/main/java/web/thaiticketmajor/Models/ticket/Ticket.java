package web.thaiticketmajor.Models.ticket;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import web.thaiticketmajor.Models.concert.Concert;
import web.thaiticketmajor.Models.seat.Seat;
import web.thaiticketmajor.Models.zone.Zone;

@Entity
@Getter
@Setter
public class Ticket
{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    private int Concert_id;
     @ManyToOne @JoinColumn(name="Concert_id",insertable=false,updatable=false)
    private Concert concert;
    
    private int Zone_id;
    @ManyToOne @JoinColumn(name="Zone_id",insertable=false,updatable=false)
    private Zone zone;

    private int Seat_id;
    @ManyToOne @JoinColumn(name="Seat_id",insertable=false,updatable=false)
    private Seat seat;
}