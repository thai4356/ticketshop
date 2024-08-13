package web.thaiticketmajor.Models.concert;



import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import web.thaiticketmajor.Models.category.Category;

@Entity
@Getter
@Setter
public class Concert
{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;

    private String name; 
    private int Duration; 
    private LocalDate  startSale; 
    private LocalDate  endSale;  

    private LocalDate  startDate; 

    private String imgLink;
    private String videoLink;

    private boolean status;
    @Column(columnDefinition="LONGTEXT")
    private String    moTa; 

    @Transient
    private MultipartFile mtFile; 
    

    
    private int cat_id;
    @ManyToOne @JoinColumn(name="cat_id",insertable=false,updatable=false)
    private Category category;
    
}