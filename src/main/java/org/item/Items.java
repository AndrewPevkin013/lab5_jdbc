package org.item;

import java.util.Date;

public class Items {
    private int id;
    private String title;
    private String artist;
    private Date releasedate;
    private String listPrice;
    private String price;
    private String version;

    public Items() {

    }

    public int getId()
    {return id;}

    public void setId(int id)
    {this.id = id;}

    public String getTitle()
    {return title;}

    public void setTitle(String title)
    {this.title = title;}

    public String getArtist()
    {return artist;}

    public void setArtist(String artist)
    {this.artist= artist;}

    public Date getReleasedate()
    {return releasedate;}

    public void setReleasedate(Date releasedate)
    {this.releasedate = releasedate;}

    public String getListPrice()
    {return listPrice;}

    public void setListPrice(String listPrice)
    {this.listPrice = listPrice;}

    public String getPrice()
    {return price;}

    public void setPrice(String price)
    {this.price = price;}

    public String getVersion()
    {return version;}

    public void setVersion(String version)
    {this.version = version;}

    @Override
    public String toString() {
        return "Item [Id = " + id + ", title = " + title + ",  artist = " + artist + ", price = " + price + "]";
    }
}
