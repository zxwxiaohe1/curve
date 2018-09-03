package com.curve.modules.comm.web;

import com.curve.core.utils.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Created by heyong.
 * @createtime: on 2018/8/19.
 * @copyright&copy: <a href="http://www.sinux.com.cn">JFusion</a> All rights reserved
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "rest/sys/redirect")
public class RedirectController {
    /* 注册跳转 */
    @RequestMapping(value = "/target",method = RequestMethod.GET)
    public void redirect(String address,HttpServletRequest request, HttpServletResponse response) {
        try {
            if (StringUtils.isNotBlank(address)) {
                response.sendRedirect(request.getContextPath() +"192.168.1.105:8080/WEB-INF/"+address);
//                request.getRequestDispatcher("/WEB-INF/"+address).forward(request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
