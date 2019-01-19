package com.cc.wx.yht.sdk.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class XMLAdapterCDATA extends XmlAdapter<String, String> {
    @Override
    public String marshal(String v) {
        return "<![CDATA[" + v + "]]>";
    }

    @Override
    public String unmarshal(String v) {
        return v;
    }
}
