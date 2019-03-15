package com.offer;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

public class OfferResouceTest {
    Product prod = new Product("Something");
    Offer offer ;

    @Test
    public void offer_resource_should_handle_creation() throws Offer.InValidDateException {
         offer = new Offer(prod, "USD", LocalDate.now().plus(1, ChronoUnit.MONTHS));
        OfferResouce resource = new OfferResouce(offer);
        assertEquals(offer.getId(),resource.getOfferById(offer.getId()).getId());

    }

    @Test
    public void offer_resource_should_cancle_offer() throws Offer.InValidDateException {
        offer = new Offer(prod, "USD", LocalDate.now().plus(1, ChronoUnit.MONTHS));
        OfferResouce resource = new OfferResouce(offer);

        assertTrue(resource.getOfferById(offer.getId()).cancelOffer());
        assertEquals(Offer.STATUS.CANCELED,resource.getOfferById(offer.getId()).getStatus());
    }

    @Test
    public void offer_resource_should_query_status() throws Offer.InValidDateException {
        offer = new Offer(prod, "USD", LocalDate.now().plus(1, ChronoUnit.MONTHS));
        OfferResouce resource = new OfferResouce(offer);
        assertEquals(offer.expiryDate,resource.getOfferById(offer.getId()).getExpiryDate());
        assertFalse(resource.getOfferById(offer.getId()).hasExpired());
        assertTrue(resource.getOfferById(offer.getId()).setExpiryDate(LocalDate.of(2020,1,1)));
        assertEquals(Offer.STATUS.LIVE, resource.getOfferById(offer.getId()).getStatus());
    }



}