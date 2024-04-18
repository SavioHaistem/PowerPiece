package entities.akumanomis;

import enums.AkumasType;

public class Logia extends AkumaNoMi {

    public Logia(String name, AkumasType type, Integer id) {
        super(name, type, id);
        type = AkumasType.LOGIA;
    }
}
