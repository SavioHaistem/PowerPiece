package entities.akumanomis;
import entities.models.Transformation;
import enums.AkumasType;

public class Zoan extends AkumaNoMi {
    protected Transformation form = null;
    public Zoan() {
        super(AkumasType.ZOAN);
    };
    public Zoan(String name, Integer id) {
        super(name,id,AkumasType.ZOAN);
    }
    public Zoan(String name, Integer id, Transformation transformation) {
        super(name,id,AkumasType.ZOAN);
        this.form = transformation;
        this.powers = form.getPowers();
    }
}
