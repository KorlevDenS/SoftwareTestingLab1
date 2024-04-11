package com.denis.korolev.task3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HorrorPark {

    private int id;
    private int ticketPrice;

    private FogMachine fogMachine;
    private ShadowMachine shadowMachine;
    private Lighting lighting;
    private SoundBar soundBar;

    public HorrorPark(FogMachine fogMachine, ShadowMachine shadowMachine, Lighting lighting, SoundBar soundBar,
                      int id, int ticketPrice) {
        this.fogMachine = fogMachine;
        this.shadowMachine = shadowMachine;
        this.lighting = lighting;
        this.soundBar = soundBar;
        this.id = id;
        this.ticketPrice = ticketPrice;
    }

    public Ticket arrangeTicket(Visitor visitor) {
        return new Ticket(this.id, this.ticketPrice, visitor.getName(), visitor.getSurname(), visitor.getAge());
    }

    public boolean checkTicket(Ticket ticket) {
        return this.id == ticket.getHorrorParkId();
    }

}
