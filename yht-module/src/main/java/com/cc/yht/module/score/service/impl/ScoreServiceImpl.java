package com.cc.yht.module.score.service.impl;

import com.cc.yht.module.score.service.ScoreService;
import com.cc.yht.module.score.vo.ScoreVO;
import com.cc.yht.module.user.service.ILoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ILoginUserService loginUserService;

    @Override
    public ScoreVO getScoreDetail() {
        Long userId = loginUserService.getLoginUserId();
        return new ScoreVO();
    }
}
