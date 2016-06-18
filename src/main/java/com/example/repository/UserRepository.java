package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 2016-06-18.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

}