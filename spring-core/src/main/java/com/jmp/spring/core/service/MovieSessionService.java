package com.jmp.spring.core.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jmp.spring.core.model.MovieSession;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionService implements InitializingBean, DisposableBean {

    private Map<LocalDate, List<MovieSession>> sessions;

    public MovieSessionService() {
        List<LocalTime> times = new ArrayList<>(3);
        times.add(LocalTime.of(10, 0));
        times.add(LocalTime.of(15, 0));
        times.add(LocalTime.of(20, 0));
        sessions = new HashMap<>();
        sessions.put(LocalDate.of(2014, 12, 20), Arrays.asList(
                new MovieSession("Interstellar", times, 8),
                new MovieSession("Transformers 4", times, 9)));
        sessions.put(LocalDate.of(2014, 12, 30), Arrays.asList(new MovieSession("Hobbit 3", times, 10)));
    }

    public List<MovieSession> getMovieSessionByDate(LocalDate localDate) {
        List<MovieSession> movieSessions = Collections.EMPTY_LIST;
        if (localDate != null) {
            movieSessions = sessions.entrySet()
                    .stream()
                    .filter(p -> localDate.equals(p.getKey()))
                    .findFirst()
                    .get().getValue();
        }
        return movieSessions;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean init method is called for MovieSessionService");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy method is called for MovieSessionService");
    }
}
