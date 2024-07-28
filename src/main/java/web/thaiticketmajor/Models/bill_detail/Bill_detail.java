package web.thaiticketmajor.Models.bill_detail;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import web.thaiticketmajor.Models.bill.Bill;
import web.thaiticketmajor.Models.ticket.Ticket;

@Entity
@Getter
@Setter
public class Bill_detail
{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private    int id;
    private    int Billid;
    @ManyToOne @JoinColumn(name="bill_id",insertable=false,updatable=false)
    private Bill Bill;
    private    int Ticketid;
    @ManyToOne @JoinColumn(name="ticket_id",insertable=false,updatable=false)
    private Ticket Ticket;
}