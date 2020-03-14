package com.fancyliu.dingtalk.robot.config;

import com.fancyliu.dingtalk.robot.core.DingtalkRobotProperties;
import com.fancyliu.dingtalk.robot.service.RobotSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DingTalkRobotAutoConfiguration {

    /**
     * webhook 的配置
     */
    @Bean
    @ConfigurationProperties(prefix = "aliyun.dingtalk.robot")
    public DingtalkRobotProperties dingtalkRobotProperties() {
        log.info("Dingtalk Robot - Start initialing dingtalk configuration properties...");
        return new DingtalkRobotProperties();
    }

    @Bean
    public RobotSendService robotSendService() {
        log.info("Dingtalk Robot - Start configuring dingtalk robot service...");
        return new RobotSendService(dingtalkRobotProperties());
    }

}
