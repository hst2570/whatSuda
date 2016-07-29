package com.example.response.infra;

import com.example.response.domain.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 2016-06-18.
 */

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

    List<Photo> findByUserid(String userid);
}
