package com.cc.yht.module.user.service;

import com.cc.yht.module.user.vo.UserLoginVO;

public interface ILoginUserService {

    UserLoginVO getLoginUser();

    Long getLoginUserId();
}
