package entities.akumanomis;
import enums.AkumasType;

public class Zoan extends AkumaNoMi {

    public Zoan(String name, Integer id) {
        super(name, id);
        type = AkumasType.ZOAN;
    }
}
