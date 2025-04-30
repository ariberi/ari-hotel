package dev.ari.arihotel.data.repository;

import dev.ari.arihotel.data.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {


    Optional<Room> findByRoomNumberIgnoreCase(String roomNumber);


}
