package com.denis.korolev.task3;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Getter
@Setter
public class SoundBar {

    private SoundEffect soundEffect;
    private int maxSoundLevel;

    public SoundBar(int maxSoundLevel) {
        this.maxSoundLevel = maxSoundLevel;
        this.soundEffect = SoundEffect.DEATH;
    }

    @SneakyThrows
    public void playSound(int soundLevel, SoundEffect soundEffect) {
        if (soundLevel > this.maxSoundLevel || soundLevel < 0) throw new Exception("Недопустимый уровень звука");
        this.soundEffect = soundEffect;
    }

}
