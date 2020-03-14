package com.fancyliu.dingtalk.robot.service;

import cn.hutool.http.HttpRequest;
import com.fancyliu.dingtalk.robot.core.DingtalkRobotProperties;
import com.fancyliu.dingtalk.robot.model.TextEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RobotSendService {

    private DingtalkRobotProperties dingtalkRobotProperties;

    public RobotSendService(DingtalkRobotProperties dingtalkRobotProperties) {
        this.dingtalkRobotProperties = dingtalkRobotProperties;
    }

    /**
     * 发送基本文本内容
     *
     * @param entity 文本对象实体
     * @return
     */
    public String sendText(TextEntity entity) {
        String textString = entity.convertToJsonString();

        log.info("textString:{}", textString);
        String url = this.dingtalkRobotProperties.getWebhook() + dingtalkRobotProperties.getAccessToken();
        String result = HttpRequest.post(url)
                .body(textString, "application/json; charset=utf-8")
                .execute().body();

        return result;
    }
}
