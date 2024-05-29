package db;
import exceptions.DbException;

import java.io.File;
import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

public class DB {
    private static Connection connection = null;
    public static Connection getConnection() throws DbException {
        String basepath = new File("").getAbsolutePath();

        try {
            Class.forName("org.sqlite.JDBC");
            if (connection == null) {
                String url = "jdbc:sqlite:" + basepath + "/src/db/akumas.db";
                connection = DriverManager.getConnection(url);
                System.out.println("connection successes");
                return connection;
            }
            return connection;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("classForNameError");
        }
    }

    public static Map<Integer, String> getAkumas() {
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Akumas;");
            Map<Integer,String> response = new TreeMap<>();
            while (resultSet.next()) {
                response.put(resultSet.getInt(1),resultSet.getString(2));
            }
            return response;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("connection closed");
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void setConnection(Connection connection) {
        DB.connection = connection;
    }

    public void closeResultSet(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void closeStatment(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}