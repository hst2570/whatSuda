package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

}
