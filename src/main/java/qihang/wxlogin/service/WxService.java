package qihang.wxlogin.service;

import org.springframework.stereotype.Service;
import qihang.wxlogin.po.WxMessage;

/**
 * @description: TODO
 * @author: zhqihang
 * @date: 2024/08/26
 */
@Service
public class WxService {
    private static final String TOKEN = "zhqihang";

    public String checkSignature(String signature, String timestamp, String nonce, String echostr) {
        // 模拟校验
        System.out.println("收到微信校验请求， echostr 为：" + echostr);
        return echostr;
    }

    public void receiveWxMessage(WxMessage wxMessage) {
        System.out.println(wxMessage.getEvent());
    }
}
