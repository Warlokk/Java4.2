package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightOffer;

import static org.junit.jupiter.api.Assertions.*;

class FlightRepositoryTest {
    private FlightRepository repository = new FlightRepository();
    FlightOffer first = new FlightOffer(1, 4416, "KUF", "DME", 110);
    FlightOffer second = new FlightOffer(2, 4800, "KUF", "DME", 115);
    FlightOffer third = new FlightOffer(3, 2950, "KUF", "DME", 120);
    FlightOffer fourth = new FlightOffer(4, 5000, "KUF", "LED", 210);
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
    void shouldSaveToEmpty() {
        repository.save(first);
        FlightOffer[] expected = new FlightOffer[]{first};
        assertArrayEquals(expected, repository.getAll());

    }

    @Test
    void shouldGetAll() {
        setUp();
        FlightOffer[] expected = new FlightOffer[]{first, second, third, fourth, fifth, sixth, seventh};
        assertArrayEquals(expected, repository.getAll());
    }

    @Test
    void shouldRemoveById() {
        setUp();
        repository.removeById(3);
        FlightOffer[] expected = new FlightOffer[]{first, second, fourth, fifth, sixth, seventh};
        assertArrayEquals(expected, repository.getAll());
    }

    @Test
    void shouldNotRemoveNotExisted() {
        setUp();
        FlightOffer[] expected = repository.getAll();
        repository.removeById(8);
        FlightOffer[] actual = repository.getAll();
        assertEquals(expected, actual);
    }
}