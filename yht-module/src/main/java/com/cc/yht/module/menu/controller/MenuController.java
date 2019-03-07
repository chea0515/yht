package com.cc.yht.module.menu.controller;

import com.cc.yht.module.menu.service.IMenuService;
import com.cc.yht.sdk.model.menu.Menu;
import com.cc.yht.sdk.model.menu.MenuInfoResponse;
import com.cc.yht.sdk.model.menu.MenuResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;
    @Value("${weixin.config.accessToken}")
    private String accessToken;

    @PostMapping("/create")
    public MenuInfoResponse createMenu(@RequestBody Menu menu) {
        log.info("create menu start:");
        MenuInfoResponse response = menuService.createMenu(menu);
        log.info("create menu result, code: {}, msg: {}", response.getErrcode(), response.getErrmsg());
        return response;
    }

    @GetMapping("/get")
    public MenuResponse getMenu() {
        log.info("create menu start:");
        return menuService.getMenu();
    }

    @GetMapping("/delete")
    public MenuInfoResponse delMenu() {
        log.info("delete menu start:");
        return menuService.deleteMenu();
    }
}
