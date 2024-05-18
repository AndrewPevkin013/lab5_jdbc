package org.DAO;
import org.item.Items;
import java.sql.*;
import java.util.ArrayList;

public class DaoItem implements IDaoItem {

    private final Connection Conn;
    private ArrayList<Items> arrayList;
    private static final String SQL_INSERT = "INSERT INTO item (title, artist, releasedate, listprice, price, version) VALUES (?,?,?,?,?,?)";
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
                    stmt.close();
                    return item;
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failed : " + e.getMessage());
        }
        return null;
    }

    @Override
    public void searchByKeyword(String likeText) {
        arrayList = new ArrayList<>();
        try (Statement stmt = Conn.createStatement()) {
            String query = "SELECT * FROM item WHERE title like '" + likeText + "'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Items item = new Items();
                item.setId(rs.getInt("item_id"));
                item.setArtist(rs.getString("artist"));
                item.setPrice(rs.getString("price"));
                item.setTitle(rs.getString("title"));
                arrayList.add(item);
                System.out.println("id: " + rs.getInt("item_id") + " title: " +  rs.getString("title")
                        + " artist: " + rs.getString("artist") + " price: " + rs.getString("price"));
            }
            rs.close();
            System.out.println("Array size:" + arrayList.size());
        } catch (SQLException e) {
            System.out.println("Connection failed : " + e.getMessage());
        }
    }

    @Override
    public void create(Items item) {
        try (PreparedStatement stmt = Conn.prepareStatement(SQL_INSERT)) {
            stmt.setString(1, item.getTitle());
            stmt.setString(2, item.getArtist());
            stmt.setDate(3, item.getReleasedate());
            stmt.setString(4, item.getListPrice());
            stmt.setString(5, item.getPrice());
            stmt.setString(6, item.getVersion());
            int row = stmt.executeUpdate();
            System.out.println(row);
        }
        catch (SQLException e) {
            System.out.println("Connection failed : " + e.getMessage());
        }
    }
}