package web.thaiticketmajor.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import web.thaiticketmajor.Models.Concert;

public interface KdlConcert extends JpaRepository<Concert, Integer>
{

}
