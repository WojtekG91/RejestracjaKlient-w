package com.company.Services;

import java.sql.Time;
import java.util.concurrent.atomic.AtomicInteger;

public class Service {
    private String name;
    private Double price;
    private Double duration;

    public Service(String name, Double price, Double duration) {
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

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", price=" + price +
                ", duration=" + duration;
    }

    public Service(ServiceWraper serviceWraper) {
        this.name = serviceWraper.name;
        this.price = serviceWraper.price;
        this.duration = serviceWraper.duration;
    }


}
