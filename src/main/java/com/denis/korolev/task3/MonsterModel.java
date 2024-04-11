package com.denis.korolev.task3;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Getter
@Setter
public class MonsterModel {

    private boolean dead;
    private MonsterType monsterType;
    private SoundEffect lastPlayedSound;

    public MonsterModel(MonsterType monsterType) {
        this.monsterType = monsterType;
        this.dead = false;
    }

    public void makeSound(SoundBar soundBar, SoundEffect soundEffect, int soundLevel) {
        soundBar.playSound(soundLevel, soundEffect);
        this.lastPlayedSound = soundEffect;
        System.out.println("Монстр " + monsterType.toString() + " издал звук: " + soundEffect.toString());
    }

    @SneakyThrows
    public void killMonster(MonsterModel monsterModel) {
        if (monsterModel.isDead()) throw new Exception("Нельзя убить мертвого");
        monsterModel.setDead(true);
    }

    public void resurrect() {
        this.dead = false;
    }

}
