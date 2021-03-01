package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.FlightOffer;
import ru.netology.repository.FlightRepository;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlightManager {
    private FlightRepository repository;

    public void add(FlightOffer offer) {
        repository.save(offer);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void findAll(FlightOffer offer) {
        repository.getAll();
    }

    public FlightOffer[] findAllThatMatches(String from, String to) {
        FlightOffer[] result = new FlightOffer[0];
        for (FlightOffer offer : repository.getAll()) {
            if (offer.matches(from, to)) {
                FlightOffer[] tmp = new FlightOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = offer;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

}
