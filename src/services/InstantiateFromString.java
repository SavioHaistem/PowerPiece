package services;

import db.DB;
import db.dao.DaoFactory;
import db.dao.PowerDao;
import db.dao.impl.PowerDaoJdbc;
import entities.models.Power;

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
