package com.denis.korolev.task3;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Getter
@Setter
public class Lighting {

    private int lampsAmount;
    private LightMode lightMode;

    public Lighting(int lampsAmount) {
        this.lampsAmount = lampsAmount;
        this.lightMode = LightMode.DARKNESS;
    }

    @SneakyThrows
    public void changeLightMode(LightMode newLightMode) {
        if (this.lampsAmount <= 0 && newLightMode != LightMode.DARKNESS) throw new Exception("Нету лампочек");
        this.lightMode = newLightMode;
    }

}
