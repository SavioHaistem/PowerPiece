package entities;

import enums.akumanomis.AkumaRarity;
import enums.akumanomis.AkumaType;
import enums.fruits.FruitType;

public class AkumaNoMi extends Fruit {
    private final AkumaType akumaType;
    private final AkumaRarity akumaRarity;
    public final String description;
    public final String name;

    public AkumaNoMi(AkumaType akumaType, AkumaRarity akumaRarity, String description, String name) {
        super(FruitType.AKUMA);
        this.akumaType = akumaType;
        this.akumaRarity = akumaRarity;
        this.description = description;
        this.name = name;
    }


}
