package model;

/**
 * Created by Administrator on 2017/3/24 0024.
 */
public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public int getAdPrice() {
        return adPrice;
    }

    public void setAdPrice(int adPrice) {
        this.adPrice = adPrice;
    }

         private  int id;
        private  String adName;
        private  int adPrice;


}
