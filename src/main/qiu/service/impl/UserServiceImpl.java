package service.impl;

import dao.UserDao;
import model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.UserService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/24 0024.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }
    public void addUser1(){
        userDao.addUser();
    }
    public User getONEUser(String adname){
        return userDao.selectONEUser(adname);
    }
    public int changeADprice(String adName, String price){
        return userDao.changeprice(adName, price);
    }


}