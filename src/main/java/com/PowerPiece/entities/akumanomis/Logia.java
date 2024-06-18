package com.PowerPiece.entities.akumanomis;

import com.PowerPiece.entities.models.Power;
import com.PowerPiece.enums.AkumasType;

import java.util.Map;

public class Logia extends AkumaNoMi {
    public Logia(String name, Integer id) {
        super(name, id, AkumasType.LOGIA);
    }
    public Logia(String name, Integer id, Map<Integer, Power> powers) {
        super(name, id, AkumasType.LOGIA, powers);
    }
}
