package com.cc.wx.yht.sdk.model.text;

import com.cc.wx.yht.sdk.model.common.BaseEventAttr;
import com.cc.wx.yht.sdk.utils.XMLAdapterCDATA;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Setter
@XmlRootElement(name = "xml")
public class TextEvent extends BaseEventAttr {
    @XmlElement(name = "Content")
    @XmlJavaTypeAdapter(XMLAdapterCDATA.class)
    private String content;

    @XmlTransient
    public String getContent() {
        return content;
    }
}
