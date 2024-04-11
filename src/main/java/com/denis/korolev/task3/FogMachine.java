package com.denis.korolev.task3;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Getter
@Setter
public class FogMachine {

    private int gasCollector;
    private int gasLevel;

    public FogMachine(int gasCollector) {
        this.gasCollector = gasCollector;
        this.gasLevel = 0;
    }

    @SneakyThrows
    public void makeFog(int gas) {
        if (gas < 0) throw new Exception("Газ не может иметь отрицательный объём");
        if (gas > gasLevel) throw new Exception("Недостаточно газа");
        this.gasLevel -= gas;
    }

    @SneakyThrows
    public void addGas(int gas) {
        if (gas > this.gasCollector || (this.gasLevel + gas) > this.gasCollector) throw new Exception("Объем хранилища ограничен");
        if (gas < 0) throw new Exception("Газ не может иметь отрицательный объём");
        this.gasLevel += gas;
    }

}
