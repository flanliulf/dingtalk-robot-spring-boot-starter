package com.fancyliu.dingtalk.robot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "aliyun.dingtalk.robot")
public class DingtalkRobotProperties {

	/**
	 * 钉钉群组的机器人的Hook地址
	 */
	private String webhook = "https://oapi.dingtalk.com/robot/send?access_token=";

	/**
	 * 钉钉群组的机器人的 AccessToken
	 */
	private String accessToken = "648a18b09e73b244a5c9417315d5e08e130ad0c856492c85a4ba814729031c1b";


	public String getWebhook() {
		return webhook;
	}

	public void setWebhook(String webhook) {
		this.webhook = webhook;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
