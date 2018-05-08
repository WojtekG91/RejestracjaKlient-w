package com.company.SQL;

import com.company.Users.Client;
import sun.security.util.Password;

import java.sql.*;

public class SQLStatements {

    public static void registrationStatement(String name, String surname, String mail, String phone, String password) {
        Connection dbConnect = null;
        PreparedStatement preparedStatement = null;
        String sqlInsert = "INSERT INTO `tclients`(`Name`, `Surname`, `Mail`, `Phone`, `Password`)" + "VALUES (?, ?, ?, ?, ?);";
        try {
            dbConnect = SqlConnection.Connect();
            preparedStatement = dbConnect.prepareStatement(sqlInsert);
//            preparedStatement.setInt(1, clientID);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, mail);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, password);
            preparedStatement.executeUpdate();
            preparedStatement.clearParameters();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean getSqlMail(String mail) {
        String dbMail = null;
        Connection dbConnect = null;
        Statement Statement = null;
        String sqlSelect = "SELECT Mail FROM tclients WHERE Mail = '" + mail + "'";
        try {
            dbConnect = SqlConnection.Connect();
            Statement = dbConnect.createStatement();
            ResultSet rs = Statement.executeQuery(sqlSelect);
            while (rs.next()) {
                dbMail = rs.getString("Mail");
            }
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (mail.equals(dbMail)) {
            return true;
        } else {
            return false;
        }
    }

    public Client getClient(String mail) {
        String userPasswordHash = "";
        String userName = "";
        String userSurname = "";
        String userPhone = "";
        String userMail = "";
        Integer userId = 0;
        Connection dbConnect = null;
        Statement Statement = null;
        String sqlSelect = "SELECT ClientID, Name, Surname, Phone, Mail, Password FROM tclients WHERE Mail = '" + mail + "'";
        try {
            dbConnect = SqlConnection.Connect();
            Statement = dbConnect.createStatement();
            ResultSet rs = Statement.executeQuery(sqlSelect);
            while (rs.next()) {
                userId = rs.getInt("ClientID");
                userName = rs.getString("Name");
                userSurname = rs.getString("Surname");
                userPhone = rs.getString("Phone");
                userPasswordHash = rs.getString("Password");
                userMail = rs.getString("Mail");
            }
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Client(userId, userName, userSurname, userPhone, userPasswordHash, userMail);
    }

}
