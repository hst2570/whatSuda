package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long>{

}
