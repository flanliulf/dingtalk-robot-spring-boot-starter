package com.fancyliu.dingtalk.robot.model;

public abstract class BaseMsgEntity {

    /**
     * 子类需要自定义实现该方法,实现对字段的封装
     *
     * @return
     */
    String convertToJsonString() {
        return "";
    }
}
