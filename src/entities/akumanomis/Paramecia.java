package entities.akumanomis;

import enums.AkumasType;

public class Paramecia extends AkumaNoMi {

    public Paramecia(String name, Integer id) {
        super(name, id);
        type = AkumasType.PARAMECIA;
    }
}
