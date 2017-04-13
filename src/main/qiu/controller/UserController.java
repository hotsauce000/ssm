package controller;

import com.alibaba.fastjson.JSONArray;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/24 0024.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    @ResponseBody
        public List<User> showUser(HttpServletRequest request, HttpServletResponse response){
            response.setHeader("Access-Control-Allow-Origin", "*");
            List<User> userList = userService.getAllUser();


        return userList;
    }

    @RequestMapping("/showoneUser")
    @ResponseBody
        public Object showoneUser(HttpServletRequest request, HttpServletResponse response){
            response.setHeader("Access-Control-Allow-Origin", "*");
            String adName = request.getParameter("adName");
            User user = userService.getONEUser(adName);

            return user.getAdName();
    }
    @RequestMapping("/changeprice")
    @ResponseBody
    public Object changeprice(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String adName = request.getParameter("adName");
        String adprice = request.getParameter("adPrice");

        userService.changeADprice(adName, adprice);
        User user = userService.getONEUser(adName);


        return user.getAdPrice();
    }

    @RequestMapping("/addUser")
    public String addUser2(HttpServletRequest request,Model model){
            userService.addUser1();
            List<User> userList = userService.getAllUser();
            model.addAttribute("userList",userList);
             return "showUser";
    }

    @RequestMapping("/test")
    @ResponseBody
    public Object test(HttpServletRequest request,HttpServletResponse response){
        System.out.println(request.getParameter("p1") + "**************************************8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String a = "a" ;

        return a ;
    }
}