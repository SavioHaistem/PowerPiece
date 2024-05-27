package entities.akumanomis;

import enums.AkumasType;
import interfaces.Fruit;

public abstract class AkumaNoMi implements Fruit {
    protected String name;
    protected AkumasType type;
    protected Integer id;

    public AkumaNoMi(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void Eat() {
        System.out.println("Eating Akuma no mi...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AkumasType getType() {
        return type;
    }

    public void setType(AkumasType type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
