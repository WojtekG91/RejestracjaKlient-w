package com.company.Services;

public class Service {
    private String name;
    private Double price;
    private Integer durationInMin;

    public Service(String name, Double price, Integer durationInMin) {
        this.name = name;
        this.price = price;
        this.durationInMin = durationInMin;
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
        return durationInMin;
    }

    public void setDuration(Double duration) {
        this.durationInMin = durationInMin;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", price=" + price +
                ", duration=" + durationInMin;
    }

    public Service(ServiceWraper serviceWraper) {
        this.name = serviceWraper.name;
        this.price = serviceWraper.price;
        this.durationInMin = serviceWraper.duration;
    }


}
