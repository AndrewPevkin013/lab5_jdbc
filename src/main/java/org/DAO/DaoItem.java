package org.DAO;
import org.item.Items;
import java.sql.*;

public class DaoItem implements IDaoItem {

    private final Connection Conn;
    public DaoItem(Connection conn) {

        Conn = conn;
    }

    @Override
    public Items searchByID(int id) {
        Items item = new Items();
        try (Statement stmt = Conn.createStatement()) {
            String query = "SELECT * FROM item";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getInt("item_id") == id) {
                    item.setId(id);
                    item.setArtist(rs.getString("artist"));
                    item.setPrice(rs.getString("price"));
                    item.setTitle(rs.getString("title"));
                    rs.close();
                    return item;
                }
            }

        } catch (SQLException e) {
            System.out.println("Connection failed : " + e.getMessage());
        }
        return null;
    }

    @Override
    public void create(Items item) {

    }

    @Override
    public void close() {

    }

}
