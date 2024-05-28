package application;

import db.DB;
import db.dao.AkumaDao;
import db.dao.DaoFactory;

import java.util.List;
import java.util.Map;

public class GameInterface {
    public static void main(String[] args) {
        AkumaDao akumaDao = DaoFactory.createAkumaDao();
        Map<Integer,String> akumas = DB.getAkumas();
        System.out.println("AkumaNoMis: ");
        System.out.println(akumas);
    }
}
