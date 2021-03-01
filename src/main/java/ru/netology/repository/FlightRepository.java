package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.FlightOffer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightRepository {
    private FlightOffer[] offers = new FlightOffer[0];

    public void save(FlightOffer offer) {
        int length = offers.length + 1;
        FlightOffer[] tmp = new FlightOffer[length];
        System.arraycopy(offers, 0, tmp, 0, offers.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = offer;
        offers = tmp;
    }

    public FlightOffer[] getAll() {
        return offers;
    }

    public void removeById(int id) {
        try {
            int length = offers.length - 1;
            FlightOffer[] tmp = new FlightOffer[length];
            int index = 0;
            for (FlightOffer offer : offers) {
                if (offer.getId() != id) {
                    tmp[index] = offer;
                    index++;
                }
            }
            offers = tmp;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Element with id " + id + " not found");
        }
    }

}
