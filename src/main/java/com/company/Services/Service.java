package com.company.Services;

public class Service {
    private String name;
    private Double price;
    private Integer duration;

    public Service(String name, Double price, Integer duration) {
        this.name = name;
        this.price = price;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return name;   }

    public Service(ServiceWraper serviceWraper) {
        this.name = serviceWraper.name;
        this.price = serviceWraper.price;
        this.duration = serviceWraper.duration;
    }


}
