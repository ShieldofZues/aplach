package com.hhera.service.Impl;

import com.hhera.common.ServiceResponse;
import com.hhera.dao.UserMapper;
import com.hhera.pojo.User;
import com.hhera.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: shieldofzues
 * Date: 2017/9/5
 * Time: 下午9:29
 * To change this template use File | Settings | File Templates.
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ServiceResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkUsername(username);
        if (resultCount == 0) {
            return ServiceResponse.createByErrorMessage("用户名不存在");

        }
//todo 密码md5
        User user = userMapper.selectLogin(username, password);
        if (user == null) {
            return ServiceResponse.createByErrorMessage("密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServiceResponse.createBySuccess("登录成功！",user);
    }

}
