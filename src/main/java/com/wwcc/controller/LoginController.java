package com.wwcc.controller;

import com.wwcc.po.ActiveUser;
import com.wwcc.util.Md5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * User:heichen
 * Date:2017/12/13
 * Time:20:38
 **/
@Controller
public class LoginController {
    //系统首页
    @RequestMapping("/index.form")
    public String first(Model model)throws Exception{

        //从shiro的session中取activeUser
        Subject subject = SecurityUtils.getSubject();
        //取身份信息
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        //通过model传到页面
        model.addAttribute("activeUser", activeUser);

        return "/index";
    }

    //欢迎页面
    @RequestMapping("/welcome.form")
    public String welcome(Model model)throws Exception{

        return "/welcome";

    }

    //登录页面
    @RequestMapping("/loginView.form")
    public String loginView(Model model)throws Exception{

        return "/login";

    }

    //登录注销
    @RequestMapping("/logout.form")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }

    //展示页面
    @RequestMapping("/show.form")
    @RequiresPermissions("user:query")
    public String show(HttpServletRequest request){
        return "show";
    }

    @RequestMapping("/login.form")
    public String login(HttpServletRequest request) {
        System.out.println("login.form");
        String username=request.getParameter("username");
        String password= Md5Utils.MD5(request.getParameter("password"));
        System.out.println("密码加密前："+request.getParameter("password"));
        System.out.println("密码加密后："+password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try{
            subject.login(token);//会跳到我们自定义的realm中
            //request.getSession().setAttribute("user", user);
            return "success";
        }catch(Exception e){
            e.printStackTrace();
            //request.getSession().setAttribute("user", user);
            request.setAttribute("error", "用户名或密码错误！");
            return "login";
        }
    }


}
