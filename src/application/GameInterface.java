package application;
import db.dao.DaoFactory;
import db.dao.EnemyDao;

public class GameInterface {
    public static void main(String[] args) {
        EnemyDao enemyDao = DaoFactory.createEnemyDao();
    }
}
