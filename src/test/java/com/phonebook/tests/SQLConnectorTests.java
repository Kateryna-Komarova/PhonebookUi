package com.phonebook.tests;

import com.phonebook.data.DbData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;

public class SQLConnectorTests {

    Connection connection;

    @BeforeMethod
    public void loadDb(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DbData.dbUrl,DbData.username,DbData.password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void getDataTableTest(){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DbData.querySelect);

            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterMethod
    public void closeDb(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void deleteRowTest(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DbData.queryDelete);
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.executeQuery(DbData.querySelect);
            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
