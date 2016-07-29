package com.example.beacon.infra;

import com.example.beacon.domain.Beacon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 2016-06-21.
 */
@Repository
public interface BeaconRepository extends JpaRepository<Beacon, String> {

}