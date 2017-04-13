package service;

import model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/3/24 0024.
 */
public interface UserService {

    List<User> getAllUser();
    User getONEUser(String adName);
    int changeADprice(String adName, String price);
    public void addUser1();


}