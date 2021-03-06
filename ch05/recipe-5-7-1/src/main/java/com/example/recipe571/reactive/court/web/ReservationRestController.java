package com.example.recipe571.reactive.court.web;

import com.example.recipe571.reactive.court.Reservation;
import com.example.recipe571.reactive.court.ReservationService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reservations")
public class ReservationRestController {

    private final ReservationService reservationService;

    public ReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public Flux<Reservation> listAll() {
        return reservationService.findAll();
    }

    @PostMapping
    public Flux<Reservation> find(@RequestBody Mono<ReservationQuery> query) {
        return query.flatMapMany(q -> reservationService.query(q.getCourtName()));
    }
}
