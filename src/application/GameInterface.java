package application;
import db.dao.DaoFactory;
import db.dao.impl.TransformationDaoJdbc;
import entities.models.Transformation;

public class GameInterface {
    public static void main(String[] args) {
        TransformationDaoJdbc formDao = DaoFactory.createTransformationDaoJdbc();
        Transformation form = formDao.findById(10);
        System.out.println(form);
    }
}
