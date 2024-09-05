package web.thaiticketmajor.Models.image;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import web.thaiticketmajor.Models.concert.Concert;

@Entity
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String img;
    @ManyToOne
    @JoinColumn(name = "ConcertID", insertable = false, updatable = false)
    private Concert concert;
    boolean type;
}