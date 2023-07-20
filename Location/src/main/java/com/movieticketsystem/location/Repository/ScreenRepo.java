package com.movieticketsystem.location.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieticketsystem.location.Entities.Screen;

@Repository
public interface ScreenRepo extends JpaRepository<Screen,String> {

    Optional<Screen> findByScreenIdAndSeatsId(String screenId, String seatId);

    Optional<Screen> findByScreenName(String screenName);
    
}
