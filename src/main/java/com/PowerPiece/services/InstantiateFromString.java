package com.PowerPiece.services;

import com.PowerPiece.db.dao.DaoFactory;
import com.PowerPiece.db.dao.PowerDao;
import com.PowerPiece.entities.models.Power;

import java.util.HashMap;
import java.util.Map;

public class InstantiateFromString {
    public static Map<Integer, Power> powerMap(String stringIDs) {
        PowerDao powerDao = DaoFactory.createPowerDao();
        Map<Integer,Power> powerMap = new HashMap<>();
        String[] powersIds = stringIDs.split(",");

        for (String id : powersIds) {
            int intID = Integer.parseInt(id);
            powerMap.put(intID,powerDao.findById(intID));
        }

        return powerMap;
    }
}
