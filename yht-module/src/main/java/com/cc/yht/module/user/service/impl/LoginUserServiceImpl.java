package com.cc.yht.module.user.service.impl;

import com.cc.yht.module.user.service.ILoginUserService;
import com.cc.yht.module.user.vo.UserLoginVO;
import com.cc.yht.module.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginUserServiceImpl implements ILoginUserService {

    @Autowired
    private HttpServletRequest httpRequest;

    @Override
    public UserLoginVO getLoginUser() {
        Object userObj = httpRequest.getSession().getAttribute(Constants.USER_LOGO_SESSION);
        if (userObj != null) {
            return (UserLoginVO) userObj;
        }
        return null;
    }

    @Override
    public Long getLoginUserId() {
        UserLoginVO loginUser = this.getLoginUser();
        if (loginUser != null) {
            return loginUser.getUserId();
        }
        return null;
    }
}
