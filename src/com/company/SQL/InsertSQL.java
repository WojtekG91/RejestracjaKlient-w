package com.company.SQL;

import java.sql.*;

public class InsertSQL {
    public static void registrationStatement(Integer clientID, String name, String surname, String mail, String phone, String password) {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection dbConnect = null;
        PreparedStatement preparedStatement = null;

        String sqlInsert = "INSERT INTO `tclients`(`ClientID`, `Name`, `Surname`, `Mail`, `Phone`, `Password`)" + "VALUES (?, ?, ?, ?, ?, ?);";

        try {
            dbConnect = SqlConnection.Connect();
                        //            resultSet = statement.executeQuery(sqlInsert);
            preparedStatement = dbConnect.prepareStatement(sqlInsert);
            preparedStatement.setInt(1, clientID);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surname);
            preparedStatement.setString(4, mail);
            preparedStatement.setString(5, phone);
            preparedStatement.setString(6, password);
            preparedStatement.executeUpdate();
            preparedStatement.clearParameters();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}