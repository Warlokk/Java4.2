package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightOffer;
import ru.netology.domain.OffersFlightTimeComparator;
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
    FlightOffer seventh = new FlightOffer(7, 5000, "KUF", "LED", 160);
    FlightOffer eighth = new FlightOffer(8, 7000, "KUF", "LED", 150);
    FlightOffer nineth = new FlightOffer(9, 6500, "KUF", "LED", 170);
    FlightOffer tenth = new FlightOffer(10, 9000, "DME", "LED", 200);

    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(nineth);
        repository.save(tenth);
    }

    @Test
    void shouldFindAllThatMatchesAscPriceSort() {
        setUp();
        FlightOffer[] actual = manager.findAllThatMatches("KUF", "DME");
        FlightOffer[] expected = new FlightOffer[]{fourth, first, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllThatMatchesComparatorTime() {
        setUp();
        OffersFlightTimeComparator comparator = new OffersFlightTimeComparator();
        FlightOffer[] actual = manager.findAllThatMatchesComparator("KUF", "LED", comparator);
        FlightOffer[] expected = new FlightOffer[]{third, eighth, seventh, nineth, fifth, sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindIfNotExist() {
        setUp();
        OffersFlightTimeComparator comparator = new OffersFlightTimeComparator();
        FlightOffer[] expected = new FlightOffer[0];
        FlightOffer[] actual = manager.findAllThatMatchesComparator("LED", "KUF", comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindOneComparator() {
        setUp();
        OffersFlightTimeComparator comparator = new OffersFlightTimeComparator();
        FlightOffer[] actual = manager.findAllThatMatchesComparator("DME", "LED", comparator);
        FlightOffer[] expected = new FlightOffer[]{tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindEmptyRepo() {
        OffersFlightTimeComparator comparator = new OffersFlightTimeComparator();
        FlightOffer[] actual = manager.findAllThatMatchesComparator("DME", "LED", comparator);
        FlightOffer[] expected = new FlightOffer[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindOneElementRepo() {
        repository.save(first);
        OffersFlightTimeComparator comparator = new OffersFlightTimeComparator();
        FlightOffer[] actual = manager.findAllThatMatchesComparator("KUF", "DME", comparator);
        FlightOffer[] expected = new FlightOffer[]{first};
        assertArrayEquals(expected, actual);
    }

}