package com.cc.yht.module.user.controller;

import com.cc.yht.module.core.PageResponseWrapper;
import com.cc.yht.module.user.service.IUserService;
import com.cc.yht.module.user.vo.UserListRequest;
import com.cc.yht.module.user.vo.UserVO;
import com.cc.yht.module.user.vo.UsersWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/yht/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/list")
    private PageResponseWrapper<UserVO> userList(@RequestBody UserListRequest request) {
        log.info("[ USER LIST ] get user list start, pageNo: {}, pageSize: {}",
                request.getPageNo(), request.getPageSize());
        PageResponseWrapper<UserVO> wrapper = new PageResponseWrapper<>();
        UsersWrapper usersWrapper = userService.getUsersWrapper(request);
        wrapper.getPage()
                .withPageNo(request.getPageNo())
                .withPageSize(request.getPageSize())
                .withResults(usersWrapper.getResults())
                .withTotalCount(usersWrapper.getTotalCount());
        return wrapper;
    }
}
