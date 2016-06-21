package com.example.repository;

import com.example.model.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 2016-06-18.
 */
@Repository
public interface PhotoRepository extends JpaRepository<Photo, String> {

    List<Photo> findByUserid(String userid);
}
