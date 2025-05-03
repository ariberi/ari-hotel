package dev.ari.arihotel.web.API;

import dev.ari.arihotel.data.entity.Room;
import dev.ari.arihotel.data.repository.RoomRepository;
import dev.ari.arihotel.web.exception.BadRequestException;
import dev.ari.arihotel.web.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomApiController {

    private RoomRepository roomRepository;

    public RoomApiController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable("id") Long id) {
        Optional<Room> room = this.roomRepository.findById(id);
        if (room.isEmpty()) {
            throw new NotFoundException("Room not found with id: " + id);
        }
        return room.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room createRoom(@RequestBody Room room) {
        return this.roomRepository.save(room);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable("id") Long id, @RequestBody Room room) {
        if (id != room.getId()) {
            throw new BadRequestException("Room id does not match the id in the payload");
        }
        return this.roomRepository.save(room);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteRoom(@PathVariable("id") Long id) {
        this.roomRepository.deleteById(id);
    }

}
