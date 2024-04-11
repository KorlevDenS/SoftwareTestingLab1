package com.denis.korolev.task3;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Getter
@Setter
public class Visitor {

    private final String name;
    private final String surname;
    private int age;
    private final String gender;
    private Ticket ticket;
    private int balance;

    public Visitor(String name, String surname, int age, String gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.ticket = null;
        this.balance = 0;
    }

    public void addMoney(int amount) {
        this.balance += amount;
    }

    @SneakyThrows
    public void buyTicket(HorrorPark horrorPark) {
        if (balance < horrorPark.getTicketPrice()) throw new Exception("Недостаточно средств");
        balance -= horrorPark.getTicketPrice();
        this.ticket = horrorPark.arrangeTicket(this);
    }

    @SneakyThrows
    public void visitHorrorPark(HorrorPark horrorPark) {
        if (this.ticket == null) throw new Exception("Билет не куплен");
        if (!horrorPark.checkTicket(this.ticket)) throw new Exception("Билет не валидный");
        System.out.println("You have successfully visited the horror park!");
    }

}
