package db;
import exceptions.DbException;

import java.io.File;
import java.sql.*;

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

    public static void setConnection(Connection connection) {
        DB.connection = connection;
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

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatment(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}