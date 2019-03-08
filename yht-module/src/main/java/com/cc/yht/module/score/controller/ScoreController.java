package com.cc.yht.module.score.controller;

import com.cc.yht.module.common.ResponseWrapper;
import com.cc.yht.module.score.service.ScoreService;
import com.cc.yht.module.score.vo.ScoreVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/detail")
    private ResponseWrapper<ScoreVO> getScoreDetail() {
        log.info("[ Score getScoreDetail ] get score detail start.");
        ResponseWrapper<ScoreVO> response = new ResponseWrapper<>();
        response.setResult(scoreService.getScoreDetail());

        return response;
    }
}
