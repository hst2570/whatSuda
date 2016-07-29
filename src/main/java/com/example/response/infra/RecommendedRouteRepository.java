package com.example.response.infra;

import com.example.response.domain.RecommendedRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 2016-06-21.
 */
@Repository
public interface RecommendedRouteRepository extends JpaRepository<RecommendedRoute, Long> {

    List<RecommendedRoute> findByUserid(String userid);
}