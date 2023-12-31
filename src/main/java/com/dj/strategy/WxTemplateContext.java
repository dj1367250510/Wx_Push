package com.dj.strategy;

import com.dj.dto.IdentityInfo;
import com.dj.enums.WxTemplateType;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: dj
 * @Date: 2022/9/6 19:06
 * @Description: 微信模板上下文
 */
@Component
public class WxTemplateContext {
    @Resource
    private Map<String, WxTemplateStrategy> strategyMap;

    public void execute(WxTemplateType wxTemplateType, WxMpTemplateMessage wxMpTemplateMessage, IdentityInfo identityInfo) {
        strategyMap.get(wxTemplateType.getTemplateId()).execute(wxMpTemplateMessage, identityInfo);
    }
}
