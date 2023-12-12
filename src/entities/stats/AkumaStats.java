package entities.stats;

import java.util.ArrayList;

public class AkumaStats {
    private ArrayList<Buff> buffs = new ArrayList<>();
    private ArrayList<Debuff> debuffs = new ArrayList<>();

    public AkumaStats() {}
    public AkumaStats(ArrayList<Buff> buffs, ArrayList<Debuff> debuffs) {
        this.buffs = buffs;
        this.debuffs = debuffs;
    }
}