package entities.akumanomis;

import enums.AkumasType;

public class Paramecia extends AkumaNoMi {

    public Paramecia(String name, AkumasType type, Integer id) {
        super(name, type, id);
        type = AkumasType.PARAMECIA;
    }
}
