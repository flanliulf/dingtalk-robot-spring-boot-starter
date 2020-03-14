package com.fancyliu.dingtalk.robot.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


/**
 * 普通文本消息
 *
 * @author : Liu Fan
 * @since : 2020/2/22
 */
@Slf4j
@Data
public class TextEntity extends BaseMsgEntity {

    /**
     * 消息类型,这里为文本类型
     */
    private String msgType;

    /**
     * 钉钉消息内容
     */
    private String content;

    /**
     * 是否@所有人
     */
    private Boolean isAtAll;

    /**
     * 被@人的手机号(在content里添加@人的手机号)
     */
    private List<String> atMobiles;

    public String getMsgType() {
        return "text";
    }

    @Override
    public String convertToJsonString() {
        // text类型
        JSONObject content = new JSONObject();
        content.put("content", this.getContent());

        // at some body
        JSONObject atMobile = new JSONObject();
        if (this.getAtMobiles().size() > 0) {
            List<String> mobiles = new ArrayList<String>();
            for (int i = 0; i < this.getAtMobiles().size(); i++) {
                mobiles.add(this.getAtMobiles().get(i));
            }
            if (mobiles.size() > 0) {
                atMobile.put("atMobiles", mobiles);
            }
            atMobile.put("isAtAll", this.getIsAtAll());
        }

        JSONObject object = new JSONObject();
        object.put("msgtype", this.getMsgType());
        object.put("text", content);
        object.put("at", atMobile);
        return object.toJSONString();
    }

    public TextEntity() {
    }

    public TextEntity(String msgType, String content, Boolean isAtAll, List<String> atMobiles) {
        this.msgType = msgType;
        this.content = content;
        this.isAtAll = isAtAll;
        this.atMobiles = atMobiles;
    }

    public TextEntity(String content, Boolean isAtAll, List<String> atMobiles) {
        this.content = content;
        this.isAtAll = isAtAll;
        this.atMobiles = atMobiles;
        this.msgType = "text";
    }
}
