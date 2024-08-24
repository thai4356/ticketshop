package web.thaiticketmajor.Models.seat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat
{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private    int id;
    private String row; 
    private String column; 
    private boolean status;
}