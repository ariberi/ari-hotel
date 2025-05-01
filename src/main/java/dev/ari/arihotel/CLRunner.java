//package dev.ari.arihotel;
//
//import dev.ari.arihotel.data.repository.GuestRepository;
//import dev.ari.arihotel.data.repository.ReservationRepository;
//import dev.ari.arihotel.data.repository.RoomRepository;
//import dev.ari.arihotel.service.RoomReservationService;
//import dev.ari.arihotel.service.model.RoomReservation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class CLRunner implements CommandLineRunner {
//
//    private static final Logger log = LoggerFactory.getLogger(CLRunner.class);
//    private final RoomRepository roomRepository;
//    private final ReservationRepository reservationRepository;
//    private final GuestRepository guestRepository;
//    private final RoomReservationService roomReservationService;
//
//    public CLRunner(RoomRepository roomRepository, ReservationRepository reservationRepository,
//                    GuestRepository guestRepository, RoomReservationService roomReservationService) {
//        this.roomRepository = roomRepository;
//        this.reservationRepository = reservationRepository;
//        this.guestRepository = guestRepository;
//        this.roomReservationService = roomReservationService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        List<RoomReservation> reservations = this.roomReservationService.getRoomReservationsForDate("2023-08-28");
//        reservations.forEach(System.out::println);
//
//
//    }
//
//}
