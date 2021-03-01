package ru.netology.domain;

import java.util.Comparator;

public class OffersFlightTimeComparator implements Comparator<FlightOffer> {

    public int compare(FlightOffer f1, FlightOffer f2) {
        if (f1.getPrice() != f2.getPrice())
            return f1.getPrice() - f2.getPrice();
        else return f1.getFlightTime() - f2.getFlightTime();

//        return f1.getFlightTime() - f2.getFlightTime();
    }
}
