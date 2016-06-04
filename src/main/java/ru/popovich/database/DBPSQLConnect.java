package ru.popovich.database;

import java.sql.*;


public class DBPSQLConnect {

    private final String HOST = "jdbc:postgresql://localhost/test";
    private final String USERNAME = "test";
    private final String PASSWORD = "test";
    private Connection connection;

    public DBPSQLConnect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();


            if (!connection.isClosed()) {
                System.out.println("Connection with DB is done!");
                ResultSet resultSet = statement.executeQuery("SELECT * FROM test1");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(""));
                }

            } else {
                System.out.println("There is not DB-connection");
            }
            connection.close();
            if (connection.isClosed()) {
                System.out.println("Connection closed!");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Не найден Class для Postgresql Driver");
        } catch (SQLException e) {
            System.out.println("Не найден драйвер SQL");
            ;
        }
    }

}
