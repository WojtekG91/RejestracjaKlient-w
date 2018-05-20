package com.company.SQL;

import com.company.Users.Client;
import sun.security.util.Password;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

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

    public void serviceListSubmit (Integer clientId, String service, String date1, String time, Integer duration, Double price, Integer employeeId){
        java.sql.Date date = new java.sql.Date(0000-00-00);
        Connection dbConnect = null;
        PreparedStatement preparedStatement = null;
//        INSERT INTO `tservice`(`clientId`, `Service`, `Date`, `Time`, `Duration`, `Price`, `EmployeeId`) VALUES (1, 'Hybryda', '2018-06-03', '03:45:00', 45, '50.0', 1)
        String sqlRegisterServices = "INSERT INTO `tservice`(`clientId`, `Service`, `Date`, `Time`, `Duration`, `Price`, `EmployeeId`) " + "VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            dbConnect = SqlConnection.Connect();
            preparedStatement = dbConnect.prepareStatement(sqlRegisterServices);
//            preparedStatement.setInt(1, clientID);
            preparedStatement.setInt(1, clientId);
            preparedStatement.setString(2, service);
            preparedStatement.setDate(3, java.sql.Date.valueOf(date1));
            preparedStatement.setTime(4, java.sql.Time.valueOf(time));
            preparedStatement.setInt(5, duration);
            preparedStatement.setDouble(6, price);
            preparedStatement.setInt(7, employeeId);
            preparedStatement.executeUpdate();
            preparedStatement.clearParameters();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
