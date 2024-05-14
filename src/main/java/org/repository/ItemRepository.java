package org.repository;

import org.item.Items;

public interface ItemRepository {
    Items searchByID(int id);
    void create(Items item);
    void close();
    boolean exists(int id);
}
