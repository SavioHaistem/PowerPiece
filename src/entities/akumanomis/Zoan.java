package entities.akumanomis;
import entities.models.Power;
import entities.models.Transformation;
import enums.AkumasType;

import java.util.HashMap;
import java.util.Map;

public class Zoan extends AkumaNoMi {
    protected Transformation form = null;
    public Zoan() {
        super();
    };
    public Zoan(String name, Integer id) {
        super(name,id);
    }
    public Zoan(String name, Integer id, Transformation transformation) {
        super(name, id);
        this.form = transformation;
        this.powers = form.getPowers();
    }
}
