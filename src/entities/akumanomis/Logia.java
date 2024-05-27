package entities.akumanomis;

import enums.AkumasType;

public class Logia extends AkumaNoMi {

    public Logia(String name, Integer id) {
        super(name, id);
        this.type = AkumasType.LOGIA;
    }
}
