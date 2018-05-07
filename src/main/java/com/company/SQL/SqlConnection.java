package com.company.SQL;

import java.sql.*;

public class SqlConnection {

    public static Connection Connect() {

        Connection connect = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/ClientRegistration?" + "user=root&password=";

            try {
            Class.forName(driver);
            connect = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connect;
    }
}
