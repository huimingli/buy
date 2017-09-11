package com.huiming.li.buymeapp.generators;

import com.example.annotation.PayEntryGenerator;
import com.huiming.li.buy.wechat.template.WXPayEntryTemplate;

/**
 * @author huimingli
 * @date 2017-09-10 21:41:48
 * @description
 */
@PayEntryGenerator(
       packageName = "com.huiming.li.buymeapp",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
