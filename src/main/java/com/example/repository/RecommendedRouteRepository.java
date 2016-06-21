package com.example.repository;

import com.example.model.RecommendedRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 2016-06-21.
 */
@Repository
public interface RecommendedRouteRepository extends JpaRepository<RecommendedRoute, String> {

    List<RecommendedRoute> findByUserid(String userid);
}