package com.coffee.dto;

public class Coffee {
    private String name;
    private int price;
    private int priceGap;

    public Coffee(String name, int price, int priceGap) {
        this.name = name;
        this.price = price;
        this.priceGap = priceGap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPriceGap() {
        return priceGap;
    }

    public void setPriceGap(int priceGap) {
        this.priceGap = priceGap;
    }

    public int getGrande(){
        return this.price + (this.priceGap*2);
    }

    public int getTall(){
        return this.price + this.priceGap;
    }

    @Override
    public String toString() {
        return name;
    }
}
