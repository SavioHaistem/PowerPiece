package entities.akumanomis;

import entities.models.Power;
import enums.AkumasType;

import java.util.Map;

public class Paramecia extends AkumaNoMi {
    public Paramecia(AkumasType akumasType) {
        super(akumasType);
    }

    public Paramecia(String name, Integer id, AkumasType type) {
        super(name, id, type);
    }

    public Paramecia(String name, AkumasType type, Integer id, Map<Integer, Power> powers) {
        super(name, type, id, powers);
    }
}