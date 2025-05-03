package dev.ari.arihotel.web.API;


import dev.ari.arihotel.data.entity.Reservation;
import dev.ari.arihotel.data.repository.ReservationRepository;
import dev.ari.arihotel.web.exception.NotFoundException;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {


    private ReservationRepository reservationRepository;

    public ReservationApiController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<Reservation> getAllReservations(@RequestParam(value = "date", required = false) String dateString) {

        if (StringUtils.isNotBlank(dateString)) {
            Date date = new Date(new java.util.Date().getTime());
            return this.reservationRepository.findAllByReservationDate(date);
        }
        return this.reservationRepository.findAll();

    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable("id") Long id) {
        return this.reservationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reservation not found with id: " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable("id") Long id, @RequestBody Reservation reservation) {
        if (id != reservation.getId()) {
            throw new NotFoundException("Reservation id does not match the id in the payload");
        }
        return this.reservationRepository.save(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteReservation(@PathVariable("id") Long id) {
        this.reservationRepository.deleteById(id);
    }






}
