package com.jmp.spring.core.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.jmp.spring.core.config.AppConfig;
import com.jmp.spring.core.model.MovieSession;
import com.jmp.spring.core.model.Reservation;
import com.jmp.spring.core.model.Viewer;
import com.jmp.spring.core.service.MovieSessionService;
import com.jmp.spring.core.service.TicketReservationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TicketReservationController {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MovieSessionService movieSessionService = (MovieSessionService)
                context.getBean("movieSessionService");
        TicketReservationService ticketReservationService = (TicketReservationService)
                context.getBean("ticketReservationService");

        Scanner scanner = new Scanner(System.in);

        // Registration
        System.out.println("Ticket reservation system");
        System.out.println("Enter your first name: ");
        String firstName = scanner.next();
        System.out.println("Enter your last name: ");
        String lastName = scanner.next();

        System.out.println("Input month: ");
        int month = scanner.nextInt();
        System.out.println("Input day: ");
        int day = scanner.nextInt();

        // Select movie session
        System.out.println("Available movie seasons: ");
        List<MovieSession> mss =  movieSessionService.getMovieSessionByDate(
                LocalDate.of(2014, month, day));
        int counter = 1;
        for (MovieSession ms : mss) {
            System.out.println(counter++ + " - " + ms.getMovieTitle());
        }
        System.out.println("Select movie session: ");
        int item = scanner.nextInt();

        // Select session time
        System.out.println("Available session time: ");
        MovieSession ms =  mss.get(item - 1);
        counter = 1;
        for (LocalTime tm : ms.getTimes()) {
            System.out.println(counter++ + " - " + tm.toString());
        }
        System.out.println("Select session time: ");
        int timeItem = scanner.nextInt();

        // Select seat
        System.out.println("Select seat number (1-100): ");
        int seatItem = scanner.nextInt();

        // Create reservation
        Reservation res = ticketReservationService.createReservation(ms, LocalDate.of(2014, month, day),
                ms.getTimes().get(timeItem - 1), seatItem, new Viewer(firstName, lastName));
        if (res != null) {
            System.out.println("Reservation successfully created, your number is " + res.getId());
        } else {
            System.out.println("Error: something gone wrong!");
            System.exit(0);
        }

        // Display reservation price by ID
        System.out.println("Enter reservation number: ");
        int resId = scanner.nextInt();
        Optional<Reservation> rsr =  ticketReservationService.findReservationById(resId);
        System.out.println("Reservation price is $" + rsr.get().getPrice());

        // Delete reservation by ID
        System.out.println("Enter reservation number for delete: ");
        int delResId = scanner.nextInt();
        ticketReservationService.deleteReservation(delResId);
    }
}
