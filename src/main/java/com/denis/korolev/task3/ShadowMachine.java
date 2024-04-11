package com.denis.korolev.task3;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Getter
@Setter
public class ShadowMachine {

    private ShadowType shadowType;
    private boolean turnedOn;

    public ShadowMachine() {
        this.turnedOn = false;
        this.shadowType = ShadowType.ELEPHANT;
    }

    @SneakyThrows
    public void showShadow(ShadowType shadowType) {
        if (!turnedOn) throw new Exception("Машина для теней выключена");
        this.shadowType = shadowType;
        System.out.println("Показываю тень: " + this.shadowType.toString());
    }

}
