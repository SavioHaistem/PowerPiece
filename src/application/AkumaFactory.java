package application;
import db.DB;
import entities.enemies.BlackBeard;
import exceptions.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AkumaFactory {
    public static void main(String[] args) {
        BlackBeard blackBeard = new BlackBeard();
        System.out.println(blackBeard);
    }
}