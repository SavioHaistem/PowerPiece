package entities.akumanomis;
import entities.models.Power;
import entities.models.Transformation;
import enums.AkumasType;

import java.util.Map;

public class Zoan extends AkumaNoMi {
    protected Transformation form = null;
    public Zoan() {
        super(AkumasType.ZOAN);
    };
    public Zoan(String name, Integer id) {
        super(name,id,AkumasType.ZOAN);
    }
    public Zoan(String name, Integer id, Transformation transformation, Power transformPower) {
        super(name,id,AkumasType.ZOAN);
        this.powers.put(transformPower.getId(),transformPower);
        this.form = transformation;
    }

    public Transformation getForm() {
        return form;
    }

    public void setForm(Transformation form) {
        this.form = form;
    }
}
