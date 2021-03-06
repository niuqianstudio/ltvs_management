package com.ltvs.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltvs.pojo.LtvsUser;
import com.ltvs.service.ILoginService;
/**
 * 登录控制层
 * @Description 
 * @author LIU
 * @date 2019年5月6日 下午2:37:06
 */
@Controller
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "ltvsLogin", method = RequestMethod.POST)
    @ResponseBody
    public String Login(HttpServletRequest hq, HttpServletResponse hr) throws IOException {
        // 获取当前登录人的账户和密码
        String userName = (String) hq.getParameter("username");
        String userPassword = (String) hq.getParameter("password");
        // 封装
        LtvsUser user = new LtvsUser();
        user.setUserName(userName);
        // 对密码进行md5加密
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(userPassword.getBytes());
            String string = new BigInteger(1, md.digest()).toString(16);
//            user.setUserPassword(string.toUpperCase());
            user.setUserPassword(string.toLowerCase());
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        // 后台查询
        LtvsUser ltvsUser = loginService.findUser(user);
        if (ltvsUser == null) {
            // 将最近的登录时间存入表中
            return "fail";
        } else {
            HttpSession session = hq.getSession();
            session.setAttribute("LOGIN_USER", ltvsUser);
            // loginService.updateLoginTime(ltvsUser);
            return "toIndex&" + ltvsUser.getUserName();
        }
    }

    @RequestMapping(value = "loginOut", method = RequestMethod.GET)
    @ResponseBody
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session.getAttribute("LOGIN_USER") != null && session.getAttribute("LOGIN_USER").equals(session.getId())) {
            session.removeAttribute("LOGIN_USER");
            request.getSession().invalidate();
                try {
                    request.getRequestDispatcher("/login.html").forward(request, response);
                } catch (ServletException | IOException e) {
                }
            return "用户已退出";
        }
            try {
                request.getRequestDispatcher("/login.html").forward(request, response);
            } catch (ServletException | IOException e) {
            }
        request.getSession().invalidate();
        return "用户已退出";
    }
}
