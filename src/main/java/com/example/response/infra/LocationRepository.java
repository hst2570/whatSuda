package com.example.response.infra;

import com.example.response.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 2016-06-18.
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
