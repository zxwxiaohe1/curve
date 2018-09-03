package com.curve.modules.comm.web;

import com.curve.core.dto.Result;
import com.curve.core.utils.StringUtils;
import com.curve.modules.comm.entity.User;
import com.curve.modules.comm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 控制器支持类
 *
 * @author heyong
 * @version 2018-08-17
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "rest/sys/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 保存用户信息
     *
     * @param user User
     * @return Result<?>
     */
    @RequestMapping(value = "/save", method = {RequestMethod.POST, RequestMethod.PUT})
    public Result<?> save(@RequestBody User user) {
        if (null != user) {
            if (null != userService.getByLoginName(user)) {
                return error("登录名已被占用!");
            }
            if (userService.save(user) > 0) {
                return success("保存" + user.getName() + "成功");
            } else {
                return error("保存" + user.getName() + "成功");
            }
        }
        return error("有点错误,请重新操作!");
    }

    /**
     * 获得用户信息
     *
     * @param id String
     * @return Result<?>
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result<?> get(String id) {
        if (StringUtils.isNotBlank(id)) {
            User user = new User();
            user.setId(id);
            return success(userService.get(user));
        }
        return error("有点错误,请重新操作!");
    }

}
