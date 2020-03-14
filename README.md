
## 简介
`dingtalk-robot-spring-boot-starter` 项目是一个**接入钉钉自定义钉机器人接口，用于钉钉群机器人推送消息**的 Spring Boot Starter 项目。

本项目参考了钉钉官方的 Java SDK，对一些常用的场景进行封装，对于常见的基于 Spring Boot 体系的 Java 项目，提供了更方便快捷的引入和使用方式。

本项目可以广泛适用于短信发送测试，预警消息推送等业务场景。

## 依赖组件
|    组件     |                          说明                          |      |
| :---------: | :----------------------------------------------------: | :--: |
| hutool-core |     核心工具类，引入用于Bean操作、日期、各种Util等     |      |
| hutool-http | http 请求工具类，基于HttpUrlConnection的Http客户端封装 |      |
|  fastjson   |                      JSON 工具类                       |      |

## 安装

### Maven

在项目的 pom.xml 的 dependencies 中加入以下内容：

```xml
<dependency>
  <groupId>com.fancyliu</groupId>
  <artifactId>dingtalk-robot-spring-boot-starter</artifactId>
  <version>1.0.0</version>
</dependency>
```

## 快速入门

下面以发送简单的文本消息内容为例，来展示如何使用 `dingtalk-robot-spring-boot-starter` ，通常只需要以下三步：

#### 1. 引入发送服务对象

在需要发送消息的地方注入 RobotSendService 类；

```java
    @Autowired
    private RobotSendService robotSendService;
```

#### 2. 封装内容实体对象

如果是 http 调用，请参考以下格式封装请求 body：

```json
{
    "content": "验证码测试文本内容 xxxx @18612341234",
    "atMobiles": [
        "18612341234"
    ],
    "isAtAll": false
}
```

#### 3. 调用发送方法

调用 robotSendService 的 sendText(TextEntity textEntity)方法，即可发送。

#### 示例代码

```java
@RestController
@RequestMapping(value = "/dingtalk/robot")
public class DingtalkController {

    @Autowired
    private RobotSendService robotSendService;

    /**
     * <p>发送简单文本内容消息</p>
     *
     * @param textEntity 消息文本封装对象
     * @return
     */
    @PostMapping(value = "/send/text")
    public String sendTextMessage(@RequestBody TextEntity textEntity) {
        return robotSendService.sendText(textEntity);
    }
}
```

![image-20200222200920456](http://img.cdn.kuaidiba.cn/md/2020-02-22-120921.png)

## 分支说明

## 注意事项

## 参考文档
* 钉钉群机器人官方文档：[群机器人开发文档](https://ding-doc.dingtalk.com/doc#/serverapi2/krgddi)
* 钉钉官方 Java SDK 文档：[服务端API SDK 文档](https://ding-doc.dingtalk.com/doc#/faquestions/vzbp02)
* Hutool 官方文档：[Hutool 参考文档](https://www.hutool.cn/docs/#/)



