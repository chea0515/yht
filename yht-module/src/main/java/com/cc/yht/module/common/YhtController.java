package com.cc.yht.module.common;

import com.cc.yht.module.user.vo.UserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Slf4j
@Controller
@RequestMapping("/yht")
public class YhtController {

    /** 首页跳转 */
    @GetMapping
    private String indexPage() {
        return "/index";
    }

    /** 用户登录 */
    @PostMapping("/login")
    @ResponseBody
    private ResponseWrapper login(@RequestBody UserLoginVO loginUser, HttpServletRequest request) {
        log.info("[ USER LOGIN ] user login start, userId: {}, userName: {}",
                loginUser.getUserId(), loginUser.getUserName());

        loginUser.setLoginTime(new Date());
        loginUser.setStatus(0);

        // test
        request.getSession().setAttribute(Constants.USER_LOGO_SESSION, loginUser);

        return new ResponseWrapper();
    }

    /** 退出登录 */
    @GetMapping("/logout")
    private String logout(HttpServletRequest request) {
        log.info("[ USER LOGIN ] user logout start.");
        request.getSession().invalidate();
        return "/index";
    }
}
