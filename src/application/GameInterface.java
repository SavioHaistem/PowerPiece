package application;

import db.dao.DaoFactory;
import db.dao.EnemyDao;
import entities.enemies.Enemy;
import entities.models.LifeBar;

import java.util.HashMap;

public class GameInterface {
    public static void main(String[] args) {
        EnemyDao enemyDao = DaoFactory.createEnemyDao();
        Enemy enemy = new Enemy(70,"Zeca pagodin",new LifeBar(100),new HashMap<>(),1);
        enemyDao.add(enemy);
        System.out.println(enemyDao.findById(70));
        enemyDao.removeById(70);
    }
}
