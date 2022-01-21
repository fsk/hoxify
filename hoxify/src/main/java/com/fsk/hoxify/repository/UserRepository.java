package com.fsk.hoxify.repository;


import com.fsk.hoxify.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
