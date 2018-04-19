package com.company.SQL;

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

    public static String getSqlPassword(String mail) {
        String passwordHash = null;
        Connection dbConnect = null;
        Statement Statement = null;
        String sqlSelect = "SELECT Password FROM tclients WHERE Mail = '" + mail + "'";
        try {
            dbConnect = SqlConnection.Connect();
            Statement = dbConnect.createStatement();
            ResultSet rs = Statement.executeQuery(sqlSelect);
            while (rs.next()) {
                passwordHash = rs.getString("Password");
            }
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passwordHash;
    }
}