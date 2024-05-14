package org.repository;

import org.item.Items;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemRepositoryImpl implements ItemRepository{
    private final Connection Conn;
    // private EntityManager

    public ItemRepositoryImpl(Connection conn) {
        Conn = conn;
    }

    @Override
    public Items searchByID(int id) {
        try (Statement stmt = Conn.createStatement()) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void create(Items item) {

    }

    @Override
    public void close() {

    }

    @Override
    public boolean exists(int id) {

        return false;
    }
}
