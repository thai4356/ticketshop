package web.thaiticketmajor.Repositories;

//package Tên_Công_ty.Tên_Dự_Án.Kdl;

//import Tên_Công_ty.Tên_Dự_Án.Tdl.Thực_Thể;

import org.springframework.data.jpa.repository.JpaRepository;

import web.thaiticketmajor.Models.User;

public interface KdlUser extends JpaRepository<User, Integer>
{

}