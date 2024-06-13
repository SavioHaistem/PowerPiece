package entities.akumanomis;

import entities.models.Power;
import enums.AkumasType;

import java.util.Map;

public class Logia extends AkumaNoMi {
    public Logia(String name, Integer id) {
        super(name, id, AkumasType.LOGIA);
    }
    public Logia(String name, Integer id, Map<Integer, Power> powers) {
        super(name, id, AkumasType.LOGIA, powers);
    }
}
