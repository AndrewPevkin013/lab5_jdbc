package org.example;

import org.DAO.DaoItem;
import org.item.Items;

import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // Maven https://jdbc.postgresql.org/download/ в pom.xml
        String url = "jdbc:postgresql://localhost/jdbc_lab5";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "Larsen0013");
        try (Connection conn = DriverManager.getConnection(url, props)) {
            System.out.println("Metadata : " + conn.getMetaData());
            DaoItem musicItem = new DaoItem(conn);
            Items item = musicItem.searchByID(4);

        } catch (SQLException e) {
            System.out.println("Connection failed : " + e.getMessage());
        }
    }
}