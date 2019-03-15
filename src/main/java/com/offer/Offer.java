package com.offer;

import java.time.LocalDate;

public class Offer {
    private LocalDate startDate;
    LocalDate expiryDate;

    String ccy;
    Product product;
    int id;

    public Offer(Product product, String usd, LocalDate startDate, LocalDate expiryDate) {
        this.product=product;
        this.ccy=ccy;
        this.startDate=startDate;
        this.expiryDate=expiryDate;
    }

    public  enum  STATUS  {LIVE,CANCELED,EXPIRED};

    STATUS status;



    public boolean cancelOffer() {
        if(!hasExpired()) {
            setStatus(STATUS.CANCELED);
            return true;
        } else {
            return false;
        }

    }

    public STATUS getStatus() {
        return (expiryDate.isBefore(LocalDate.now())) ? STATUS.EXPIRED : this.getStatus();
    }



    public Offer(Product product, String ccy, LocalDate expiryDate) throws InValidDateException {
        if(expiryDate.isBefore(LocalDate.now())) {
            throw new InValidDateException();
        }
        this.expiryDate = expiryDate;
        this.status = STATUS.LIVE;
        this.ccy=ccy;
        this.product=product;
        id =1;
    }

    public void set(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    public int getId() {
        return id;
    }


    public boolean hasExpired() {
        return expiryDate.isBefore( LocalDate.now());
    }

    public boolean setExpiryDate(LocalDate expiryDate) {
        if(!hasExpired()) {
            this.expiryDate = expiryDate;
            return true;
        } else {
            return false;
        }
    }


    public String getCcy() {
        return ccy;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public class InValidDateException extends Throwable {
    }
}
