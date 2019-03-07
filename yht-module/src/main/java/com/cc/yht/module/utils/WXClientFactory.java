package com.cc.yht.module.utils;

import com.cc.yht.sdk.WXClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WXClientFactory {

    @Value("${weixin.config.apiUrl:}")
    private String wxApi;

    public WXClient getWXClient() {
        return new WXClient(wxApi);
    }
}
