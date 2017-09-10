package com.hhera.controller.portal;

import com.hhera.common.Const;
import com.hhera.common.ServiceResponse;
import com.hhera.pojo.User;
import com.hhera.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.ValueExp;
import javax.servlet.http.HttpSession;
import java.awt.geom.NoninvertibleTransformException;

/**
 * com.hhera.controller.portal
 * 2017/9/5
 * shieldofzues
 */
@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private IUserService iUserService;
    /**
     * 用户登录
     * @param
     * @return
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServiceResponse<User> login(String username, String password, HttpSession session) {
        ServiceResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){
session.setAttribute(Const.CURRENT_USER,response.getData());

        }
        return response;
    }



}
