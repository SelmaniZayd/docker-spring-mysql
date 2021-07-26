package com.projet.projetdevops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.projetdevops.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
