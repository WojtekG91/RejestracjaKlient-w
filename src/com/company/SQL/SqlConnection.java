package com.company.SQL;

import java.sql.*;

public class SqlConnection {
    Connection connect = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/project?" + "user=root&password=";

    public void Connect() {


        try {
            Class.forName(driver);
            // Setup the connection with the DB
            connect = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
