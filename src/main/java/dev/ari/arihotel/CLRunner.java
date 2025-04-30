package dev.ari.arihotel;

import dev.ari.arihotel.data.entity.Reservation;
import dev.ari.arihotel.data.entity.Room;
import dev.ari.arihotel.data.repository.ReservationRepository;
import dev.ari.arihotel.data.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;
    private static final Logger log = LoggerFactory.getLogger(CLRunner.class);

    public CLRunner(RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("Rooms querys...");

        List<Room> rooms = roomRepository.findAll();
        Optional<Room> room = roomRepository.findByRoomNumberIgnoreCase("p1");
        System.out.println(room);
        rooms.forEach(System.out::println);

        log.info("Reservation querys...");

        Optional<List<Reservation>> reservations = reservationRepository.findAllByReservationDate(Date.valueOf("2023-08-28"));
        System.out.println(reservations);

    }

}
