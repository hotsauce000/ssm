package dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import model.User;
import java.util.List;

/**
 * Created by Administrator on 2017/3/24 0024.
 */
@Repository
public interface UserDao {
    public int changeprice(@Param("adname") String adName, @Param("price") String adPrice);
    public List<User> selectAllUser();
    public User selectONEUser(@Param("adname") String adName);
    public void addUser();

}
