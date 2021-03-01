package ru.netology.domain;

import java.util.Comparator;

public class OffersFlightTimeComparator implements Comparator<FlightOffer> {

    public int compare(FlightOffer f1, FlightOffer f2) {
        return f1.getFlightTime() - f2.getFlightTime();
    }
}
