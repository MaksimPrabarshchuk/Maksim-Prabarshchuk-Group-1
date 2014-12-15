package com.jmp.spring.core.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.jmp.spring.core.model.MovieSession;
import com.jmp.spring.core.model.Reservation;
import com.jmp.spring.core.model.Viewer;
import org.springframework.stereotype.Service;

@Service
public class TicketReservationService {

    private List<Reservation> reservations = new ArrayList<>();
    private int counter;

    public Reservation createReservation(MovieSession movieSession, LocalDate localDate,
            LocalTime sessionTime, int seat, Viewer viewer) {
        Reservation res = new Reservation();
        res.setId(++counter);
        res.setMovieTitle(movieSession.getMovieTitle());
        res.setSessionTime(LocalDateTime.of(localDate, sessionTime));
        res.setSeat(seat);
        res.setPrice(movieSession.getPrice());
        res.setViewer(viewer);
        reservations.add(res);
        return res;
    }

    public boolean deleteReservation(long id) {
        Optional<Reservation> res = findReservationById(id);
        if (res.isPresent()) {
            reservations.remove(res.get());
            return true;
        }
        return false;
    }

    public Optional<Reservation> findReservationById(long id) {
        return reservations.stream()
                .filter(r -> r.getId() == id)
                .findFirst();
    }
}
