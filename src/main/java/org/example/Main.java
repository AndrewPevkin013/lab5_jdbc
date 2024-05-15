package org.example;

import org.DAO.DaoItem;
import org.item.Items;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/jdbc_lab5";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "Larsen0013");
        try (Connection conn = DriverManager.getConnection(url, props)) {
            // 1
            System.out.println("Metadata : " + conn.getMetaData());
            DaoItem item = new DaoItem(conn);
            Items musicItem = item.searchByID(4);
            System.out.println(musicItem.toString());

            // 2
            item.searchByKeyword("S%");

            // 3
            Items musicItem2 = new Items();
            Date date = new Date(2015-11-9);
            musicItem2.setTitle("Hello");
            musicItem2.setArtist("Adele");
            musicItem2.setPrice("19.99");
            musicItem2.setReleasedate(date);
            musicItem2.setListPrice("13.7");
            musicItem2.setVersion("1");
            item.create(musicItem2);
        } catch (SQLException e) {
            System.out.println("Connection failed : " + e.getMessage());
        }
    }
}