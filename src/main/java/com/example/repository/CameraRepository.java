package com.example.repository;

import com.example.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 2016-06-18.
 */
@Repository
public interface CameraRepository extends JpaRepository<Camera, String> {

}