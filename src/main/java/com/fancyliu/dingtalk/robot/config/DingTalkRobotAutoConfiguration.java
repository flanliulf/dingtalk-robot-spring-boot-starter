package com.fancyliu.dingtalk.robot.config;

import com.fancyliu.dingtalk.robot.service.RobotSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DingtalkRobotProperties.class) // 开启属性注入,通过@autowired注入
@Slf4j
public class DingTalkRobotAutoConfiguration {

	//	/**
//	 * webhook 的配置
//	 */
//	@Bean
//	public DingtalkRobotProperties dingtalkRobotProperties() {
//		log.info("Dingtalk Robot - Start initialing dingtalk configuration properties...");
//		return new DingtalkRobotProperties();
//	}
	@Autowired
	private DingtalkRobotProperties dingtalkRobotProperties;

	@Bean
	public RobotSendService robotSendService() {
		log.info("Dingtalk Robot - Start configuring dingtalk robot service...");
		log.info("dingtalkRobotProperties: webhook={},accessToken={}", dingtalkRobotProperties.getWebhook(), dingtalkRobotProperties.getAccessToken());
		return new RobotSendService(dingtalkRobotProperties);
	}

}
