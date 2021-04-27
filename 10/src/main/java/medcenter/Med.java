package medcenter;

import java.sql.Date;

public class Med {
    public String name;
    public int price;
    public Date releaseData;

    public Med(String name, int price, Date releaseData) {
        this.name = name;
        this.price = price;
        this.releaseData = releaseData;
    }
    public Med()
    {

    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Date getReleaseData() {
        return releaseData;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setReleaseData(Date releaseData) {
        this.releaseData = releaseData;
    }

    @Override
    public String toString() {
        return "Med{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", releaseData=" + releaseData +
                '}';
    }
}
