package entities.player;

import entities.fruits.AkumaNoMi;
import entities.stats.Buff;
import entities.stats.Debuff;

import java.util.ArrayList;

public class Player {
    private ArrayList<Buff> buffs = new ArrayList<>();
    private ArrayList<Debuff> debuffs = new ArrayList<>();
    private AkumaNoMi akumaNoMi;
}
