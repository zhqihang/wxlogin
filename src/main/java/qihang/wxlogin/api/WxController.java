package qihang.wxlogin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qihang.wxlogin.po.WxMessage;
import qihang.wxlogin.service.WxService;

/**
 * @description: 微信控制类
 * @author: zhqihang
 * @date: 2024/08/26
 */

@RestController
public class WxController {

    @Autowired
    private WxService wxService;

    /**
     * 暴露接口 用于连接微信服务器 校验防止为盗刷
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @GetMapping("qihang")
    public String checkIsAvailable(
            @RequestParam("signature") String signature,
            @RequestParam("timestamp") String timestamp,
            @RequestParam("nonce") String nonce,
            @RequestParam("echostr") String echostr
    ) {
        return wxService.checkSignature(signature, timestamp, nonce, echostr);
    }


    @PostMapping("qihang")
    public void receiveWxMessage(@RequestBody WxMessage wxMessage) {
        wxService.receiveWxMessage(wxMessage);
    }
}
