package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightOffer;
import ru.netology.repository.FlightRepository;

import static org.junit.jupiter.api.Assertions.*;

class FlightManagerTest {
    private FlightRepository repository = new FlightRepository();
    private FlightManager manager = new FlightManager(repository);
    FlightOffer first = new FlightOffer(1, 4416, "KUF", "DME", 110);
    FlightOffer second = new FlightOffer(2, 4800, "KUF", "DME", 115);
    FlightOffer third = new FlightOffer(3, 5000, "KUF", "LED", 120);
    FlightOffer fourth = new FlightOffer(4, 2950, "KUF", "DME", 210);
    FlightOffer fifth = new FlightOffer(5, 2950, "KUF", "LED", 180);
    FlightOffer sixth = new FlightOffer(6, 8000, "KUF", "LED", 190);
    FlightOffer seventh = new FlightOffer(7, 6000, "KUF", "LED", 160);

    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
    }

    @Test
    void shouldFindAllThatMatchesAscPriceSort() {
        setUp();
        FlightOffer[] actual = manager.findAllThatMatches("KUF", "DME");
        FlightOffer[] expected = new FlightOffer[]{fourth, first, second};
        assertArrayEquals(expected, actual);
    }

}