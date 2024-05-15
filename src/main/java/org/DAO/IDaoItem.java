package org.DAO;

import org.item.Items;

public interface IDaoItem {
    Items searchByID(int id);
    void create(Items item);
    void searchByKeyword(String likeText);
}
