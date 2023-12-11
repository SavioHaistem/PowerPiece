package entities.fruits;

import enums.akumanomis.AkumaRarity;
import enums.akumanomis.AkumaType;
import enums.fruits.FruitType;

public class AkumaNoMi extends Fruit {
    private AkumaType akumaType;
    private AkumaRarity akumaRarity;
    private String description;
    private String name;

    public AkumaNoMi() {
        super();
    }

    public AkumaNoMi(AkumaType akumaType, AkumaRarity akumaRarity, String description, String name) {
        super(FruitType.AKUMA);
        this.akumaType = akumaType;
        this.akumaRarity = akumaRarity;
        this.description = description;
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder akumanomi = new StringBuilder();
        akumanomi.append("!!! -- ").append(this.name).append(" -- !!!\n\n");
        akumanomi.append("type: ").append(this.akumaType).append("\n");
        akumanomi.append("rarity: ").append(this.akumaRarity).append("\n\n");
        akumanomi.append("description: \n").append(this.description);

        return akumanomi.toString();
    }
}
