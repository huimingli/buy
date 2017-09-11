package com.huiming.li.buymeapp.generators;

import com.example.annotation.AppRegisterGenerator;
import com.huiming.li.buy.wechat.template.WXAppRegisterEntryTemplate;

/**
 * @author huimingli
 * @date 2017-09-10 21:41:48
 * @description
 */
@AppRegisterGenerator(
        packageName = "com.huiming.li.buymeapp",
        registerTemplate = WXAppRegisterEntryTemplate.class

)
public interface AppRegister {
}
