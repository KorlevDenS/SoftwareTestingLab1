package com.denis.korolev.task3;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Ticket {

    private int horrorParkId;

    private int ticketPrice;
    private Date date;

    private String name;
    private String surname;
    private int age;

    public Ticket(int horrorParkId, int ticketPrice, String name, String surname, int age) {
        this.horrorParkId = horrorParkId;
        this.ticketPrice = ticketPrice;
        this.date = new Date();
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

}
