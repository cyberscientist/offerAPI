package com.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OfferResouce {
    List<Offer> offers = new ArrayList<>();

    public OfferResouce(Offer offer) {
        offers.add(offer);
    }

    public void addOffer(Offer offer) {
        offers.add(offer);
    }

    public Offer getOfferById(double offerId) {
        return offers.stream().filter(o-> o.getId()==offerId).collect(Collectors.toList()).get(0);    }
}
