package com.offer;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class OfferCreationFeature {
    Product product = new Product("Apples");


    @Test
    public void should_be_able_to_query_offer() throws Offer.InValidDateException {
        String ccy = "USD";

        Offer offer = new Offer(product, ccy,  LocalDate.now().plus(1, ChronoUnit.MONTHS));
        OfferResouce offerResouce = new OfferResouce(offer);

    }

    @Test(expected=Offer.InValidDateException.class)
    public void should_not_be_able_to_create_offer_in_past() throws Offer.InValidDateException {
        Offer offer = new Offer(product, "GPB", LocalDate.now().minus(1,ChronoUnit.DAYS));
    }

    @Test
    public void offer_could_have_duration() throws Offer.InValidDateException {
        LocalDate startDate = LocalDate.now().plus(1,ChronoUnit.WEEKS);

        LocalDate  endEndDate = startDate.plus(2,ChronoUnit.WEEKS);
        Offer offer = new Offer(product, "USD", startDate, endEndDate);
    }
}
