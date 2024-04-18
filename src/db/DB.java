package db;
import exceptions.DbException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB {
    Connection connection = null;
    public void connection() throws DbException {
        try {
            Class.forName("org.sqlite.JDBC");
            if (connection == null) {
                String url = "jdbc:sqlite:/home/savio/akumas.db";
                connection = DriverManager.getConnection(url);
                System.out.println(connection);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("classForNameError");
        }
    }
}
