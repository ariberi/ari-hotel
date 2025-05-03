package dev.ari.arihotel.web.API;

import dev.ari.arihotel.data.entity.Guest;
import dev.ari.arihotel.data.repository.GuestRepository;
import dev.ari.arihotel.web.exception.BadRequestException;
import dev.ari.arihotel.web.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestApiController {

    private GuestRepository guestRepository;

    public GuestApiController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public List<Guest> getAllGuests() {
        return this.guestRepository.findAll();
    }

    @GetMapping("/{id}")
    public Guest getGuestById(@PathVariable("id") Long id) {
        return this.guestRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Guest not found with id: " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Guest addGuest(@RequestBody Guest guest) {
        return this.guestRepository.save(guest);
    }

    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable("id") Long id, @RequestBody Guest guest) {
        if (id != guest.getId()) {
            throw new BadRequestException("Guest id does not match the id in the payload");
        }
        return this.guestRepository.save(guest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteGuest(@PathVariable("id") Long id) {
        this.guestRepository.deleteById(id);
    }




}
