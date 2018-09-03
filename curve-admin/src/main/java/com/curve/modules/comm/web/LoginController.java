package com.curve.modules.comm.web;

import com.curve.modules.comm.entity.User;
import com.curve.modules.comm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Created by heyong.
 * @createtime: on 2018/8/19.
 * @copyright&copy: <a href="http://www.sinux.com.cn">JFusion</a> All rights reserved
 */
@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value = "rest/login")
public class LoginController {

    @Autowired
    private UserService userService;
    /**
     * 获得用户信息
     *
     * @param user User
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return Result<?>
     */
    @RequestMapping(value = "/access", method = {RequestMethod.POST, RequestMethod.PUT})
    public ModelAndView login(User user) {
        String redirect = "/login.html";
        if (null != user) {
            if(null != userService.login(user)){
                redirect = "/index.html";
            }
        }
        return new ModelAndView("redirect:"+redirect);
    }
}
