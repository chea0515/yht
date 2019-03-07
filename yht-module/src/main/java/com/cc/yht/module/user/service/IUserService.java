package com.cc.yht.module.user.service;

import com.cc.yht.module.user.vo.UserListRequest;
import com.cc.yht.module.user.vo.UsersWrapper;

public interface IUserService {

    UsersWrapper getUsersWrapper(UserListRequest request);
}
