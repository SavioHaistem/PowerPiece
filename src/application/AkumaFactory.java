package application;
import db.DB;
import exceptions.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AkumaFactory {
    public static void main(String[] args) {
        Connection connection = DB.getConnection();
        System.out.println(DB.getAkumas());
        DB.closeConnection(connection);
    }
}