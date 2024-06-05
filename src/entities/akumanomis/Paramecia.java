package entities.akumanomis;

import entities.models.Power;
import enums.AkumasType;

import java.util.Map;

public class Paramecia extends AkumaNoMi {
    public Paramecia(AkumasType akumasType) {
        super(akumasType);
    }
    public Paramecia(String name, Integer id) {
        super(name, id, AkumasType.PARAMECIA);
    }
    public Paramecia(String name, Integer id, Map<Integer, Power> powers) {
        super(name, id, AkumasType.PARAMECIA, powers);
    }
}