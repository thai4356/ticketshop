package web.thaiticketmajor.Models.concert;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int Duration;
    private LocalDate startSale;
    private LocalDate endSale;
    private LocalDate startDate;
    private String videoLink;
    private boolean status;
    @Column(columnDefinition = "LONGTEXT")
    private String moTa;
    public int Popularity;
}