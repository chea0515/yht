package com.cc.wx.yht.module.menu.service;

import com.cc.wx.yht.sdk.model.menu.Menu;
import com.cc.wx.yht.sdk.model.menu.MenuInfoResponse;
import com.cc.wx.yht.sdk.model.menu.MenuResponse;

public interface IMenuService {

    MenuInfoResponse createMenu(Menu menu);

    MenuResponse getMenu();

    MenuInfoResponse deleteMenu();
}
