package com.example.repository;

import com.example.model.Beacon;
import com.example.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 2016-06-21.
 */
@Repository
public interface StoryRepository extends JpaRepository<Story, String> {

    Story findByBeacon(Beacon beacon);
}
