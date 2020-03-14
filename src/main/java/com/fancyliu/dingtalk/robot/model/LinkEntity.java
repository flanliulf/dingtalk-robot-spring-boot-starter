package com.fancyliu.dingtalk.robot.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class LinkEntity {

    private String msgType;

    // 显示标题
    private String title;

    // 显示内容
    private String content;

    // icon url
    private String picUrl;

    // 内容对链接
    private String messageUrl;

    public String getMsgType() {
        return "link";
    }

    public String getJSONObjectString() {
        // text类型
        JSONObject linkContent = new JSONObject();
        linkContent.put("title", this.getTitle());
        linkContent.put("text", this.getContent());
        linkContent.put("picUrl", this.getPicUrl());
        linkContent.put("messageUrl", this.getMessageUrl());

        JSONObject json = new JSONObject();
        json.put("msgtype", this.getMsgType());
        json.put("link", linkContent);
        return json.toJSONString();
    }
}
