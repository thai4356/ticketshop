package web.thaiticketmajor.Models.user;



import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User
{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;

    private int       thuTu; 
    
    private String    gmail; 

    @Column(columnDefinition="LONGTEXT")
    private String    password; 

    @Transient
    private MultipartFile mtFile; 
    private LocalDate dob;
    private int phoneNo;
    private boolean status;
    private byte roleID;

}