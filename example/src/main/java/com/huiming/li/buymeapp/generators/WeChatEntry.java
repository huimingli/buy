package com.huiming.li.buymeapp.generators;

/**
 * @author huimingli
 * @date 2017-09-10 21:41:48
 * @description
 */

import com.example.annotation.EntryGenerator;
import com.huiming.li.buy.wechat.template.WXEntryTemplate;

@EntryGenerator(
        packageName="com.huiming.li.buymeapp",
        entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}
