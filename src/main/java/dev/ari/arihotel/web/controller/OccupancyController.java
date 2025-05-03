package dev.ari.arihotel.web.controller;

import dev.ari.arihotel.service.RoomReservationService;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/occupancy")
public class OccupancyController {

    private final RoomReservationService roomReservationService;

    public OccupancyController(RoomReservationService roomReservationService) {
        this.roomReservationService = roomReservationService;
    }

    @GetMapping
    public String getRoomReservationsForDate(Model model, @RequestParam(value = "date", required = false) String dateString) {

        Date date = new Date();
        if (StringUtils.isNotBlank(dateString)) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                date = sdf.parse(dateString);
            } catch (Exception e) {
                // Handle the exception, e.g., log it or set a default date
            }
        }

        model.addAttribute("date", date);
        model.addAttribute("reservations", roomReservationService.getRoomReservationsForDate(dateString));

        return "occupancy";

    }




}
