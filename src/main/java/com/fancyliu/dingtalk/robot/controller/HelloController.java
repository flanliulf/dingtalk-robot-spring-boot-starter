package com.fancyliu.dingtalk.robot.controller;

import com.fancyliu.dingtalk.robot.model.TextEntity;
import com.fancyliu.dingtalk.robot.service.RobotSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/robot")
public class HelloController {

    @Autowired
    private RobotSendService robotSendService;

    @PostMapping("/send/text")
    public String sendText(@RequestBody TextEntity textEntity) {
        return robotSendService.sendText(textEntity);
    }
}
