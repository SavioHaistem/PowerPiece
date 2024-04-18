package entities.akumanomis;
import enums.AkumasType;

public class Zoan extends AkumaNoMi {

    public Zoan(String name, AkumasType type, Integer id) {
        super(name, type, id);
        type = AkumasType.ZOAN;
    }
}
