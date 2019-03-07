package com.cc.yht.module.user.service.impl;

import com.cc.yht.module.user.service.IUserService;
import com.cc.yht.module.user.vo.UserListRequest;
import com.cc.yht.module.user.vo.UserVO;
import com.cc.yht.module.user.vo.UsersWrapper;
import com.cc.yht.provider.common.Page;
import com.cc.yht.provider.common.PageInfo;
import com.cc.yht.provider.user.dao.UserDAO;
import com.cc.yht.provider.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDAO userDAO;

    @Page
    @Override
    public UsersWrapper getUsersWrapper(UserListRequest request) {
        UsersWrapper wrapper = new UsersWrapper();
        List<UserVO> userVOList = new ArrayList<>();
        PageInfo<User> pageInfo = new PageInfo<>(userDAO.selectList(request.getUserName()));
        pageInfo.getResults().parallelStream().forEach(user ->
                userVOList.add(buildUserVO(user)));

        wrapper.setTotalCount(pageInfo.getTotalCount());
        wrapper.setResults(userVOList);
        return wrapper;
    }

    private UserVO buildUserVO(User user) {
        UserVO userVO = new UserVO();
        userVO.setUserId(user.getId());
        userVO.setUserName(user.getName());
        return userVO;
    }
}
