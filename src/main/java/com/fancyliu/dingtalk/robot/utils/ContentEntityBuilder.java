package com.fancyliu.dingtalk.robot.utils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.fancyliu.dingtalk.robot.model.TextEntity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContentEntityBuilder {

    /**
     * 如果 isAtAll 为 true,在 content 上追加 @所有人;否则只追加@ atMobiles 中的每一个人
     *
     * @param content   文本内容
     * @param isAtAll   是否 at 所有人
     * @param atMobiles 需要 at 的手机号列表
     * @return 重新封装文本内容后的对象
     */
    public static TextEntity buildTextEntity(String content, Boolean isAtAll, List<String> atMobiles) {
        if (!isAtAll && CollectionUtil.isNotEmpty(atMobiles)) {
            String allAtStr = " ";
            List<String> collect = atMobiles.stream().filter(e -> StrUtil.isNotBlank(e))
                    .map(e -> "@" + e)
//                        .forEach(e -> System.out.println(e));
                    .collect(Collectors.toList());
            for (String s : collect) {
                allAtStr += s + " ";
            }
            System.out.println(allAtStr);
            return new TextEntity(content + allAtStr, isAtAll, atMobiles);
        } else {
            return new TextEntity(content, isAtAll, atMobiles);
        }
    }

    public static void main(String[] args) {
        TextEntity textEntity = ContentEntityBuilder.buildTextEntity("zheshissfsafs", false,
                Arrays.asList("18627272", "", "18623232"));
        System.out.println(textEntity);
    }

}
