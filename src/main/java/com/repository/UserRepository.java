package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
