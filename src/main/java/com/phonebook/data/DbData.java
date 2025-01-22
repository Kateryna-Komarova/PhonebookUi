package com.phonebook.data;

public class DbData {
    public static final String dbUrl = "jdbc:mysql://localhost:3306/test";
    public static final String username = "root";
    public static final String password = "Kotik5541";
    public static final String querySelect = "select * from contacts;";
    public static final String queryDelete = " delete from contacts where firstName='Kate';";
}
