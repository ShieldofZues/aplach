package com.hhera.service;

import com.hhera.common.ServiceResponse;
import com.hhera.pojo.User;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: shieldofzues
 * Date: 2017/9/5
 * Time: 下午9:26
 * To change this template use File | Settings | File Templates.
 */
@Service
public interface IUserService {

 ServiceResponse<User> login(String username, String password);

}
