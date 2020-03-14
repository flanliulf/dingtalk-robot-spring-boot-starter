package com.fancyliu.dingtalk.robot.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class FeedCardEntity {

    private String msgType;

    // links
    private List<FeedCardLinkEntity> links;

    public String getMsgType() {
        return "feedCard";
    }

    public String getJSONObjectString() {

        // text类型
        JSONObject feedCardContent = new JSONObject();
        List<FeedCardLinkEntity> links = new ArrayList<FeedCardLinkEntity>();
        for (int i = 0; i < this.getLinks().size(); i++) {
            links.add(this.getLinks().get(i));
        }
        if (this.getLinks().size() > 0) {
            feedCardContent.put("links", links);
        }

        JSONObject json = new JSONObject();
        json.put("msgtype", this.getMsgType());
        json.put("feedCard", feedCardContent);

        return json.toJSONString();
    }

    private class FeedCardLinkEntity {
    }
}
